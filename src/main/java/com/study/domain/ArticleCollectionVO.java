package com.study.domain;

import java.util.Date;
/**
 * 文章收藏实体类
 *
 * */
public class ArticleCollectionVO extends ArticleCollectionVOKey {
    //收藏时间
    private Date collectionTime;

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }
}