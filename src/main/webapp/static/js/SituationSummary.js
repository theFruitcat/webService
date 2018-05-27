/**
 * 背诵单词总结页面
 * */

//用户ID
var userId ;
//获取session中的用户id
userId = getStatus();

user = {};
//获取用户信息
function getStatus() {
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
                $(".login").append("<a href=\"blog.html\"><p>欢迎 " + alias + "</p></a>\n" +
                    "                            <ul role=\"menu\" class=\"sub-menu\">\n" +
                    "                                <li><a href=\"MyHome.html\">主页</a></li>\n" +
                    "                                <li><a class = \"logOut\">注销</a></li>\n" +
                    "                            </ul>\n" +
                    "                        ");
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

function getUserInfo() {
    user = {};
    //获取用户的全部信息
    if(userId != null){
        $.ajax({
            url:"./userInfo/getUserInfo?userId=" + userId,
            type:"GET",
            async:false,
            // data:user1,
            contentType:"application/json;charset=utf-8",
            success:function(data){

                user = data;

            }
        });
        return user;
    }

}
$(".btn-common").click(function () {
    user = getUserInfo();
    var level = user.level;

    $("#myModal1").modal('show');


})

//目标选择弹出框确认按钮事件
$("#confirm3").click(function () {
    var goal = $(".dropdown-toggle").attr("title");

    // user = getUserInfo();
    // var level = user.level;
    if(goal == "食物"){
            window.location.href = "SituationWord.html?situation=food";
    }
    else if(goal == "餐具"){
            window.location.href = "SituationWord.html?situation=tableWare";
    }
    else if(goal == "衣物"){

    }
    else if(goal == "交通工具"){

    }
    else if(goal == "日常用品"){

    }
})

