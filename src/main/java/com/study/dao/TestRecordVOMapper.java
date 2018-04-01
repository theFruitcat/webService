package com.study.dao;

import com.study.domain.TestRecordVO;

public interface TestRecordVOMapper {
    //ɾ�����Լ�¼
    int deleteByPrimaryKey(String userId);
    //�������Լ�¼
    int insert(TestRecordVO record);
    //�������Լ�¼
    int insertSelective(TestRecordVO record);
    //��ѯ���Լ�¼
    TestRecordVO selectByPrimaryKey(String userId);
    //���²��Լ�¼
    int updateByPrimaryKeySelective(TestRecordVO record);
    //���²��Լ�¼
    int updateByPrimaryKey(TestRecordVO record);
}