/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.util;

import com.gl.springboot.annotation.Validate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.regex.Pattern;

@Slf4j
public class ValidateUtil {

    /**
     * 通过反射及实体上的注解验证
     */
    public static <T> boolean validate(T clazz) {
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            Validate annotation = field.getAnnotation(Validate.class);
            if(Objects.isNull(annotation)){
                continue;
            }
            String value;
            try {
                PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(),clazz.getClass());
                Method getMethod = descriptor.getReadMethod();//获得get方法
                value = getMethod.invoke(clazz).toString();//执行get方法返回一个Object
            } catch (Exception e) {
                log.error("validate get property value error....",e);
                return false;
            }
            if (!annotation.blank() && StringUtils.isEmpty(value)) {
                return false;
            }

            if(annotation.blank() && StringUtils.isEmpty(value)){
                continue;
            }

            if (value.length() > annotation.maxLength() || !Pattern.matches(annotation.regex(),value)){
                return false;
            }
        }
        return true;
    }
}
