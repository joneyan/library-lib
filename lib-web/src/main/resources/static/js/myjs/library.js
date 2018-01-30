function saveInfo(){
    var libaname=$("#libarayname").val();
    var curator=$("#curator").val();
    var address=$("#address").val();
    var createdate=$("#createdate").val();
    var tel=$("#tel").val();
    var email=$("#email").val();
    if(libaname==""||curator==""||address==""||createdate==""||tel==""||email==""){
        $("#sp1").html("输入信息不可以为空！").css("color","red");
        return ;
    }
    $("#edit_lib_info").submit();
}