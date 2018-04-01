package com.study.dao;

import com.study.domain.WordReciteVO;
import com.study.domain.WordReciteVOKey;

public interface WordReciteVOMapper {
    //ɾ�����е���
    int deleteByPrimaryKey(WordReciteVOKey key);
    //�������е���
    int insert(WordReciteVO record);
    //�������е���
    int insertSelective(WordReciteVO record);
    //��ѯ���е���
    WordReciteVO selectByPrimaryKey(WordReciteVOKey key);
    //���±��е���
    int updateByPrimaryKeySelective(WordReciteVO record);
    //���±��е���
    int updateByPrimaryKey(WordReciteVO record);
}