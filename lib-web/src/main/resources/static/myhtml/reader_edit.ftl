<#escape x as x?html>
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
    <div style="margin: 0 auto; width: 400px;border-radius: 10px;border: 1 solid red;background-color: burlywood">
        <h1 style="margin: 0 auto;width: 300px;color: #01a7b3">新增读者</h1>
        <hr/>
        <form method="post" class="form-inline" action="${pagecontext.request.getcontextpath}/user/edituser" onsubmit="return formValidate()">
            <input type="hidden" name="isBanner" value="1">
            &nbsp;&nbsp;&nbsp;<label for="readername">读者的名字：</label>
            <div class="form-group">

                <input type="text" class="form-control" id="readername" name="name" value="${reader.name}">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="barcode">读者条形码：</label>
            <div class="form-group">
                <input type="text" class="form-control" id="barcode" name="barcode" value="${reader.barcode}">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="papernum">读者身份证：</label>
            <div class="form-group">
                <input type="text" class="form-control" id="papernum" name="papernum" value="${reader.papernum}">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="papernum">读者的邮箱：</label>
            <div class="form-group">
                <input type="text" class="form-control" id="readermail" name="readermail" value="${reader.papernum}">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="papernum">读者的手机：</label>
            <div class="form-group">
                <input type="text" class="form-control" id="readertel" name="readertel" value="${reader.papernum}">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="status">读者的类型：</label>
            <div class="form-group">

                <#assign thevalue=typeid/>
                <select class="form-control" id="typeid" name="typeid">

                    <option  value="-1" <#if (((thevalue)!'') == '-1')>selected="selected"</#if>>--请选择--</option>
                    <#list types as type>
                        <option   value="${type.id}" <#if (((thevalue)!'') == '${type.id}')>selected="selected"</#if>>${type.rolename}</option>
                    </#list>
                </select>
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="readername">读者的职业：</label>
            <div class="form-group">

                <input type="text" class="form-control" id="vocation" name="vocation" value="${reader.vocation}">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label>读者的性别：</label>
            <div class="form-group">
                <select class="form-control" id="sex" name="sex">

                    <option  value="-1" <#if (((thevalue)!'') == '-1')>selected="selected"</#if>>--请选择--</option>
                    <option   value="1" <#if (((thevalue)!'') == '1')>selected="selected"</#if>>男</option>
                    <option   value="2" <#if (((thevalue)!'') == '2')>selected="selected"</#if>>女</option>
                </select>
            </div>
            <br/>
        </form>
    </div>
    <div class="btn-line" style="text-align: center">
        <a href="javascript:validate()" class="btn btn-primary btn-o">
            <span>确 定</span>
        </a>
        <a href="javascript:closeSetting();" class="btn btn-default btn-o">
            <i class="fa fa-close"></i>
            <span>取 消</span>
        </a>
    </div>
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
</script>