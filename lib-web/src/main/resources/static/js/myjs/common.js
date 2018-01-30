function showautos(){

    var i=$("#autos").text();
    i=i-1;
    if(i<=0){
        window.location.href="/library/getEditInfo";
        return;
    }
        $("#autos").text(i);



};
$(function () {

    setInterval(showautos,1000)

});
