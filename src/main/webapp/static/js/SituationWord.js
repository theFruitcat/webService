//用户ID
var userId ;
//获取session中的用户id
userId = getStatus();

//情境单词
var situationWords = new Array();
//获取路径中的情境变量
var url = GetRequest();
var situation = url['situation'];
var map = {};
map.situation = situation;
user = {};
user = getUserInfo();
var obj = JSON.stringify(map);
situationWords = getWords(obj);
var totalWords = situationWords.length;
console.log("总共单词数"+ totalWords);
var currentNumber = 0;
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

function getWords(map) {
    var Situationwords;
    //获取背诵单词
    $.ajax({
        url:"./situationWord/getWords",
        type:"POST",
        async:false,
        data:map,
        contentType:"application/json;charset=utf-8",
        success:function(words){
            console.log(words);
            Situationwords = words;
        }
    });
    wordRadioHandle(Situationwords);
    return Situationwords;
}

//初始化单词声音注册
function wordRadioHandle(situationWords){
    for(word of situationWords){
        var AudioSrc = word.name;
        var AudioName = word.voiceAddress;
        createjs.Sound.registerSound(AudioName,AudioSrc);
    }
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

$("#start").click(function () {
    $("#team-carousel").empty();
    $("#team-carousel").append("<div class=\"Level\">\n" +
        "                        <div class=\"col-sm-4 text-left\">\n" +
        "                            <h2 id=\"currentLevel\"></h2>\n" +
        "                        </div>\n" +
        "                        <div class=\"col-sm-4 text-center\">\n" +
        "                            <h2 id = \"translate\"></h2><br>\n" +
        "                            <i class=\"btn fa fa-play-circle fa-4x\"></i>\n" +
        "                        </div>\n" +
        "<div class=\"train col-sm-4 text-right\" align=\"center\">\n" +
        "                        <a  class=\"btn btn-common\" href=\"#\" id=\"end\" data-target=\"#myModal\">结束训练</a>\n" +
        "                    </div>" +
        "                    </div>\n" +
        "\n" +
        "                    <div class=\"img-rotation\">\n" +
        "                        <btn class=\" btn img-left\" href=\"#\">\n" +
        "                            <img src=\"static/images/left.png\" alt=\"\"/>\n" +
        "                        </btn>\n" +
        "                        <img class=\"img-picture\" src=\"\" alt=\"\"/>\n" +
        "                        <btn class=\"btn img-right\" href=\"#\">\n" +
        "                            <img src=\"static/images/right.png\" alt=\"\"/>\n" +
        "                        </btn>\n" +
        "                    </div>");

    wordInitialization(situationWords);
})

//注册声音
function loadHandler(event) {
    // 这会引发针对每个已注册的声音。


    //下一个播放单词发音
    $("#team-carousel").on("click",".img-right",function () {
        if(situationWords[currentNumber]== undefined || reviewNumber == 4){
            console.log("pass");
        }else{
            var instance = createjs.Sound.play(situationWords[currentNumber].name);
            instance.on("complete", this.handleComplete, this);
        }
    })

    //上一个播放单词发音
    $("#team-carousel").on("click",".img-left",function () {
        var instance = createjs.Sound.play(reciteWords[currentNumber].name);
        instance.on("complete", this.handleComplete, this);
    })
}


//页面加载初始化第一个单词
function wordInitialization(situationWords) {
    $(".img-picture").attr("src",situationWords[0].pictureAddress);
    $("#currentLevel").text("当前训练类别:"+situationWords[0].situation);
    $("#translate").text(situationWords[0].name);

    var instance = createjs.Sound.play(situationWords[currentNumber].name);
    instance.on("complete", this.handleComplete, this);
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

$("#team-carousel").on("click",".img-left",function () {
    if(currentNumber >=1){
        console.log(currentNumber);
        currentNumber --;
        $(".img-picture").attr("src",situationWords[currentNumber].pictureAddress);
        $("#translate").text(situationWords[currentNumber].name);
        var instance = createjs.Sound.play(situationWords[currentNumber].name);
        instance.on("complete", this.handleComplete, this);
    }
})

$("#team-carousel").on("click",".img-right",function () {
    if(currentNumber <= totalWords-2){
        console.log(currentNumber);
        currentNumber ++;
        $(".img-picture").attr("src",situationWords[currentNumber].pictureAddress);
        $("#translate").text(situationWords[currentNumber].name);
        var instance = createjs.Sound.play(situationWords[currentNumber].name);
        instance.on("complete", this.handleComplete, this);
    }
    else if(currentNumber == totalWords-1){
        alert("已经到最后一个啦!");
    }
})

$("#team-carousel").on("click","#end",function () {
    $("#myModal").modal('show');
})

//播放按钮,播放单词声音
$("#team-carousel").on("click",".fa-play-circle",function () {
    var instance = createjs.Sound.play(situationWords[currentNumber].name);
    instance.on("complete", this.handleComplete, this);
})

//结束训练确认按钮
$("#confirm").click(function () {
    window.location.href = "index.html";
})

