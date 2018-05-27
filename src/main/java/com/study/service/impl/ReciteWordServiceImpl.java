package com.study.service.impl;

import com.study.dao.WordCollectionVOMapper;
import com.study.dao.WordReciteVOMapper;
import com.study.dao.WordRecitedVOMapper;
import com.study.domain.*;
import com.study.service.ReciteWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * 背诵单词处理
 * @author gaoziming
 * */
@Service("ReciteWordService")
@Transactional
public class ReciteWordServiceImpl implements ReciteWordService {

    @Autowired
    WordReciteVOMapper wordReciteDao;

    @Autowired
    WordCollectionVOMapper wordCollectionDao;

    @Autowired
    WordRecitedVOMapper wordRecitedDao;

    @Override
    //批量获取背诵单词信息
    public List<WordReciteVO> getReciteWords(Map<String, Object> map) {

        return wordReciteDao.getReciteWords(map);
    }

    @Override
    //获取背诵单词详细信息
    public WordReciteVO getReciteWord(WordReciteVOKey record) {
        return wordReciteDao.selectByPrimaryKey(record);
    }

    @Override
    //增加已背诵的单词
    public int insertRecitedWord(WordRecitedVO record) {
        return wordRecitedDao.insertSelective(record);
    }

    @Override
    //增加收藏单词
    public int insertCollectionWord(WordCollectionVO record) {
        return wordCollectionDao.insertSelective(record);
    }

    @Override
    //删除收藏单词
    public int deleteCollectionWord(WordCollectionVOKey record) {
        return wordCollectionDao.deleteByPrimaryKey(record);
}

    //查询收藏单词是否存在
    public int selectCollectionWord(WordCollectionVO record){
        return wordCollectionDao.countCollection(record);
    }

}
