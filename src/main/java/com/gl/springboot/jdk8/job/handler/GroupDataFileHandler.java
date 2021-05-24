/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.jdk8.job.handler;

import com.gl.springboot.enumeration.DataFileTypeEnum;
import com.gl.springboot.jdk8.job.AbstarctImportDataFileHandler;
import com.gl.springboot.jdk8.job.DataFileContext;
import com.gl.springboot.jdk8.job.executor.*;
import com.gl.springboot.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.function.BiConsumer;


/**
 * @Description: 团体数据文件组织者-程序入口
 * @Auther: za-guanlei
 * @Date: 2021/05/18/11:33
 */
@Slf4j
@Component
public class GroupDataFileHandler extends AbstarctImportDataFileHandler {

    @Autowired
    private DownloadDataFileExecutor downloadDataFileExecutor;

    @Autowired
    private BackupDataFileExecutor backupDataFileExecutor;

    @Autowired
    private ReadDataFileExecutor readDataFileExecutor;

    @Autowired
    private SaveGroupDataExecutor saveGroupDataExecutor;

    @Autowired
    private DeleteDataFileExecutor deleteDataFileExecutor;

    private BiConsumer<DataFileTypeEnum, DataFileContext> executor;

    /**
     * @PostConstruct 在容器启动时执行吗，具体执行顺序为： 构造方法  ——> @Autowired ——> @PostConstruct ——> 静态方法
     */
    @PostConstruct
    public void init(){
        executor = downloadDataFileExecutor.andThen(backupDataFileExecutor).andThen(readDataFileExecutor).andThen(saveGroupDataExecutor).andThen(deleteDataFileExecutor);
    }

    public void processor(){
        //1.查询数据库，获取未处理的文件记录

        //2.将filePath传入，执行调用链
        DataFileContext dataFileContext = new DataFileContext();
        ResultVO resultVO = ResultVO.build(Boolean.TRUE, "", new File("/filePath"));
        dataFileContext.setResultVOFile(resultVO);
        executor.accept(DataFileTypeEnum.GROUP,dataFileContext);
        deleteLocalFile(resultVO);
    }

}
