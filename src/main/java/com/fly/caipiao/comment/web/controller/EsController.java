package com.fly.caipiao.comment.web.controller;

import com.fly.caipiao.comment.entity.UserEsEntity;
import com.fly.caipiao.comment.service.EsTestService;
import com.fly.caipiao.comment.web.vo.ApiResultVO;
import com.fly.caipiao.comment.web.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QPageRequest;
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
public class EsController {
    private final static Logger logger = LoggerFactory.getLogger(EsController.class);
    @Autowired
    private EsTestService esTestService;

    @RequestMapping("/add")
    public ApiResultVO add(@RequestBody UserVO userVo){
        UserEsEntity entity = new UserEsEntity();
        BeanUtils.copyProperties(userVo,entity);
        esTestService.add(entity);
        return new ApiResultVO();
    }

    @RequestMapping("/list")
    public ApiResultVO list(Integer pageNumber,Integer pageSize){
        QPageRequest request = new QPageRequest(pageNumber,pageSize);
        List<UserVO> list =  esTestService.listConditionPhraseMatch(request);
        ApiResultVO resultVO = new ApiResultVO();
        resultVO.setData(list);
        return resultVO;
    }
}
