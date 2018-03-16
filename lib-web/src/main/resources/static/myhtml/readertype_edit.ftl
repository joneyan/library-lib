<#escape x as x?html>
<html>
<head>
<link rel="shortcut icon" href="img/favicon.html">
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
</head>
<body>
<div style="margin: 0 auto; width: 300px;border-radius: 10px;border: 1 solid red;background-color: burlywood">
    <hr/>
    <form id="myform" method="post" class="form-inline" action="${pagecontext.request.getcontextpath}/user/edituser" onsubmit="return formValidate()">
        &nbsp;&nbsp;&nbsp;<label for="readername">类型名称：</label>
        <div class="form-group">

            <input type="text" style="width: 180px;" class="form-control" id="rolename" name="rolename" value="${readertype.rolename}">
        </div>
        <br/>
        &nbsp;&nbsp;&nbsp;<label for="barcode">可借数目：</label>
        <div class="form-group">
            <input type="text" style="width: 180px;" class="form-control" id="brownum" name="brownum" value="${readertype.brownum}">
        </div>
    </form>
</div>
<div class="btn-line" style="text-align: center">
    <a href="javascript:formValidate()" class="btn btn-primary btn-o">
        <span>确 定</span>
    </a>
    <a href="javascript:closeSetting();" class="btn btn-default btn-o">
        <i class="fa fa-close"></i>
        <span>取 消</span>
    </a>
</div>
</body>
</html>
</#escape>
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
    /**
     * 关闭layer页面
     */
    function closeSetting(){
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }

    /**
     * 表单校验
     */
    function formValidate(){
        var rolename=$('#rolename').val();
        var brownum=$('#brownum').val();
        if(rolename!=null && brownum !=null){
            submitProp()
        }else{
            alert("error");
        }
    }
    /**
     * 提交表单
     */
    function submitProp(){
        $('#myform').serialize();
        url='${pagecontext.request.contextpath}/usertype/updateusertype';
        $.get(url, $('#myform').serialize(), function(data) {
            if ("1" == data) {
                alert('操作成功');
            } else if ("0" == data){
                alert('操作失败');
            } else if("2"==data){
                alert("传入数据不能为空")
            } else {
                alert("网关未开启");
            }
            closeSetting();
            top.location.href='${pagecontext.request.contextpath}/usertype/getusertypelist';
        }, "text");
    }

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