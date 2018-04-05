package com.study.dao;

import com.study.domain.StudyProgressVO;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyProgressVOMapper {
    //删除学习进度
    int deleteByPrimaryKey(String userId);
    //新增学习进度
    int insert(StudyProgressVO record);
    //新增学习进度
    int insertSelective(StudyProgressVO record);
    //查询学习进度
    StudyProgressVO selectByPrimaryKey(String userId);
    //更新学习进度
    int updateByPrimaryKeySelective(StudyProgressVO record);
    //更新学习进度
    int updateByPrimaryKey(StudyProgressVO record);
}