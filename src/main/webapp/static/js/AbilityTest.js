var achievement;
function test(test_id) {
    if(test_id!=""){
        //获取测试能力等级
        var url = GetRequest();
        var catagoryId = url['catagoryId'];
        var data = {};
        data = getTestWord(catagoryId);
        console.log(data);
        var titleB = "英语能力测试";
        //var exam = data.exam;
        var test_box = '';

        //$.each(exam, function(h, data) {
        var title = data.title;
        var info = data.infos!=null?'<h4 class="jxz-title">'+data.infos+'</h4>':'';
        var test = data.values;
        var topic_box = '';

        $.each(test, function(i, topic) {//1单选2多选3判断4填空5问答8论述题6完型填空7阅读理解
            var type = topic.type;
            var options = topic.options;
            var answer = topic.answer;
            var analysis = topic.analysis==null||topic.analysis==""?"无":topic.analysis;
            var option_box = '';//题目

            if(type==1){
                //answer_op = '';
                $.each(options, function(j, option) {
                    var op = convert(j);
                    option_box += `
                                    <div class="jxz-option radio">
                                        <label>
                                            <input name="test`+''+i+`" type="radio" value="`+option+`"> `+op+`：`+option+`
                                        </label>
                                    </div>
                                    `;
                });

            }

            var answer_op = '';//答案
            if(type==3){
                $.each(answer, function(i, aw) {
                    answer_op += aw==1 ? "正确" : "错误";
                });
            }else{
                $.each(answer, function(i, aw) {
                    answer_op += answer.length==(i+1) ? aw : aw+" ";
                });
            }
            topic_box += `
                            <div class="testCon" data-type="`+type+`" data-answer="`+answer_op+`">
                                <h4 class="jxz-title">`+topic.questionStem+`</h4>
                                `+option_box+`
                                <div class="topic-answer">
                                   <p>您的答案：<span class="userAnswer"></span></p>
                                   <p>正确答案：`+answer_op+`</p>
                                   <p>解析：`+analysis+`</p>
                                </div>
                            </div>
                            `;

        });
        test_box += `
                            <div class="jxz-box col-md-12">
                            <h4 class="tesTitle">`+title+`</h4>
                            `+info+`
                            `+topic_box+`
                        </div>
                        `;
        //});

        var test_html = `
                    <div class="page-header">
                        <h3 class="text-center">`+titleB+`</h3>
                    </div>
                    <form class="" id="testForm">
                        <div class="test-form-box">
                            `+test_box+`
                        </div>
                        <div class="form-group assignment">
                            <button type="button" class="btn btn-primary" id="sub" onclick="assignment()">交卷</button>
                            <button type="button" class="btn btn-primary" onclick="returnHome()">返回页面</button>
                        </div>
                    </form>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel"></h4>
                </div>
                <div class="modal-body">
                    <!--提示信息,表示用户是否通过测试-->
                    <h3 id="summary"></h3>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="hideButton()">查看试卷</button>
                    <button type="button" class="btn btn-primary" id="confirm" onclick="returnHome()">返回背诵</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
`;
        $('#testArea').html(test_html)
        //},
        //error:function(data){
        //alert("网络异常，请稍后重试");
        //}
        //});
    }else{
        alert("试题获取失败！");
    }
}
//交卷
function assignment(){
    $(".testCon h4").css("color","#555");
    var _temp_tip = "yes";
    var tall = 0;
    $(".testCon").each(function(i){
        var type = $(this).attr("data-type");
        if(type==1||type==3||type==7){
            if($(this).find('input[type="radio"]:checked').val() == undefined){
                _temp_tip = "no";
                $(this).find("h4").css("color","#00B895");
            }
        }
        tall++;
    });

    if(_temp_tip == "no"){
        alert("还有题目没做完");
        return;
    }

    var err = 0;
    $(".testCon").each(function(i){
        var type = $(this).attr("data-type");
        var aw = $(this).attr("data-answer");
        var set_answer = '';

        if(type==1){

            var rd = $(this).find('input[type="radio"]:checked').val();
            if(rd != aw){
                $(this).find("h4").css("color","red");
                err++;
            }
            set_answer = rd;

        }

        $(this).find("span.userAnswer").text(set_answer);

    });
    $(".topic-answer").show();
    achievement = (20-err)*5;
    if(achievement <60){
        $("#myModalLabel").text("测试未通过!"+"你的成绩:"+achievement);
        $("#summary").text("很抱歉,你没有通过该等级的测试!请选择低一等级的测试或者直接开始学习初级测试!");
    }
    else{
        $("#myModalLabel").text("测试通过!"+"你的成绩:"+achievement);
        $("#summary").text("恭喜你已经通过了该等级的测试,请开始你的学习之旅吧!");
    }
    $("#myModal").modal('show');
}
//数字转换成大写字母
function convert(num){
    num = num + 1;
    return num <= 26 ? String.fromCharCode(num + 64) : convert(~~((num - 1) / 26)) + convert(num % 26 || 26);
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

function getTestWord(catagoryId) {
    data = {};
    //获取用户的全部信息
    $.ajax({
        url:"./abilityTest/getWords?catagoryId=" + catagoryId,
        type:"GET",
        async:false,
        // data:user1,
        contentType:"application/json;charset=utf-8",
        success:function(testWords){

            data = testWords;

        }
    });
    console.log(data);
    return data;
}
//返回总结页面
function returnHome() {
    window.location.href="ReciteSummary.html";
}
function hideButton() {
    $("#sub").hide();
}

