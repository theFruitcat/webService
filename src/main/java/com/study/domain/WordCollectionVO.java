package com.study.domain;
/**
 * �����ղ�ʵ����
 * */
public class WordCollectionVO {
    //�û�ID
    private String userId;
    //���ID
    private Integer categoryId;
    //�ղر��
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