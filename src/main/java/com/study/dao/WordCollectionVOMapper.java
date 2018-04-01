package com.study.dao;

import com.study.domain.WordCollectionVO;

public interface WordCollectionVOMapper {
    //ɾ�������ղ�
    int deleteByPrimaryKey(String userId);
    //���������ղ�
    int insert(WordCollectionVO record);
    //���������ղ�
    int insertSelective(WordCollectionVO record);
    //��ѯ�ղص���
    WordCollectionVO selectByPrimaryKey(String userId);
    //�����ղص���
    int updateByPrimaryKeySelective(WordCollectionVO record);
    //�����ղص���
    int updateByPrimaryKey(WordCollectionVO record);
}