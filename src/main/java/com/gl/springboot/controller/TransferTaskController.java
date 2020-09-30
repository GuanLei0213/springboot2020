package com.gl.springboot.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.gl.springboot.constant.Constants;
import com.gl.springboot.entity.TransferTaskInfo;
import com.gl.springboot.entity.UserInfo;
import com.gl.springboot.logic.RedisLogic;
import com.gl.springboot.logic.TransferTaskInfoLogic;
import com.gl.springboot.vo.ResultVO;
import com.gl.springboot.vo.param.TransferTaskInfoParamVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/transferTask/api/v1")
public class TransferTaskController {

    @Autowired
    private TransferTaskInfoLogic transferTaskInfoLogic;

    @Autowired
    private RedisLogic redisLogic;

    @PostMapping
    public ResultVO create(@Valid @RequestBody TransferTaskInfoParamVO paramVO){
        transferTaskInfoLogic.insertTransferTaskInfo(copyProperties(paramVO));
        return ResultVO.build(Constants.TRUE,Constants.SUCCESS);
    }

    @GetMapping
    public ResultVO query(TransferTaskInfoParamVO paramVO){
        PageInfo<TransferTaskInfo> pageInfo = transferTaskInfoLogic.pageTransferTaskInfos(copyProperties(paramVO));
        long total = pageInfo.getTotal();
        List<TransferTaskInfo> transferTaskInfos = pageInfo.getList();
        return ResultVO.build(Constants.TRUE,Constants.SUCCESS,total,transferTaskInfos);
    }

    @PutMapping
    public ResultVO update(@RequestBody TransferTaskInfoParamVO paramVO){
        transferTaskInfoLogic.updateTransferTaskInfo(copyProperties(paramVO));
        return ResultVO.build(Constants.TRUE,Constants.SUCCESS);
    }

    @DeleteMapping
    public ResultVO delete(@RequestBody TransferTaskInfoParamVO paramVO){
        transferTaskInfoLogic.deleteTransferTaskInfo(copyProperties(paramVO));
        return ResultVO.build(Constants.TRUE,Constants.SUCCESS);
    }

    @PostMapping(value = "/redis")
    public ResultVO opsForRedis(@RequestBody UserInfo userInfo){
        redisLogic.setUserInfo(userInfo);
        UserInfo userInfo1 = redisLogic.getUserInfo("userInfo-" + userInfo.getUserId());
        return ResultVO.build(Constants.TRUE,Constants.SUCCESS,userInfo1);
    }

    private TransferTaskInfo copyProperties(TransferTaskInfoParamVO paramVO){
        TransferTaskInfo taskInfo = new TransferTaskInfo();
        BeanUtil.copyProperties(paramVO,taskInfo);
        return taskInfo;
    }
}
