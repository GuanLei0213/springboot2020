package com.gl.springboot.enumeration;

/**
 * @Description: 数据文件类型枚举
 * @Auther: za-guanlei
 * @Date: 2021/05/18/13:48
 */
public enum DataFileTypeEnum {

    AGENCY(1,"AgencyDataFile"),
    GROUP(2,"GroupDataFile");

    private Integer code;

    private String desc;

    DataFileTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
