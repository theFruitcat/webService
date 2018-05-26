
$(".login_fields_submit").click(function () {
    var userID = $("#userID").val();
    var passWord = $("#passWord").val();
    console.log(userID);
    user = {}
    user.administratorId = userID;
    user.password = passWord;
    var user1 = JSON.stringify(user);

    //提交ajax请求
    $.ajax({
        url:"./userInfo/logInAdmin",
        type:"POST",
        data:user1,
        contentType:"application/json",
        success:function(data){
            if(data == 1){
                window.location.href = "../adminReview.html";
            }
            else{
                alert("登录失败!");
            }
        }
    });
})