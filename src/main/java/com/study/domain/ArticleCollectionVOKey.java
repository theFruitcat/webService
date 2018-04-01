package com.study.domain;

public class ArticleCollectionVOKey {
    //ÓÃ»§ID
    private String userId;
    //ÎÄÕÂID
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