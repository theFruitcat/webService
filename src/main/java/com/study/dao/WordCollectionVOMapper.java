package com.study.dao;

import com.study.domain.WordCollectionVO;
import com.study.domain.WordCollectionVOKey;
import com.study.domain.WordRecitedVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface WordCollectionVOMapper {
    //删除收藏单词
    int deleteByPrimaryKey(WordCollectionVOKey key);
    //新增收藏单词
    int insert(WordCollectionVO record);
    //新增收藏单词
    int insertSelective(WordCollectionVO record);
    //查询收藏单词
    WordCollectionVO selectByPrimaryKey(WordCollectionVOKey key);
    //更新收藏单词
    int updateByPrimaryKeySelective(WordCollectionVO record);
    //更新收藏单词
    int updateByPrimaryKey(WordCollectionVO record);
    //批量查询收藏单词
    List<WordCollectionVO> selectByPageLimit(Map<String, Object> map);

}