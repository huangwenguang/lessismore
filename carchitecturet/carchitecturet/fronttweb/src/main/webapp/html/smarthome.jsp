<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transition al.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <title>app系统开发_手机APP制作-广州少即多科技有限公司-官网</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Language" content="zh-CN" />
    <meta name="Author" content="lx" />
    <meta name="Copyright" content="少即多科技有限公司" />
    <meta name="keywords" content="少即多科技有限公司" />
    <meta name="description" content="APP开发，小程序开发，游戏开发，软件开发，网站开发，公众号开发" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <link rel="Shortcut Icon" href="../images/logo.ico" />
    <link rel="stylesheet" href="./../css/global.css" />
    <link rel="stylesheet" href="./../css/index.css" />
    <link rel="stylesheet" href="./../css/smarthome.css" />
    <script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>

<body>
    <!-- 导航 -->
    <div>
        <div class="header-title">专业团队开发，优质服务、开发快速，为您打造更好的产品！&nbsp;&nbsp;<span>全国免费咨询热线&nbsp;&nbsp;400-775-2560</span></div>
        <div class="header">
            <div class="container">
                <h1><a href="">少即多科技有限公司</a></h1>
                <ul class="nav">
                    <li><a href="./../">首页<span></span></a></li>
                    <li><a href="./appdev.jsp">APP开发<span></span></a></li>
                    <li><a href="./store.jsp">商城开发<span></span></a></li>
                    <li><a href="./game.jsp">游戏开发<span></span></a></li>
                    <li><a href="./applet.jsp">小程序开发<span></span></a></li>
                    <li><a href="./iot.jsp">物联网<span></span></a></li>
                    <li><a class="active" href="./smarthome.jsp">智能家居开发<span></span></a></li>
                    <li><a href="./contactus.jsp">联系我们<span></span></a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- 导航结束 -->
    <!-- 首页内容 -->
    <div>
        <div class="img">
        </div>
        <div class="smarthome-dev">
            <div class="title container">
                <h2>智能家居开发</h2>
                <span></span>
            </div>
            <div class="smarthome-introduce container clearfix">
                <div class="introduce-text">
                    <p>智能家居是以住宅为平台，利用综合布线技术、网络通信技术、 安全防范技术、自动控制技术、音视频技术将家居生活有关的设施集成，构建高效的住宅设施与家庭日程事务的管理系统，提升家居安全性、便利性、舒适性、艺术性，并实现环保节能的居住环境。</p>
                </div>
                <div class="introduce-img"></div>
            </div>
        </div>
        <div class="smarthome-solution">
            <div class="title container">
                <h2>智能家居解决方案</h2>
                <span></span>
            </div>
            <div class="solution-bg container">
            </div>
        </div>
    </div>
    <!-- 首页内容结束 -->
    <!-- 底部 -->
    <div class="footer">
        <div class="container">
            <!-- 底部导航 -->
            <ul class="fl footer-nav">
                <li class="active">
                    <a href="./../" onClick="scrollTo(0,0);
">首页</a>
                </li>
                <li>
                    <a href="./appdev.jsp" onClick="scrollTo(0,0);
">App开发</a>
                </li>
                <li>
                    <a href="./store.jsp" onClick="scrollTo(0,0);
">商城开发</a>
                </li>
                <li>
                    <a href="./game.jsp" onClick="scrollTo(0,0);
">游戏开发</a>
                </li>
                <li>
                    <a href="./applet.jsp" onClick="scrollTo(0,0);
">小程序开发</a>
                </li>
                <li>
                    <a href="./h5.jsp" onClick="scrollTo(0,0);
">H5建站</a>
                </li>
                <li>
                    <a href="./zhidxcom.jsp" onClick="scrollTo(0,0);
">公众号开发</a>
                </li>
                <li>
                    <a href="./iot.jsp" onClick="scrollTo(0,0);
">物联网</a>
                </li>
                <li>
                    <a href="./smarthome.jsp" onClick="scrollTo(0,0);
">智能家居开发</a>
                </li>
                <li>
                    <a href="./contactus.jsp" onClick="scrollTo(0,0);
">联系我们</a>
                </li>
            </ul>
            <!-- 底部信息 -->
            <div class="info fl">
                <h2>${info.name }</h2>
                <p><span>电话:</span><span>${info.telephone }</span></p>
                <p><span>手机:</span><span>${info.phone }</span></p>
                <p><span>Q Q :</span><span>${info.qq }</span></p>
                <p><span>地铁:</span><span>${info.subway }</span></p>
                <p><span class="fl">地址:</span><span class="fr">${info.address }</span></p>
            </div>
            <!-- 底部二维码 -->
            <div class="richscan fl">
                <p class="richscan-title fr">扫一扫 关注二维码</p>
                <p class="qrcode fr"></p>
            </div>
        </div>
        <div class="filing container">
            <p>Copyright © 2017 少即多科技, All Rights Reserved <a href="http://www.miitbeian.gov.cn">粤ICP备17062174号-1</a></p>
        </div>
    </div>
    <!-- 底部结束 -->
    <!-- 左下返回顶部 -->
    <div>
        <div id="service" style="display: none;">
            <div class="_top_qq" data-url="http://wpa.qq.com/msgrd?v=3&uin=2864108950&site=qq&menu=yes">
                <a href="http://wpa.qq.com/msgrd?v=3&uin=2864108950&site=qq&menu=yes" target="_blank">
                    <img src="http://www.lessismore520.com/images/qq.jpg" alt="">
                    <img src="http://www.lessismore520.com/images/qqtext.jpg" alt="">
                </a>
            </div>
            <div class="_top"> <img src="http://www.lessismore520.com/images/icon-phone.gif" alt=""> <img src="http://www.lessismore520.com/images/phone-txt.png" alt=""> </div>
            <div class="_center"> <img src="http://www.lessismore520.com/images/icon-phone.jpg" alt=""> <img src="http://www.lessismore520.com/images/icon-phone.png" alt=""> </div>
            <div class="_bottom" onClick="scrollTo(0,0);"> <img src="http://www.lessismore520.com/images/icon-zhiding.jpg" alt=""> <img src="http://www.lessismore520.com/images/icon-zhiding.png" alt=""> </div>
            <div class="text-1">
                <div class="text-1-1">
                    <div class="text-1-1-1">
                        <div class="first">
                            <div class="left"><img src="http://www.lessismore520.com/images/icon-telphone.png" alt=""></div>
                            <div class="right">
                                <span>少即多售前咨询电话</span>
                                <div>400-775-2560</div>
                            </div>
                        </div>
                        <div class="second">
                            <ul>
                                <li>全方位的服务咨询</li>
                                <li>新颖创意策划方案</li>
                                <li>标准售后服务指导</li>
                                <li>1对1的贴心服务</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-2"> <img src="http://www.lessismore520.com/images/qrcode.jpg" alt=""> </div>
        </div>
    </div>
    <!-- 左下返回顶部结束 -->
    <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=HWBU8TeF8e3eIMAdE1RxQZuLDZLR8lT5"></script>
    <script src="./../js/hm.js"></script>
    <script src="./../js/lx.js"></script>
    <script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?d0f40132d2ccd1f219d129fcdd666e0f";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
    </script>
    <script type="text/javascript" charset="utf-8" async src="http://lxbjs.baidu.com/lxb.js?sid=10800932"></script>
</body>

</html>
