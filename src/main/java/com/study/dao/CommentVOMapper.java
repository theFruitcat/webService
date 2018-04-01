package com.study.dao;

import com.study.domain.CommentVO;
import com.study.domain.CommentVOKey;

public interface CommentVOMapper {
    //删除评论
    int deleteByPrimaryKey(CommentVOKey key);
    //新增评论
    int insert(CommentVO record);
    //新增评论
    int insertSelective(CommentVO record);
    //查询评论
    CommentVO selectByPrimaryKey(CommentVOKey key);
    //更新评论
    int updateByPrimaryKeySelective(CommentVO record);
    //更新评论
    int updateByPrimaryKeyWithBLOBs(CommentVO record);
    //更新评论
    int updateByPrimaryKey(CommentVO record);
}