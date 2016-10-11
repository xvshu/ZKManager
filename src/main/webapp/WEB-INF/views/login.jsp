<%--
  Created by IntelliJ IDEA.
  User: xvshu
  Date: 2016/10/10
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="resources/login/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/login/login.css">
</head>
<body>


    <div class="content">


        <!--  登录面板    -->
        <div class="panel">

            <!--  账号和密码组    -->
            <div class="group">
                <label>账号</label>
                <input placeholder="请输入账号" id="username">
            </div>
            <div class="group">
                <label>密码</label>
                <input placeholder="请输入密码" type="password" id="password">
            </div>

            <!--  登录按钮    -->
            <div class="login">
                <button onclick="login()">登录</button>
            </div>
        </div>

    </div>

    <script type="text/javascript">
        function login(){
            $.ajax({
                url:"lg/up",    //请求的url地址
                dataType:"text",   //返回格式为json
                async:true,//请求是否异步，默认为异步，这也是ajax重要特性
                data:{"username":$("#username").val(),"password":$("#password").val()},    //参数值
                type:"GET",   //请求方式
                success:function(req){
                    if(req!="true"){
                        alert("登录失败");
                    }else{
                        window.location.href="/home";
                    }
                },
                error:function(){
                    alert("登录失败");
                }
            });
        }
    </script>

</body>
</html>
