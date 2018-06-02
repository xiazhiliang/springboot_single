package com.fly.caipiao.comment.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * @author baidu
 * @date 2018/5/30 下午5:27
 * @description ${TODO}
 **/

@Document(indexName = "user_index",type="user")
public class UserEsEntity {
    @Id
    @Field(store=true,type=FieldType.Long)
    private Long id;
    @Field(store=true,type=FieldType.Text)
    private String firstName;
    @Field(store=true,type=FieldType.Text)
    private String lastName;
    @Field(store=true,type=FieldType.Text)
    private String email;
    @Field(store=true,type=FieldType.Text)
    private String tel;
    @Field(store=true,type=FieldType.Text)
    private Integer age;
    @Field(store=true,type=FieldType.Text)
    private String about;
    @Field(store=true,type=FieldType.Text)
    private List<String> interests;
    @Field(store=true,type=FieldType.Text)
    private String address;

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
