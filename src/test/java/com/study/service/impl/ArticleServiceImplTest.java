package com.study.service.impl;

import com.study.service.UserInfoService;
import com.study.service.UserInfoServiceImplTest;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

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
    public void getArticle() {
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