package com.study.dao;

import com.study.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User selectByPrimaryKey(@Param("username") String username);

}