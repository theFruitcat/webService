package com.study.service;

import com.study.domain.*;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    //新增文章
    int insertArticle (ArticleVO record);
    //删除文章
    int deleteArticle (int id);
    //批量查询文章
    List<ArticleVO> getArticles (Map<String,Object> map);
    //查询单个文章
    ArticleVO getArticle (int id);
    //新增评论
    int insertComment (CommentVO record);
    //删除评论
    int deleteComment (CommentVOKey voKey);
    //查询文章对应的评论
    List<CommentVO> getComments(Map<String ,Object> map);
    //新增收藏文章
    int insertCollectionArticle(ArticleCollectionVO record);
    //删除收藏文章
    int deleteCollectionArticle(ArticleCollectionVOKey record);
}
