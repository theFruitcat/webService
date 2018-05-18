package com.study.service.impl;

import com.study.dao.ArticleCollectionVOMapper;
import com.study.dao.ArticleVOMapper;
import com.study.dao.CommentVOMapper;
import com.study.domain.*;
import com.study.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 文章相关信息
 * @author gaoziming
 * */
@Service("ArticleService")
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleVOMapper articleVOMapper;

    @Autowired
    CommentVOMapper commentVOMapper;

    @Autowired
    ArticleCollectionVOMapper articleCollectionVOMapper;

    @Override
    //新增文章
    public int insertArticle(ArticleVO record) {
        return articleVOMapper.insertSelective(record);
    }

    @Override
    //删除文章
    public int deleteArticle(int id) {
        return articleVOMapper.deleteByPrimaryKey(id);
    }

    @Override
    //批量获取文章
    public List<ArticleVO> getArticles(Map<String, Object> map) {
        return articleVOMapper.selectByPageLimit(map);
    }

    @Override
    //获取单个文章
    public ArticleVO getArticle(int id) {
        return articleVOMapper.selectByPrimaryKey(id);
    }

    @Override
    //新增评论
    public int insertComment(CommentVO record) {
        return commentVOMapper.insert(record);
    }

    @Override
    //删除评论
    public int deleteComment(CommentVOKey voKey) {
        return commentVOMapper.deleteByPrimaryKey(voKey);
    }

    //回复评论
    public int replyComment(CommentVO record){return 1;}
    @Override
    //查询文章对应的评论
    public List<CommentVO> getComments(Map<String, Object> map) {
        return commentVOMapper.getComments(map);
    }

    @Override
    //新增收藏文章
    public int insertCollectionArticle(ArticleCollectionVO record) {
        return articleCollectionVOMapper.insertSelective(record);
    }

    @Override
    //删除收藏文章
    public int deleteCollectionArticle(ArticleCollectionVOKey record) {
        return articleCollectionVOMapper.deleteByPrimaryKey(record);
    }
    @Override
    //查询文章数量
    public int countArticle(){
        return  articleVOMapper.countArticle();
    }
    @Override
    //根据标签查询文章数量
    public int countArticleByLabel(String label){
        return  articleVOMapper.countArticleByLabel(label);
    }
    @Override
    //查询文章的评论数量
    public int countArticleComment(String articleId){
        return articleVOMapper.countArticleComment(articleId);
    }
    @Override
    //查询文章的收藏数量
    public int countArticleCollection(String articleId){
        return articleVOMapper.countArticleCollection(articleId);
    }
}
