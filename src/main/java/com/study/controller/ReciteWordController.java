package com.study.controller;


import com.study.domain.StudyProgressVO;
import com.study.domain.UserVO;
import com.study.domain.WordReciteVO;
import com.study.domain.WordRecitedVO;
import com.study.service.ReciteWordService;
import com.study.service.StudyProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "reciteWord")
public class ReciteWordController {

    @Autowired
    @Qualifier("ReciteWordService")
    ReciteWordService ReciteWordService;

    @Autowired
    @Qualifier("StudyProgressService")
    StudyProgressService StudyProgressService;

    /**
     * 批量返回单词,默认一次返回十个
     * @param  UserVO user
     * @return List<WordReciteVO>
     * */
    @RequestMapping(value = "/get" ,method = RequestMethod.POST)
    @ResponseBody
    public List<WordReciteVO> getReciteWord(@RequestBody UserVO user){
        String userID = user.getUserId();
        String level = user.getLevel();
        int catagoryId = Integer.valueOf(level);
        Map map = new HashMap();

        List<WordReciteVO> listReciteWords;

        StudyProgressVO studyProgressVO;
        studyProgressVO = StudyProgressService.getStudyProgress(userID);
        if(studyProgressVO == null){
            map.put("categoryId",catagoryId);
            map.put("start",0);
            map.put("size",20);
            listReciteWords = ReciteWordService.getReciteWords(map);
            return listReciteWords;
        }
        return null;
    }

    /**
     * 增加用户的已学习单词
     * */
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    @ResponseBody
    public int updateStudyProgress(HttpServletRequest request,@RequestBody WordRecitedVO word){

        String userId;
        //获取session
        HttpSession session = request.getSession();
        //获取session中的用户数据
        userId = (String)session.getAttribute("userID");

        int catagoryId = word.getCategoryId();
        int number = word.getReciteNumber();
        String name = word.getName();

        word.setUserId(userId);
        int i = ReciteWordService.insertRecitedWord(word);
        return i;
    }
}


