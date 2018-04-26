package com.study.dao;

import com.study.domain.CommentVO;
import com.study.domain.CommentVOKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
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
    //批量查询评论
    List<CommentVO> getComments(Map<String,Object> map);
}