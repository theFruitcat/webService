package com.study.dao;

import com.study.domain.WordReciteNumberVO;
import com.study.domain.WordReciteNumberVOKey;

public interface WordReciteNumberVOMapper {
    //ɾ�����е��ʱ��
    int deleteByPrimaryKey(WordReciteNumberVOKey key);
    //�������е��ʱ��
    int insert(WordReciteNumberVO record);
    //�������е��ʱ��
    int insertSelective(WordReciteNumberVO record);
    //��ѯ���е��ʱ��
    WordReciteNumberVO selectByPrimaryKey(WordReciteNumberVOKey key);
    //���µ��ʱ��
    int updateByPrimaryKeySelective(WordReciteNumberVO record);
    //���µ��ʱ��
    int updateByPrimaryKey(WordReciteNumberVO record);
}