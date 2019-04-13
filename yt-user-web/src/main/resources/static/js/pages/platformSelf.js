/*
 * 项目组:
 *            = = =      =       =      =       =       =
 *          =            =       =       =     = =     =
 *         =             = = = = =        =   =   =   =
 *          =            =       =         = =     = =
 *            = = =      =       =          =       =
 */
$(function(){

    $("#ps-seach-menu li").click(function(){
        $(this).parent().find("li").removeClass("cx-active");
        $(this).addClass("cx-active");
        
    });

    // 初始化动态排行榜事件
    // 可在 方法中进行初始化
    initSellingEvent();

});

function initSellingEvent(){
    // 排行榜总标题事件
    $("#platformSelfTypes dt").click(function(){
        $("#platformSelfTypes dt").removeClass("cur");
        $("#platformSelfTypes dd span").removeClass("cura");
        $(this).addClass("cur");
    });
    // 排行榜副标题事件
    $("#platformSelfTypes dd span").click(function(){
        $("#platformSelfTypes dt").removeClass("cur");
        $("#platformSelfTypes dd span").removeClass("cura");
        $(this).addClass("cura");
    });

    // 排行榜 展开缩小事件
    $("#platformSelfTypes dt span").click(function(event){
        event.stopPropagation();
        if($(this).html()=="-"){
            $(this).parents("dl").find("dd").css("display","none");
            $(this).html("+");
            return;
        }
        $(this).parents("dl").find("dd").css("display","block");
        $(this).html("-");
    });
}

