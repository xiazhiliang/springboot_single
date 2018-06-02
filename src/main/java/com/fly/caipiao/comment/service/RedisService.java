package com.fly.caipiao.comment.service;

import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

public interface RedisService {
    void remove(String... keys);

    void removePattern(String pattern);

    void remove(String key);

    boolean exists(String key);

    Object get(String key);

    boolean set(String key, Object value);

    boolean set(String key, Object value, Long expireTime);

    void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate);

    void lpush(String key, Object value);

    Object rpop(String key);
}
