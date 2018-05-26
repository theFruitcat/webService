/**
 * 博客详细信息
 * */
//用户
var user = {}
//用户ID
var userId ;
//获取session中的用户id
// user = getuser();
var author;
var article = {};
var request = GetRequest();
var articleId = request["articleId"];
article = getArticle(articleId);
author = getAuthor(article.userId);
article.author = author.alias;
initArticle(article);
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
                $(".login").append("<a class ='status' href='../MyHome.html'>");
                $(".status").append("<p>欢迎 " + alias + "</p>");
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
var content = article.content;
var title = article.articleName;
var author = article.author;
$(".post-content").append("<h2 class=\"post-title bold\"><a href=\"#\">"+title+"</a></h2>\n" +
    "                                    <h3 class=\"post-author\"><a href=\"#\">"+author+"</a></h3>\n" +
    "                                    <div id = \"content\">"+content+"</div>\n"
);
$(".post-content").append("<div class=\"train\" align=\"center\">\n" +
    "                                        <a id = \"pass\" class=\"btn btn-common\" >通过审核</a>\n" +
    "                                    </div>");


$(".post-content").append("<div class=\"train\" align=\"center\">\n" +
    "                                        <a id = \"reject\" class=\"btn btn-common\" >开始训练</a>\n" +
    "                                    </div>");

}

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

$("#pass").click(function () {

   var article = {};
   article.articleId = articleId;
   article.passed = 'Y'
    var map = JSON.stringify(article);
    $.ajax({
        url:"./article/reviewArticle",
        type:"POST",
        async:false,
        data:map,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            if(data == 1){
                alert("验证通过");
            }
        }
    });
})