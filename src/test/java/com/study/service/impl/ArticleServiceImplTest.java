package com.study.service.impl;

import com.study.domain.ArticleVO;
import com.study.service.UserInfoService;
import com.study.service.UserInfoServiceImplTest;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:Spring-myBaties.xml"})
public class ArticleServiceImplTest extends TestCase {

    private static Logger logger = Logger.getLogger(String.valueOf(ArticleServiceImplTest.class));

    @Autowired
    @Qualifier("ArticleService")
    ArticleServiceImpl articleService;

    @Test
    public void insertArticle() {
    }

    @Test
    public void deleteArticle() {
    }

    @Test
    public void getArticles() {
    }

    @Test
    //测试正则去掉HTML标签的功能
    public void getArticle() {
        ArticleVO articleVO = articleService.getArticle(7);
        String content = articleVO.getContent();
        String pattern = "<[^>]*>";
        String oldContent;
        String newContent="";
        String subLength;
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(content);
        oldContent = m.replaceAll("");
        int length;
        try {
            newContent = idgui(oldContent,600);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(newContent+"...");
    }

    public static String idgui(String s,int num)throws Exception{
        int changdu = s.getBytes("UTF-8").length;
        if(changdu > num){
            s = s.substring(0, s.length() - 1);
            s = idgui(s,num);
        }
        return s;
    }

    @Test
    public void insertComment() {
    }

    @Test
    public void deleteComment() {
    }

    @Test
    public void getComments() {
    }

    @Test
    public void insertCollectionArticle() {
    }

    @Test
    public void deleteCollectionArticle() {
    }

    @Test
    public void countArticle(){
        int i = articleService.countArticle();
        System.out.println(i);
    }

    @Test
    public void countArticleByLabel(){
        int i = articleService.countArticleByLabel("aasaa");
        System.out.println(i);
    }
}