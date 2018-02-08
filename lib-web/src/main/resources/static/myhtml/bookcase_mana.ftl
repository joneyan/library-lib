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
    <style type="text/css">table{border:1px solid; border-top:1px solid;text-align:center;border-collapse:collapse;}
    th{border:1px solid ;border-left:1px solid ;border-top: 1px solid;  border-right: 1px solid;}
    td{border:1px solid ;border-left:1px solid ;border-top: 1px solid;  border-right: 1px solid;}</style></head>
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
                    <span class="username">${managerlog.username}</span>
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
                        <li class="" ><a href="${pagecontext.request.getcontextpath}/library_mana">图书馆设置</a></li>
                        <li class="active"><a  href="${pagecontext.request.getcontextpath}/bookcase/getbookecaselist">书架管理</a></li>
                        <li><a class="" href="${pagecontext.request.getcontextpath}/press/getbookepresslist">出版社管理</a></li>
                        <#if managerlog.status==1>
                            <li><a class="" href="${pagecontext.request.getcontextpath}/manager/getbookemanagerlist">管理员管理</a></li>
                        </#if>
                        <li><a class="" href="${pagecontext.request.getcontextpath}/user/getbookbanneruserlist?isBanner=1">封禁管理</a></li>
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
        <section class="wrapper" >
            <ul class="nav nav-tabs">
                <li role="presentation" class="active" style="background-color:lawngreen"><a href="${pagecontext.request.contextpath}/bookcase/getbookecaselist">书架列表</a></li>
                <li role="presentation" style="background-color: hotpink"><a href="${pagecontext.request.contextpath}/bookcase_add">新增书架</a></li>
            </ul>
            <table class="table table-striped" style="text-align: center; table-layout: fixed;border-radius: 5px;" cellspacing="0" border="1">
            <caption style="color: #18d4cb;font-size: 30px;">书架列表</caption>
                <tr>
                    <th style="text-align: center;">编号</th>
                    <th style="text-align: center;">名字</th>
                    <th style="text-align: center;">操作</th>
                </tr>
                <#list pagebean.pageElements as case>
                <tr>
                    <td style="text-align: center;font-size: large;">${case.id}</td>
                    <td style="text-align: center;font-size: large;">${case.casename}</td>
                    <td style="text-align: center;font-size: large;">
                        <div class="btn-group" role="group" aria-label="...">
                            <button type="button" class="btn btn-default" style="background-color: peachpuff" onclick="window.location.href='${pagecontext.request.contextpath}/bookcase/editbookcase'">
                                <span class="glyphicon glyphicon-floppy-save" style="color: #18d4cb;" aria-hidden="true" ><font style="font-size: large">&nbsp;修改</font></span>
                            </button>
                            <button type="button" class="btn btn-default" style="background-color: peachpuff" onclick="window.location.href='${pagecontext.request.contextpath}/bookcase/romovebookcase?id=${case.id}'">
                                <span class="glyphicon glyphicon-floppy-remove" style="color:red;" aria-hidden="true" ><font style="font-size: large">&nbsp;删除</font></span>
                            </button>
                        </div>
                    </td>
                </tr>
                </#list>
            </table>
            <nav aria-label="...">
                <ul class="pager">
                    <li>一共&nbsp;<span>${pagebean.totalNum}</span>&nbsp;条数据&nbsp;&nbsp;
                        <span>${pagebean.page}</span>/<span>${pagebean.totalPage}</span>业</li>
                    <#if pagebean.totalPage == pagebean.page &&pagebean.page==1>
                    <li><a href="javascript:void(0)">上一页</a></li>
                    <li><a href="javascript:void(0)">下一页</a></li>
                    </#if>

                    <#if pagebean.totalPage gt pagebean.page && pagebean.page != 1>
                        <li><a href="${pagecontext.request.contextpath}/bookcase/getbookecaselist?page=${pagebean.page-1}">上一页</a></li>
                        <li><a href="${pagecontext.request.contextpath}/bookcase/getbookecaselist?page=${pagebean.page+1}">下一页</a></li>
                    </#if>
                    <#if pagebean.totalPage gt pagebean.page && pagebean.page == 1>
                        <li><a href="javascript:void(0)">上一页</a></li>
                        <li><a href="${pagecontext.request.contextpath}/bookcase/getbookecaselist?page=${pagebean.page+1}">下一页</a></li>
                    </#if>

                    <#if pagebean.totalPage == pagebean.page && pagebean.totalPage gt 1>
                        <li><a href="${pagecontext.request.contextpath}/bookcase/getbookecaselist?page=${pagebean.page-1}">上一页</a></li>
                        <li><a href="javascript:void(0)">下一页</a></li>
                    </#if>
                </ul>
            </nav>

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