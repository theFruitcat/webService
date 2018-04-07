package com.study.service;

import com.study.domain.StudyProgressVO;

public interface StudyProgressService {
    //查询用户的学习进度
    StudyProgressVO getStudyProgress(String userId);
    //更新用户的学习进度
    int updateStudyProgress(StudyProgressVO record);
    //新增用户的学习进度
    int insertStudyProgress(StudyProgressVO record);
}
