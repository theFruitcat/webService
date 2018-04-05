package com.study.dao;

import com.study.domain.WordReciteVO;
import com.study.domain.WordReciteVOKey;
import org.springframework.stereotype.Repository;

@Repository
public interface WordReciteVOMapper {
    //删除背诵单词
    int deleteByPrimaryKey(WordReciteVOKey key);
    //新增背诵单词
    int insert(WordReciteVO record);
    //新增背诵单词
    int insertSelective(WordReciteVO record);
    //选择背诵单词
    WordReciteVO selectByPrimaryKey(WordReciteVOKey key);
    //更新背诵单词
    int updateByPrimaryKeySelective(WordReciteVO record);
    //更新背诵单词
    int updateByPrimaryKey(WordReciteVO record);
}