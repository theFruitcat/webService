package com.study.dao;

import com.study.domain.WordReciteNumberVO;
import com.study.domain.WordReciteNumberVOKey;

public interface WordReciteNumberVOMapper {
    //删除背诵单词编号
    int deleteByPrimaryKey(WordReciteNumberVOKey key);
    //新增背诵单词编号
    int insert(WordReciteNumberVO record);
    //新增背诵单词编号
    int insertSelective(WordReciteNumberVO record);
    //查询背诵单词编号
    WordReciteNumberVO selectByPrimaryKey(WordReciteNumberVOKey key);
    //更新单词编号
    int updateByPrimaryKeySelective(WordReciteNumberVO record);
    //更新单词编号
    int updateByPrimaryKey(WordReciteNumberVO record);
}