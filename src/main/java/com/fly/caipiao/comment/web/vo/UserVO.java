package com.fly.caipiao.comment.web.vo;

import com.fly.caipiao.comment.entity.es.UserEsEntity;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

/**
 * @author baidu
 * @date 2018/5/30 下午5:27
 * @description ${TODO}
 **/

@Document(indexName = "user_index",type="user")
public class UserVO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String tel;
    private Integer age;
    private String about;
    private List<String> interests;
    private String address;

    public UserVO() {
    }

    public UserVO(UserEsEntity entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
        this.tel = entity.getTel();
        this.age = entity.getAge();
        this.about = entity.getAbout();
        this.interests = entity.getInterests();
        this.address = entity.getAddress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
