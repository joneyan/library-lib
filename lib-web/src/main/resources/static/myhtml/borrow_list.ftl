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
    <link href="${pagecontext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pagecontext.request.contextPath}/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${pagecontext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="${pagecontext.request.contextPath}/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="${pagecontext.request.contextPath}/css/owl.carousel.css" type="text/css">
    <!-- Custom styles for this template -->
    <link href="${pagecontext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pagecontext.request.contextPath}/css/style-responsive.css" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="${pagecontext.request.contextPath}/js/html5shiv.js"></script>
    <script src="${pagecontext.request.contextPath}/js/respond.min.js"></script>
    <![endif]-->
    <script src="${pagecontext.request.contextPath}/js/jquery.js"></script>
    <script src="${pagecontext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script src="${pagecontext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">table{border:1px solid; border-top:1px solid;text-align:center;border-collapse:collapse;}
    th{border:1px solid ;border-left:1px solid ;border-top: 1px solid;  border-right: 1px solid;}
    td{border:1px solid ;border-left:1px solid ;border-top: 1px solid;  border-right: 1px solid;}</style>
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
                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon-book"></i>
                        <span>系统设置</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li class="" ><a href="${pagecontext.request.getcontextpath}/library_mana">图书馆设置</a></li>
                        <li class=""><a  href="${pagecontext.request.getcontextpath}/bookcase/getbookecaselist">书架管理</a></li>
                        <li class=""><a  href="${pagecontext.request.getcontextpath}/press/getbookepresslist">出版社管理</a></li>
                    <#if managerlog.status==1>
                        <li class=""><a href="${pagecontext.request.getcontextpath}/manager/getbookemanagerlist">管理员管理</a></li>
                    </#if>
                        <li class=""><a  href="${pagecontext.request.getcontextpath}/user/getbookbanneruserlist?isBanner=1">封禁管理</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon-cogs"></i>
                        <span>读者管理</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li class=""><a  href="${pagecontext.request.getcontextpath}/user/getReaderList">所有读者</a></li>
                        <li class=""><a class="" href="${pagecontext.request.getcontextpath}/user/toaddpage">新增读者</a></li>
                        <li class=""><a  href="${pagecontext.request.getcontextpath}/usertype/getusertypelist">读者类型管理</a></li>
                    </ul>
                </li>
                <li class="sub-menu ">
                    <a href="javascript:;" class="">
                        <i class="icon-tasks"></i>
                        <span>图书管理</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li ><a  href="${pagecontext.request.getcontextpath}/book/getBookList">所有图书</a></li>
                        <li><a class="" href="javascript:openaddpage();">新增图书</a></li>
                        <li><a class="" href="${pagecontext.request.getcontextpath}/booktype/getBookTypeList">图书类型管理</a></li>
                    </ul>
                </li>
                <li class="sub-menu active">
                    <a href="javascript:;" class="">
                        <i class="icon-th"></i>
                        <span>图书借还</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li class="active"><a class="" href="${pagecontext.request.contextpath}/borrow/toborrow">图书借阅</a></li>
                        <li><a class="" href="${pagecontext.request.getcontextpath}/borrow/tohaveborrows">图书续借</a></li>
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
                        <li><a class="" href="${pagecontext.request.getcontextpath}/book/getBookList">图书档案查询</a></li>
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
                <li role="presentation"  ><a href="${pagecontext.request.getcontextpath}/borrow/toborrow">图书列表</a></li>
                <li role="presentation" class="active"><a href="${pagecontext.request.getcontextpath}/borrow/tohaveborrows">已借图书</a></li>
            </ul>
            <form class="form-inline" action="${pagecontext.request.getcontextpath}/borrow/tohaveborrows">

                <label for="bookname">借书人名字：</label>
                <div class="form-group">

                    <input type="text" class="form-control" id="name" name="name" value="${name}">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <hr/>
            <table class="table table-striped" style="text-align: center; table-layout: fixed;border-radius: 5px;" cellspacing="0" border="1">
                <caption style="color: #18d4cb;font-size: 30px;">图书列表</caption>
                <tr>
                    <th style="text-align: center;">编号</th>
                    <th style="text-align: center;">书籍名称</th>
                    <th style="text-align: center;">借书日期</th>
                    <th style="text-align: center;">规定归还日期</th>
                    <th style="text-align: center;">归还日期</th>
                    <th style="text-align: center;">借书人</th>
                    <th style="text-align: center;">操作管理员</th>
                    <th style="text-align: center;">状态</th>
                    <th style="text-align: center;">操作</th>
                </tr>
            <#list pagebean.pageElements as case>
                <input type="hidden" id="typeid" name="typeid" value="${case.id}">
                <tr>
                    <td style="text-align: center;font-size: large;" id="">${case.id}</td>
                    <td style="text-align: center;font-size: large;">${case.bookname}</td>
                    <td style="text-align: center;font-size: large;">${case.borrowTime?string("yyyy-MM-dd")}</td>
                    <td style="text-align: center;font-size: large;">${case.stipulateTime?string("yyyy-MM-dd")}</td>
                    <#if case.backTime !=null>
                        <td style="text-align: center;font-size: large;">${case.backTime?string("yyyy-MM-dd")}</td>
                    </#if>
                    <#if case.backTime ==null>
                        <td style="text-align: center;font-size: large;">未归还</td>
                    </#if>

                    <td style="text-align: center;font-size: large;">${case.readerName}</td>
                    <td style="width: 245px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;text-align: center;font-size: large;">${case.manaName}</td>
                    <#if case.status=='1'>
                        <td style="text-align: center;font-size: large;">已归还</td>
                    </#if>
                    <#if case.status=='2'>
                        <td style="text-align: center;font-size: large;">未归还</td>
                    </#if>
                    <td style="text-align: center;font-size: large;">
                        <div class="btn-group" role="group" aria-label="...">
                            <button class="keepborrowbook" type="button" class="btn btn-default" style="background-color: peachpuff"  typeid="${case.id}" <#if case.status == 1> disabled="disabled"</#if>>
                                <span class="glyphicon glyphicon-floppy-save" style="color: #18d4cb;" aria-hidden="true" ><font style="font-size: large">&nbsp;续借</font></span>
                            </button>
                            <button class="returnbook" type="button" class="btn btn-default" style="background-color: peachpuff"  typeid="${case.id}" <#if case.status == 1> disabled="disabled"</#if>>
                                <span class="glyphicon glyphicon-floppy-save" style="color: #18d4cb;" aria-hidden="true" ><font style="font-size: large">&nbsp;归还</font></span>
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
                    <li><a href="${pagecontext.request.contextpath}/user/getbookbanneruserlist?page=${pagebean.page-1}">上一页</a></li>
                    <li><a href="${pagecontext.request.contextpath}/user/getbookbanneruserlist?page=${pagebean.page+1}">下一页</a></li>
                </#if>
                <#if pagebean.totalPage gt pagebean.page && pagebean.page == 1>
                    <li><a href="javascript:void(0)">上一页</a></li>
                    <li><a href="${pagecontext.request.contextpath}/bookcase/getbookbanneruserlist?page=${pagebean.page+1}">下一页</a></li>
                </#if>

                <#if pagebean.totalPage == pagebean.page && pagebean.totalPage gt 1>
                    <li><a href="${pagecontext.request.contextpath}/press/getbookbanneruserlist?page=${pagebean.page-1}">上一页</a></li>
                    <li><a href="javascript:void(0)">下一页</a></li>
                </#if>
                </ul>
            </nav>

        </section>      </section>
    <!--main content end-->
</section>
<!-- js placed at the end of the document so the pages load faster -->
<script src="${pagecontext.request.contextPath}/js/jquery.scrollTo.min.js"></script>
<script src="${pagecontext.request.contextPath}/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${pagecontext.request.contextPath}/js/jquery.sparkline.js" type="text/javascript"></script>
<script src="${pagecontext.request.contextPath}/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
<script src="${pagecontext.request.contextPath}/js/owl.carousel.js" ></script>
<script src="${pagecontext.request.contextPath}/js/jquery.customSelect.min.js" ></script>
<!--common script for all pages-->
<script src="${pagecontext.request.contextPath}/js/common-scripts.js"></script>
<!--script for this page-->
<script src="${pagecontext.request.contextPath}/js/sparkline-chart.js"></script>
<script src="${pagecontext.request.contextPath}/js/easy-pie-chart.js"></script>
<script src="${pagecontext.request.contextPath}/js/myjs/selectjs.js"></script>
<script src="${pagecontext.request.contextPath}/js/myjs/date.js"></script>
<script src="${pagecontext.request.contextPath}/js/layer/layer.js"></script>
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
    //打开一个借书信息填充页面
    $(".borrowbook").click(function(){
        var readertypeid=$(this).attr("typeid");
        var url='${pagecontext.request.contextpath}/borrow/toborrowpage?id='+readertypeid;
        layer.open({
            type: 2 //Page层类型
            ,area: ['800px', '500px']
            ,title: '修改信息'
            ,shade: 0.6 //遮罩透明度
            ,maxmin: true //允许全屏最小化
            ,anim: 1 //0-6的动画形式，-1不开启
            ,content:url
        });
    })

    //打开一个新增页面弹窗
    function openaddpage(){
        var url='${pagecontext.request.contextpath}/book/toaddpage';
        layer.open({
            type: 2 //Page层类型
            ,area: ['800px', '530px']
            ,title: '修改信息'
            ,shade: 0.6 //遮罩透明度
            ,scrollbar:true//是否允许出现滚动条
            ,maxmin: true //允许全屏最小化
            ,anim: 1 //0-6的动画形式，-1不开启
            ,content:url
        });
    }


</script>

</body>
</html>