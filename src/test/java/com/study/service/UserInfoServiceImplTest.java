package com.study.service;

import com.study.domain.*;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:Spring-myBaties.xml"})
public class UserInfoServiceImplTest extends TestCase {

    private static Logger logger = Logger.getLogger(String.valueOf(UserInfoServiceImplTest.class));

    @Autowired
    @Qualifier("UserInfoService")
    UserInfoService userService;

    @Ignore
    public void getUserInfo() {

    }

    @Test
    //测试注册用户
    public void testregistUser() {
        UserVO userVO = new UserVO();
        userVO.setUserId("771984187");
        userVO.setName("gzm");
        userVO.setPassword("123456");
        userVO.setAge(17);
        int number;
        number = userService.registUser(userVO);
        System.out.printf(" " + number);
    }

    @Test
    //测试删除用户
    public void testdeleteUser() {
        String id = "771984187";
        int number = userService.deleteUser(id);
        System.out.printf(" " + number);
    }

    @Ignore
    public void updateUser() {
    }

    @Test
    //测试获取用户收藏的文章
    public void getCollectionArticles() {
        Map<String,Object> map = new HashMap<>();
        map.put("userId","771984187");
        map.put("start",0);
        map.put("size",10);
        List<ArticleCollectionVO> list = userService.getCollectionArticles(map);
        for(ArticleCollectionVO vo:list){
            System.out.printf(" " + vo.getUserId());
            System.out.printf(" " + vo.getArticleId());
        }
    }

    @Test
    //测试获取用户已背诵的单词
    public void testGetRecitedWords(){
        Map<String,Object> map = new HashMap<>();
        map.put("userId","771984187");
        map.put("start",0);
        map.put("size",10);
        List<WordRecitedVO> list = userService.getRecitedWords(map);
        for(WordRecitedVO vo:list){
            System.out.printf(" " + vo.getUserId());
        }
    }

    @Test
    //测试获取用户收藏的单词
    public void testGetCollectionWords(){
        Map<String,Object> map = new HashMap<>();
        map.put("userId","771984187");
        map.put("start",0);
        map.put("size",10);
        List<WordCollectionVO> list = userService.getCollectionWords(map);
        for(WordCollectionVO vo:list){
            System.out.printf(" " + vo.getUserId());
        }
    }


}