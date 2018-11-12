(function() {
    // 左下客服
    window.onscroll = function() {
            var h = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
            var kf = document.getElementById('service');
            if (h > 500) {
                kf.style.display = "block";
            } else {
                kf.style.display = "none";
            }
        }
        //回到顶部
    function gotoTop(acceleration, stime) {
        acceleration = acceleration || 0.1;
        stime = stime || 10;
        var x1 = 0;
        var y1 = 0;
        var x2 = 0;
        var y2 = 0;
        var x3 = 0;
        var y3 = 0;
        if (document.documentElement) {
            x1 = document.documentElement.scrollLeft || 0;
            y1 = document.documentElement.scrollTop || 0;
        }
        if (document.body) {
            x2 = document.body.scrollLeft || 0;
            y2 = document.body.scrollTop || 0;
        }
        var x3 = window.scrollX || 0;
        var y3 = window.scrollY || 0;

        // 滚动条到页面顶部的水平距离
        var x = Math.max(x1, Math.max(x2, x3));
        // 滚动条到页面顶部的垂直距离
        var y = Math.max(y1, Math.max(y2, y3));

        // 滚动距离 = 目前距离 / 速度, 因为距离原来越小, 速度是大于 1 的数, 所以滚动距离会越来越小
        var speeding = 1 + acceleration;
        window.scrollTo(Math.floor(x / speeding), Math.floor(y / speeding));

        // 如果距离不为零, 继续调用函数
        if (x > 0 || y > 0) {
            var run = "gotoTop(" + acceleration + ", " + stime + ")";
            window.setTimeout(run, stime);
        }
    }
    //判断该用户从哪来进入网站
    var r = document.referrer;
    r = r.toLowerCase(); //转为小写
    var aSites = new Array('google', 'baidu', 'soso', 'so', '360', 'yahoo', 'youdao', 'sogou', 'gougou');
    var b = false;
    var platform = '';
    for (i in aSites) {
        if (r.indexOf(aSites[i]) > 0) {
            // console.log(aSites[i]);
            platform = aSites[i];
            b = true;
        }
    }
    if (!b) {
        // console.log('直接输入网址');
        platform = '直连';
    }

    setTimeout(function() {
        window.open('http://p.qiao.baidu.com/cps/chat?siteId=10759575&userId=23913009', '', 'height=600,width=700,top=200,left=500,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no')
    }, 20000);
    window.lx = 'liuxin';





    /**
     *
     *  "Our Contributors"
     *
     *
     *
     *  Functional : Collection of this site's contributors, and Chrome only.
     *
     *  
     *  
     */

    (function() {
        var Contributors;
        Contributors = {
            shuffle: function(o) { //v1.0
                for (var j, x, i = o.length; i; j = Math.floor(Math.random() * i), x = o[--i], o[i] = o[j], o[j] = x);
                return o;
            },
            people: [{
                name: "lxljl(lxx_ljl@163.com)",
                url: "http://lxljl.cn",
                avatar: "https://wx2.sinaimg.cn/thumb300/704a2b51gy1fgssok9omoj2050050t8q.jpg"
            }, {
                name: "wqq(1141637768@qq.com)",
                url: "http://weibo.com/208383193",
                avatar: "https://lh5.googleusercontent.com/-tcHjX1CT-oM/AAAAAAAAAAI/AAAAAAAAEWQ/c9iraDvdmE4/s125/photo.jpg"
            }]
        }
        if (window.console && window.console.log) {
            Contributors.shuffle(Contributors.people);
            //console.clear();
            console.log("%cSpecial Thanks", "font-size: 18px; font-weight: bold");
            console.log("");
            for (var i in Contributors.people) {
                console.log("%c" + Contributors.people[i].name, "font-size: 18px;");
                console.log("%cUrl: " + Contributors.people[i].url, "font-size: 14px; color: #666");
                console.log("%c", "background:url(" + Contributors.people[i].avatar + ") no-repeat; line-height:180px; padding: 85px 85px; -webkit-background-size: 100% 100%; background-size: 100% 100%; width: 180px; height: 180px;");
                console.log("");
            }
            console.log("And you.");
        }
    })()
    // 请求搜狐获取用户ip和地区
    // $.ajax({
    //     cache: true,
    //     dataType: 'jsonp',
    //     jsonp: 'callback',
    //     url: "http://pv.sohu.com/cityjson?ie=utf-8",
    //     data: '',
    //     async: false,
    //     error: function(request) {
    //         // console.log('失败了')
    //         // console.log(returnCitySN);
    //     },
    //     success: function(data) {
    //         // console.log('成功')
    //         // console.log(returnCitySN)
    //     }
    // });
    // 提交表单
    $('#submit').on('click', function() {    	
        // 动画开启
        console.log(123)
        var name = $("#form input[type='text']").eq(0).val();
        var phone = $("#form input[type='text']").eq(1).val();
        var qq = $("#form input[type='text']").eq(2).val();
        var needs = $("#needs").val();
        console.log(needs)
            // 手机正则
        var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;
        if ($.trim(name) == '') {
            swal("姓名不能为空！");
            return false;
        }
        if (!phoneReg.test($.trim(phone))) {
            swal("请输入有效的手机号！");
            return false;
        }
        if ($.trim(needs) == '') {
            swal("需求不能为空！");
            return false;
        }
        $('.loading').show();
        $.ajax({
        	type:"POST",
            cache: true,
            dataType: 'jsonp',
            jsonp: 'callback',
           /* url: "https://www.lessismore520.com/gwapi/gwUser/save.do",*/
            url: "http://localhost:8078/lessismore/guanWang/save.do",
            data: $.param({
                    'ip': returnCitySN.cip,
                    'city': returnCitySN.cname,
                    'platform': platform
                }) + '&' +
                $('#form').serialize(),
            async: false,
            error: function(request) {
                // console.log(request);
                swal({
                        title: "提交成功",                       
                        text: "",
                        type: "success",
                        confirmButtonText: "OK",
                        closeOnConfirm: false
                    },
                    function() {
                        window.scrollTo(0, 0);
                        location.reload();
                    });
                // 动画关闭
                $('.loading').hide();
            },
            success: function(data) {
                // console.log(data);
                swal({
                        title: "提交成功",
                        text: "",
                        type: "success",
                        confirmButtonText: "OK",
                        closeOnConfirm: false
                    },
                    function() {
                        window.scrollTo(0, 0);
                        location.reload();
                    });
                // 动画关闭
                $('.loading').hide();
            }
        });
    })




    // 地图
    // 百度地图API功能
    // 创建Map实例
    var map = new BMap.Map("allmap", { enableMapClick: true });
    // 初始化地图,设置中心点坐标和地图级别
    map.centerAndZoom(new BMap.Point(113.296467, 23.348056), 11);
    // 添加地图类型控件
    map.addControl(new BMap.MapTypeControl());
    // 设置地图显示的城市 此项是必须设置的
    map.setCurrentCity("广州");
    // 开启鼠标滚轮缩放      
    map.enableScrollWheelZoom(true);
    // 设置定时器，对地图进行自动移动
    setTimeout(function() {
        map.panTo(new BMap.Point(113.296467, 23.348056));
    }, 2000);
    setTimeout(function() {
        map.setZoom(14);
    }, 4000);
    /************************************************
    添加折线
    *************************************************/
    var pointGZ = new BMap.Point(113.296467, 23.348056);
    var pointHK = new BMap.Point(113.296467, 23.348056);
    setTimeout(function() {
        var polyline = new BMap.Polyline([pointGZ, pointHK], { strokeColor: "blue", strokeWeight: 5, strokeOpacity: 0.5 });
        map.addOverlay(polyline);
    }, 6000);
    /************************************************
    添加工具条、比例尺控件
    *************************************************/
    map.addControl(new BMap.ScaleControl({ anchor: BMAP_ANCHOR_TOP_LEFT }));
    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.NavigationControl({ anchor: BMAP_ANCHOR_BOTTOM_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL }));
    /************************************************
    添加自定义控件类，放大ZoomControl
    *************************************************/
    function ZoomControl() {
        //默认停靠位置和偏移量
        this.defaultAnchor = BMAP_ANCHOR_BOTTOM_RIGHT;
        this.defaultOffset = new BMap.Size(50, 23);
    }
    //通过JavaScript的prototype属性继承于BMap.Control
    ZoomControl.prototype = new BMap.Control();
    //自定义控件必须实现自己的initialize方法，并且将控件的DOM元素返回
    //在本方法中创建div容器，并将其添加到地图容器中
    ZoomControl.prototype.initialize = function(map) {
            //创建一个DOM元素
            var div = document.createElement('div');
            //添加文字说明
            div.appendChild(document.createTextNode('放大两级'));
            //添加样式
            div.style.color = '#40C5CC';
            div.style.cursor = 'pointer';
            div.style.border = '3px solid gray';
            div.style.backgroundColor = '#eee';
            //绑定事件，点击触发
            div.onclick = function(e) {
                    map.setZoom(map.getZoom() + 2);
                }
                //添加DOM元素到地图上
            map.getContainer().appendChild(div);
            //将DOM元素返回
            return div;
        }
        //创建控件
    var myZoomCtrl = new ZoomControl();
    map.addControl(myZoomCtrl)

    /************************************************
    添加添加城市列表控件
    *************************************************/
    map.addControl(new BMap.CityListControl({
        anchor: BMAP_ANCHOR_BOTTOM_RIGHT,
        offset: new BMap.Size(130, 23)
            // 切换城市之间事件
            // onChangeBefore: function(){
            //    alert('before');
            // },
            // 切换城市之后事件
            // onChangeAfter:function(){
            //   alert('after');
            // }
    }));
    /************************************************
    添加新图标
    *************************************************/
    //定义新图标
    var myIcon = new BMap.Icon("http://developer.baidu.com/map/jsdemo/img/fox.gif", new BMap.Size(300, 157));
    //创建标注
    var marker = new BMap.Marker(pointHK, { icon: myIcon });
    var marker1 = new BMap.Marker(pointGZ, { icon: myIcon });
    //将标注放大地图上
    map.addOverlay(marker);
    map.addOverlay(marker1);
    //文字提示
    var label = new BMap.Label('广州市白云区人和镇凤岗路8号九洲创意园 C栋B208室', { offset: new BMap.Size(140, 10) });
    marker1.setLabel(label);
    //添加新图标的监听事件
    marker1.addEventListener('click', function() {
        var p = marker1.getPosition(); //获取位置
        alert("点击的位置是：" + p.lng + ',' + p.lat);
    })

    /************************************************
    添加曲线
    *************************************************/
    var beijingPosition = new BMap.Point(116.432045, 39.910683),
        hangzhouPosition = new BMap.Point(120.129721, 30.314429),
        taiwanPosition = new BMap.Point(121.491121, 25.127053);
    var point = [beijingPosition, hangzhouPosition, taiwanPosition];

    var curve = new BMapLib.CurveLine(point, { strokeColor: "blue", strokeWeight: 3, strokeOpacity: 0.5 }); //创建弧线
    map.addOverlay(curve); //添加到地图上
    curve.enableEditing(); //开启编辑功能

    /************************************************
    给地图添加右键菜单
    *************************************************/
    var menu = new BMap.ContextMenu();

    var txtMenuItem = [{
        text: '放大',
        callback: function() { map.zoomIn() }
    }, {
        text: '缩小',
        callback: function() { map.zoomOut() }
    }];
    for (var i = 0; i < txtMenuItem.length; i++) {
        menu.addItem(new BMap.MenuItem(txtMenuItem[i].text, txtMenuItem[i].callback, 100));
    }
    map.addContextMenu(menu);
    // this.ipdata = returnCitySN;
    // this.platform = platform;


})()
