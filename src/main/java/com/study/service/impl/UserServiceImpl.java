package com.study.service.impl;

import com.study.dao.UserMapper;
import com.study.domain.User;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserMapper userMapper;

    public User getUserInfo(String username){
        User user =  userMapper.selectByPrimaryKey(username);
        return  user;
    }
}
