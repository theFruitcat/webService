package com.study.controller;

import com.study.domain.UserVO;
import com.study.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/MY" ,method = RequestMethod.GET)
public class MyController {
    @Autowired
    @Qualifier("UserInfoService")
    UserInfoServiceImpl userService;

    @RequestMapping("/INDEX")
    public ModelAndView index() throws  Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserVO getUserInfo(@RequestAttribute String id ){
        UserVO user = userService.getUserInfo(id);
        return user;
    }
}
