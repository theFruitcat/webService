    /**
     * 处理背诵单词部分
     * */
    //用户ID
    var userId ;
    //获取session中的用户id
    userId = getuser();
    //初始化单词
    var initialWords;
    //背诵单词
    var reciteWords = new Array();
    //复习单词(即测试单词)
    var reviewWords = new Array();
    //当前背诵单词数量
    var topReciteWord = 0;
    //当前复习单词数量
    var topReviewWord = 0;
    //该变量用于判断单词是否为最后几个单词,即小于预设的四个单词,默认单词数量为4
    var endWord = 4;
    //测试的次数
    var testNumber = 0;
    //复习列表编号
    var reviewNumber = 0;
    //当前背诵编号
    var currentNumber =0;
    //总共剩余单词数量(背诵单词数量+复习单词数量)
    var totalWords = 0;
    //用户数据
    var data = {};
    //测试题
    var test = {};
    //测试单词
    var testWords = new Array();
    //判断是否为页面初始
    var first = true;
    //计数器,用于计算用户当前的背诵进度
    var counter = 1;
    //获取用户的数据
    data = getUserInfo(userId);
    console.log(data);
    //将用户的数据转换为json格式
    var obj = JSON.stringify(data);
    console.log(obj);
    //根据背诵单词初始化背诵的单词
    initialWords = getReciteWords(obj);
    console.log(initialWords);
    //如果是页面第一次加载,则展示背诵开始的第一个单词
    if(first){
        initialWord();
        wordInitialization(reciteWords);
        first = false;
    }
    totalWords = reciteWords.length;
    console.log(reciteWords);
    console.log(reciteWords[1].name);
    console.log(reciteWords[2].name);
    //注册音频播放组件
    createjs.Sound.alternateExtensions = ["mp3"];
    createjs.Sound.on("fileload", this.loadHandler, this);

    First = false;
    //点击下一个单词触发事件
    $(".scene-content").on("click",".next",function () {

                if (currentNumber >= endWord - 1 ) {
                    if (counter == endWord * 2 ) {
                        for (var i = 0; i < endWord; i++) {
                            //将该单词放入复习队列
                            // reviewWords.splice(reviewNumber, 0, reciteWords[0]);
                            reviewWords[i] = reciteWords[0];
                            //将该单词从背诵队列中删除
                            reciteWords.splice(0, 1);
                            //复习单词编号加一
                            reviewNumber++;
                            currentNumber--;
                            console.log(i);
                            console.log(reciteWords);
                        }
                        counter = 1;
                    }
                    //单词编号重新初始化
                    currentNumber = currentNumber - endWord;

                    // showWords();
                }
                if (reviewNumber < endWord) {
                //判断单词是否越界 改判断代码有冗余的可能,保留
                if (currentNumber < topReciteWord - 1) {
                    currentNumber++;
                    counter++;
                    console.log("当前执行次数" + counter);
                    console.log("当前背诵单词序号" + currentNumber);
                    showWords();
                }

                }
            else{
                    //初始化currentNumber
                    currentNumber = 0;

                $(".scene-content").empty();
                $(".scene-content").append("<div class = \"test\">\n" +
                    "        <h1>请选出<span id=\"wordTranslation\"></span>对应的正确单词</h1>\n" +
                    "        <div class = \"testDiv\">\n" +
                    "            <button id = \"word1\" class=\"btn btn-primary btn-lg testWord\"></button>\n" +
                    "            <button id = \"word2\" class=\"btn btn-primary btn-lg testWord\"></button>\n" +
                    "        </div>\n" +
                    "        <div class = \"testDiv\">\n" +
                    "            <button id = \"word3\" class=\"btn btn-primary btn-lg testWord\"></button>\n" +
                    "            <button id = \"word4\" class=\"btn btn-primary btn-lg testWord\"></button>\n" +
                    "        </div>\n" +
                    "        <i id=\"judgement\"></i>\n" +
                    "    </div>");
                    initialTest();
                    addTestWord();
            }
        }
    );

    //点击上一个单词
    $(".scene-content").on("click",".last",function () {
    // $(".last").click(function () {
        //判断单词是否越界
        if(currentNumber > 0){
            currentNumber--;
            counter--;
            showWords();
        }

    }

    );
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

    //初始化animate动画插件
    new WOW().init();
    function getUserInfo(userId) {
        var newData;
        //获取用户的详细信息
        $.ajax({
            url:"./userInfo/getUserInfo?userId=" + userId,
            type:"GET",
            async:false,
            // data:"771984187",
            contentType:"application/json;charset=utf-8",
            success:function(data){
                newData = data;
            }
        });
        console.log("test getUserInfo");
        console.log(newData);
        return newData;
    }

    function getReciteWords(data){
        var Recitewords;
    //获取背诵单词
        $.ajax({
            url:"./reciteWord/get",
            type:"POST",
            async:false,
            data:data,
            contentType:"application/json;charset=utf-8",
            success:function(words){
                console.log(words);
                Recitewords = words;
            }
        });
        wordRadioHandle(Recitewords);
        return Recitewords;
    }


    //注册声音
    function loadHandler(event) {
        // 这会引发针对每个已注册的声音。
        //播放按钮,播放单词声音
        $(".scene-content").on("click","#audio",function () {
        // $("#audio").click(function () {

            // var instance = createjs.Sound.play("sound");  // 发挥使用ID。也可以使用完整的源路径或event.src。
            // instance.on("complete", this.handleComplete, this);
            // instance.volume = 0.5;
            var instance = createjs.Sound.play(reciteWords[currentNumber].name);
            instance.on("complete", this.handleComplete, this);
        })
        //为了满足测试结束后播放下一个单词发音的需求
        $(".scene-content").on("click",".testWord",function () {
            if(testNumber == 4){
                setTimeout(function () {
                    var instance = createjs.Sound.play(reciteWords[0].name);
                    instance.on("complete", this.handleComplete, this);
                    instance.volume = 0.5;
                },1000)
            }
        })
        //下一个播放单词发音
        $(".scene-content").on("click",".next",function () {
        // $(".next").click(function () {
            if(reciteWords[currentNumber]== undefined || reviewNumber == 4){
                console.log("pass");
            }else{
            var instance = createjs.Sound.play(reciteWords[currentNumber].name);
            instance.on("complete", this.handleComplete, this);
            }
        })
        //上一个播放单词发音
        $(".scene-content").on("click",".last",function () {
        // $(".last").click(function () {
            var instance = createjs.Sound.play(reciteWords[currentNumber].name);
            instance.on("complete", this.handleComplete, this);
        })
    }

    //自动播放声音


    //初始化单词声音注册
    function wordRadioHandle(reciteWords){
        for(word of reciteWords){
            AudioSrc = word.name;
            AudioName = word.voiceAddress;
            createjs.Sound.registerSound(AudioName,AudioSrc);
        }
    }
    
    //页面加载初始化第一个单词
    function wordInitialization(reciteWords) {
        $("#wordPicture").attr("src",reciteWords[0].pictureAddress);
        $("#word span").text(reciteWords[0].name);
        $("#translate").text(reciteWords[0].explanation);
        $("#sentence span").text(reciteWords[0].exampleSentence);
        $("#sentence small").text(reciteWords[0].sentenceTranslate);
        // var instance = createjs.Sound.play(reciteWords[0].name);
        // instance.on("complete", this.handleComplete, this);
    }

    //初始化单词(将后台的单词塞入背诵单词列表中,防止覆盖)
    function  initialWord() {
        for(word of initialWords){
            reciteWords.splice(topReciteWord, 0,initialWords[topReciteWord]);
            topReciteWord++;
        }
    }
    //展示单词
    function  showWords() {
        $("#wordPicture").attr("src",reciteWords[currentNumber].pictureAddress);
        $("#word span").text(reciteWords[currentNumber].name);
        $("#translate").text(reciteWords[currentNumber].explanation);
        $("#sentence span").text(reciteWords[currentNumber].exampleSentence);
        $("#sentence small").text(reciteWords[currentNumber].sentenceTranslate);
    }

    //初始化测试题
    function initialTest() {
        var i ;
        i = parseInt(Math.random()*3);
        test.options = testWords;
        test.answer = reviewWords[0].name;
        test.questionStem = reviewWords[0].explanation;
        //将要检测的单词放入到随机的位置,其他位置由后续单词填满
        for(var x = 0; x < i ; x++ ){
            testWords[x]  = reviewWords[x+1].name;
        }
        testWords[i] = reviewWords[0].name;
        for(var y = 3-i; y > 0 ;y--){
            testWords[y+i] = reviewWords[y+i].name;
        }
    }
    //向测试模块添加单词
        function addTestWord(){
        $("#wordTranslation").text(test.questionStem);
        $("#word1").text(testWords[0]);
        $("#word2").text(testWords[1]);
        $("#word3").text(testWords[2]);
        $("#word4").text(testWords[3]);
    }
    //测试单词点击事件
    $(".scene-content").on("click",".testWord",function () {
        var word = $(this).text();
        testNumber++;

            if(word == test.answer){
                //显示正确标识,并进入下一个单词
                $("#judgement").attr("class","fa fa-check fa-3x fa-fw true");
                //复习单词数量减一reviewNumber --;

                //总单词数减1
                totalWords--;
                exchangeTestWord();
                setTimeout(function () {
                    $("#judgement").attr("class","");
                    initialTest();
                    addTestWord();
                },500);
            }
            else{
                //显示错误标识,并进入下一个单词
                $("#judgement").attr("class","fa fa-remove fa-3x fa-fw false");
                //复习单词数量减一 reviewNumber --;

                //将学习者选错的单词重新放入背诵单词列表
                reciteWords.splice(reciteWords.length, 0,reviewWords[0]);
                exchangeTestWord();
                setTimeout(function () {
                    $("#judgement").attr("class","");
                    initialTest();
                    addTestWord();
                },500);
            }
        if(totalWords != 0){
        //判断测试次数,等于四就跳出测试,进入背诵阶段
        if(testNumber >= 4){
            setTimeout(function () {
                if(totalWords < 4){
                    endWord = totalWords;
                }
                //初始化reviewNumber
                reviewNumber = 0;
                testNumber = 0;
            $(".scene-content").empty();
            $(".scene-content").append("<div class=\"record\">\n" +
                "            <div class=\"record-history\">\n" +
                "                <ul class=\"record-ul\">\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "            <button class=\"btn collect-btn btn-success\"><li class=\"fa fa-star\"></li>收藏</button>\n" +
                "        </div>\n" +
                "        <div class=\"current-img\">\n" +
                "            <img id = \"wordPicture\" class=\"current-imgs\" src=\"\" alt=\"11\"/>\n" +
                "            <i class=\"last btn  fa fa-arrow-circle-left fa-5x\"></i>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"current-word\">\n" +
                "            <div class=\"current-words\">\n" +
                "                <h1 id=\"word\"><span></span><i id=\"audio\" class=\"fa btn fa-volume-down fa-1x fa-fw\"></i></h1>\n" +
                "\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"current-paraphrase\">\n" +
                "                <h2>单词释义：</h2>\n" +
                "                <h2 id=\"translate\"></h2>\n" +
                "                <h2 id = \"sentence\"><span></span>\n" +
                "                <small id = \"sentenceTranslate\"></small>\n" +
                "                </h2>\n" +
                "\n" +
                "            </div>\n" +
                "            <i class=\"next btn fa fa-arrow-circle-right fa-5x\"></i>\n" +
                "\n" +
                "        </div>");
            wordInitialization(reciteWords);
            },500);
        }
        }
        else{
            $(".scene-content").empty();

        }
    })
    //交换背诵单词
    function exchangeTestWord() {
        var worda;
        worda = reviewWords[0];
        reviewWords[0] = reviewWords[testNumber];
        reviewWords[testNumber] = worda;
    }
    //记录背诵单词(后台)
    function insertRecitedWord(word) {
        var word = JSON.stringify(word);
        $.ajax({
            url:"./reciteWord/insert",
            type:"POST",
            async:false,
            data:word1,
            contentType:"application/json;charset=utf-8",
            success:function(data){
                console.log(data);
            }
        });
    }

    $(".collect-btn").click(function () {
        var word = {};
        var userId = data.userId;
        var categoryId = data.abilityLevel;
        var name =  $("#word span").text();
        // alert("用户id"+userId+"类别"+ categoryId +"名称"+ name )
        word.userId = userId;
        word.categoryId = categoryId;
        word.name = name;
        word.collectionNumber = reciteWords[currentNumber].number;
        var word = JSON.stringify(word);
        $.ajax({
            url:"./reciteWord/addCollectionWord",
            type:"POST",
            async:false,
            data:word,
            contentType:"application/json;charset=utf-8",
            success:function(data){
                alert("收藏成功");
            },
            error:function () {
                alert("该单词已经被收藏");
            }
        });
    })

    //注销
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