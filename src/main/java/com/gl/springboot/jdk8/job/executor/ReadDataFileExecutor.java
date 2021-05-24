/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.jdk8.job.executor;


import com.gl.springboot.entity.ChannelGroupAgreement;
import com.gl.springboot.enumeration.DataFileTypeEnum;
import com.gl.springboot.jdk8.job.DataFileContext;
import com.gl.springboot.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.function.BiConsumer;

/**
 * @Description: 公共读数据文件执行者
 * @Auther: za-guanlei
 * @Date: 2021/05/18/11:45
 */
@Component
@Slf4j
public class ReadDataFileExecutor implements BiConsumer<DataFileTypeEnum, DataFileContext> {
    @Override
    public void accept(DataFileTypeEnum dataFileTypeEnum, DataFileContext dataFileContext) {
        ResultVO<File> resultVO = dataFileContext.getResultVOFile();
        if (!resultVO.isSuccess()){
            return;
        }
        log.info("数据文件[{}]执行读取成功.......",dataFileTypeEnum.getDesc());
        ResultVO resultVO1 = ResultVO.build(Boolean.TRUE, "", new ArrayList<ChannelGroupAgreement>());
        dataFileContext.setResultVOList(resultVO1);
    }
}
