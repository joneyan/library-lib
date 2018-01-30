<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">
    <title>图书馆信息</title>
    <!-- Bootstrap core CSS -->
    <link href="//10.0.9.193:8088/css/bootstrap.min.css" rel="stylesheet">
    <link href="//10.0.9.193:8088/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="//10.0.9.193:8088/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="//10.0.9.193:8088/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="//10.0.9.193:8088/css/owl.carousel.css" type="text/css">
    <!-- Custom styles for this template -->
    <link href="//10.0.9.193:8088/css/style.css" rel="stylesheet">
    <link href="//10.0.9.193:8088/css/style-responsive.css" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="//10.0.9.193:8088/js/html5shiv.js"></script>
    <script src="//10.0.9.193:8088/js/respond.min.js"></script>
    <![endif]-->
    <script src="//10.0.9.193:8088/js/jquery.js"></script>
    <script src="//10.0.9.193:8088/js/jquery-1.8.3.min.js"></script>
    <script src="//10.0.9.193:8088/js/bootstrap.min.js"></script>
</head>
<body>

<section id="container" class="">
    <!--header start 头文件  标题log 提醒，用户等等..-->
    <header class="header white-bg">
        <div class="sidebar-toggle-box">
            <div data-original-title="Toggle Navigation" data-placement="right" class="icon-reorder tooltips"></div>
        </div>
        <!--logo start-->
        <a href="#" class="logo">图书馆<span>管理系统</span></a>
        <!--logo end-->
        <div class="nav notify-row" id="top_menu">
            <!--  notification start -->
        </div><div class="top-nav ">
        <!--search & user info start-->
        <ul class="nav pull-right top-menu">
            <li>
                <input type="text" class="form-control search" placeholder="Search">
            </li>
            <!-- user login dropdown start-->
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <img alt="" src="${pagecontext.request.getcontextpath}/img/avatar1_small.jpg">
                    <span class="username">严静</span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu extended logout">
                    <div class="log-arrow-up"></div>
                    <li><a href="#"><i class=" icon-suitcase"></i>文档</a></li>
                    <li><a href="#"><i class="icon-cog"></i> 设置</a></li>
                    <li><a href="#"><i class="icon-bell-alt"></i> 提醒</a></li>
                    <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
                </ul>
            </li>
            <!-- user login dropdown end -->
        </ul>
        <!--search & user info end-->
    </div>        </header>
    <!--header end-->
    <!--sidebar start 左边菜单栏-->
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu">
                <li class="">
                    <a class="" href="index.html">
                        <i class="icon-dashboard"></i>
                        <span>首页</span>
                    </a>
                </li>
                <li class="sub-menu active">
                    <a href="javascript:;" class="">
                        <i class="icon-book"></i>
                        <span>系统设置</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li class="active" ><a href="">图书馆设置</a></li>
                        <li><a class="" href="bookcase_mana.html">书架管理</a></li>
                        <li><a class="" href="press_mana.html">出版社管理</a></li>
                        <li><a class="" href="manager_mana.html">管理员管理</a></li>
                        <li><a class="" href="stop_mana.html">封禁管理</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon-cogs"></i>
                        <span>读者管理</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li><a class="" href="reader_list.html">所有读者</a></li>
                        <li><a class="" href="reader_add.html">新增管理</a></li>
                        <li><a class="" href="readertype_mana.html">读者类型管理</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon-tasks"></i>
                        <span>图书管理</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li><a class="" href="book_list.html">所有图书</a></li>
                        <li><a class="" href="book_add.html">新增图书</a></li>
                        <li><a class="" href="booktype_mana.html">图书类型管理</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon-th"></i>
                        <span>图书借还</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li><a class="" href="book_borrow.html">图书借阅</a></li>
                        <li><a class="" href="book_borrowlong.html">图书续借</a></li>
                        <li><a class="" href="book_return.html">图书归还</a></li>
                    </ul>
                </li>
                <li>
                    <a class="" href="javascript:;">
                        <i class="icon-envelope"></i>
                        <span>系统查询</span>
                        <ul class="sub">
                            <li><a class="" href="book_list.html">图书档案查询</a></li>
                            <li><a class="" href="book_borrowlist.html">图书借阅查询</a></li>
                            <li><a class="" href="book_borrownotime.html">图书借阅快到期</a></li>
                        </ul>
                    </a>
                </li>
                <li class="">
                    <a class="" href="index.html">
                        <i class="icon-dashboard"></i>
                        <span>首页</span>
                    </a>
                </li>
                <li>
                    <a class="" href="login.html">
                        <i class="icon-user"></i>
                        <span>Login Page</span>
                    </a>
                </li>
            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>      <!--sidebar end-->
    <!--main content start 内容-->
    <section id="main-content" style="background-image: url('${pagecontext.request.contextpath}/img/tsg2.jpg')">
        <section class="wrapper" style="height:700px;">
            <div class="alert alert-success" style="margin: 0 auto;width: 600px;height: 50px;font-size: larger;" role="alert" >${message}将在<span id="autos" style="font-size: large;color: red">5</span>秒后返回!如未跳转请
                <a href="${pagecontext.request.getcontextpath}/library/getEditInfo">点击跳转</a></div>

        </section>      </section>
    <!--main content end-->
</section>
<!-- js placed at the end of the document so the pages load faster -->
<script src="//10.0.9.193:8088/js/jquery.scrollTo.min.js"></script>
<script src="//10.0.9.193:8088/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="//10.0.9.193:8088/js/jquery.sparkline.js" type="text/javascript"></script>
<script src="//10.0.9.193:8088/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
<script src="//10.0.9.193:8088/js/owl.carousel.js" ></script>
<script src="//10.0.9.193:8088/js/jquery.customSelect.min.js" ></script>
<!--common script for all pages-->
<script src="//10.0.9.193:8088/js/common-scripts.js"></script>
<!--script for this page-->
<script src="//10.0.9.193:8088/js/sparkline-chart.js"></script>
<script src="//10.0.9.193:8088/js/easy-pie-chart.js"></script>
<script src="//10.0.9.193:8088/js/myjs/common.js"></script>
<script>
    //owl carousel
    $(document).ready(function() {
        $("#owl-demo").owlCarousel({
            navigation : true,
            slideSpeed : 300,
            paginationSpeed : 400,
            singleItem : true

        });
    });

    //custom select box
    $(function(){
        $('select.styled').customSelect();
    });

</script>

</body>
</html>