package com.study.domain;
/**
 * �ѱ��еĵ���ʵ����
 *
 * */
public class WordRecitedVO {
    //�û�ID
    private String userId;
    //���ID
    private Integer categoryId;
    //���б��
    private Integer reciteNumber;

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

    public Integer getReciteNumber() {
        return reciteNumber;
    }

    public void setReciteNumber(Integer reciteNumber) {
        this.reciteNumber = reciteNumber;
    }
}