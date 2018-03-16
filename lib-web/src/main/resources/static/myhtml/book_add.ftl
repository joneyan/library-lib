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

        <label for="bookname">图书名字：</label>
        <div class="form-group">

            <input type="text" class="form-control" id="bookname" name="bookname" value="${book.bookname}">
        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="author">作者：</label>
        <div class="form-group">
            <input type="text" class="form-control" id="author" name="author" value="${book.author}">
        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="barcode">图书编码：</label>
        <div class="form-group">
            <input type="text" class="form-control" id="isbn" name="isbn" value="${book.isbn}">
        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="barcode">条形码：</label>
        <div class="form-group">
            <input type="text" class="form-control" id="barcode" name="barcode" value="${book.barcode}">
        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="price">价格：</label>
        <div class="form-group">
            <input type="text" class="form-control" id="price" name="price" value="${book.barcode}">
        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="page">页数：</label>
        <div class="form-group">
            <input type="text" class="form-control" id="pagepage" name="page" value="${book.page}">
        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="totalnum">数量：</label>
        <div class="form-group">
            <input type="text" class="form-control" id="totalnum" name="totalnum" value="${book.totalnum}">
        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="pressid">出版社：</label>
        <div class="form-group">
            <#assign thevalue=book.pressid/>
            <select class="form-control" id="pressid" name="pressid">

                <option value="-1" <#if (((thevalue)!'') == '-1')>selected="selected"</#if>>--请选择--</option>
                <#list presses as press>
                    <option value="${press.id}" <#if (((thevalue)!'') == '${press.id}')>selected="selected"</#if>>${press.pubname}</option>
                </#list>
            </select>

        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="typeid">书籍类别：</label>
        <div class="form-group">
            <#assign thevalue=book.typeid/>
            <select class="form-control" id="typeid" name="typeid">

                <option value="-1" <#if (((thevalue)!'') == '-1')>selected="selected"</#if>>--请选择--</option>
                <#list catelogs as catelog>
                    <option value="${catelog.id}" <#if (((thevalue)!'') == '${catelog.id}')>selected="selected"</#if>>${catelog.typename}</option>
                </#list>
            </select>

        </div><br/>
        &nbsp;&nbsp;&nbsp;<label for="bookcaseid">书架：</label>
        <div class="form-group">

            <#assign thevalue=book.bookcaseid/>
            <select class="form-control" id="bookcaseid" name="bookcaseid">

                <option  value="-1" <#if (((thevalue)!'') == '-1')>selected="selected"</#if>>--请选择--</option>
                <#list bookcases as type>
                    <option   value="${type.id}" <#if (((thevalue)!'') == '${type.id}')>selected="selected"</#if>>${type.casename}</option>
                </#list>
            </select>
        </div><br/>
       &nbsp;&nbsp;&nbsp;<label>状态：</label>
        <#assign thevalue2=book.status/>
        <div class="form-group">
            <select class="form-control" id="status" name="status">

                <option  value="-1" <#if (((thevalue2)!'') == '-1')>selected="selected"</#if>>--请选择--</option>
                <option   value="1" <#if (((thevalue2)!'') == '1')>selected="selected"</#if>>上架</option>
                <option   value="2" <#if (((thevalue2)!'') == '2')>selected="selected"</#if>>未上架</option>
            </select>
        </div><br/>
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
            submitProp()
    }
    /**
     * 提交表单
     */
    function submitProp(){
        $('#myform').serialize();
        url='${pagecontext.request.contextpath}/book/addbook';
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
            top.location.href='${pagecontext.request.contextpath}/user/getReaderList';
        }, "text");
    }

</script>