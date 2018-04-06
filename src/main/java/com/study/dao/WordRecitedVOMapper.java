package com.study.dao;

import com.study.domain.WordRecitedVO;
import com.study.domain.WordRecitedVOKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface WordRecitedVOMapper {
    //删除已背诵的单词
    int deleteByPrimaryKey(WordRecitedVOKey key);
    //新增已背诵的单词
    int insert(WordRecitedVO record);
    //新增已背诵的单词
    int insertSelective(WordRecitedVO record);
    //查询已背诵单词
    WordRecitedVO selectByPrimaryKey(WordRecitedVOKey key);
    //更新已背诵的单词
    int updateByPrimaryKeySelective(WordRecitedVO record);
    //更新已背诵的单词
    int updateByPrimaryKey(WordRecitedVO record);
    //批量查询已背诵单词
    List<WordRecitedVO> selectByPageLimit(Map<String, Object> map);
}