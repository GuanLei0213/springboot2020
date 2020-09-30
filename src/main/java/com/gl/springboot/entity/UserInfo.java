package com.gl.springboot.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -6264696829484922152L;

    private String userId;

    private String userName;

    private String userAge;

    private String userSex;

    private String userWork;
}
