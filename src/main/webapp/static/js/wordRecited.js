var currentNumber = 1;
var userId = getuser();
var totalNumber = getCollectionWordNumber();
initReviewArticles();

/**
 * 批量获取文章的信息
 * @param number 提取文章的数量
 * @param currentPageNumber 当前文章的页码值
 * */
function getArtilces(currentPageNumber) {
    var words;
    $(".content").append(
        "        <div class=\"panel-body\">\n" +
        "                <p>我已经背诵的单词</p>\n" +
        "        </div>\n" +
        "        <div id = \"collection-content\">\n" +
        "            <table class=\"table\">\n" +
        "                    <thead id = \"title-content\">\n" +
        "                    <tr>\n" +
        "                            <th>#</th>\n" +
        "                            <th>单词名称</th>\n" +
        "                            <th>单词类别</th>\n" +
        "                            <th>单词编号</th>\n" +
        "                    </tr>\n" +
        "\n" +
        "                    </thead>\n" +
        "\n" +
        "                </table>\n" +
        "        </div>")
    var map = {};
    var number = 12
    map.start = currentPageNumber*12-12;
    map.size = number;
    map.userId = userId;
    var obj = JSON.stringify(map);
    // 批量获取收藏
    $.ajax({
        url:"./userInfo/getRecitedWords",
        type:"POST",
        async:false,
        data:obj,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            words = data;
            console.log(words);
        }
    });
    var wNumber = currentPageNumber*12-12;
    for(var word of words){

        initArticles(word,wNumber);
        wNumber++;
    }

}

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


// 初始化界面
function  initReviewArticles() {

    getArtilces(1);
    initBottomLine(totalNumber);
}

function  getCollectionWordNumber() {
    var number;
    var map = {};
    map.userId = userId;
    var obj = JSON.stringify(map);
    $.ajax({
        url:"./userInfo/getRecitedWords",
        type:"POST",
        async:false,
        data:obj,
        contentType:"application/json;charset=utf-8",
        success:function(data){
            number = data.length;
        }
    });
    return number;
}

/**
 * 初始化文章
 * @param article 文章对象
 * @param id 文章id
 * */
function initArticles(word,wNumber) {
    var name;
    var number;
    var categoryId;
    name = word.name;
    number = word.reciteNumber;
    categoryId = word.categoryId;

    $("#title-content").append("<tr>\n" +
        "            <th>"+wNumber+"</th>\n" +
        "            <th>"+name+"</a></th>\n" +
        "            <th>"+categoryId+"</th>\n" +
        "            <th>"+number+"</th>\n" +
        "        </tr>")


}

//初始化底栏分页
function initBottomLine(totalNumber) {
    $(".content").append("<nav aria-label=\"Page navigation\" class = \"page-bottom\">\n" +
        "        <ul class=\"pagination\">\n" +
        "            <li>\n" +
        "                <a href=\"#\" aria-label=\"Previous\">\n" +
        "                    <span aria-hidden=\"true\">&laquo;</span>\n" +
        "                </a>\n" +
        "            </li>\n" +
        "            \n" +
        "        </ul>\n" +
        "    </nav>")

    var number = totalNumber/12;
    var remainder = totalNumber%12;
    if(remainder != 0){
        number ++;
    }
    //多循环一次,增加右边的图标
    for(var i = 1;i<=number+1;i++){
        if(i <= number+1){
            $(".pagination").append("<li id="+"'"+i+"'"+"><a href=\"#\">"+i+"</a></li>");
        }
        else{
            $(".pagination").append("  <a href=\"#\" aria-label=\"Next\">\n" +
                "                    <span aria-hidden=\"true\">&raquo;</span>\n" +
                "                </a>");
        }

    }
}

/**
 * 分页触发事件
 * */

$(".content").on("click",".pagination li",function () {
    //获取点击的页码
    var page = $(this).text();
    if(isNaN(page)){
        alert("sdsdds");
    }else{
        alert("43334")
        $(".panel-default").empty();
        getArtilces(page);
        initBottomLine(totalNumber);
    }
})

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