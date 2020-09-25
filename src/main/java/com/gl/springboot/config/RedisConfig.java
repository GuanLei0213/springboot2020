package com.gl.springboot.config;

import com.gl.springboot.entity.RedisData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    /**
     * 配置序列化器，解决对象属性乱码的问题
     */
    @Bean
    public RedisTemplate<String,RedisData> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,RedisData> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisData.class));
        return redisTemplate;
    }

}
