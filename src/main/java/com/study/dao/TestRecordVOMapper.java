package com.study.dao;

import com.study.domain.TestRecordVO;

public interface TestRecordVOMapper {
    //删除测试记录
    int deleteByPrimaryKey(String userId);
    //新增测试记录
    int insert(TestRecordVO record);
    //新增测试记录
    int insertSelective(TestRecordVO record);
    //查询测试记录
    TestRecordVO selectByPrimaryKey(String userId);
    //更新测试记录
    int updateByPrimaryKeySelective(TestRecordVO record);
    //更新测试记录
    int updateByPrimaryKey(TestRecordVO record);
}