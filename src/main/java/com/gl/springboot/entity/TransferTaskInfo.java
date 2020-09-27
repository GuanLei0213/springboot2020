package com.gl.springboot.entity;

import lombok.Data;

@Data
public class TransferTaskInfo {

    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 任务类型
     */
    private Integer taskType;
    /**
     * 任务状态
     */
    private Integer taskStatus;
    /**
     * 任务条件
     */
    private String taskConditions;
    /**
     * 任务结果
     */
    private String taskResult;
    /**
     *目的云存储IP
     */
	private String targetIP;
	/**
	 *目的云存储端口 
	 */
	private Integer targetPort;
    /**
     *迁移成功的文件是否清理 1-是，2-否
     */
	private Integer isClean;
	/**
	 * 标记任务插入关联表是否成功 1-是，2-否
	 */
	private Integer insertSuccess;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 *最后更新时间
	 */
	private java.util.Date lastTime;
	/**
	 * 附加参数
	 */
	private Integer page;
	
	private Integer pageSize;
	
}
