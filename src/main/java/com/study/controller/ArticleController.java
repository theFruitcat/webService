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
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/getArticles",method = RequestMethod.GET)
    @ResponseBody
    public List<ArticleVO> getArticles(HttpServletRequest request,@RequestBody Map map){

        return articleService.getArticles(map);
    }
}
