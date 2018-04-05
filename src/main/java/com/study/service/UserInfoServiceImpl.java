package com.study.service;

import com.study.dao.UserVOMapper;
import com.study.domain.UserVO;
import com.study.service.impl.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/**
 * 获取用户的相关信息
         * */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    UserVOMapper userDao;
    //根据用户ID获取用户的详细信息
    public  UserVO getUserInfo(String id){
        UserVO user = userDao.selectByPrimaryKey(id);
        return user;
    }
}
