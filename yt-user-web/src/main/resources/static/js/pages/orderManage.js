/*
 * 项目组:
 *            = = =      =       =      =       =       =
 *          =            =       =       =     = =     =
 *         =             = = = = =        =   =   =   =
 *          =            =       =         = =     = =
 *            = = =      =       =          =       =
 */

// 模拟 ajax 获取数据后的页面拼接

var allOrders = `
<div class="title">
    <span>所有订单</span>
</div>
<div class="am-panel am-panel-default">
    <div class="am-panel-bd order-list">
        <ul class="am-g total">
            <li  class="am-u-sm-3">图书信息</li>
            <li  class="am-u-sm-2">单价</li>
            <li  class="am-u-sm-1">数量</li>
            <li  class="am-u-sm-2">实付款</li>
            <li  class="am-u-sm-2">交易状态</li>
            <li  class="am-u-sm-2">交易操作</li>
        </ul>

        <!-- 一个订单 start -->
        <div class="order-item am-g">
            <div class="order-num">
                <span>订单时间：<i>2018-05-14</i></span>
                <span>订单编号：<i>57902538102899926</i></span>
                <span>订单总价：<i>￥88.88</i></span>
            </div>
            <div class="am-u-sm-8 item">

                <!-- 一个订单中得产品 -->
                <ul class="am-g list">
                    <li  class="am-u-sm-5">
                        <span class="img"><img src="./img/newbook/newbook01.jpg"></span>
                        <span>阿里阿德涅的子弹</span>
                    </li>
                    <li  class="am-u-sm-3">￥29.8</li>
                    <li  class="am-u-sm-2">1</li>
                    <li  class="am-u-sm-3">￥8.9</li>
                </ul>
                <!-- 一个订单中得产品 -->

                <ul class="am-g list">
                    <li  class="am-u-sm-5">
                        <span class="img"><img src="./img/newbook/newbook01.jpg"></span>
                        <span>阿里阿德涅的子弹</span>
                    </li>
                    <li  class="am-u-sm-3">￥29.8</li>
                    <li  class="am-u-sm-2">1</li>
                    <li  class="am-u-sm-3">￥8.9</li>
                </ul>
            </div>
            <div class="am-u-sm-4 item operation">
                <ul class="am-g list ">
                    <li  class="am-u-sm-6">
                        <span>交易成功</span>
                        <span>
                            <a href="./orderDetail.html" target="_blank">订单详情</a>
                        </span>
                        
                    </li>
                    <li  class="am-u-sm-6 setting"></li>
                </ul>
            </div>
        </div>
        <!-- 一个订单 end -->
        
        <!-- 一个订单 start -->
        <div class="order-item am-g">
            <div class="order-num">
                <span>订单时间：<i>2018-05-14</i></span>
                <span>订单编号：<i>57902538102899926</i></span>
                <span>订单总价：<i>￥88.88</i></span>
            </div>
            <div class="am-u-sm-8 item">
                
                <!-- 一个订单中得产品 -->
                <ul class="am-g list">
                    <li  class="am-u-sm-5">
                        <span class="img"><img src="./img/newbook/newbook01.jpg"></span>
                        <span>阿里阿德涅的子弹</span>
                    </li>
                    <li  class="am-u-sm-3">￥29.8</li>
                    <li  class="am-u-sm-2">1</li>
                    <li  class="am-u-sm-3">￥8.9</li>
                </ul>
                <!-- 一个订单中得产品 -->
            </div>
            <div class="am-u-sm-4 item operation">
                <ul class="am-g list ">
                    <li  class="am-u-sm-6">
                        <span>交易成功</span>
                        <span>
                            <a href="./orderDetail.html" target="_blank">订单详情</a>
                        </span>
                        
                    </li>
                    <li  class="am-u-sm-6 setting"></li>
                </ul>
            </div>
        </div>
        <!-- 一个订单 end -->
        
        <!-- 一个订单 start -->
        <div class="order-item am-g">
            <div class="order-num">
                <span>订单时间：<i>2018-05-14</i></span>
                <span>订单编号：<i>57902538102899926</i></span>
                <span>订单总价：<i>￥88.88</i></span>
            </div>
            <div class="am-u-sm-8 item">
                
                <!-- 一个订单中得产品 -->
                <ul class="am-g list">
                    <li  class="am-u-sm-5">
                        <span class="img"><img src="./img/newbook/newbook01.jpg"></span>
                        <span>阿里阿德涅的子弹</span>
                    </li>
                    <li  class="am-u-sm-3">￥29.8</li>
                    <li  class="am-u-sm-2">1</li>
                    <li  class="am-u-sm-3">￥8.9</li>
                </ul>
                <!-- 一个订单中得产品 -->

                <ul class="am-g list">
                    <li  class="am-u-sm-5">
                        <span class="img"><img src="./img/newbook/newbook01.jpg"></span>
                        <span>阿里阿德涅的子弹</span>
                    </li>
                    <li  class="am-u-sm-3">￥29.8</li>
                    <li  class="am-u-sm-2">1</li>
                    <li  class="am-u-sm-3">￥8.9</li>
                </ul>
                <ul class="am-g list">
                    <li  class="am-u-sm-5">
                        <span class="img"><img src="./img/newbook/newbook01.jpg"></span>
                        <span>阿里阿德涅的子弹</span>
                    </li>
                    <li  class="am-u-sm-3">￥29.8</li>
                    <li  class="am-u-sm-2">1</li>
                    <li  class="am-u-sm-3">￥8.9</li>
                </ul>

            </div>
            <div class="am-u-sm-4 item operation">
                <ul class="am-g list ">
                    <li  class="am-u-sm-6">
                        <span>交易成功</span>
                        <span>
                            <a href="./orderDetail.html" target="_blank">订单详情</a>
                        </span>
                    </li>
                    <li  class="am-u-sm-6 setting">
                        
                    </li>
                </ul>
            </div>
        </div>
        <!-- 一个订单 end -->
        <!-- 一个订单 start -->
        <div class="order-item am-g">
            <div class="order-num">
                <span>订单时间：<i>2018-05-14</i></span>
                <span>订单编号：<i>57902538102899926</i></span>
                <span>订单总价：<i>￥88.88</i></span>
            </div>
            <div class="am-u-sm-8 item">
                
                <!-- 一个订单中得产品 -->
                <ul class="am-g list">
                    <li  class="am-u-sm-5">
                        <span class="img"><img src="./img/newbook/newbook01.jpg"></span>
                        <span>阿里阿德涅的子弹</span>
                    </li>
                    <li  class="am-u-sm-3">￥29.8</li>
                    <li  class="am-u-sm-2">1</li>
                    <li  class="am-u-sm-3">￥8.9</li>
                </ul>
                <!-- 一个订单中得产品 -->

            </div>
            <div class="am-u-sm-4 item operation">
                <ul class="am-g list ">
                    <li  class="am-u-sm-6">
                        <span>待付款</span>
                    </li>
                    <li  class="am-u-sm-6 setting">
                        <a class="am-btn am-btn-default am-btn-xs" href="./shoppingCar.html" target="_blank">去付款</a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 一个订单 end -->
            <!-- 一个订单 start -->
            <div class="order-item am-g">
            <div class="order-num">
                <span>订单时间：<i>2018-05-14</i></span>
                <span>订单编号：<i>57902538102899926</i></span>
                <span>订单总价：<i>￥88.88</i></span>
            </div>
            <div class="am-u-sm-8 item">
                
                <!-- 一个订单中得产品 -->
                <ul class="am-g list">
                    <li  class="am-u-sm-5">
                        <span class="img"><img src="./img/newbook/newbook01.jpg"></span>
                        <span>阿里阿德涅的子弹</span>
                    </li>
                    <li  class="am-u-sm-3">￥29.8</li>
                    <li  class="am-u-sm-2">1</li>
                    <li  class="am-u-sm-3">￥8.9</li>
                </ul>
                <!-- 一个订单中得产品 -->

            </div>
            <div class="am-u-sm-4 item operation">
                <ul class="am-g list ">
                    <li  class="am-u-sm-6">
                        <span>待收货</span>
                        <span>
                            <a href="./orderDetail.html" target="_blank">订单详情</a>
                        </span>
                    </li>
                    <li  class="am-u-sm-6 setting">
                        <a class="am-btn am-btn-default am-btn-xs" href="#" target="_blank">确认收货</a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 一个订单 end -->
    </div>
</div>
`;

var pendingPayment = `
<div class="title">
    <span>待付款</span>
</div>
<div class="am-panel am-panel-default">
    <div class="am-panel-bd order-list">
        <ul class="am-g total">
            <li  class="am-u-sm-3">图书信息</li>
            <li  class="am-u-sm-2">单价</li>
            <li  class="am-u-sm-1">数量</li>
            <li  class="am-u-sm-2">实付款</li>
            <li  class="am-u-sm-2">交易状态</li>
            <li  class="am-u-sm-2">交易操作</li>
        </ul>

        <!-- 一个订单 start -->
        <div class="order-item am-g">
            <div class="order-num">
                <span>订单时间：<i>2018-05-14</i></span>
                <span>订单编号：<i>57902538102899926</i></span>
                <span>订单总价：<i>￥88.88</i></span>
            </div>
            <div class="am-u-sm-8 item">
                
                <!-- 一个订单中得产品 -->
                <ul class="am-g list">
                    <li  class="am-u-sm-5">
                        <span class="img"><img src="./img/newbook/newbook01.jpg"></span>
                        <span>阿里阿德涅的子弹</span>
                    </li>
                    <li  class="am-u-sm-3">￥29.8</li>
                    <li  class="am-u-sm-2">1</li>
                    <li  class="am-u-sm-3">￥8.9</li>
                </ul>
                <!-- 一个订单中得产品 -->

            </div>
            <div class="am-u-sm-4 item operation">
                <ul class="am-g list ">
                    <li  class="am-u-sm-6">
                        <span>待付款</span>
                    </li>
                    <li  class="am-u-sm-6 setting">
                        <a class="am-btn am-btn-default am-btn-xs" href="./shoppingCar.html" target="_blank">去付款</a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 一个订单 end -->
    </div>
</div>
`;
var goodsReceived = `
<div class="title">
    <span>待收货</span>
</div>
<div class="am-panel am-panel-default">
    <div class="am-panel-bd order-list">
        <ul class="am-g total">
            <li  class="am-u-sm-3">图书信息</li>
            <li  class="am-u-sm-2">单价</li>
            <li  class="am-u-sm-1">数量</li>
            <li  class="am-u-sm-2">实付款</li>
            <li  class="am-u-sm-2">交易状态</li>
            <li  class="am-u-sm-2">交易操作</li>
        </ul>
            <!-- 一个订单 start -->
            <div class="order-item am-g">
            <div class="order-num">
                <span>订单时间：<i>2018-05-14</i></span>
                <span>订单编号：<i>57902538102899926</i></span>
                <span>订单总价：<i>￥88.88</i></span>
            </div>
            <div class="am-u-sm-8 item">
                
                <!-- 一个订单中得产品 -->
                <ul class="am-g list">
                    <li  class="am-u-sm-5">
                        <span class="img"><img src="./img/newbook/newbook01.jpg"></span>
                        <span>阿里阿德涅的子弹</span>
                    </li>
                    <li  class="am-u-sm-3">￥29.8</li>
                    <li  class="am-u-sm-2">1</li>
                    <li  class="am-u-sm-3">￥8.9</li>
                </ul>
                <!-- 一个订单中得产品 -->

            </div>
            <div class="am-u-sm-4 item operation">
                <ul class="am-g list ">
                    <li  class="am-u-sm-6">
                        <span>待收货</span>
                        <span>
                            <a href="./orderDetail.html" target="_blank">订单详情</a>
                        </span>
                    </li>
                    <li  class="am-u-sm-6 setting">
                        <a class="am-btn am-btn-default am-btn-xs" href="#" target="_blank">确认收货</a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 一个订单 end -->
    </div>
</div>
`;


// 模拟 ajax 获取数据后的页面拼接


$(function(){    
    loadData();
    bindEvent();
});

function loadData(dataType){

     // 默认数据请求
    var htmlStr = allOrders;

    if(dataType){
        // 根据分类请求
        // eval(dataType) 仅为模拟 演示使用 ，实际开发 因为 ajax 返回数据后 渲染的 DOM 树
       htmlStr = eval(dataType)
    }
    
    $("#orderListShow").html(htmlStr);
}

function bindEvent(){
    $("#orderList .user-left-menu li").click(function(){
        var dataType = $(this).attr("data-target");
        loadData(dataType);
    });
}
