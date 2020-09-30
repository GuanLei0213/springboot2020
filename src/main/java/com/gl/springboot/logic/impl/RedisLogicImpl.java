package com.gl.springboot.logic.impl;

import com.gl.springboot.entity.UserInfo;
import com.gl.springboot.logic.RedisLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisLogicImpl implements RedisLogic {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean setValue(String key, String value) {
        stringRedisTemplate.opsForValue().set(key,value);
        return true;
    }

    @Override
    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean setUserInfo(UserInfo userInfo){
        redisTemplate.opsForValue().set("userInfo-"+userInfo.getUserId(),userInfo);
        return true;
    }

    @Override
    public UserInfo getUserInfo(String key){
        return (UserInfo) redisTemplate.opsForValue().get(key);
    }
}
