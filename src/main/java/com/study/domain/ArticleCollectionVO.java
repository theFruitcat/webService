package com.study.domain;

import java.util.Date;
/**
 * �����ղ�ʵ����
 *
 * */
public class ArticleCollectionVO extends ArticleCollectionVOKey {
    //�ղ�ʱ��
    private Date collectionTime;

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }
}