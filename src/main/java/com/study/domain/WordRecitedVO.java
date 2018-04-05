package com.study.domain;
/**
 * 已背诵单词实体类
 *
 * */
public class WordRecitedVO {
    //用户ID
    private String userId;
    //类别ID
    private Integer categoryId;
    //背诵编号
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