package com.study.dao;

import com.study.domain.WordStituationVO;

public interface WordStituationVOMapper {
    //删除背诵单词
    int deleteByPrimaryKey(String name);
    //新增背诵单词
    int insert(WordStituationVO record);
    //新增背诵单词
    int insertSelective(WordStituationVO record);
    //查询背诵单词
    WordStituationVO selectByPrimaryKey(String name);
    //更新背诵单词
    int updateByPrimaryKeySelective(WordStituationVO record);
    //更新背诵单词
    int updateByPrimaryKey(WordStituationVO record);
}