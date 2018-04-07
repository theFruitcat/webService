package com.study.service;

import com.study.domain.*;

import java.util.List;
import java.util.Map;

public interface ReciteWordService {
    //批量获取背诵背诵单词信息
    List<WordReciteVO> getReciteWords(Map<String, Object> map);
    //获取指定单词详细信息
    WordReciteVO getReciteWord(WordReciteVOKey record);
    //增加已背诵的单词
    int insertRecitedWord(WordRecitedVO record);
    //增加收藏的单词
    int insertCollectionWord(WordCollectionVO record);
    //删除收藏单词
    int deleteCollectionWord(WordCollectionVOKey record);
}

