package com.study.dao;

import com.study.domain.WordStituationVO;

public interface WordStituationVOMapper {
    //ɾ�����е���
    int deleteByPrimaryKey(String name);
    //�������е���
    int insert(WordStituationVO record);
    //�������е���
    int insertSelective(WordStituationVO record);
    //��ѯ���е���
    WordStituationVO selectByPrimaryKey(String name);
    //���±��е���
    int updateByPrimaryKeySelective(WordStituationVO record);
    //���±��е���
    int updateByPrimaryKey(WordStituationVO record);
}