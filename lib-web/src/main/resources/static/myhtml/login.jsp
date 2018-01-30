<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">

    <title>登录图书馆</title>

    <!-- Bootstrap core CSS -->
    <link href="${pagecontext.request.getcontextpath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pagecontext.request.getcontextpath}/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${pagecontext.request.getcontextpath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="${pagecontext.request.getcontextpath}/css/style.css" rel="stylesheet">
    <link href="${pagecontext.request.getcontextpath}/css/style-responsive.css" rel="stylesheet" />
    <script src="${pagecontext.request.getcontextpath}/js/jquery-1.8.3.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="${pagecontext.request.getcontextpath}/js/html5shiv.js"></script>
    <script src="${pagecontext.request.getcontextpath}/js/respond.min.js"></script>

    <![endif]-->
</head>

<body class="login-body"  style="background-image: url('${pagecontext.request.getcontextpath}/img/tsg1.JPG')">

<div class="container">
    <form method="post" class="form-signin" id="loginform" action="/login/manalogin">
        <h2 class="form-signin-heading">sign in now</h2>
        <div class="login-wrap">
            <span style="text-align: center;color: red" id="sp1">${message}</span>
            <input type="text" name="username" id="username" class="form-control" value="${loginInfo.username}" placeholder="用户名" autofocus>
            <input type="password" name="password" id="password" value="${loginInfo.password}" class="form-control" placeholder="密码">
            <label class="checkbox">
                <input type="checkbox" name="remember" id="remember" value="remember-me"> 记住密码
                <span class="pull-right"> <a href="#"> 忘记密码</a></span>
            </label>
            <button class="btn btn-lg btn-login btn-block" onclick="login()" id="loginbt" type="button">登录</button>
            <!--<p>or you can sign in via social network</p>
            <div class="login-social-link">
                <a href="index.html" class="facebook">
                    <i class="icon-facebook"></i>
                    Facebook
                </a>
                <a href="index.html" class="twitter">
                    <i class="icon-twitter"></i>
                    Twitter
                </a>
            </div>-->

        </div>

    </form>

</div>


</body>
<script>
    function login(){
        var username=$("#username").val();
        var password=$("#password").val();
        if(username==null||username==""){
            $("#sp1").html("用户名不能为空！").css("color","red");
            return;
        }
        if(username==null||username==""){
            $("#sp1").html("密码不能为空！").css("color","red");
            return;
        }
        $("#loginform").submit();
    }
    $(function(){
        var username=$("#username").val();
        if(username!=''){
            $("#remember").attr("checked","checked");
        }
    });
</script>
</html>