package com.study.domain;

import java.util.Date;
/**
 * �û�ʵ����
 * */
public class UserVO {
    //�û�ID
    private String userId;
    //����
    private String password;
    //ע��ʱ��
    private Date registDate;
    //�ȼ�
    private String level;
    //����
    private String name;
    //����
    private String alias;
    //����
    private Integer age;
    //�绰����
    private Integer phoneNumber;
    //����ֵ
    private String integral;
    //�����ȼ�
    private String abilityLevel;
    //����ʧ�ܴ���
    private Integer numberFailure;
    //����
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