/*
 * 项目组:
 *            = = =      =       =      =       =       =
 *          =            =       =       =     = =     =
 *         =             = = = = =        =   =   =   =
 *          =            =       =         = =     = =
 *            = = =      =       =          =       =
 */
$(function(){
    $("#bl-seach-menu li").click(function(){
        $(this).parent().find("li").removeClass("bl-active");
        $(this).addClass("bl-active");

        
    });
    $("#toggleTypeBtn").click(function(){
        $("#toggleTypeList").toggleClass("hidden");
        $(this).toggleClass("text");
        $(this).find("span").toggleClass("am-icon-angle-down")
                            .toggleClass("am-icon-angle-up");  
    });

    $("#bookSort li").click(function(){
        // 效果事件 不要修改
        $("#bookSort li").removeClass("on");
        $(this).addClass("on");
        $("#bookSort li:not(.on) span").removeClass("up").removeClass("down");
        var $span = $(this).find("span");
        if($span.length==0){
            return;
        }
        var classStr = $span[0].className;
        if(classStr.indexOf("up")==-1&&classStr.indexOf("down")==-1){
            $span.addClass("up");
            return;
        }
        $span.toggleClass("up");
        $span.toggleClass("down");
    }).click(function(){
        // 数据事件 参数依赖于 页面中得 data-sort 属性
        var sort = $(this).find("i").attr("data-sort");
        if($(this).find("span").length!=0){
            var isAsc = $(this).find("span")[0].className.indexOf("up") != -1;
            var isDesc = $(this).find("span")[0].className.indexOf("down") != -1;
        }
        console.log("查询方式："+sort+"，升序："+isAsc+"，降序："+isDesc);
        // 根据条件获取数据 并渲染页面
        // ……


    });


});