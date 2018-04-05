<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--<html>--%>
<%--<head><meta charset="gb2312"></head>--%>
<%--<body>--%>
<%--<h2>Hello World!你好</h2>--%>
<%--</body>--%>
<%--</html>--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>测试spring MVC</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" />
    <!-- 导入Bootrap 3的JS插件所依赖的jQuery库  -->
    <script src="${pageContext.request.contextPath}/static/jquery/jquery-3.1.1.js"></script>
    <!-- 导入Bootstrap 3的JS插件库 -->
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed"
                data-toggle="collapse" data-target="#menu">
            <span class="sr-only">Toggle navigation</span> <span
                class="icon-bar"></span> <span class="icon-bar"></span> <span
                class="icon-bar"></span>
        </button>
        <!-- 标题栏  -->
        <a class="navbar-brand" href="#">
            <div>
                <img alt="图书管理" src="images/fklogo.gif"
                     style="width:52px;height:52px">&nbsp;<strong>电子拍卖系统</strong>
            </div>
        </a>
    </div>
    <div class="collapse navbar-collapse" id="menu">
        <ul class="nav navbar-nav">
            <li><a href="#" onclick="goPage('login.html');">登录</a></li>
            <li><a href="#" onclick="goPage('viewSucc.html');">查看竞得物品</a></li>
            <li><a href="#" onclick="goPage('viewFail.html');">浏览流拍物品</a></li>
            <li><a href="#" onclick="goPage('viewCategory.html');">管理种类</a></li>
            <li><a href="#" onclick="goPage('viewOwnerItem.html');">管理物品</a></li>
            <li><a href="#" onclick="goPage('viewInBid.html');">浏览拍卖物品</a></li>
            <li><a href="#" onclick="goPage('viewBid.html');">查看自己竞标</a></li>
            <li><a href="#" onclick="goPage('home.html');">返回首页</a></li>
        </ul>
    </div>
</nav>
<div style="height: 50px;"></div>
<div class="container">
    <div id="data" style="margin-top: 10px;">
        <!-- 此处用于动态的去展示各种信息  -->
    </div>
    <hr>
    <footer>
        <p align="center">
            All Rights Reserved.&copy; <a href="http://www.crazyit.org">http://www.crazyit.org</a><br />
            版权所有 Copyright&copy;2010-2018 Yeeku.H.Lee <br /> 如有任何问题和建议，请登录 <a
                href="http://www.crazyit.org">http://www.crazyit.org</a><br />
        </p>
    </footer>
</div>
<!-- 弹出框 -->
<div id="myModal" class="modal bs-example-modal-sm fade">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p id="tip"></p>
            </div>
            <div class="modal-footer">
                <button id="cancelBn" type="button" class="btn btn-default"
                        data-dismiss="modal">取消</button>
                <button id="sure" type="button" class="btn btn-primary"
                        data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>
</html>