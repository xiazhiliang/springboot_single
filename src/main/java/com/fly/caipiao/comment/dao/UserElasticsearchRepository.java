package com.fly.caipiao.comment.dao;

import com.fly.caipiao.comment.entity.es.UserEsEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author baidu
 * @date 2018/5/30 下午4:39
 * @description ${TODO}
 **/
@Repository
public interface UserElasticsearchRepository extends ElasticsearchRepository<UserEsEntity, Long> {

}
