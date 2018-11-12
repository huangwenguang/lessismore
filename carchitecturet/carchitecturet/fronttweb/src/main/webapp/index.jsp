<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
        <link rel="Shortcut Icon" href="./images/logo.ico" />
        <link rel="stylesheet" href="./css/sweetalert.css" />
        <link rel="stylesheet" href="./css/global.css" />
        <link rel="stylesheet" href="./css/index.css" />
        <link rel="stylesheet" href="./css/home.css" />
		<script>
		var browser = {
        versions: function() {
            var u = navigator.userAgent,
                app = navigator.appVersion;
            return { //移动终端浏览器版本信息   
                trident: u.indexOf('Trident') > -1, //IE内核  
                presto: u.indexOf('Presto') > -1, //opera内核  
                webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核  
                gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核  
                mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端  
                ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端  
                android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器  
                iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器  
                iPad: u.indexOf('iPad') > -1, //是否iPad    
                webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部  
            };
        }(),
        language: (navigator.browserLanguage || navigator.language).toLowerCase()
		}

		if (browser.versions.mobile || browser.versions.ios || browser.versions.android ||
			browser.versions.iPhone || browser.versions.iPad) {
			window.location = "http://www.lessismore520.com/web/index.jsp";
		}
		</script>
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
                        <!-- <li><a class="active" href="/">首页<span></span></a></li>
                        <li><a href="./html/appdev.html">APP开发<span></span></a></li>
                        <li><a href="./html/store.html">商城开发<span></span></a></li>
                        <li><a href="./html/game.html">游戏开发<span></span></a></li>
                        <li><a href="./html/applet.html">小程序开发<span></span></a></li>
                        <li><a href="./html/iot.html">物联网<span></span></a></li>
                        <li><a href="./html/smarthome.html">智能家居开发<span></span></a></li>
                        <li><a href="./html/contactus.html">联系我们<span></span></a></li> -->
                        <li><a class="active" href="/">首页<span></span></a></li>
                        <li><a href="./html/appdev.jsp">APP开发<span></span></a></li>
                        <li><a href="./html/store.jsp">商城开发<span></span></a></li>
                        <li><a href="./html/game.jsp">游戏开发<span></span></a></li>
                        <li><a href="./html/applet.jsp">小程序开发<span></span></a></li>
                        <li><a href="./html/iot.jsp">物联网<span></span></a></li>
                        <li><a href="./html/smarthome.jsp">智能家居开发<span></span></a></li>
                        <li><a href="./html/contactus.jsp">联系我们<span></span></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 导航结束 -->
        <!-- 首页内容 -->
        <div class="clearfix">
            <div class="img">
            </div>
            <!-- 开发服务 -->
            <div class="container">
                <div class="title  container">
                    <h2>开发服务</h2>
                    <span></span>
                </div>
                <ul class="devlist clearfix">
                    <li class="clearfix">
                        <a href="./html/store.jsp" class="clearfix" onClick="scrollTo(0,0);
">
                            <div class="fl">
                                <div></div>
                            </div>
                            <div class="fr">
                                <h3>商城开发</h3>
                                <p>定制需求开发，基础功能、商家、支付模块、分销，推广、会员积分等，功能全面，营销利器一个都不少</p>
                            </div>
                        </a>
                    </li>
                    <li class="clearfix">
                        <a href="./html/appdev.jsp" class="clearfix" onClick="scrollTo(0,0);
">
                            <div class="fl">
                                <div></div>
                            </div>
                            <div class="fr">
                                <h3>APP开发</h3>
                                <p>可根据客户的需求提供高品质的APP开发解决方案!使得企业生活便利智能化与企业系统品牌价值的双提升。</p>
                            </div>
                        </a>
                    </li>
                    <li class="clearfix">
                        <a href="./html/h5.jsp" class="clearfix" onClick="scrollTo(0,0);
">
                            <div class="fl">
                                <div></div>
                            </div>
                            <div class="fr">
                                <h3>H5建站</h3>
                                <p>专注于HTML5开发，拥有卓越的交互体验设计，坚持创新风格，以用户体验为基础，深入用户的想法，把技术实现到各个主流开发平台</p>
                            </div>
                        </a>
                    </li>
                    <li class="clearfix">
                        <a href="./html/game.jsp" class="clearfix" onClick="scrollTo(0,0);
">
                            <div class="fl">
                                <div></div>
                            </div>
                            <div class="fr">
                                <h3>游戏开发</h3>
                                <p>可根据客户需求开发手机游戏和网页游戏，为客户提供最好的产品、良好的技术支持、健全的售后服务。</p>
                            </div>
                        </a>
                    </li>
                    <li class="clearfix">
                        <a href="./html/zhidxcom.jsp" class="clearfix" onClick="scrollTo(0,0);
">
                            <div class="fl">
                                <div></div>
                            </div>
                            <div class="fr">
                                <h3>公众号网站</h3>
                                <p>为客户提供个性化定制的微信公众平台开发服务，快速提高知名度，帮您打造微品牌。</p>
                            </div>
                        </a>
                    </li>
                    <li class="clearfix">
                        <a href="./html/applet.jsp" class="clearfix" onClick="scrollTo(0,0);
">
                            <div class="fl">
                                <div></div>
                            </div>
                            <div class="fr">
                                <h3>小程序开发</h3>
                                <p>不是APP胜似APP，有多种功能，在微信里无需下载、安装、升级，用户搜一搜、扫一扫立刻享受服务极致用户体验。把你的服务入驻微信开放给微信 10亿用户。</p>
                            </div>
                        </a>
                    </li>
                    <li class="clearfix">
                        <a href="./html/smarthome.jsp" class="clearfix" onClick="scrollTo(0,0);
">
                            <div class="fl">
                                <div></div>
                            </div>
                            <div class="fr">
                                <h3>智能家居开发</h3>
                                <p>足不出户就能管理自己的家。以住宅为平台，利用综合布线技术、网络通信技术、 安全防范技术、自动控制技术、音视频技术将家居生活有关的设施集成，构建高效的住宅设施与家庭日程事务的管理系统，提升家居安全性、便利性、舒适性、艺术性，并实现环保节能的居住环境。</p>
                            </div>
                        </a>
                    </li>
                    <li class="clearfix">
                        <a href="./html/iot.jsp" class="clearfix" onClick="scrollTo(0,0);
">
                            <div class="fl">
                                <div></div>
                            </div>
                            <div class="fr">
                                <h3>物联网</h3>
                                <p>物物相连的网络，以互联网为基础，在此的基础上做了一些延伸和扩展，延伸到了任何物体和物体之间，进行信息交换和通信。</p>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="kb"></div>
            <div class="container">
                <!-- 我们的服务优势 -->
                <div class="title  container">
                    <h2>我们的服务优势</h2>
                    <span></span>
                </div>
                <ul class="advantage clearfix">
                    <li>
                        <div class="img">
                        </div>
                        <div class="text">
                            <h3>专注以及品质追求</h3>
                            <p>从创始至今，我们的业务方向始终不变，专注做好一件事才能更好的追求高品质，这也是我们存在的价值。在未来我们也是基于此信念而继续创造。</p>
                        </div>
                    </li>
                    <li>
                        <div class="img"></div>
                        <div class="text">
                            <h3>严谨的项目流程</h3>
                            <p>在不断的创新和实践中总结出可持续和可信赖的设计流程，坚持与用户一起思考，发现问题、解决问题、并实现客户产品和企业价值的提升。</p>
                        </div>
                    </li>
                    <li>
                        <div class="img"></div>
                        <div class="text">
                            <h3>优秀的项目累计</h3>
                            <p>积累了大量优秀的项目案例，并验证了设计的价值。在不断的探索中总结经验，以结果为导向，继续为更多客户提供优秀的设计。</p>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="kb"></div>
            <div class="container">
                <div class="title  container">
                    <h2>合作流程</h2>
                    <span></span>
                </div>
                <ul class="flow clearfix">
                    <li class="odd">
                        <div class="flow-text">
                            <span>了解客户需求，用户使用环境、操作流程、签订合同</span>
                        </div>
                        <div class="flow-img"></div>
                        <div class="flow-icon"><span class="flow-arrows">&gt;</span></div>
                        <div class="flow-title">沟通项目</div>
                    </li>
                    <li class="even">
                        <div class="flow-icon"><span class="flow-arrows">&gt;</span></div>
                        <div class="flow-title">方案规划</div>
                        <div class="flow-img"></div>
                        <div class="flow-text">
                            <span>制定方案、规划内容、制定风格、买点设计</span>
                        </div>
                    </li>
                    <li class="odd">
                        <div class="flow-text">
                            <span>交互情景模拟、设计原型</span>
                        </div>
                        <div class="flow-img"></div>
                        <div class="flow-icon"><span class="flow-arrows">&gt;</span></div>
                        <div class="flow-title">交互设计</div>
                    </li>
                    <li class="even">
                        <div class="flow-icon"><span class="flow-arrows">&gt;</span></div>
                        <div class="flow-title">视觉设计</div>
                        <div class="flow-img"></div>
                        <div class="flow-text">
                            <span>创意设计、页面设计、色彩设计、用户体验研究</span>
                        </div>
                    </li>
                    <li class="odd">
                        <div class="flow-text">
                            <span>程序开发、页面动态展示、多平台开发</span>
                        </div>
                        <div class="flow-img"></div>
                        <div class="flow-icon"><span class="flow-arrows">&gt;</span></div>
                        <div class="flow-title">制作开发</div>
                    </li>
                    <li class="even">
                        <div class="flow-icon"></div>
                        <div class="flow-title">质量审核</div>
                        <div class="flow-img"></div>
                        <div class="flow-text">
                            <span>验收测试、规范完善、客户意见。</span>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="about-us clearfix">
                <div class="about-us-title  container">
                    <h2>关于我们</h2>
                    <span></span>
                </div>
                <div>
                    <!-- <p class="container">广州市少即多科技有限公司是一个新型的互联网公司，成立于2017年，公司技术骨干都是来自华为，立信，硅谷等知名互联网企业，技术骨干曾经都担任过技术总监，技术经理等核心的岗位，是互联网的佼佼者，公司主要业务是从事软件定制开发和建立属于公司的平台产品，欢迎你的加入。</p> -->
               		<p class="container">${company.content }</p>
                </div>
                <ul class="img-box">
                    <li class="animated fadeInLeft">
                    </li>
                    <li class="animated fadeInDown">
                    </li>
                    <li class="animated fadeInRight">
                    </li>
                    <li class="animated fadeInLeft">
                    </li>
                    <li class="animated fadeInUp">
                    </li>
                </ul>
            </div>
            <div class="leaveword clearfix">
                <div class="leaveword-title clearfix  container">
                    <h2>联系我们</h2>
                    <span></span>
                </div>
                <form class="container clearfix" id="form">
                    <input name="username" class="fl" type="text" placeholder="您的姓名">
                    <input name="phone" class="fr" type="text" placeholder="您的手机号">
                    <input name="weixin" class="fl" type="text" placeholder="您的微信(选填)">
                    <input name="qq" class="fr" type="text" placeholder="您的QQ(选填)">
                    <textarea class="fl" name="needs" id="needs" cols="30" rows="10" placeholder="您的需求"></textarea>
                    <input type="hidden" name="type" value="1">
                    <input type="button" value="提交留言" id="submit">
                </form>
            </div>
        </div>
        <!-- 首页内容结束 -->
        <!-- 底部 -->
        <div class="footer">
            <div class="container">
                <!-- 底部导航 -->
                <ul class="fl footer-nav">
                    <li class="active">
                        <a href="/" onClick="scrollTo(0,0);
">首页</a>
                    </li>
                    <li>
                        <a href="./html/appdev.jsp" onClick="scrollTo(0,0);
">App开发</a>
                    </li>
                    <li>
                        <a href="./html/store.jsp" onClick="scrollTo(0,0);
">商城开发</a>
                    </li>
                    <li>
                        <a href="./html/game.jsp" onClick="scrollTo(0,0);
">游戏开发</a>
                    </li>
                    <li>
                        <a href="./html/applet.jsp" onClick="scrollTo(0,0);
">小程序开发</a>
                    </li>
                    <li>
                        <a href="./html/h5.jsp" onClick="scrollTo(0,0);
">H5建站</a>
                    </li>
                    <li>
                        <a href="./html/zhidxcom.jsp" onClick="scrollTo(0,0);
">公众号开发</a>
                    </li>
                    <li>
                        <a href="./html/iot.jsp" onClick="scrollTo(0,0);
">物联网</a>
                    </li>
                    <li>
                        <a href="./html/smarthome.jsp" onClick="scrollTo(0,0);
">智能家居开发</a>
                    </li>
                    <li>
                        <a href="./html/contactus.jsp" onClick="scrollTo(0,0);
">联系我们</a>
                    </li>
                </ul>
                <!-- 底部信息 -->
                <div class="info fl">
                   <!--  <h2>广州市少即多科技有限公司</h2>
                    <p><span>电话:</span><span>400-775-2560</span></p>
                    <p><span>手机:</span><span>13229422332</span></p>
                    <p><span>Q Q :</span><span>2864108950</span></p>
                    <p><span>地铁:</span><span>3号线北沿段人和站B出口直走1000米</span></p>
                    <p><span class="fl">地址:</span><span class="fr">广州市白云区人和镇凤岗路9号九洲创意园
      C栋B208室</span></p> -->
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
        <script src="https://cdn.bootcss.com/jquery/1.8.1/jquery.min.js"></script>
        <script src="./js/sweetalert.min.js"></script>
        <script src="./js/hm.js"></script>
        <script src="./js/lx.js"></script>
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
