package com.fly.caipiao.comment.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author baidu
 * @date 2018/5/13 下午5:01
 * @description ${TODO}
 **/
@Document(collection = "user")
public class UserEntity {
    @Id
    private String userId;
    private String userName;
    private String email;
    private String tel;
    private String address;
    private String wechat;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserEntity{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", tel='").append(tel).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", wechat='").append(wechat).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
