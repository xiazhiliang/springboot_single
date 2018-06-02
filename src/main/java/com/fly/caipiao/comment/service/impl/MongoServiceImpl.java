package com.fly.caipiao.comment.service.impl;

import com.fly.caipiao.comment.entity.UserEntity;
import com.fly.caipiao.comment.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baidu
 * @date 2018/5/13 下午4:10
 * @description ${TODO}
 **/

@Service
public class MongoServiceImpl implements MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List find(Query query, Class t) {
        return mongoTemplate.find(query,t);
    }

    @Override
    public void insert(UserEntity userEntity) {
        mongoTemplate.insert(userEntity);
    }


}
