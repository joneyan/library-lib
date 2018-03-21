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
<div style="margin: 0 auto; width: 450px;border-radius: 10px;border: 1 solid red;background-color: burlywood">
    <hr/>
    <form id="myform" class="form-inline">

        <label for="bookname">读者名字：</label>
        <div class="form-group">

            <input type="text" class="form-control" id="name" name="name" value="">
        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="author">读者证件号：</label>
        <div class="form-group">
            <input type="text" class="form-control" id="papernum" name="papernum" value="">
        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="barcode">读者编码：</label>
        <div class="form-group">
            <input type="text" class="form-control" id="barcode" name="barcode" value="">
        </div><br/>
        <input type="hidden" class="form-control" id="bookid" name="bookid" value="${bookid}">
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
        debugger;
        var name =  $("#name").val();
        console.log(name);
        var papernum = $("#papernum").val();
        var barcode = $("#barcode").val();
        if(name != null && papernum != null && barcode != null && name !="" && papernum !="" && barcode != ""){
            submitProp();
        }else{
            layer.msg("表单不能有空值！");
        }

    }
    /**
     * 提交表单
     */
    function submitProp(){
        $('#myform').serialize();
        url='${pagecontext.request.contextpath}/borrow/borrowbook';
        $.get(url, $('#myform').serialize(), function(data) {
            var message = '${message}';
            console.log(message)
            if ("1" == data) {
                alert('操作成功'+message);
            } else if ("0" == data){
                alert('操作失败'+message);
            } else if("2"==data){
                alert("传入数据不能为空"+message)
            } else {
                alert("网关未开启"+message);
            }
            closeSetting();
            top.location.href='${pagecontext.request.contextpath}/borrow/toborrow';
        }, "text");
    }

</script>