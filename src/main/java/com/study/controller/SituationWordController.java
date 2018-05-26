package com.study.controller;

import com.study.domain.WordSituationVO;
import com.study.service.SituationWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "situationWord")
public class SituationWordController {

    @Autowired
    @Qualifier("SituationWordService")
    SituationWordService situationWordService;

    @RequestMapping(value = "/getWords",method = RequestMethod.POST)
    @ResponseBody
    public List<WordSituationVO> getSituationWords(@RequestBody Map map){
        return situationWordService.getSituationWords(map);
    }
}
