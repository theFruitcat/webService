package com.study.dao;

import com.study.domain.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVOMapper {
    //删除用户
    int deleteByPrimaryKey(String userId);
    //新增用户
    int insert(UserVO record);
    //新增用户
    int insertSelective(UserVO record);
    //查询用户
    UserVO selectByPrimaryKey(String userId);
    //更新用户
    int updateByPrimaryKeySelective(UserVO record);
    //更新用户
    int updateByPrimaryKey(UserVO record);
}