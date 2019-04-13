/*
 * 项目组:
 *            = = =      =       =      =       =       =
 *          =            =       =       =     = =     =
 *         =             = = = = =        =   =   =   =
 *          =            =       =         = =     = =
 *            = = =      =       =          =       =
 */

$(function(){
    // 自营平台模拟数据 ->
    var types = {
        type1:`<li>
                    <img src="./img/recommend/s4018703.jpg" />
                    <p>面对危机中的世界/克里希那穆提欧洲演讲集</p>
                    <p class="index-book-sal">
                        <span>￥14.6</span>
                        <del>￥48.6</del>												
                    </p>
                </li>`,
        type2:`<li>
                    <img src="./img/recommend/s6383723.jpg" />
                    <p>罗马女人/意大利文学大师莫拉维亚作品</p>
                    <p class="index-book-sal">
                        <span>￥14.6</span>
                        <del>￥48.6</del>												
                    </p>
                </li>`,
        type3:`<li>
                    <img  src="./img/recommend/s6473996.jpg" />
                    <p>教皇往事-波吉亚家族/著名历史学家希伯特传记作品</p>
                    <p class="index-book-sal">
                        <span>￥14.6</span>
                        <del>￥48.6</del>												
                    </p>
                </li>`,
        type4:`<li>
                    <img src="./img/recommend/s7278751.jpg" />
                    <p>美了千年 却被淡忘-诗经名物图解</p>
                    <p class="index-book-sal">
                        <span>￥14.6</span>
                        <del>￥48.6</del>												
                    </p>
                </li>`
    }
    // <- 自营平台模拟数据
    
    // 平台自营 event
    // 该 事件 只提供 思路 和 模拟数据操作，实际项目开发需要自行修改
    $("#fromMenu > li").hover(function(){
        $("#fromMenu > li").removeClass("index-from-active");
        $(this).addClass("index-from-active");
        var type = $(this).attr("data-type");

        var content = "";
        for (let i = 0; i < 10; i++) {
            content += types[type];
        }

        $("#fromContent").html(content);

    });

    // 出版社模拟数据 ->
    var pressList = [
        {
            name:"中华数据",
            info:"中华书局于1912年元旦由陆费逵先生在上海创办，是中国近现代最悠久的出版社之一。百馀年来，中华书局恪守传承文明职责，专注于优秀传统文化出版，在海内外享有盛誉。特别是从1958年至1978年，历经二十年时间，组织整理、出版的“二十四史”及《清史稿》点校本，被公认为新中国最伟大的古籍整理工程。相继编辑出版了《全上古三代秦汉三国六朝文》《先秦汉魏晋南北朝诗》《全唐文》《全唐诗》《全宋词》《古本小说丛刊》《甲骨文合集》《资治通鉴》《文苑英华》《太平御览》等一大批古代文史哲经典文献，在学术界、读书界、教育界有着广泛的影响。",
            list:[
                {
                    img:"./img/recommend/s4018703.jpg",
                    bookName:"面对危机中的世界/克里希那穆提欧洲演讲集",
                    newSal:14.6,
                    oldSal:48.6
                }
            ]
        },
        {
            name:"作家出版社",
            info:"作家出版社是中国作家协会所属国家级大型文学出版社，自1953年建社以来，出版了大量的优秀文学图书，其中有部分作品先后被介绍到海外，在国内外产生了广泛影响。作家出版社以中国文学的主流作家为出版依托，出版了大量当代名家名作，巴金、王蒙、季羡林、铁凝、贾平凹、二月河、王安忆、莫言、张平、张抗抗、周梅森、余华、张承志、从维熙、金庸、董桥、周汝昌、张中行、汪曾祺、黄苗子、黄永玉、冯骥才、周国平、韩少功、毕飞宇、池莉、毕淑敏、蒋子龙、张贤亮、张炜、李国文、曹文轩、魏明伦、韩寒、张悦然等都有代表作品在作家出版社出版。",
            list:[
                {
                    img:"./img/recommend/s7278751.jpg",
                    bookName:"美了千年 却被淡忘-诗经名物图解",
                    newSal:14.6,
                    oldSal:48.6
                }
            ]
        },
    ];
    // <- 出版社模拟数据

    // 出版社 描述 切换事件
    $("#pressList > li").hover(function(){
        var index = $(this).attr("data-press");
        $("#pressList > li").removeClass("cur");
        $(this).addClass("cur");

        var books = "";
        for (let i = 0; i < 5; i++) {
            books += `
                    <li>
                        <a href="#">
                            <img src="${ pressList[index].list[0].img }" />
                            <p>${ pressList[index].list[0].bookName }</p>
                            <p class="index-book-sal">
                                <span>￥${ pressList[index].list[0].newSal }</span>
                                <del>￥${ pressList[index].list[0].oldSal }</del>												
                            </p>
                        </a>
                    </li>
            `; 
        }

        var detail = `
            <div class="pubText">
                <h3>
                    <a href="#">${ pressList[index].name}</a>
                </h3>
                <div class="publishInfo">
                    <p>${ pressList[index].info}</p>
                </div>
                <ul class="am-avg-sm-5 am-thumbnails index-hot-list">
                    ${ books }
                </ul>
            </div>

        `;

        $("#pressDetail").html(detail);
    });


// -------------------------------------------------------------------------------------  
    // 出版社 上下按钮事件绑定
    // 出版生上下翻页效果 请勿修改，除非你知道在干嘛 （如存在效果问题，请咨询项目老师）->
    $("#downArrow").on("click",function(){
        var top = parseFloat($("#pressList").css("top"));
        var maxTop = parseFloat($("#pressList").css("height"));
        if(maxTop+(top-390)>=0){
            $("#pressList").animate({
                "top":top-390
            },500)
        }
    });
    $("#upArrow").on("click",function(){
        var top = parseFloat($("#pressList").css("top"));
        if(top<0){
            $("#pressList").animate({
                "top":top+390
            },500);
            return;
        }
        $("#pressList").animate({
            "top":0
        },500);
    // <- 出版生上下翻页效果 请勿修改，除非你知道在干嘛 （如存在效果问题，请咨询项目老师）
// -------------------------------------------------------------------------------------

        
    });
});