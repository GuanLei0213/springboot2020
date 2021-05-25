/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.jdk8.job.executor;

import com.gl.springboot.enumeration.DataFileTypeEnum;
import com.gl.springboot.jdk8.job.DataFileContext;
import com.gl.springboot.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.function.BiConsumer;

/**
 * @Description: 公共下载数据文件执行者
 * @Auther: za-guanlei
 * @Date: 2021/05/18/11:46
 */
@Slf4j
@Component
public class DownloadDataFileExecutor implements BiConsumer<DataFileTypeEnum, DataFileContext> {

    @Override
    public void accept(DataFileTypeEnum fileType,DataFileContext dataFileContext) {
        log.info("执行调用链1.......，文件下载............");
        ResultVO<File> resultVO = dataFileContext.getResultVOFile();
        if (!resultVO.isSuccess())
            return;
        resultVO.setSuccess(Boolean.TRUE);
        resultVO.setData(resultVO.getData());
        log.info("执行公共下载文件成功......");
    }
}
