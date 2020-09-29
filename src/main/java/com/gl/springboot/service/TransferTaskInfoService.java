package com.gl.springboot.service;

import com.github.pagehelper.PageInfo;
import com.gl.springboot.entity.TransferTaskInfo;

import java.util.List;

public interface TransferTaskInfoService {

	int insertTransferTaskInfo(TransferTaskInfo transferTaskInfo);

	int deleteTransferTaskInfo(TransferTaskInfo transferTaskInfo);

	int updateTransferTaskInfo(TransferTaskInfo transferTaskInfo);

	TransferTaskInfo queryTransferTaskInfoByTaskId(String taskId);

	List<TransferTaskInfo> queryTransferTaskInfos(TransferTaskInfo transferTaskInfo);

	PageInfo<TransferTaskInfo> pageTransferTaskInfos(TransferTaskInfo transferTaskInfo);

}