package com.gl.springboot.logic.impl;

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
		return transferTaskInfoService.insertTransferTaskInfo(transferTaskInfo);
	}

	@Override
	public int deleteTransferTaskInfo(TransferTaskInfo transferTaskInfo) {
		return 0;
	}

	@Override
	public int updateTransferTaskInfo(TransferTaskInfo transferTaskInfo) {
		return 0;
	}

	@Override
	public TransferTaskInfo queryTransferTaskInfoByTaskId(String taskId) {
		return null;
	}

	@Override
	public List<TransferTaskInfo> queryTransferTaskInfos(TransferTaskInfo transferTaskInfo) {
		return null;
	}
}
