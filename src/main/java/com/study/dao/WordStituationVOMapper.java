package com.study.dao;

import com.study.domain.WordStituationVO;
import org.springframework.stereotype.Repository;

@Repository
public interface WordStituationVOMapper {
    //删除情境单词
    int deleteByPrimaryKey(String name);
    //新增情境单词
    int insert(WordStituationVO record);
    //新增情境单词
    int insertSelective(WordStituationVO record);
    //查询情境单词
    WordStituationVO selectByPrimaryKey(String name);
    //更新情境单词
    int updateByPrimaryKeySelective(WordStituationVO record);
    //更新情境单词
    int updateByPrimaryKey(WordStituationVO record);
}