package com.fly.caipiao.comment;

import com.fly.caipiao.comment.entity.mongo.UserEntity;
import com.fly.caipiao.comment.service.MongoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author baidu
 * @date 2018/5/11 下午11:09
 * @description ${TODO}
 **/
public class MongoServiceTest extends BaseTest {

    @Autowired
    private MongoService mongoService;

    @Test
    public void testInsertMongo(){
//        UserEntity user = new UserEntity();
//        user.setUserId("11111111");
//        user.setUserName("baidu");
//        user.setAddress("Cambodia");
//        mongoService.insert(user);
        Query query= new Query();
        Criteria criteria = new Criteria();
        query.addCriteria(criteria);
        System.out.println(mongoService.find(query,UserEntity.class).get(0).toString());
    }
}
