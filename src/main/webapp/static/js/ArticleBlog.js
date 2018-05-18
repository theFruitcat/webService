/**
 * 博客阅读部分
 * */
//用户ID
var userId ;
//获取session中的用户id
userId = getuser();

//数据库内文章的数量
var totalAtriclesNumber;
//指定标签的文章数量
var articleNumberByLabel;
totalAtriclesNumber = getArticleNumber("null");
if(totalAtriclesNumber/6 > 1){
    getArtilces(1);
}
else{
    getArtilces(totalAtriclesNumber);
}
initBottomLine(totalAtriclesNumber);
//获取用户信息
function getuser() {
    var userId;
    //处理用户的登录信息
    $.ajax({
        url:"./userInfo/getStatus",
        type:"GET",
        async:false,
        // data:user1,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            //后台返回数字2代表用户已经登录
            console.log(data);
            // var obj = JSON.parse(data);
            var alias = data.alias;
            // userId = data.userID;
            var content = "<a href='../home.html'>" +alias;
            if(alias != null){
                $(".login").empty();
                $(".login").append("<a class ='status' href='../MyHome.html'>");
                $(".status").append("<p>欢迎 " + alias + "</p>");
                userId = data.userID;
                // getUserInfo(data.userID);
            }
            else{
                alert("登录失败!");
            }

        }
    });
    return userId;
}

//获取文章的数量
function getArticleNumber(label) {
    var number;
    $.ajax({
        url:"./article/countArticles?label="+label,
        type:"GET",
        async:false,
        data:label,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            number = data;
        }
    });
    return number;
}
/**
 * 批量获取文章的信息
 * @param number 提取文章的数量
 * @param currentPageNumber 当前文章的页码值
 * */
function getArtilces(currentPageNumber,label) {
    var articleName;
    var author;
    var content;
    var articles;
    var map = {};

    var newArticle;
    var number = totalAtriclesNumber-currentPageNumber*6;
    if (number >= 0){
        number = 6;
    }
    else {
       number = number + 6;
    }
    map.start = currentPageNumber*6-6;
    map.size = number;
    map.label = label;
    var obj = JSON.stringify(map);
    // 批量获取文章
    $.ajax({
        url:"./article/getArticles",
        type:"POST",
        async:false,
        data:obj,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            articles = data;
            console.log(articles);
        }
    });
    for(var article of articles){
        var id;
        var articleInfo;
        author = article.userId;
        author = getAuthor(author);
        article.author = author.alias;
        id = article.articleId;
        articleInfo = getCollectionAndCommentNumber(id);
        article.collectionNumber = articleInfo.collectionNumber;
        article.commentNumber = articleInfo.commentNumber;
        initArticles(article,id);
    }

}
/**
 * 获取作者信息
 * */
function getAuthor(userId) {
    var user;
    $.ajax({
        url:"./userInfo/getUserInfo?userId="+userId,
        type:"GET",
        async:false,
        // data:map,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            user = data;
        }
    });
    return user;
}
/**
 * 获取文章的收藏和评论数
 *
 * */
function  getCollectionAndCommentNumber(articleId) {
    var articleInfo;
    $.ajax({
        url:"./article/getCollectionAndCommentNumber?articleId="+articleId,
        type:"GET",
        async:false,
        // data:map,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            articleInfo = data;
        }
    });
    return articleInfo;
}
//初始化底栏分页
function initBottomLine(totalNumber) {
    var number = totalNumber/6;
    var remainder = totalNumber%6;
    if(remainder != 0){
        number ++;
    }

    for(var i = 1;i<=number+1;i++){
        if(i <= number+1){
            $(".pagination").append("<li id="+"'"+i+"'"+"><a href=\"#\">"+i+"</a></li>");
        }
        else{
            $(".pagination").append("<li><a href=\"#\" >right</a></li>");
        }

    }
}
/**
 * 初始化文章
 * @param article 文章对象
 * @param id 文章id
 * */
function initArticles(article,id) {
    var articleName;
    var author;
    var content;
    var image;
    var collectionNumber;
    var commentNumber;
    articleName = article.articleName;
    author = article.author;
    content = article.content;
    image = article.pictureAddress;
    collectionNumber = article.collectionNumber;
    commentNumber = article.commentNumber;
    $("#content").append("<div id="+"'"+id+"'"+" class=\"col-md-6 col-sm-12 blog-padding-right\">\n" +
        "                            <div class=\"single-blog two-column\">\n" +
        "                                <div class=\"post-thumb\">\n" +
        "                                    <a href=\"blogdetails.html\"><img src="+ "'"+ image+"'"+" class=\"img-responsive\" alt=\"\"></a>\n" +
        "                                    <div class=\"post-overlay\">\n" +
        "                                        <span class=\"uppercase\"><a href=\"#\">14 <br><small>Feb</small></a></span>\n" +
        "                                    </div>\n" +
        "                                </div>\n" +
        "                                <div class=\"post-content overflow\">\n" +
        "                                    <h2 class=\"post-title bold\"><a href=\"blogdetails.html\">"+articleName+"</a></h2>\n" +
        "                                    <h3 class=\"post-author\"><a href=\"#\">"+author+"</a></h3>\n" +
        "                                    <p>"+content+"</p>\n" +
        "                                    <a href=\"#\" class=\"read-more\">查看更多</a>\n" +
        "                                    <div class=\"post-bottom overflow\">\n" +
        "                                        <ul class=\"nav nav-justified post-nav\">\n" +
        "                                            <li><a href=\"\"><i class=\"fa fa-heart\"></i>" + collectionNumber +" 喜欢</a></li>\n" +
        "                                            <li><a href=\"\"><i class=\"fa fa-comments\"></i>" + commentNumber + " 评论</a></li>\n" +
        "                                        </ul>\n" +
        "                                    </div>\n" +
        "                                </div>\n" +
        "                            </div>\n" +
        "                        </div>")
}
/**
 * 分页触发事件
 * */
$(".pagination").on("click","li",function () {

    var page = $(this).text();
    if(isNaN(page)){
        alert("sdsdds");
    }else{
        $("#content").empty();
        getArtilces(page);
    }
})
/**
 * 标签分类触发事件
 * */
$(".navbar-stacked").on("click","li",function () {
    var page = $(this).attr("id");
    alert(page);
    articleNumberByLabel = getArticleNumber(page);
    $("#content").empty();
    $(".pagination").empty();
    if(articleNumberByLabel > 0){
        $(".pagination").append("<li><a href=\"#\">left</a></li>");
    }
    if(articleNumberByLabel/6 > 1){
        getArtilces(1,page);
    }
    else{
        getArtilces(articleNumberByLabel,page);
    }
    initBottomLine(articleNumberByLabel);
})
