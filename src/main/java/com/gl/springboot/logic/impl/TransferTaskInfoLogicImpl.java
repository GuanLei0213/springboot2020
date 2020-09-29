package com.gl.springboot.logic.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.UUID;
import com.github.pagehelper.PageInfo;
import com.gl.springboot.entity.TransferTaskInfo;
import com.gl.springboot.logic.TransferTaskInfoLogic;
import com.gl.springboot.service.TransferTaskInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransferTaskInfoLogicImpl implements TransferTaskInfoLogic {

	@Autowired
	private TransferTaskInfoService transferTaskInfoService;

	@Override
	public int insertTransferTaskInfo(TransferTaskInfo transferTaskInfo) {
		transferTaskInfo.setTaskId(UUID.randomUUID().toString());
		transferTaskInfo.setCreateTime(DateTime.now());
		return transferTaskInfoService.insertTransferTaskInfo(transferTaskInfo);
	}

	@Override
	public int deleteTransferTaskInfo(TransferTaskInfo transferTaskInfo) {
		return transferTaskInfoService.deleteTransferTaskInfo(transferTaskInfo);
	}

	@Override
	public int updateTransferTaskInfo(TransferTaskInfo transferTaskInfo) {
		transferTaskInfo.setLastTime(DateTime.now());
		return transferTaskInfoService.updateTransferTaskInfo(transferTaskInfo);
	}

	@Override
	public TransferTaskInfo queryTransferTaskInfoByTaskId(String taskId) {
		return null;
	}

	@Override
	public List<TransferTaskInfo> queryTransferTaskInfos(TransferTaskInfo transferTaskInfo) {
		return null;
	}

	@Override
	public PageInfo<TransferTaskInfo> pageTransferTaskInfos(TransferTaskInfo transferTaskInfo) {
		return transferTaskInfoService.pageTransferTaskInfos(transferTaskInfo);
	}
}
