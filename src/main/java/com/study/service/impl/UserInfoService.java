package com.study.service.impl;

import com.study.domain.*;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    //根据获取用户全部信息
    UserVO getUserInfo(String id);
    //注册用户
    int registUser (UserVO uservo);
    //删除用户
    int deleteUser(String userId);
    //更新用户
    int updateUser(UserVO record);
    //查询用户的学习进度
    StudyProgressVO getStudyProgress(String userId);
//    //查询用户已背诵的单词
//    WordRecitedVO getRecitedWords(String userId);
//    //查询用户收藏的单词
//    WordCollectionVO getCollectionWords(String userId);
    //查询用户收藏的文章
    List<ArticleCollectionVO> getCollectionArticles(Map<String, Object> map);
}
