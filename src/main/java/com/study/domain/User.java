package com.study.domain;

import java.util.Date;

public class User {
    private String username;

    private String password;

    private Date registData;

    private Integer level;

    private String name;

    private String alias;

    private Integer age;

    private Integer phoneNumber;

    private Integer integral;

    private String abilityLevel;

    private Integer numberFailure;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getRegistData() {
        return registData;
    }

    public void setRegistData(Date registData) {
        this.registData = registData;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
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
}