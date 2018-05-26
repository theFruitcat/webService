package com.study.controller;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.study.domain.AdministratorVO;
import com.study.domain.UserVO;
import com.study.service.impl.UserInfoServiceImpl;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理用户登录注册,以及信息显示修改
 * */
@Controller
@RequestMapping(value = "userInfo")
public class UserInfoController {

    @Autowired
    @Qualifier("UserInfoService")
    UserInfoServiceImpl UserInfoService;

    /**
     * 判断用户是否已经登录
     * produces 增加对response响应的支持
     * */
    @RequestMapping(value = "/getStatus" ,method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getStatus(HttpServletRequest request, HttpServletResponse response){
        String userID;
        String alias;
        //获取session
        HttpSession session = request.getSession();
        //获取session中的用户数据
        userID = (String)session.getAttribute("userID");
        alias = (String)session.getAttribute("alias");

        //将数据转化成json格式传给前台
        ObjectMapper mapper = new ObjectMapper(); //转换器
        Map map=new HashMap();
        map.put("userID",userID);
        map.put("alias",alias);
        String json = "";
        //将map格式转化为json格式
        try {
            json=mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //判断用户ID是否为空,即用户当前是否登录
        if(userID != null){
            return json;
        }
        else{
            return "";
        }
    }
    /**
     * 获取用户详细信息
     * @param userId
     * @return userVO
     * */
    @RequestMapping(value = "/getUserInfo" ,method = RequestMethod.GET)
    @ResponseBody
    public UserVO getUserInfo(@RequestParam String userId){//@RequestAttribute String id
//        UserVO user = userService.getUserInfo("771984187");
        UserVO user = UserInfoService.getUserInfo(userId);
        return user;
    }

    /**
     * 处理用户注册
     * @param  Uservo
     * @return int number
     * */
    @RequestMapping(value = "/regist" ,method = RequestMethod.POST)
    @ResponseBody
    public int Register(@RequestBody UserVO user){
        UserVO olduser = UserInfoService.getUserInfo(user.getUserId());


        int number;
        if(olduser == null){
            //用户昵称
            String alias;
            //判断用户是否有别名,若没有,默认为账号
            if(user.getAlias() == null){
                alias = user.getUserId();
                user.setAlias(alias);
            }
            System.out.println(user.getUserId());
            System.out.println(user.getPassword());
            System.out.println(user.getRegistDate());
            number = UserInfoService.registUser(user);
            return number;
        }
        else{
            number = 0;
            return  number;
        }
    }
    /**
     * 处理用户登录
     * @param  userVO
     * @return  number(int)
     * */
    @RequestMapping(value = "/logIn" ,method = RequestMethod.POST)
    @ResponseBody
    public int logIn(HttpServletRequest request,@RequestBody UserVO user){
        //获取session
        HttpSession session = request.getSession();
        //获取用户ID
        String userID = user.getUserId();
        String userPassWord = user.getPassword();
        //根据登录用户ID获取真实用户信息
        UserVO trueUser = UserInfoService.getUserInfo(userID);
        //number标识符,1代码验证通过,2代表验证失败 默认失败
        int number = 2;
        String truePassWord = trueUser.getPassword();
        if(truePassWord.equals(userPassWord) ){
            String alias = trueUser.getAlias();
            number = 1;
            session.setAttribute("userID",userID);
            session.setAttribute("alias",alias);
            return number;
        }
        else{
            return number;
        }
    }

    /**
     * 更改用户的基本信息
     * @param userVO
     * */
    @RequestMapping(value = "/updateUserInfo" ,method = RequestMethod.POST)
    @ResponseBody
    public int update(@RequestBody UserVO user){
        return UserInfoService.updateUser(user);
    }

    /**
     * 注销用户登录状态
     *
     * */
    @RequestMapping(value = "/logOut" ,method = RequestMethod.GET)
    @ResponseBody
    public void logOut(HttpServletRequest request){
        //获取session
        HttpSession session = request.getSession();
        //移除用户的登录状态
        session.removeAttribute("userID");
        session.removeAttribute("alias");
    }

    /**
     * 处理管理员登录
     * @param  administratorVO
     * @return  number(int)
     * */
    @RequestMapping(value = "/logInAdmin" ,method = RequestMethod.POST)
    @ResponseBody
    public int logInAdmin(HttpServletRequest request,@RequestBody AdministratorVO administratorVO){
        //获取session
        HttpSession session = request.getSession();
        //获取用户ID
        String adminID = administratorVO.getAdministratorId();
        String adminPassWord = administratorVO.getPassword();
        //根据登录用户ID获取真实用户信息
        AdministratorVO trueAdmin = UserInfoService.getAdministratorVO(adminID);
        //number标识符,1代码验证通过,2代表验证失败 默认失败
        int number = 2;
        String truePassWord = trueAdmin.getPassword();
        if(truePassWord.equals(adminPassWord) ){
            String name = trueAdmin.getName();
            number = 1;
            session.setAttribute("adminID",adminID);
            session.setAttribute("adminName",name);
            return number;
        }
        else{
            return number;
        }
    }

}
