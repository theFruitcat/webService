package com.study.dao;

import com.study.domain.ArticleVO;

public interface ArticleVOMapper {
    //删除文章
    int deleteByPrimaryKey(Integer articleId);
    //新增文章
    int insert(ArticleVO record);
    //新增文章
    int insertSelective(ArticleVO record);
    //查询文章
    ArticleVO selectByPrimaryKey(Integer articleId);
    //更新文章
    int updateByPrimaryKeySelective(ArticleVO record);
    //和updateByExample相比此方法可以修改大字段类型，其余性质和updateByExample相同
    int updateByPrimaryKeyWithBLOBs(ArticleVO record);

    int updateByPrimaryKey(ArticleVO record);
}