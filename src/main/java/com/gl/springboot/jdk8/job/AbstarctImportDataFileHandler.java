/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.jdk8.job;

import cn.hutool.core.io.FileUtil;
import com.gl.springboot.enumeration.DataFileTypeEnum;
import com.gl.springboot.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.function.BiConsumer;

/**
 * @Description: 导入数据文件抽象类
 * @Auther: za-guanlei
 * @Date: 2021/05/18/11:16
 */
@Slf4j
public abstract class AbstarctImportDataFileHandler implements BiConsumer<DataFileTypeEnum, DataFileContext> {

    @Override
    public BiConsumer<DataFileTypeEnum, DataFileContext> andThen(BiConsumer<? super DataFileTypeEnum, ? super DataFileContext> after) {
        return null;
    }

    @Override
    public void accept(DataFileTypeEnum fileTypeEnum, DataFileContext dataFileContext) {
        log.info("这里做了重载，上一层是否处理成功可以统一在这里判断.......");
    }

    /**
     * 定义普通方法，以方便其它继承该抽象类的子类能够复用，达到复用的目的
     */
    public void deleteLocalFile(ResultVO<File> resultVO){
        if (!resultVO.isSuccess())
            return;
        File file = resultVO.getData();
        boolean del = FileUtil.del(file);
        log.warn("AbstarctImportDataFileHandler delete file........ result:{},filePath:{}",del,file.getAbsolutePath());
    }
}
