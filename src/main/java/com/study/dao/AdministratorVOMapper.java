package com.study.dao;

import com.study.domain.AdministratorVO;
import org.springframework.stereotype.Repository;

/**
 * 管理员实体类接口
 * */
@Repository
public interface AdministratorVOMapper {
    //根据ID删除管理员
    int deleteByPrimaryKey(String administratorId);
    //添加管理员 不推荐
    int insert(AdministratorVO record);
    //添加管理员
    int insertSelective(AdministratorVO record);
    //查询管理员
    AdministratorVO selectByPrimaryKey(String administratorId);
    //更新管理员
    int updateByPrimaryKeySelective(AdministratorVO record);
    //更新管理员 不推荐
    int updateByPrimaryKey(AdministratorVO record);
}