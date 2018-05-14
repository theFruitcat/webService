package com.study.service;

import com.study.domain.StudyProgressVO;
import com.study.domain.TestRecordVO;

public interface StudyProgressService {
    //查询用户的学习进度
    StudyProgressVO getStudyProgress(String userId);
    //更新用户的学习进度
    int updateStudyProgress(StudyProgressVO record);
    //新增用户的学习进度
    int insertStudyProgress(StudyProgressVO record);
    //新增用户的测试记录
    int insertTestRecord(TestRecordVO record);
}
