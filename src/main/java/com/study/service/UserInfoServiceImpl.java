package com.study.service;

import com.study.dao.*;
import com.study.domain.*;
import com.study.service.impl.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 获取用户的相关信息
         * */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    UserVOMapper userDao;

    @Autowired
    StudyProgressVOMapper studyProgressDao;

    @Autowired
    WordRecitedVOMapper wordRecitedDao;

    @Autowired
    WordCollectionVOMapper wordCollectionDao;

    @Autowired
    ArticleCollectionVOMapper articleCollectionDao;

    //根据用户ID获取用户的详细信息
    public  UserVO getUserInfo(String id){
        UserVO user = userDao.selectByPrimaryKey(id);
        return user;
    }

    @Override
    //注册用户
    public int registUser(UserVO uservo) {
        return userDao.insertSelective(uservo);
    }

    @Override
    //删除用户
    public int deleteUser(String userId) {
        return userDao.deleteByPrimaryKey(userId);
    }

    @Override
    //更新用户的信息
    public int updateUser(UserVO record) {
        return userDao.updateByPrimaryKeySelective(record);
    }


    @Override
    //查询用户的学习进度
    public StudyProgressVO getStudyProgress (String userId) {
        return studyProgressDao.selectByPrimaryKey(userId);
    }

    @Override
    //查询用户收藏的文章
    public List<ArticleCollectionVO> getCollectionArticles(Map<String, Object> map) {
        return articleCollectionDao.selectAll(map);
    }

    public String getUserStudyProgress(String id) {
        //当前学习科目
        Integer currentStudyProject;
        currentStudyProject = studyProgressDao.selectByPrimaryKey(id).getCategoryId();
        //判断当前学习类别是否为0 ,如果是0 ,说明用户正在使用情境背诵,返回情境,否则返回单词背诵等级
        if (currentStudyProject == 0) {
            return "SituationStudy";
        } else {
            return currentStudyProject.toString();
        }
    }
}
