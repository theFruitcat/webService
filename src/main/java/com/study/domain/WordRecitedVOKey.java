package com.study.domain;

public class WordRecitedVOKey {
    //用户ID
    private String userId;
    //类别ID
    private Integer categoryId;
    //背诵单词编号
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