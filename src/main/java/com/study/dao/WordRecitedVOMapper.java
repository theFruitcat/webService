package com.study.dao;

import com.study.domain.WordRecitedVO;

public interface WordRecitedVOMapper {
    //ɾ�����е���
    int deleteByPrimaryKey(String userId);
    //�������е���
    int insert(WordRecitedVO record);
    //�������е���
    int insertSelective(WordRecitedVO record);
    //��ѯ����
    WordRecitedVO selectByPrimaryKey(String userId);
    //���µ���
    int updateByPrimaryKeySelective(WordRecitedVO record);
    //���µ���
    int updateByPrimaryKey(WordRecitedVO record);
}