package com.study.dao;

import com.study.domain.WordRecitedVO;

public interface WordRecitedVOMapper {
    //删除背诵单词
    int deleteByPrimaryKey(String userId);
    //新增背诵单词
    int insert(WordRecitedVO record);
    //新增背诵单词
    int insertSelective(WordRecitedVO record);
    //查询单词
    WordRecitedVO selectByPrimaryKey(String userId);
    //更新单词
    int updateByPrimaryKeySelective(WordRecitedVO record);
    //更新单词
    int updateByPrimaryKey(WordRecitedVO record);
}