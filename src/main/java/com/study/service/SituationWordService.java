package com.study.service;

import com.study.domain.WordReciteVO;
import com.study.domain.WordSituationVO;

import java.util.List;
import java.util.Map;

public interface SituationWordService {
    //批量获取情境单词
    List<WordSituationVO> getSituationWords(Map<String, Object> map);
    //查看情境单词详情
    WordSituationVO getSituationWord(String name);
}
