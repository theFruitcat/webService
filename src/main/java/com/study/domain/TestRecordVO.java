package com.study.domain;

import java.util.Date;
/**
 * ���Լ�¼ʵ����
 * */
public class TestRecordVO {
    //�û�ID
    private String userId;
    //����
    private Integer fraction;
    //�ȼ�
    private String level;
    //����ʱ��
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