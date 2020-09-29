package com.gl.springboot.vo.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TransferTaskInfoParamVO {

    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 任务类型
     */
    @NotNull(message = "taskType不能为null")
    private Integer taskType;
    /**
     * 任务条件
     */
    @NotBlank(message = "taskConditions不能为空.")
    private String taskConditions;
    /**
     *目的云存储IP
     */
    @NotBlank(message = "targetIP不能为空.")
    private String targetIP;
    /**
     *目的云存储端口
     */
    @NotNull(message = "targetPort不能为null")
    private Integer targetPort;
    /**
     *迁移成功的文件是否清理 1-是，2-否
     */
    private Integer isClean;
    /**
     * 当前页
     */
    private Integer page;
    /**
     * 每页显示数量
     */
    private Integer pageSize;
}
