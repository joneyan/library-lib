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
        <form id="myform" method="post" class="form-inline" action="${pagecontext.request.getcontextpath}/user/edituser" onsubmit="return formValidate()">
            &nbsp;&nbsp;&nbsp;<label for="readername">读者的名字：</label>
            <div class="form-group">

                <input type="text" class="form-control" id="readername" name="name" value="${reader.name}" readonly="readonly">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="barcode">读者条形码：</label>
            <div class="form-group">
                <input type="text" class="form-control" id="barcode" name="barcode" value="${reader.barcode}" readonly="readonly">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="papernum">读者身份证：</label>
            <div class="form-group">
                <input type="text" class="form-control" id="papernum" name="papernum" value="${reader.papernum}" readonly="readonly">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="papernum">读者的邮箱：</label>
            <div class="form-group">
                <input type="text" class="form-control" id="readermail" name="readermail" value="${reader.readermail}">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="papernum">读者的手机：</label>
            <div class="form-group">
                <input type="text" class="form-control" id="readertel" name="readertel" value="${reader.readertel}">
            </div>
            <br/>
            &nbsp;&nbsp;&nbsp;<label for="status">读者的类型：</label>
            <div class="form-group">

                <#assign thevalue=reader.typeid/>
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
            <#assign thevalue=reader.sex/>
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
        <a href="javascript:formValidate()" class="btn btn-primary btn-o">
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

    /**
     * 表单校验
     */
    //表单校验
    function formValidate(){
        var readername=$('#readername').val();
        var barcode=$('#barcode').val();
        var papernum=$('#papernum').val();
        var typeid=$('#typeid').val();
        var vocation=$('#vocation').val();
        var sex=$('#sex').val();
        if(readername!=null && barcode !=null && papernum !=null && typeid !=null && vocation !=null && sex !=null){
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
        url='${pagecontext.request.contextpath}/user/updateuser';
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