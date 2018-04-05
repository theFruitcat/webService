package com.study.domain;
/**
 * 文章收藏实体类
 *
 * */
public class ArticleCollectionVOKey {
    //用户ID
    private String userId;
    //文章ID
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