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
                    <a class="" href="${pagecontext.request.getcontextpath}/index">
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
                        <li class="active" ><a href="${pagecontext.request.getcontextpath}/library_mana">图书馆设置</a></li>
                        <li><a class="" href="${pagecontext.request.contextpath}/bookcase/getbookecaselist">书架管理</a></li>
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
                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon-th"></i>
                        <span>系统查询</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li><a class="" href="book_list.html">图书档案查询</a></li>
                        <li><a class="" href="book_borrowlist.html">图书借阅查询</a></li>
                        <li><a class="" href="book_borrownotime.html">图书借阅快到期</a></li>
                    </ul>
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
    <section id="main-content">
        <section class="wrapper">
            <div class="row state-overview">
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol terques">
                            <i class="icon-user"></i>
                        </div>
                        <div class="value">
                            <a href="#"> <h1></h1>
                                <p>新读者</p></a>
                        </div>
                    </section>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol red">
                            <i class="icon-tags"></i>
                        </div>
                        <div class="value">
                            <a href="#"> <h1></h1>
                                <p>借出数量</p></a>
                        </div>
                    </section>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol yellow">
                            <i class="icon-shopping-cart"></i>
                        </div>
                        <div class="value">
                            <a href="#"><h1>345</h1>
                                <p>近期入馆图书</p></a>
                        </div>
                    </section>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <section class="panel">
                        <div class="symbol blue">
                            <i class="icon-bar-chart"></i>
                        </div>
                        <div class="value">
                            <a href="#"><h1>34,500</h1>
                                <p>图书馆藏书</p></a>
                        </div>
                    </section>
                </div>
            </div>
            <div class="panel panel-primary">
                <!-- Default panel contents -->
                <div class="panel-heading"><h1 class="glyphicon glyphicon-list-alt" aria-hidden="true">&nbsp;图书馆信息</h1></div>
                <div class="panel-body">
                </div>
                    <span style="text-align: center;color: red" id="sp1">${message}</span>
                <form id="edit_lib_info" action="${pagecontext.request.getcontextpath}/library/saveInfo" method="post">

                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-info-sign" aria-hidden="true">&nbsp;馆&nbsp;&nbsp;名：</span></span>
                    <input type="text" name="libarayname" id="libarayname" class="form-control"
                           value="${lib.libarayname}"  aria-describedby="basic-addon1">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-user" aria-hidden="true">&nbsp;馆&nbsp;&nbsp;长：</span></span>
                    <input type="text" name="curator" id="curator" class="form-control"
                           value="${lib.curator}"  aria-describedby="basic-addon1">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon3"><span class="glyphicon glyphicon-home" aria-hidden="true">&nbsp;地&nbsp;&nbsp;址：</span></span>
                    <input type="text" name="address" id="address" class="form-control"
                           value="${lib.address}"  aria-describedby="basic-addon1">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon4"><span class="glyphicon glyphicon-eye-open" aria-hidden="true">&nbsp;创立时间：</span></span>
                    <input type="text" name="createdate1" id="createdate" class="form-control"
                           value="${lib.createdate?string('yyyy-MM-dd')}" readonly aria-describedby="basic-addon1">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon5"><span class="glyphicon glyphicon-phone-alt" aria-hidden="true">&nbsp;电&nbsp;&nbsp;话：</span></span>
                    <input type="text" name="tel" id="tel" class="form-control"
                           value="${lib.tel}"  aria-describedby="basic-addon1">
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon6"><span class="glyphicon glyphicon-envelope" aria-hidden="true">&nbsp;邮&nbsp;&nbsp;箱：</span></span>
                    <input type="text" name="email" id="email" class="form-control"
                           value="${lib.email}"  aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-default" style="background-color: peachpuff" onclick="saveInfo()">
                        <span class="glyphicon glyphicon-floppy-save" style="color: #18d4cb;" aria-hidden="true" ><font style="font-size: large">&nbsp;保存</font></span>
                    </button>
            </div>
            </form>

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
<script src="//10.0.9.193:8088/js/myjs/library.js"></script>
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