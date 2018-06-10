package com.fly.caipiao.comment.web.vo;

/**
 * @author baidu
 * @date 2018/6/6 下午2:39
 * @description ${TODO}
 **/
public class UserResponseVO {
    private String key;
    private Integer docCount;

    public UserResponseVO() {
    }

    public UserResponseVO(String key, Integer docCount) {
        this.key = key;
        this.docCount = docCount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getDocCount() {
        return docCount;
    }

    public void setDocCount(Integer docCount) {
        this.docCount = docCount;
    }
}
