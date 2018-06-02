package com.fly.caipiao.comment.service.impl;

import com.fly.caipiao.comment.service.RedisService;
import com.fly.caipiao.comment.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis cache 工具类
 * 
 */
@Service("redisService")
public final class RedisServiceImpl implements RedisService {

	private Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

	private RedisTemplate<Serializable, Object> redisTemplate;

	/**
	* 批量删除对应的value
	* 
	* @param keys
	*/
	@Override
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	* 批量删除key
	* 
	* @param pattern
	*/
	@Override
	public void removePattern(final String pattern) {
		Set<Serializable> keys = redisTemplate.keys(pattern);
		if (!keys.isEmpty()) {
			redisTemplate.delete(keys);
		}
	}

	/**
	* 删除对应的value
	* 
	* @param key
	*/
	@Override
	public void remove(final String key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	* 判断缓存中是否有对应的value
	* 
	* @param key
	* @return
	*/
	@Override
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	* 读取缓存
	* 
	* @param key
	* @return
	*/
	@Override
	public Object get(final String key) {
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		Object result = operations.get(key);
		return result;
	}

	/**
	* 写入缓存,数据不过期
	* 
	* @param key
	* @param value
	* @return
	*/
	@Override
	public boolean set(final String key, Object value) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			logger.error("====>>>error:", e);
		}
		return result;
	}

	/**
	* 写入缓存，指定过期时间
	* 
	* @param key
	* @param value
	* @return
	*/
	@Override
	public boolean set(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			logger.error("====>>>error:", e);
		}
		return result;
	}

	@Override
	public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void lpush(String key, Object value){
		ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
		operations.leftPush(key, JacksonUtil.beanToJson(value));
	}

	@Override
	public Object rpop(String key){
		ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
		return operations.rightPop(key);
	}
}