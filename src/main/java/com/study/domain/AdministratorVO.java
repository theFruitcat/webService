package com.study.domain;
/**
 * 管理员实体类
 *
 * */
public class AdministratorVO {
    //管理员ID
    private String administratorId;
    //管理员密码
    private String password;
    //管理员名称
    private String name;
    //电话号码
    private Integer phoneNumber;

    public String getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(String administratorId) {
        this.administratorId = administratorId == null ? null : administratorId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}