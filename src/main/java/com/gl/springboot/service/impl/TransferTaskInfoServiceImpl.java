package com.gl.springboot.service.impl;

import com.gl.springboot.dao.TransferTaskInfoDao;
import com.gl.springboot.entity.TransferTaskInfo;
import com.gl.springboot.service.TransferTaskInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferTaskInfoServiceImpl implements TransferTaskInfoService {

	@Autowired
	private TransferTaskInfoDao transferTaskInfoDao;

	@Override
	public int insertTransferTaskInfo(TransferTaskInfo transferTaskInfo) {
		return transferTaskInfoDao.insertRecord(transferTaskInfo);
	}

	@Override
	public int deleteTransferTaskInfo(TransferTaskInfo transferTaskInfo) {
		return transferTaskInfoDao.deleteRecordById(transferTaskInfo.getTaskId());
	}

	@Override
	public int updateTransferTaskInfo(TransferTaskInfo transferTaskInfo) {
		return transferTaskInfoDao.updateRecord(transferTaskInfo);
	}

	@Override
	public TransferTaskInfo queryTransferTaskInfoByTaskId(String taskId) {
		return transferTaskInfoDao.getRecordById(taskId);
	}

	@Override
	public List<TransferTaskInfo> queryTransferTaskInfos(TransferTaskInfo transferTaskInfo) {
		return null;
	}
}