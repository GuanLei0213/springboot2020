/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.jdk8.job;

import com.gl.springboot.entity.ChannelGroupAgreement;
import com.gl.springboot.vo.ResultVO;
import lombok.Data;

import java.io.File;
import java.util.List;

/**
 * @Description: 数据文件上下文
 * @Auther: za-guanlei
 * @Date: 2021/05/24/16:32
 */

@Data
public class DataFileContext{

    private ResultVO<File> resultVOFile;

    private ResultVO<List<ChannelGroupAgreement>> resultVOList;
}
