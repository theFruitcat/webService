package com.study.service.impl;

import com.study.dao.WordSituationVOMapper;
import com.study.domain.WordSituationVO;
import com.study.service.SituationWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 情境单词处理
 * @author gaoziming
 * */
@Service("SituationWordService")
@Transactional
public class SituationWordServiceImpl implements SituationWordService{
    @Autowired
    WordSituationVOMapper wordSituationDao;

    @Override
    //批量获取情境单词,必传参数:情境 可选参数:开始编号,结束编号
    public List<WordSituationVO> getSituationWords(Map<String, Object> map) {
        return wordSituationDao.getSituationWords(map);
    }

    @Override
    //获取单个情境单词的详细信息
    public WordSituationVO getSituationWord(String name) {
        return wordSituationDao.selectByPrimaryKey(name);
    }
}
