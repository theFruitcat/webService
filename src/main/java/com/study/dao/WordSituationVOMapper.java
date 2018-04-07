package com.study.dao;

import com.study.domain.WordReciteVO;
import com.study.domain.WordSituationVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WordSituationVOMapper {
    //删除情境单词
    int deleteByPrimaryKey(String name);
    //新增情境单词
    int insert(WordSituationVO record);
    //新增情境单词
    int insertSelective(WordSituationVO record);
    //查询情境单词
    WordSituationVO selectByPrimaryKey(String name);
    //更新情境单词
    int updateByPrimaryKeySelective(WordSituationVO record);
    //更新情境单词
    int updateByPrimaryKey(WordSituationVO record);
    //批量获取情境单词
    List<WordSituationVO> getSituationWords(Map<String, Object> map);
}