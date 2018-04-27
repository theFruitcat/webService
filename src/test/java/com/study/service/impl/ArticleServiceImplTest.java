package com.study.service.impl;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:Spring-myBaties.xml"})
public class ArticleServiceImplTest extends TestCase {

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
}