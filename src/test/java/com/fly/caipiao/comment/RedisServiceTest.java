package com.fly.caipiao.comment;

import com.fly.caipiao.comment.service.MongoService;
import com.fly.caipiao.comment.service.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author baidu
 * @date 2018/5/11 下午11:09
 * @description ${TODO}
 **/
public class RedisServiceTest extends BaseTest {

    @Autowired
    private RedisService redisService;
    @Autowired
    private MongoService mongoService;

    @Test
    public void testInsert() {
        System.out.println(redisService.set("a", "hello world"));
        System.out.println(redisService.get("a"));
    }
}
