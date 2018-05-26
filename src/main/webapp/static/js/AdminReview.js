var currentNumber = 1;
var totalNumber = getArticleNumber();
initReviewArticles();

//提交文章按钮
$("#submit").click(function () {

    $(".panel-default").empty();
    $(".panel-default").append("<div class=\"input-group input-group-lg\">\n" +
        "        <span class=\"input-group-addon\" id=\"sizing-addon1\">标题</span>\n" +
        "        <input type=\"text\" id = \"articleName\" class=\"form-control\" placeholder=\"请输入文章标题\" aria-describedby=\"sizing-addon1\">\n" +
        "    </div>\n" +
        "\n" +
        "    <div id=\"summernote\"></div>\n" +
        "\n" +
        "\n" +
        "\n" +
        "    <div class=\"modal-body\">\n" +
        "        <h3>选择文章的分类</h3>\n" +
        "        <h4><input type=\"radio\" name=\"sex\" value=\"summary\">外文摘要<small>国外优秀的文章,短片</small></h4><br>\n" +
        "        <h4><input type=\"radio\" name=\"sex\" value=\"speech\">演讲<small>国外优秀的外语演讲稿</small></h4><br>\n" +
        "        <h4><input type=\"radio\" name=\"sex\" value=\"news\">焦点新闻稿<small>国外优秀的焦点,热点新闻稿</small></h4><br>\n" +
        "    </div>\n" +
        "\n" +
        "    <div class=\"train\" align=\"center\">\n" +
        "        <a  class=\"btn btn-common\" >提交</a>\n" +
        "    </div>");


    $('#summernote').summernote({
            height:400,
            lang: 'zh-CN',
            placeholder: '请输入正文部分',
            toolbar: [
                // [groupName, [list of button]]
                ['style', ['bold', 'italic', 'underline', 'clear']],
                ['fontsize', ['fontsize']],
                ['color', ['color']],
                ['height', ['height']],
                ['insert',['picture']]]
            ,
            callbacks: {
                onImageUpload: function(files, editor, $editable) {
                    var formdata = new FormData();
                    formdata.append("file", $('.note-image-input')[0].files[0]);
                    $.ajax({
                        data : formdata,
                        type : "POST",
                        url : "./file/uploadImage", //图片上传出来的url，返回的是图片上传后的路径，http格式
                        cache : false,
                        contentType : false,
                        processData : false,
                        // dataType : "json",
                        success: function(data) {
                            //data是返回的hash,key之类的值，key是定义的文件名
                            console.log(data);
                            // $('#summernote').summernote('editor.insertImage', "static/images/ArticleImage","advertisement.jpg");
                            if(!$('#summernote').summernote('insertImage', "./static/images/ArticleImage/"+ data.url)){
                                alert("上传失败");
                            }
                        },
                        error:function(){
                            alert("上传失败");
                        }
                    });

                }
            }


        }

    );
})
/**
 * 审批确认按钮
 * */
$("#review").click(function () {
    $(".panel-default").empty();
    initReviewArticles();
})


/**
 * 批量获取文章的信息
 * @param number 提取文章的数量
 * @param currentPageNumber 当前文章的页码值
 * */
function getArtilces(currentPageNumber) {

    $(".panel-default").append("<div class=\"panel-heading\">文章评审</div>\n" +
        "    <div class=\"panel-body\">\n" +
        "        <p>主要负责对用户提交的文章进行初步的人工审核,对不合格的文章进行驳回</p>\n" +
        "    </div>\n" +
        "    <div id = \"review-content\">\n" +
        "    <table class=\"table\">\n" +
        "        <thead id = \"title-content\">\n" +
        "        <tr>\n" +
        "            <th>#</th>\n" +
        "            <th>文章名称</th>\n" +
        "            <th>文章作者</th>\n" +
        "            <th>发表时间</th>\n" +
        "        </tr>\n" +
        "\n" +
        "        </thead>\n" +
        "\n" +
        "\n" +
        "    </table>")
    var articleName;
    var author;
    var content;
    var articles;
    var map = {};

    var newArticle;
    var number = totalNumber-currentPageNumber*6;
    if (number >= 0){
        number = 6;
    }
    else {
        number = number + 6;
    }
    map.start = currentPageNumber*6-6;
    map.size = number;
    map.passed = 'N';
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
    var number = (currentPageNumber-1)*6;
    for(var article of articles){
        var id;
        var articleInfo;
        author = article.userId;
        author = getAuthor(author);
        article.author = author.alias;
        id = article.articleId;
        initArticles(article,id,number);
        number++;
    }

}

// 初始化文章评审界面
function  initReviewArticles() {

    getArtilces(1);
    initBottomLine(totalNumber);
}

function  getArticleNumber() {
    var number;
    var map = {};
    map.passed = 'N';
    var obj = JSON.stringify(map);
    $.ajax({
        url:"./article/getArticles",
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
 * 初始化文章
 * @param article 文章对象
 * @param id 文章id
 * */
function initArticles(article,id,number) {
    var articleName;
    var author;
    var time;
    articleName = article.articleName;
    author = article.author;
    time = article.time;
    var formatTime = fmtDate(time);
    $("#title-content").append("<tr>\n" +
        "            <th>"+number+"</th>\n" +
        "            <th><a href='blogReview.html?articleId="+id+"'>"+articleName+"</a></th>\n" +
        "            <th>"+author+"</th>\n" +
        "            <th>"+formatTime+"</th>\n" +
        "        </tr>")


}

//初始化底栏分页
function initBottomLine(totalNumber) {
    $(".panel-default").append("<nav aria-label=\"Page navigation\" class = \"page-bottom\">\n" +
        "        <ul class=\"pagination\">\n" +
        "            <li>\n" +
        "                <a href=\"#\" aria-label=\"Previous\">\n" +
        "                    <span aria-hidden=\"true\">&laquo;</span>\n" +
        "                </a>\n" +
        "            </li>\n" +
        "            \n" +
        "        </ul>\n" +
        "    </nav>")

    var number = totalNumber/6;
    var remainder = totalNumber%6;
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

$(".panel-default").on("click",".pagination li",function () {
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
//文章提交
$(".panel-default").on("click",".btn-common",function () {
    var level = $("input:radio:checked").val();
    var content = $('#summernote').summernote('code');
    var articleName = $("#articleName").val();
    alert(level);
    console.log(content);
    console.log(articleName);
})

function fmtDate(obj){
    var date =  new Date(obj);
    var y = 1900+date.getYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
}