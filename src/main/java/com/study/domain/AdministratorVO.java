package com.study.domain;
/**
 * ����Աʵ����
 *
 * */
public class AdministratorVO {
    //����ԱID
    private String administratorId;
    //����Ա����
    private String password;
    //����Ա����
    private String name;
    //�绰����
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