package com.gl.springboot;

import com.gl.springboot.entity.RedisData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Springboot2020ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,RedisData> redisTemplate;

   /* @Autowired
    private RedisTemplate<String,String> redisTemplate;*/

    /*@Test
    public void set(){
        redisTemplate.opsForValue().set("hf","hf");
        System.out.println(redisTemplate.opsForValue().get("hf"));
    }*/

    /**
     * 测试序列化器是否生效
     */
    @Test
    public void setObject(){
        RedisData redisData = new RedisData();
        redisData.setName("张三");
        redisData.setAge("22");
        redisData.setWorkName("张三的公司");
        redisTemplate.opsForValue().set("redisData",redisData);
    }

}
