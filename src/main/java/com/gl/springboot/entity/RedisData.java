package com.gl.springboot.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RedisData implements Serializable {
    //存储到redis中使序列化器生效必须实现Serializable

    private String name;

    private String age;

    private String workName;
}
