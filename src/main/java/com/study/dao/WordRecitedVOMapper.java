package com.study.dao;

import com.study.domain.WordRecitedVO;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRecitedVOMapper {
    //删除已背诵单词
    int deleteByPrimaryKey(String userId);
    //新增已背诵单词
    int insert(WordRecitedVO record);
    //新增已背诵单词
    int insertSelective(WordRecitedVO record);
    //查询已背诵单词
    WordRecitedVO selectByPrimaryKey(String userId);
    //更新已背诵单词
    int updateByPrimaryKeySelective(WordRecitedVO record);
    //更新已背诵单词
    int updateByPrimaryKey(WordRecitedVO record);
}