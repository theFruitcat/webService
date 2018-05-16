var picture_address;


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

//点击下一步,完成提交前的最后一步操作
$("#nextStep").click(function () {

    // console.log($(".note-editable").html());
    // console.log(content);
    // console.log(src[1]);
    $("#myModal").modal('show');
    $(".rdolist").labelauty("rdolist", "rdo");
})

//完成文章的提交
$("#confirm").click(function () {
    var labelElement = $(".rdobox.checked");
    var content = $('#summernote').summernote('code');
    var re = /(?=src="([\s\S]*?)")/;
    var src = re.exec(content);
    var date = CurentTime();
    var articleName = $("#articleName").val();
    // var lable1 = $(".rdobox.checked").children("span.radiobox-content");
    var label = labelElement.attr("id");

    var article = {};
    article.articleName = articleName;
    article.time = date;
    article.label = label;
    article.content = content;
    article.pictureAddress = src[1];

    //生成json字符串
    var article1 = JSON.stringify(article);
    //提交ajax请求
    $.ajax({
        url:"./article/insertArticle",
        type:"POST",
        data:article1,
        contentType:"application/json",
        success:function(data){
            if(data == 1){
                window.location = "MyHome.html";
            }
        }
    });


})

//自动调整图片大小
function AutoResizeImage(maxWidth,maxHeight,objImg){
    var img = new Image();
    img.src = objImg.src;
    var hRatio;
    var wRatio;
    var Ratio = 1;
    var w = img.width;
    var h = img.height;
    wRatio = maxWidth / w;
    hRatio = maxHeight / h;
    if (maxWidth ==0 && maxHeight==0){
        Ratio = 1;
    }else if (maxWidth==0){//
        if (hRatio<1) Ratio = hRatio;
    }else if (maxHeight==0){
        if (wRatio<1) Ratio = wRatio;
    }else if (wRatio<1 || hRatio<1){
        Ratio = (wRatio<=hRatio?wRatio:hRatio);
    }
    if (Ratio<1){
        w = w * Ratio;
        h = h * Ratio;
    }
    objImg.height = h;
    objImg.width = w;
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
