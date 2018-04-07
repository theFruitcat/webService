package com.study.domain;

import java.util.Date;
import java.util.Map;

/**
 * 学习进度实体类
 * */
public class StudyProgressVO {
    //用户ID
    private String userId;
    //类别ID
    private Integer categoryId;
    //当前背诵单词编号
    private Integer currentNumber;
    //背诵时间
    private Date reciteTime;

    //是否完成当前任务
    private String passed;

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

    public String getPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }

}