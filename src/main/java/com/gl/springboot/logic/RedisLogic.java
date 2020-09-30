package com.gl.springboot.logic;

import com.gl.springboot.entity.UserInfo;

public interface RedisLogic {

    boolean setValue(String key,String value);

    String getValue(String key);

    boolean setUserInfo(UserInfo userInfo);

    UserInfo getUserInfo(String key);
}
