package com.fly.caipiao.comment.service;

import com.fly.caipiao.comment.entity.mongo.UserEntity;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @author baidu
 * @date 2018/5/13 下午4:09
 * @description ${TODO}
 **/
public interface MongoService {

    List find(Query query, Class clazz);

    void insert(UserEntity userEntity);
}
