package com.study.controller;

import com.study.domain.ExaminationVO;
import com.study.domain.SingleChoiceWordVO;
import com.study.domain.WordReciteVO;
import com.study.domain.ExaminationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.study.service.ReciteWordService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping(value = "abilityTest")
public class AbilityTestController {

    @Autowired
    @Qualifier("ReciteWordService")
    ReciteWordService ReciteWordService;

        @RequestMapping(value = "/getWords" ,method = RequestMethod.GET)
        @ResponseBody
        public ExaminationVO initTest(int catagoryId){
            ExaminationVO examinationVO = new ExaminationVO();
            //随机单词编号
            int randomNumber;
            //随机单词位置编号
            int randomPositionNumber;
            //初始编号
            int startNumber;
            //终止编号
            int endNumber;
            //用于生成题目的单词
            List<WordReciteVO> listWords;
            //题目
            List<SingleChoiceWordVO> listTestWords = new ArrayList<>();
            //循环二十次,生成二十道试题
            for(int i = 1; i <=20;i ++){
                List<String> options = new ArrayList<>();
                //单个试题
                SingleChoiceWordVO singleChoiceWordVO = new SingleChoiceWordVO();
                //产生0-3之间的随机整数
                randomNumber = new Random().nextInt(4);
                startNumber = i * 4 - 4;
                endNumber = i * 4 - 1;
                randomPositionNumber = new Random().nextInt(endNumber-startNumber+1)+startNumber;
                Map map = new HashMap();
                map.put("categoryId",catagoryId);
                map.put("start",startNumber);
                map.put("size",4);
                listWords = ReciteWordService.getReciteWords(map);
                //对从数据库查询到的四个单词进行遍历,随机选出一个作为试题
                for(WordReciteVO word : listWords){
                    options.add(word.getName());
                    if (word.getNumber()==randomPositionNumber+1){
                        List<String> answer = new ArrayList<>();
                        answer.add(word.getName());
                        singleChoiceWordVO.setAnswer(answer);
                        singleChoiceWordVO.setQuestionStem("选择<"+word.getExplanation()+">对应的正确单词选项");
                        singleChoiceWordVO.setType(1);
                    }
                }
                singleChoiceWordVO.setOptions(options);
                listTestWords.add(singleChoiceWordVO);
            }

            examinationVO.setTitle("单项选择题");
            examinationVO.setInfo("外语能力测试");
            examinationVO.setValues(listTestWords);
            return examinationVO;
        }
}
