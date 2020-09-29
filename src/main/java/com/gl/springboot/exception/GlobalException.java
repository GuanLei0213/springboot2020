package com.gl.springboot.exception;

import com.gl.springboot.constant.Constants;
import com.gl.springboot.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO parameterExceptionHandler(MethodArgumentNotValidException e) {
        log.error("请求参数不合法！",e);
        BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!CollectionUtils.isEmpty(errors)) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return ResultVO.build(Constants.FALSE, fieldError.getDefaultMessage());
            }
        }
        return ResultVO.build(Constants.FALSE, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO otherExceptionHandler(Exception e) {
        log.error("未知异常！",e);
        return ResultVO.build(Constants.FALSE, e.getMessage());
    }
}



