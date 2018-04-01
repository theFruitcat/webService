package com.study.dao;

import com.study.domain.UserVO;

public interface UserVOMapper {
    //ɾ���û�
    int deleteByPrimaryKey(String userId);
    //�����û�
    int insert(UserVO record);
    //�����û�
    int insertSelective(UserVO record);
    //��ѯ�û�
    UserVO selectByPrimaryKey(String userId);
    //�����û�
    int updateByPrimaryKeySelective(UserVO record);
    //�����û�
    int updateByPrimaryKey(UserVO record);
}