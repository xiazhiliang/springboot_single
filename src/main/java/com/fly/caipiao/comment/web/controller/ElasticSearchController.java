package com.fly.caipiao.comment.web.controller;

import com.fly.caipiao.comment.entity.es.UserEsEntity;
import com.fly.caipiao.comment.framework.response.ApiResult;
import com.fly.caipiao.comment.framework.response.ResponseData;
import com.fly.caipiao.comment.service.ElasticSearchService;
import com.fly.caipiao.comment.web.vo.UserResponseVO;
import com.fly.caipiao.comment.web.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author baidu
 * @date 2018/5/29 上午2:52
 * @description ${TODO}
 **/

@RestController
@RequestMapping("/es")
public class ElasticSearchController {
    private final static Logger logger = LoggerFactory.getLogger(ElasticSearchController.class);
    @Autowired
    private ElasticSearchService elasticSearchService;

    @RequestMapping("/add")
    public ResponseData add(@RequestBody UserVO userVo){
        UserEsEntity entity = new UserEsEntity();
        BeanUtils.copyProperties(userVo,entity);
        elasticSearchService.add(entity);
        return ApiResult.success();
    }

    @RequestMapping("/list")
    public ResponseData list(Integer pageNumber,Integer pageSize){
//        QPageRequest request = new QPageRequest(pageNumber,pageSize);
//        List<UserVO> list =  elasticSearchService.listConditionPhraseMatch(request);
        List<UserVO> list =  elasticSearchService.listConditionPhraseMatchHighlight();
        return ApiResult.success(list);
    }

    @RequestMapping("/aggregations")
    public ResponseData aggregations(){
        List<UserResponseVO> list =  elasticSearchService.listConditionsAggregations();
        return ApiResult.success(list);
    }
}
