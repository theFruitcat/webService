package com.study.service.impl;

import com.study.dao.*;
import com.study.domain.*;
import com.study.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 获取用户的相关信息
 * @author gaoziming
 * */
@Service("UserInfoService")
@Transactional
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

    @Autowired
    AdministratorVOMapper administratorDao;

    //根据用户ID获取用户的详细信息
    public  UserVO getUserInfo(String id){
        UserVO user = userDao.selectByPrimaryKey(id);
        return user;
    }

    //根据管理员ID获取管理员的详细信息
    public AdministratorVO getAdministratorVO(String id){
        return administratorDao.selectByPrimaryKey(id);
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
    //批量查询已背诵单词
    public List<WordRecitedVO> getRecitedWords(Map<String, Object> map) {
        return wordRecitedDao.selectByPageLimit(map);
    }

    @Override
    //批量查询收藏单词
    public List<WordCollectionVO> getCollectionWords(Map<String, Object> map) {
        return wordCollectionDao.selectByPageLimit(map);
    }

    @Override
    //批量查询用户收藏的文章
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
