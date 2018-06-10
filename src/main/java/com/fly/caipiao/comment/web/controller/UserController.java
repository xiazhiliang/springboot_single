package com.fly.caipiao.comment.web.controller;

import com.fly.caipiao.comment.entity.PutUser;
import com.fly.caipiao.comment.framework.response.ApiResult;
import com.fly.caipiao.comment.framework.response.ResponseData;
import com.fly.caipiao.comment.service.PutUserService;
import com.fly.caipiao.comment.web.vo.request.LoginRequestVO;
import com.fly.caipiao.comment.web.vo.request.NicknameRequestVO;
import com.fly.caipiao.comment.web.vo.request.PwdRequestVO;
import com.fly.caipiao.comment.web.vo.request.RegisterRequestVO;
import com.fly.caipiao.comment.web.vo.response.LoginResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author baidu
 * @date 2018/5/24 下午3:45
 * @description 用户评论
 **/

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PutUserService userService;

    /**
     * 登录
     * @param requestVO
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseData register(@RequestBody @Valid RegisterRequestVO requestVO){
        PutUser user = new PutUser();
        BeanUtils.copyProperties(requestVO,user);
        userService.register(user);
        return ApiResult.success();
    }

    /**
     * 登录
     * @param requestVO
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseData login(@RequestBody @Valid LoginRequestVO requestVO){
        LoginResponseVO responseVO = userService.login(requestVO.getUsername(),requestVO.getPassword());
        return ApiResult.success(responseVO);
    }

    /**
     * 密码更改
     * @param requestVO
     * @return
     */
    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
    public ResponseData updatePwd(@RequestBody @Valid PwdRequestVO requestVO){
        userService.updatePwd(requestVO.getUserId(),requestVO.getOldPassword(),requestVO.getNewPassword());
        return ApiResult.success();
    }

    /**
     * 昵称更改
     * @param requestVO
     * @return
     */
    @RequestMapping(value = "/updateNickname",method = RequestMethod.POST)
    public ResponseData updateNickname(@RequestBody @Valid NicknameRequestVO requestVO){
        userService.updateNickname(requestVO.getUserId(),requestVO.getNickname());
        return ApiResult.success();
    }
}
