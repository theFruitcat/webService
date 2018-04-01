package com.study.dao;

import com.study.domain.WordSituationNumberVO;

public interface WordSituationNumberVOMapper {
    //删除情境单词编号
    int deleteByPrimaryKey(String name);
    //新增情境单词编号
    int insert(WordSituationNumberVO record);
    //新增情境单词编号
    int insertSelective(WordSituationNumberVO record);
    //查询背诵单词编号
    WordSituationNumberVO selectByPrimaryKey(String name);
    //更新背诵单词编号
    int updateByPrimaryKeySelective(WordSituationNumberVO record);
    //更新背诵单词编号
    int updateByPrimaryKey(WordSituationNumberVO record);
}