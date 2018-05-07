package com.study.service.impl;

import com.study.dao.StudyProgressVOMapper;
import com.study.domain.StudyProgressVO;
import com.study.service.StudyProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 学习进度处理
 * @author gaoziming
 * */
@Service("StudyProgressService")
@Transactional
public class StudyProgressServiceImpl implements StudyProgressService{

    @Autowired
    StudyProgressVOMapper studyProgressDao;

    @Override
    //查询用户的学习进度
    public StudyProgressVO getStudyProgress (String userId) {

        return studyProgressDao.selectByPrimaryKey(userId);
    }

    @Override
    //更新用户的学习进度
    public int updateStudyProgress(StudyProgressVO record) {
        return studyProgressDao.updateByPrimaryKeySelective(record);
    }

    @Override
    //新增用户的学习进度
    public int insertStudyProgress(StudyProgressVO record) {
        return studyProgressDao.insertSelective(record);
    }
}
