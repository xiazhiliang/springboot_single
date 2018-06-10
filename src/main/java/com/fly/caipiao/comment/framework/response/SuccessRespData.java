package com.fly.caipiao.comment.framework.response;

/**
 * @author baidu
 * @date 2018/6/6 下午5:28
 * @description ${TODO}
 **/
public class SuccessRespData<T> extends ResponseData {

    public static final int CODE = 1000;

    public static final String MESSAGE = "操作成功";


    public SuccessRespData() {
        this(null);
    }

    public SuccessRespData(T data) {
        this(data,null);
    }

    public SuccessRespData(T data, String message) {
        this.setData(data);
        this.setCode(CODE);
        this.setMessage(message);
    }
}
