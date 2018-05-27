/**
 * 博客详细信息
 * */
//用户
var user = {}
//用户ID
var userId ;
//获取session中的用户id
user = getuser();
var author;
var article = {};
var request = GetRequest();
var articleId = request["articleId"];
article = getArticle(articleId);
author = getAuthor(article.userId);
article.author = author.alias;
initArticle(article);
getComments();
//获取用户信息
function getuser() {
    var user = {};
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
            userId = data.userID;
            var content = "<a href='../home.html'>" +alias;
            if(alias != null){
                $(".login").empty();
                $(".login").append("<a href=\"blog.html\"><p>欢迎 " + alias + "</p></a>\n" +
                    "                            <ul role=\"menu\" class=\"sub-menu\">\n" +
                    "                                <li><a href=\"MyHome.html\">主页</a></li>\n" +
                    "                                <li><a class = \"logOut\">注销</a></li>\n" +
                    "                            </ul>\n" +
                    "                        ");
                userId = data.userID;
                user = data;
                // getUserInfo(data.userID);
            }
            else{
                alert("登录失败!");
            }

        }
    });
    return user;
}

//注销点击事件
$(".logOut").click(function () {
    $.ajax({
        url:"./userInfo/logOut",
        type:"GET",
        async:false,
        // data:user1,
        contentType:"application/json;charset=utf-8",
        success:function(){
            $(".login").empty();
            $(".login").append("<a href=\"logIn.html\">登录</a>");
            userId = null;
        }
    });
})

/**
 * 获取文章的详细信息
 * @param articleId 文章id int型
 * */
function getArticle(articleId) {
    var article;
    $.ajax({
        url:"./article/getSingleArticle?articleId="+articleId,
        type:"GET",
        async:false,
        // data:obj,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            article = data;
        }
    });
    return article;
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

function initArticle(article) {
var articleId = article.articleId;
var articleInfo = getCollectionAndCommentNumber(articleId);
var content = article.content;
var title = article.articleName;
var author = article.author;
var collectionNumber = articleInfo.collectionNumber+" 喜欢";
var commentNumber = articleInfo.commentNumber+" 评论";
$(".post-content").append("<h2 class=\"post-title bold\"><a href=\"#\">"+title+"</a></h2>\n" +
    "                                    <h3 class=\"post-author\"><a href=\"#\">"+author+"</a></h3>\n" +
    "                                    <div id = \"content\">"+content+"</div>\n" +
    "                                    <div class=\"post-bottom overflow\">\n" +
    "                                        <ul class=\"nav navbar-nav post-nav\">\n" +
    "                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i>"+collectionNumber+"</a></li>\n" +
    "                                            <li><a href=\"#\"><i class=\"fa fa-comments\"></i>"+commentNumber+"</a></li>\n" +
    "                                        </ul>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"author-profile padding\">\n" +
    "                                        <div class=\"row\">\n" +
    "                                            <div class=\"col-sm-10\">\n" +
    "                                                <h3>我也评论一下!</h3>\n" +
    "                                                <input class=\"form-control commentInput\" height=\"120px\">\n" +
    "                                                <button class=\"btn comment\">评论</button>\n" +
    "                                            </div>\n" +
    "                                        </div>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"response-area\">\n" +
    "                                    <h2 class=\"bold\">Comments</h2>\n" +
    "                                    <ul class=\"media-list\" id='commentList'>\n" +
    "\n" +
    "                                    </ul>\n" +
    "                                </div>");


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
/**
 *  留言评论
 * */
$(".comment").click(function () {
    var commentContent = $(".commentInput").val();

    var commentEntity = {};
    var commentId = Date.parse(new Date());
    commentId = commentId.toString();
    commentId = commentId.substring(6,12);
    commentId = parseInt(commentId);
    var commentTime = CurentTime();
    commentEntity.name = user.alias;
    commentEntity.commentPeopleId = user.userID;
    commentEntity.commentContent = commentContent;
    commentEntity.commentTime = commentTime;
    commentEntity.commentId = commentId;
    commentEntity.articleId = articleId;
    $(".commentInput").val("");
    insertComment(commentEntity);
    comment(articleId,commentEntity);
})
//获取请求路径中的参数
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}

function comment(articleId,comment) {
    var commentId = comment.commentId;
    var content = comment.commentContent;
    var name = comment.name;
    if(articleId>80000){
        $("#"+articleId).append("<div class=\"parrent\" id='"+commentId+"'>\n" +
            "                                                <ul class=\"media-list\">\n" +
            "                                                    <li class=\"post-comment \">\n" +
            "                                                        <div class=\"media-body\">\n" +
            "                                                            <span><i class=\"fa fa-user\"></i>Posted by <a href=\"#\">"+name+"</a></span>\n" +
            "                                                            <p>"+content+"</p>\n" +
            "                                                            <ul class=\"nav navbar-nav post-nav\">\n" +
            "                                                                <li><a href=\"#\"><i class=\"fa fa-clock-o\"></i>February 11,2014</a></li>\n" +
            "                                                            </ul>\n" +
            "                                                        </div>\n" +
            "                                                    </li>\n" +
            "                                                </ul>\n" +
            "                                            </div>");
    }
    else{
        $("#commentList").append("<li class=\"media commentBody\" id='"+ commentId +"'>\n" +
            "                                            <div class=\"post-comment\">\n" +
            "                                                <div class=\"media-body\">\n" +
            "                                                    <span><i class=\"fa fa-user\"></i>Posted by <a href=\"#\">"+name+"</a></span>\n" +
            "                                                    <p>"+content+"</p>\n" +
            "                                                    <ul class=\"nav navbar-nav post-nav\">\n" +
            "                                                        <li><a href=\"#\"><i class=\"fa fa-clock-o\"></i>February 11,2014</a></li>\n" +
            "                                                        <li ><a class='btn reply'><i class=\"fa fa-reply\"></i>Reply</a></li>\n" +
            "                                                    </ul>\n" +
            "                                                </div>\n" +
            "                                            </div>\n" +
            "                                        </li>");

    }

}
/**
 * 获取所有评论
 * */
function  getComments() {
    var comments;
    var Article = {};
    Article.articleId = articleId;
    var jsonArticle = JSON.stringify(Article);
    $.ajax({
        url:"./article/getComment",
        type:"POST",
        async:false,
        data:jsonArticle,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            comments = data;
        }
    });
    for(Acomment of comments){
        comment(Acomment.articleId,Acomment);
    }
}
//后台新增评论
function insertComment(comment) {
    var comm = JSON.stringify(comment);
    $.ajax({
        url:"./article/insertComment",
        type:"POST",
        async:false,
        data:comm,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            articleInfo = data;
        }
    });
}
/**
 * 留言回复
 * */
$(".post-content").on("click",".reply",function () {
    var id = $(this).parents("li.commentBody").attr("id");
    $("#"+id).children(".post-comment").after("<ul class = \"reply-body\">\n" +
    " <li><input class=\"form-control replyInput\" height=\"120px\" width=\"800px\"></li>\n" +
    " <li><button class=\"btn\" id=\"reply\">回复</button><li>\n" +
    "</ul>");
})

/**
 * 回复点击事件
 * */
$(".post-content").on("click","#reply",function () {
    var ArticleId = $(this).parents("li.commentBody").attr("id");
    var commentContent = $(".replyInput").val();

    var commentEntity = {};
    var commentId = Date.parse(new Date());
    commentId = commentId.toString();
    commentId = commentId.substring(6,12);
    commentId = parseInt(commentId);
    var commentTime = CurentTime();
    commentEntity.name = user.alias;
    commentEntity.commentPeopleId = user.userID;
    commentEntity.commentContent = commentContent;
    commentEntity.commentTime = commentTime;
    commentEntity.commentId = commentId;
    commentEntity.articleId = ArticleId;

    $(".reply-body").remove();
    insertComment(commentEntity);
    comment(ArticleId,commentEntity);


})

//获取当前时间
function CurentTime()
{
    var now = new Date();

    var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日

    var clock = year + "-";

    if(month < 10)
        clock += "0";

    clock += month + "-";

    if(day < 10)
        clock += "0";

    clock += day + "";
    return(clock);
}