package com.study.dao;

import com.study.domain.StudyProgressVO;

public interface StudyProgressVOMapper {
    //ɾ��ѧϰ����
    int deleteByPrimaryKey(String userId);
    //����ѧϰ����
    int insert(StudyProgressVO record);
    //����ѧϰ����
    int insertSelective(StudyProgressVO record);
    //��ѯѧϰ����
    StudyProgressVO selectByPrimaryKey(String userId);
    //����ѧϰ����
    int updateByPrimaryKeySelective(StudyProgressVO record);
    //����ѧϰ����
    int updateByPrimaryKey(StudyProgressVO record);
}