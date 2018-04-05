package com.study.domain;

import java.util.Date;
/**
 * 测试记录
 * */
public class TestRecordVO {
    //用户ID
    private String userId;
    //分数
    private Integer fraction;
    //等级
    private String level;
    //测试时间
    private Date testTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }
}