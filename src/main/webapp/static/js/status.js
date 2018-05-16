(function ($) {
    $.ajax({
        url:"./userInfo/getStatus",
        type:"GET",
        // data:user1,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            //后台返回数字2代表用户已经登录
            console.log(data);
            // var obj = JSON.parse(data);
            var alias = data.alias;
            var content = "<a href='../home.html'>" +alias;

            if(alias != null){
                $(".login").empty();
                $(".login").append("<a class ='status' href='../MyHome.html'>");
                $(".status").append("<p>欢迎 " + alias + "</p>");
            }
            else{
                alert("登录失败!");
            }
        }
    });
    new WOW().init();
}(jQuery));


