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
                <li class="sub-menu active">
                    <a href="javascript:;" class="">
                        <i class="icon-cogs"></i>
                        <span>读者管理</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li class="active"><a  href="${pagecontext.request.getcontextpath}/user/getReaderList">所有读者</a></li>
                        <li class=""><a class="" href="${pagecontext.request.getcontextpath}/user/toaddpage">新增读者</a></li>
                        <li class=""><a class="" href="${pagecontext.request.getcontextpath}/usertype/getusertypelist">读者类型管理</a></li>
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
                <li role="presentation" class="active" ><a href="${pagecontext.request.getcontextpath}/user/getReaderList">读者列表</a></li>
                <li role="presentation"><a href="${pagecontext.request.contextpath}/user/toaddpage">新增读者</a></li>
            </ul>
            <form class="form-inline" action="${pagecontext.request.getcontextpath}/user/getReaderList">

                <label for="readername">读者名字：</label>
                <div class="form-group">

                    <input type="text" class="form-control" id="readername" name="name" value="${reader.name}">
                </div>
                &nbsp;&nbsp;&nbsp;<label for="barcode">读者条形码：</label>
                <div class="form-group">
                    <input type="text" class="form-control" id="barcode" name="barcode" value="${reader.barcode}">
                </div>
                &nbsp;&nbsp;&nbsp;<label for="papernum">读者身份证：</label>
                <div class="form-group">
                    <input type="text" class="form-control" id="papernum" name="papernum" value="${reader.papernum}">
                </div>
                &nbsp;&nbsp;&nbsp;<label for="status">最近操作管理：</label>
                <div class="form-group">
                <#assign thevalue=reader.operator/>
                    <select class="form-control" id="operator" name="operator">

                        <option value="-1" <#if (((thevalue)!'') == '-1')>selected="selected"</#if>>--请选择--</option>
                    <#list operators as manager>
                        <option value="${manager.id}" <#if (((thevalue)!'') == '${manager.id}')>selected="selected"</#if>>${manager.username}</option>
                    </#list>
                    </select>

                </div>
                &nbsp;&nbsp;&nbsp;<label for="status">读者类型：</label>
                <div class="form-group">

                <#assign thevalue=reader.typeid/>
                    <select class="form-control" id="typeid" name="typeid">

                        <option  value="-1" <#if (((thevalue)!'') == '-1')>selected="selected"</#if>>--请选择--</option>
                    <#list types as type>
                        <option   value="${type.id}" <#if (((thevalue)!'') == '${type.id}')>selected="selected"</#if>>${type.rolename}</option>
                    </#list>
                    </select>
                </div>
                &nbsp;&nbsp;&nbsp;<label for="readername">读者职业：</label>
                <div class="form-group">

                    <input type="text" class="form-control" id="vocation" name="vocation" value="${reader.vocation}">
                </div>
                &nbsp;&nbsp;&nbsp;<label>注册时间:</label>
                <div class="form-group">
                    <input readonly="readonly" name="startTime" id="startTime" class="form-control" type="text" value="${startTime}" onclick="SelectDate(event,this,'yyyy-MM-dd');return false;" />
                </div>
                <a href="javascript:var n = document.getElementById('startTime');SelectDate(event,n,'yyyy-MM-dd');" title="" ><span class="glyphicon glyphicon-calendar"></span></a>
                &nbsp;&nbsp;&nbsp;<label>到:</label>
                <div class="form-group">
                    <input readonly="readonly" name="endTime" id="endTime" class="form-control" type="text" value="${endTime}" onclick="SelectDate(event,this,'yyyy-MM-dd');return false;" />
                </div>
                <a href="javascript:var n = document.getElementById('endTime');SelectDate(event,n,'yyyy-MM-dd');" title="" ><span class="glyphicon glyphicon-calendar"></span></a>
                &nbsp;&nbsp;&nbsp;<label>性别：</label>
            <#assign thevalue2=reader.sex/>
                <div class="form-group">
                    <select class="form-control" id="sex" name="sex">

                        <option  value="-1" <#if (((thevalue2)!'') == '-1')>selected="selected"</#if>>--请选择--</option>
                        <option   value="1" <#if (((thevalue2)!'') == '1')>selected="selected"</#if>>男</option>
                        <option   value="2" <#if (((thevalue2)!'') == '2')>selected="selected"</#if>>女</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <hr/>
            <table class="table table-striped" style="text-align: center; table-layout: fixed;border-radius: 5px;" cellspacing="0" border="1">
                <caption style="color: #18d4cb;font-size: 30px;">读者列表</caption>
                <tr>
                    <th style="text-align: center;">编号</th>
                    <th style="text-align: center;">名字</th>
                    <th style="text-align: center;">封禁日期</th>
                    <th style="text-align: center;">读者条形码</th>
                    <th style="text-align: center;">创建日期</th>
                    <th style="text-align: center;">证件号码</th>
                    <th style="text-align: center;">联系电话</th>
                    <th style="text-align: center;">性别</th>
                    <th style="text-align: center;">读者类型</th>
                    <th style="text-align: center;">读者职业</th>
                    <th style="text-align: center;">最近操作</th>
                    <th style="text-align: center;">操作</th>
                </tr>
            <#list pagebean.pageElements as case>
                <input type="hidden" id="readerid" name="readerid" value="${case.id}">
                <tr>
                    <td style="text-align: center;font-size: large;">${case.id}</td>
                    <td style="text-align: center;font-size: large;">${case.name}</td>
                    <td style="text-align: center;font-size: large;">${case.bannertime}</td>
                    <td style="text-align: center;font-size: large;">${case.barcode}</td>
                    <td style="text-align: center;font-size: large;">${case.createdate?string("yyyy-MM-dd")}</td>
                    <td style="text-align: center;font-size: large;">${case.papernum}</td>
                    <td style="text-align: center;font-size: large;">${case.readertel}</td>
                    <#if case.sex=='1'>
                        <td style="text-align: center;font-size: large;">男</td>
                    </#if>
                    <#if case.sex=='2'>
                        <td style="text-align: center;font-size: large;">女</td>
                    </#if>

                    <td style="text-align: center;font-size: large;">${case.readerType}</td>
                    <td style="text-align: center;font-size: large;">${case.vocation}</td>
                    <td style="text-align: center;font-size: large;">${case.domanager}</td>
                    <td style="text-align: center;font-size: large;">
                        <div class="btn-group" role="group" aria-label="...">
                            <button type="button" class="btn btn-default" style="background-color: peachpuff" onclick="openEditPage()">
                                <span class="glyphicon glyphicon-floppy-save" style="color: #18d4cb;" aria-hidden="true" ><font style="font-size: large">&nbsp;修改</font></span>
                            </button>
                            <button type="button" class="btn btn-default" style="background-color: peachpuff" onclick="window.location.href='${pagecontext.request.contextpath}/user/removereader?id=${case.id}'">
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
    //打开一个修改页面弹窗
    function openEditPage(){
        var readerid=$("#readerid").val();
        var url='${pagecontext.request.contextpath}/user/geteditreader?id='+readerid;
        layer.open({
            type: 2 //Page层类型
            ,area: ['800px', '500px']
            ,title: '修改信息'
            ,shade: 0.6 //遮罩透明度
            ,maxmin: true //允许全屏最小化
            ,anim: 1 //0-6的动画形式，-1不开启
            ,content:url
        });
    }

</script>

</body>
</html>