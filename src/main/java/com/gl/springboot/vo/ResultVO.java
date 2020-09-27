package com.gl.springboot.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

    private boolean success;

    private String message;

    private T data;

    private ResultVO() {
    }

    public static ResultVO build(boolean success, String message){
        ResultVO vo = new ResultVO();
        vo.setSuccess(success);
        vo.setMessage(message);
        return vo;
    }

    public static ResultVO build(boolean success, String message, Object data){
        ResultVO vo = new ResultVO();
        vo.setSuccess(success);
        vo.setMessage(message);
        vo.setData(data);
        return vo;
    }
}
