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
                $(".login").append("<a class ='status' href='../aboutus2.html'>");
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

function getUserInfo() {
    user = {};
    //获取用户的全部信息
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
$(".btn-common").click(function () {
    user = getUserInfo();
    var level = user.abilityLevel;
    if(level == null){
        $("#myModal").modal('show');
    }
})
//等级选择弹出框确认按钮事件
$("#confirm").click(function () {
    var level = $("input:radio:checked").val();
    if(level == "middle"){
        window.location.href = "AbilityTest.html?catagoryId=0";
    }
})
