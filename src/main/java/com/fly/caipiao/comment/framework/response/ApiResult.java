package com.fly.caipiao.comment.framework.response;

/**
 * @author baidu
 * @date 2018/6/6 下午5:48
 * @description ${TODO}
 **/
public class ApiResult {

    public static <T> SuccessRespData<T> success(){
        return new SuccessRespData<T>();
    }

    public static <T> SuccessRespData<T> success(T t){
        return new SuccessRespData<T>(t);
    }

    public static <T> SuccessRespData<T> success(T t, String message){
        return new SuccessRespData<T>(t,message);
    }

    public static <T> FailedRespData<T> failed(){
        return new FailedRespData<T>();
    }

    public static <T> FailedRespData<T> failed(String message){
        return new FailedRespData<T>(message);
    }

    public static <T> FailedRespData<T> failed(String message,Integer code){
        return new FailedRespData<T>(message,code);
    }


}
