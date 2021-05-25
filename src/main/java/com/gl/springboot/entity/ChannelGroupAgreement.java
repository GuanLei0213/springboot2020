package com.gl.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 团体契约
 * </p>
 *
 * @author guanlei
 * @since 2021-04-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChannelGroupAgreement extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 代表证券番号
     */
    private String groupAgreementNo;

    /**
     * 备注内容
     */
    private String extraInfo;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 修改者
     */
    private String modifier;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 是否删除 Y：是  N：否
     */
    @TableLogic(value = "N", delval = "Y")
    private String isDeleted;

    /**
     * 团契是否已停止 Y：已停止 N：开始中
     */
    private String isStopped;

    /**
     * 版本号
     */
    @Version
    private Integer version;

}
