package com.study.dao;

import com.study.domain.ArticleCollectionVO;
import com.study.domain.ArticleCollectionVOKey;
/**
 * �����ղ�
 * */
public interface ArticleCollectionVOMapper {
    //ɾ�������ղ�
    int deleteByPrimaryKey(ArticleCollectionVOKey key);
    //���������ղ�
    int insert(ArticleCollectionVO record);
    //���������ղ� ��������ڿ�ֵ
    int insertSelective(ArticleCollectionVO record);
    //��ѯ�����ղ�
    ArticleCollectionVO selectByPrimaryKey(ArticleCollectionVOKey key);
    //���������ղ� �Ƽ�
    int updateByPrimaryKeySelective(ArticleCollectionVO record);
    //���������ղ�
    int updateByPrimaryKey(ArticleCollectionVO record);
}