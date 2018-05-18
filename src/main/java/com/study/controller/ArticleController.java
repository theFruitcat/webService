package com.study.controller;

import com.study.domain.ArticleVO;
import com.study.service.ArticleService;
import com.study.service.impl.ArticleServiceImpl;
import com.study.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    @Qualifier("ArticleService")
    ArticleServiceImpl articleService;



    @RequestMapping(value = "/insertArticle" ,method = RequestMethod.POST)
    @ResponseBody
    public int insertArticle(HttpServletRequest request, @RequestBody ArticleVO articleVO){

        //获取session
        HttpSession session = request.getSession();
        //获取当前用户的id
        String userId = (String)session.getAttribute("userID");
        //设置文章的作者id
        articleVO.setUserId(userId);
        //新增文章
        int number = articleService.insertArticle(articleVO);

        return number;
    }

    /**
     * 统计目前的文章数量
     * @param label
     * */
    @RequestMapping(value = "/countArticles",method = RequestMethod.GET)
    @ResponseBody
    public int countArticle(String label){
        int articleNumber;
        //默认为null,不加查询条件
        if(label.equals("null")) {
            articleNumber = articleService.countArticle();
        }
        else{
            articleNumber = articleService.countArticleByLabel(label);
        }
        return articleNumber;
    }

    @RequestMapping(value = "/getArticles",method = RequestMethod.POST)
    @ResponseBody
    public List<ArticleVO> getArticles(HttpServletRequest request,@RequestBody Map map){

        //获取需求的文章列表
        List<ArticleVO> articleVOS = articleService.getArticles(map);

        for(ArticleVO articleVO:articleVOS){
//            获取文章内容
            String content = articleVO.getContent();
            try {
                //对文章内容进行过滤
                content = contentFilter(content);
                //对文章内容进行截取
                content = contentSbu(content,600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            articleVO.setContent(content+"....");

        }
        return articleVOS;
    }

    /**
     * 查询文章的收藏和评论数
     *@param articleId 文章id
     * */
    @RequestMapping(value = "/getCollectionAndCommentNumber")
    @ResponseBody
    public Map getCollectionAndCommentNumber(String articleId){
        int collectionNumber;
        int commentNumber;
        collectionNumber = articleService.countArticleCollection(articleId);
        commentNumber = articleService.countArticleComment(articleId);
        Map map = new HashMap();
        map.put("collectionNumber",collectionNumber);
        map.put("commentNumber",commentNumber);
        return map;
    }
    /**
     * 用于对文章的内容进行简化,截取固定的长度字符串
     * @param content 原文章内容
     * @param num 截取的字符串长度,utf-8 单个汉字长度为3
     * */
    public static String contentSbu(String content,int num)throws Exception{
        int contentLength = content.getBytes("UTF-8").length;
        if(contentLength > num){
            content = content.substring(0, content.length() - 1);
            //循环递归,直至满足条件
            content = contentSbu(content,num);
        }
        return content;
    }
    /**
     * 用于对文章的标签进行过滤,以纯文本的形式展现在文章列表中
     * @param oldContent 原文章内容
     * */
    public static String contentFilter(String oldContent){
        //新的文本内容
        String newContent;
        //过滤规则
        String pattern = "<[^>]*>";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(oldContent);
        //将匹配到的内容全部替换为空
        newContent = m.replaceAll("");
        return newContent;
    }
}


