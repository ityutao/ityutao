$(function(){
	$(".top-nav>div").click(function(){
		$(this).parent().find("div").removeClass("active");
		$(this).addClass("active");
		$(this).find(".mark").removeClass("other");
		$(this).parent().find(".mark").addClass("other");
	})

	scoreFun($("#settingStar"),{
		fen_d:32,//每一个a的宽度
		ScoreGrade:5//a的个数5
	});
	

})