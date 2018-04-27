
$(".login_fields_submit").click(function () {
    var userID = $("#userID").val();
    var passWord = $("#passWord").val();
    console.log(userID);
    user = {}
    user.userId = userID;
    user.password = passWord;
    var user1 = JSON.stringify(user);

    //提交ajax请求
    $.ajax({
        url:"./userInfo/logIn",
        type:"POST",
        data:user1,
        contentType:"application/json",
        success:function(data){
            if(data == 1){
                window.location.href = "../index.html";
            }
            else{
                alert("登录失败!");
            }
        }
    });
})