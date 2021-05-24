/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description: 自动填充处理类
 * @Auther: za-guanlei
 * @Date: 2021/04/07/9:56
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    //在执行mybatisPlus的insert()时，为我们自动给某些字段填充值，这样的话，我们就不需要手动给insert()里的实体类赋值了
    @Override
    public void insertFill(MetaObject metaObject) {
        //其中方法参数中第一个是前面自动填充所对应的字段，第二个是要自动填充的值。第三个是指定实体类的对象
        this.setFieldValByName("modifierId", new Long(111), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
        this.setFieldValByName("creatorId", new Long(111), metaObject);
        this.setFieldValByName("gmtCreat",new Date(), metaObject);
        this.setFieldValByName("availableFlag",true, metaObject);
    }

    //在执行mybatisPlus的update()时，为我们自动给某些字段填充值，这样的话，我们就不需要手动给update()里的实体类赋值了
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifierId", new Long(111), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
