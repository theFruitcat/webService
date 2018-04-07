package com.study.service.impl;

import com.study.domain.WordReciteVO;
import com.study.domain.WordSituationVO;
import com.study.service.SituationWordService;
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

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:Spring-myBaties.xml"})
public class SituationWordServiceImplTest extends TestCase {

    @Autowired
    @Qualifier("SituationWordService")
    SituationWordService situationWordService;

    @Test
    public void getSituationWords() {
        Map<String,Object> map = new HashMap<>();
        map.put("situation",0);
        map.put("start",0);
        map.put("size",10);
        List<WordSituationVO> listWords = situationWordService.getSituationWords(map);
        for(WordSituationVO vo :listWords){
            System.out.printf(" " + vo.getName());
            System.out.println(" " + vo.getChineseTranslation());
        }
    }

    @Test
    public void getSituationWord() {
        String name = "apple";
        WordSituationVO wordSituationVO = situationWordService.getSituationWord(name);
        System.out.println(" " + wordSituationVO.getChineseTranslation());
    }
}