package com.study.domain;
/**
 * 单词收藏实体类
 * */
public class WordCollectionVO {
    //用户ID
    private String userId;
    //类别ID
    private Integer categoryId;
    //单词收藏编号
    private Integer collectionNumber;

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

    public Integer getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(Integer collectionNumber) {
        this.collectionNumber = collectionNumber;
    }
}