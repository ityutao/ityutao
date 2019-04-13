/*
 * 项目组:
 *            = = =      =       =      =       =       =
 *          =            =       =       =     = =     =
 *         =             = = = = =        =   =   =   =
 *          =            =       =         = =     = =
 *            = = =      =       =          =       =
 */
$(function(){

    $("#ts-seach-menu li").click(function(){
        $(this).parent().find("li").removeClass("ts-active");
        $(this).addClass("ts-active");
        
    });


});