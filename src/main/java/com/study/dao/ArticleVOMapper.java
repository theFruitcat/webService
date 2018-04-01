package com.study.dao;

import com.study.domain.ArticleVO;

public interface ArticleVOMapper {
    //ɾ������
    int deleteByPrimaryKey(Integer articleId);
    //��������
    int insert(ArticleVO record);
    //��������
    int insertSelective(ArticleVO record);
    //��ѯ����
    ArticleVO selectByPrimaryKey(Integer articleId);
    //��������
    int updateByPrimaryKeySelective(ArticleVO record);
    //��updateByExample��ȴ˷��������޸Ĵ��ֶ����ͣ��������ʺ�updateByExample��ͬ
    int updateByPrimaryKeyWithBLOBs(ArticleVO record);

    int updateByPrimaryKey(ArticleVO record);
}