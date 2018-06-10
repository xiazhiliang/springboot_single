package com.fly.caipiao.comment.service;

import com.fly.caipiao.comment.entity.es.UserEsEntity;
import com.fly.caipiao.comment.web.vo.UserResponseVO;
import com.fly.caipiao.comment.web.vo.UserVO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author baidu
 * @date 2018/5/29 上午2:58
 * @description ${TODO}
 **/
public interface ElasticSearchService {
    /**
     * 写入数据
     * @param entity
     */
    void add(UserEsEntity entity);

    /**
     * match查询
     * @return
     */
    List<UserVO> listConditionMatch();

    /**
     * 短语查询
     * @return
     */
    List<UserVO> listConditionPhraseMatch(Pageable pageable);

    /**
     * 短语查询高亮展示
     * @return
     */
    List<UserVO> listConditionPhraseMatchHighlight();


    /**
     * bool(多条件)查询
     * @return
     */
    List<UserVO> listConditionBool();

    /**
     * 聚合查询
     * @return
     */
    List<UserResponseVO> listConditionsAggregations();

}
