package com.study.domain;

public class ArticleCollectionVOKey {
    //�û�ID
    private String userId;
    //����ID
    private Integer articleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}