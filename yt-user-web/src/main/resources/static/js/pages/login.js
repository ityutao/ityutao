/*
 * 项目组:
 *      =       =       =      =
 *       =     = =     =       =
 *        =   =   =   =        =
 *         = =     = =         =
 *          =       =          = = = = 
 */
$(function(){
    createCode();
})

function createCode() {
    var datas = ['A','B','C','D','E','F','G'];
    var code = "";
    for(var i = 0;i < 4;i++){
        var index = Math.floor(Math.random()*datas.length);
        code += datas[index];
    }

    $(".code").html(code);
}

function change(){
    createCode();
}