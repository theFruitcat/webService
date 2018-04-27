
    $(".register_fields__submit").click(function () {
        var passed = true;
        var pattern = new RegExp("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")
        // 获取注册表单参数
        var username = $("#username").val();
        var password = $("#password").val();
        var email = $("#email").val();
        passed = pattern.test(email);
        console.log(passed);
        if(passed==true){
            register(username,password,email);
        }
        else{
            console.log("email is false");
            $(".eamil").after(" <div class=\"input-group warning\">\n" +
                "            <span class=\"input-group-addon \">请输入正确邮箱格式</span>\n" +
                "        </div>");
        }
    });

    function register(username,password,email) {

        //拼装参数
        user = {}
        user.userId = username;
        user.password = password;
        user.email = email;
        user.registDate = CurentTime();

        //生成json字符串
        var user1 = JSON.stringify(user);
        console.log(user1);
        //提交ajax请求
        $.ajax({
            url:"./userInfo/regist",
            type:"POST",
            data:user1,
            contentType:"application/json",
            success:function(data){
                if(data == 1){
                    window.location.href("logIn.html");
                }
            }
        });
    }

    //获取当前时间
    function CurentTime()
    {
        var now = new Date();

        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate();            //日

        // var hh = now.getHours();            //时
        // var mm = now.getMinutes();          //分

        var clock = year + "-";

        if(month < 10)
            clock += "0";

        clock += month + "-";

        if(day < 10)
            clock += "0";

        clock += day + "";

        // if(hh < 10)
        //     clock += "0";
        //
        // clock += hh + ":";
        // if (mm < 10) clock += '0';
        // clock += mm;
        return(clock);
    }



