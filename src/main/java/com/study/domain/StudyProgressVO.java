package com.study.domain;

import java.util.Date;
/**
 * ѧϰ����ʵ����
 * */
public class StudyProgressVO {
    //�û�ID
    private String userId;
    //���ID
    private Integer categoryId;
    //��ǰ���е��ʱ��
    private Integer currentNumber;
    //���п�ʼʱ��
    private Date reciteTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Date getReciteTime() {
        return reciteTime;
    }

    public void setReciteTime(Date reciteTime) {
        this.reciteTime = reciteTime;
    }
}