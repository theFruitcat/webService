package com.study.dao;

import com.study.domain.WordSituationNumberVO;

public interface WordSituationNumberVOMapper {
    //ɾ���龳���ʱ��
    int deleteByPrimaryKey(String name);
    //�����龳���ʱ��
    int insert(WordSituationNumberVO record);
    //�����龳���ʱ��
    int insertSelective(WordSituationNumberVO record);
    //��ѯ���е��ʱ��
    WordSituationNumberVO selectByPrimaryKey(String name);
    //���±��е��ʱ��
    int updateByPrimaryKeySelective(WordSituationNumberVO record);
    //���±��е��ʱ��
    int updateByPrimaryKey(WordSituationNumberVO record);
}