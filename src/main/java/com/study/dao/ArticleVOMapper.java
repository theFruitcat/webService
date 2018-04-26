package com.study.dao;

import com.study.domain.ArticleVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
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
    //和updateByPrimaryKey相比此方法可以修改大字段类型，其余性质和updateByPrimaryKey相同
    int updateByPrimaryKeyWithBLOBs(ArticleVO record);

    int updateByPrimaryKey(ArticleVO record);
    //根据页面限制批量查询文章
    List<ArticleVO> selectByPageLimit(Map<String,Object> map);
}