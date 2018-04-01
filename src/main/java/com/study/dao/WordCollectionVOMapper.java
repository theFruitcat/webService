package com.study.dao;

import com.study.domain.WordCollectionVO;

public interface WordCollectionVOMapper {
    //删除单词收藏
    int deleteByPrimaryKey(String userId);
    //新增单词收藏
    int insert(WordCollectionVO record);
    //新增单词收藏
    int insertSelective(WordCollectionVO record);
    //查询收藏单词
    WordCollectionVO selectByPrimaryKey(String userId);
    //更新收藏单词
    int updateByPrimaryKeySelective(WordCollectionVO record);
    //更新收藏单词
    int updateByPrimaryKey(WordCollectionVO record);
}