package com.study.service.impl;

import com.study.domain.*;
import com.study.service.ReciteWordService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:Spring-myBaties.xml"})
public class ReciteWordServiceImplTest extends TestCase {

    private static Logger logger = Logger.getLogger(String.valueOf(ReciteWordServiceImplTest.class));

    @Autowired
    @Qualifier("ReciteWordService")
    ReciteWordService recitedWordService;

    @Test
    public void getReciteWords() {
        Map<String,Object> map = new HashMap<>();
        map.put("categoryId",0);
        map.put("start",0);
        map.put("size",10);
        List<WordReciteVO> list = recitedWordService.getReciteWords(map);
        for(WordReciteVO vo :list){
            System.out.printf(" " + vo.getName());
            System.out.println(" " + vo.getNumber());
        }
    }

    @Test
    public void getReciteWord() {
        WordReciteVOKey wordRecitedVO = new WordReciteVO();
        wordRecitedVO.setCategoryId(0);
        wordRecitedVO.setName("apple");
        WordReciteVO wordRecitedVO1;
        wordRecitedVO1 = recitedWordService.getReciteWord(wordRecitedVO);
        System.out.printf(" " + wordRecitedVO1.getNumber());
    }

    @Test
    public void insertRecitedWord() {
        WordRecitedVO wordRecitedVO = new WordRecitedVO();
        wordRecitedVO.setReciteNumber(3);
        wordRecitedVO.setCategoryId(0);
        wordRecitedVO.setUserId("771984187");
        wordRecitedVO.setName("flower");
        int number = recitedWordService.insertRecitedWord(wordRecitedVO);
        System.out.println(" " + number);
    }

    @Test
    public void insertCollectionWord() {
        WordCollectionVO wordCollectionVO = new WordCollectionVO();
        wordCollectionVO.setName("pig");
        wordCollectionVO.setCategoryId(0);
        wordCollectionVO.setCollectionNumber(2);
        wordCollectionVO.setUserId("771984187");
        int number = recitedWordService.insertCollectionWord(wordCollectionVO);
        System.out.println(" " + number);
    }

    @Test
    public void deleteCollectionWord(){
        WordCollectionVOKey wordCollectionVOKey = new WordCollectionVOKey();
        wordCollectionVOKey.setCategoryId(0);
        wordCollectionVOKey.setCollectionNumber(2);
        wordCollectionVOKey.setUserId("771984187");
        int number = recitedWordService.deleteCollectionWord(wordCollectionVOKey);
        System.out.println(" " + number);
    }
}