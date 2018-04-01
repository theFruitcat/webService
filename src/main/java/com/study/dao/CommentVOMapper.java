package com.study.dao;

import com.study.domain.CommentVO;
import com.study.domain.CommentVOKey;

public interface CommentVOMapper {
    //ɾ������
    int deleteByPrimaryKey(CommentVOKey key);
    //��������
    int insert(CommentVO record);
    //��������
    int insertSelective(CommentVO record);
    //��ѯ����
    CommentVO selectByPrimaryKey(CommentVOKey key);
    //��������
    int updateByPrimaryKeySelective(CommentVO record);
    //��������
    int updateByPrimaryKeyWithBLOBs(CommentVO record);
    //��������
    int updateByPrimaryKey(CommentVO record);
}