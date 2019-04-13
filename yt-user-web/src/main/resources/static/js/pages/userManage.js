/*
 * 项目组:
 *            = = =      =       =      =       =       =
 *          =            =       =       =     = =     =
 *         =             = = = = =        =   =   =   =
 *          =            =       =         = =     = =
 *            = = =      =       =          =       =
 */
$(function(){
    // 初始化地市下拉列表功能
    $('#area').areaSelector();
    // console.log($("#infoMenu"))
    
    changePanel();
    bindEvent();
});

function changePanel(panelId){
    $(".content-show").css("display","none");
    if(panelId){
        $("#"+panelId).css("display","block");
        return;
    }
    $("#baseInfo").css("display","block");
}

function bindEvent(){
    $("#userInfo .user-left-menu li").click(function(){
        var targetStr = $(this).attr("data-target");
        changePanel(targetStr);
    });
}
