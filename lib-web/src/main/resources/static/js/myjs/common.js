function showautos(){

    var i=$("#autos").text();
    var url=$('#tourl').val();
    i=i-1;
    if(i<=0){
        window.location.href=""+url+"";
        return;
    }
        $("#autos").text(i);



};
$(function () {

    setInterval(showautos,1000)

});
