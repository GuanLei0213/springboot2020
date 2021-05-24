package com.gl.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gl.springboot.dao.TransferTaskInfoDao;
import com.gl.springboot.entity.TransferTaskInfo;
import com.gl.springboot.service.TransferTaskInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Transactional
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
		int i = transferTaskInfoDao.updateRecord(transferTaskInfo);
		System.out.println("更新结果："+i);
//		i = 10/0;
		return i;
	}

	@Override
	public TransferTaskInfo queryTransferTaskInfoByTaskId(String taskId) {
		return transferTaskInfoDao.getRecordById(taskId);
	}

	@Override
	public List<TransferTaskInfo> queryTransferTaskInfos(TransferTaskInfo transferTaskInfo) {
		return null;
	}

	@Override
	public PageInfo<TransferTaskInfo> pageTransferTaskInfos(TransferTaskInfo transferTaskInfo) {
		PageHelper.startPage(transferTaskInfo.getPage(),transferTaskInfo.getPageSize(),"CHUANGJSJ DESC");
		List<TransferTaskInfo> records = transferTaskInfoDao.getRecords(transferTaskInfo);
		return new PageInfo<>(records);
	}

	public static void main(String[] args) {
		List<Long> longs = Arrays.asList(111L,222L,333L,444L);

		List<Integer> integers = Arrays.asList(1,2,3,4);

		final int index = longs.indexOf(222L);

		final Integer integer = integers.get(index);
		System.out.println(integer);
	}
}