package com.gl.springboot.dao;

import com.gl.springboot.entity.TransferTaskInfo;

import java.util.List;

public interface TransferTaskInfoDao {

	int insertRecord(TransferTaskInfo transferTaskInfo);

	int updateRecord(TransferTaskInfo transferTaskInfo);

	int deleteRecordById(String id);

	List<TransferTaskInfo> getRecords(TransferTaskInfo transferTaskInfo);

	TransferTaskInfo getRecordById(String id);
	
}