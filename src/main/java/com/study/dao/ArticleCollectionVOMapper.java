package com.study.dao;

import com.study.domain.ArticleCollectionVO;
import com.study.domain.ArticleCollectionVOKey;
import org.springframework.stereotype.Repository;

/**
 * 文章收藏
 * */
@Repository
public interface ArticleCollectionVOMapper {
    //删除文章收藏
    int deleteByPrimaryKey(ArticleCollectionVOKey key);
    //新增文章收藏
    int insert(ArticleCollectionVO record);
    //新增文章收藏 不允许存在空值
    int insertSelective(ArticleCollectionVO record);
    //查询文章收藏
    ArticleCollectionVO selectByPrimaryKey(ArticleCollectionVOKey key);
    //更新文章收藏 推荐
    int updateByPrimaryKeySelective(ArticleCollectionVO record);
    //更新文章收藏
    int updateByPrimaryKey(ArticleCollectionVO record);
}