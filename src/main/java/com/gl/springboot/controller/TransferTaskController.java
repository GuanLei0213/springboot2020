package com.gl.springboot.controller;

import com.gl.springboot.entity.TransferTaskInfo;
import com.gl.springboot.logic.TransferTaskInfoLogic;
import com.gl.springboot.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/transferTask/api/v1/")
public class TransferTaskController {

    @Autowired
    private TransferTaskInfoLogic transferTaskInfoLogic;

    @PostMapping
    public ResultVO create(TransferTaskInfo taskInfo){
        transferTaskInfoLogic.insertTransferTaskInfo(taskInfo);
        return ResultVO.build(true,"ok!");
    }
}
