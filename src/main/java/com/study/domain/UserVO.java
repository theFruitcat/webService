package com.study.domain;

import java.util.Date;
/**
 * 用户实体类
 * */
public class UserVO {
    //用户ID
    private String userId;
    //用户密码
    private String password;
    //注册时间
    private Date registDate;
    //能力等级
    private String level;
    //姓名
    private String name;
    //别名,昵称
    private String alias;
    //年龄
    private Integer age;
    //电话号码
    private Integer phoneNumber;
    //积分
    private String integral;
    //能力等级
    private String abilityLevel;
    //失败次数
    private Integer numberFailure;
    //邮箱
    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral == null ? null : integral.trim();
    }

    public String getAbilityLevel() {
        return abilityLevel;
    }

    public void setAbilityLevel(String abilityLevel) {
        this.abilityLevel = abilityLevel == null ? null : abilityLevel.trim();
    }

    public Integer getNumberFailure() {
        return numberFailure;
    }

    public void setNumberFailure(Integer numberFailure) {
        this.numberFailure = numberFailure;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}