/*
 * 项目组:
 *      =       =       =      =
 *       =     = =     =       =
 *        =   =   =   =        =
 *         = =     = =         =
 *          =       =          = = = = 
 */
$(function(){
    changeStep();
    bindStepThreeButton();


    // 事件应为动态绑定
    bindStepOneButton();
    bindStepTwoButton();
    // 事件应为动态绑定
    
});

// 订单提交步骤
function changeStep(step){
    $("#executionSteps li").removeClass("active");
    $("#stepOne").css("display","none");
    $("#stepTwo").css("display","none");
    $("#stepThree").css("display","none");
    if(!step){
        $("#stepOne").css("display","block");
        $("#executionSteps li[name=stepOne]").addClass("active");
    }
    if(step){
        $("#"+step).css("display","block");
        $("#executionSteps li[name="+step+"]").addClass("active");

    }

}

function bindStepOneButton(){
    $("#stepOne .acount").on("click",function(){
        changeStep("stepTwo");
    });
}
function bindStepTwoButton(){
    $("#stepTwo .acount").on("click",function(){
        changeStep("stepThree");
    });
}
function bindStepThreeButton(){
    // 打开二维码弹窗
    $("#stepThree .acount").on("click",function(){
        $("#scavengingPayment").modal('open')
    });
}   