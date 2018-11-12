
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
            // console.log("%cSpecial Thanks", "font-size: 18px; font-weight: bold");
            // console.log("");
            for (var i in Contributors.people) {
                // console.log("%c" + Contributors.people[i].name, "font-size: 18px;");
                // console.log("%cUrl: " + Contributors.people[i].url, "font-size: 14px; color: #666");
                // console.log("%c", "background:url(" + Contributors.people[i].avatar + ") no-repeat; line-height:180px; padding: 85px 85px; -webkit-background-size: 100% 100%; background-size: 100% 100%; width: 180px; height: 180px;");
                // console.log("");
            }
            console.log("And you.");
        }
    })()

    $.ajax({
        type:"get",
        cache: true,
        url: "https://www.lessismore520.com/gwapi/tecCoope/list.do",
        async: false,
        error: function(request) {
            console.log(request)
        },
        success: function(res) {
            if (res.status = 1) {
                var html = '';
                for (var i = 0; i < res.data.length; i++) {
                    html += '<li class="teccoope clearfix"><div class="teccoope-img"><img src="'+ res.data[i].Logo.lg +'" alt=""></div><div class="teccoope-name">'+ res.data[i].name +'</div><div class="teccoope-content">'+ res.data[i].content+'</div></li>'
                }
                $("#teccoope").html(html);
            }
        }
    });

    // 技术外派
    $.ajax({
        type:"get",
        cache: true,
        url: "https://www.lessismore520.com/gwapi/Protype/list.do",
        async: false,
        error: function(request) {
            console.log(request)
        },
        success: function(res) {
            if (res.status = 1) {
                var html = '';
                for (var i = 0; i < res.data.length; i++) {
                    html += '<option value="'+ res.data[i].name +'">'+ res.data[i].name +'</option>'
                }
                $("#mySelect").html(html);
            }
        }
    });
    // 我的团队
    $.ajax({
        type:"get",
        cache: true,
        url: "https://www.lessismore520.com/gwapi/weTeams/list.do",
        async: false,
        error: function(request) {
            console.log(request)
        },
        success: function(res) {
            if (res.status = 1) {
                var html = '';
                for (var i = 0; i < res.data.pictures.length; i++) {
                    html += '<li class="animated" style="background-image: url('+ res.data.pictures[i].lg +');"></li>'
                }
                $("#weTeams .weteam-text").html(res.data.content);
                $("#weTeams ul").html(html);
            }
        }
    });

    // 请求搜狐获取用户ip和地区
    $.ajax({
        cache: true,
        dataType: 'jsonp',
        jsonp: 'callback',
        url: "https://pv.sohu.com/cityjson?ie=utf-8",
        data: '',
        async: false,
        error: function(request) {
            // console.log('失败了')
            // console.log(returnCitySN);
        },
        success: function(data) {
            // console.log('成功')
            // console.log(returnCitySN)
        }
    });

    $(".share_box").on("click","#share_button",function(){
        $(this).parent().toggleClass("active");
    })
    $(".share_box").on("click","#share_copylink",function(){
        var clipboard = new Clipboard('#share_copylink a', {
            text: function() {
                return window.location;
            }
        });
        clipboard.on('success', function(e) {
            swal("复制成功")
        });

        clipboard.on('error', function(e) {
            swal("复制失败")
        });
    })

    

    
    $(".share_box .share .share_item").hover(function(){
        $(this).addClass("active");
        // if ($(this).attr("id") === 'share_button') {
        //     $(this).parent().addClass("active");
        // }
    },function(){
        $(this).removeClass("active");
        // if ($(this).attr("id") === 'share_button') {
        //     $(this).parent().removeClass("active");
        // }
    });

    var hometitle = "广州市少即多科技有限公司";
    var homepage = window.location;
    var homepics = "https://www.lessismore520.com/images/qrcodepc.png";
    $("#share_sina").find("a").attr("href","https://service.weibo.com/share/share.php?url="+ homepage +"&title="+ hometitle +"&pic="+ homepics);
    $("#share_qzone").find("a").attr("href","https://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url="+ homepage+"&title="+ hometitle +"&pics=" + homepics);
    $("#share_qq").find("a").attr("href","http://connect.qq.com/widget/shareqq/index.html?url="+ homepage+"&desc=&title="+ hometitle+"&summary=&pics="+ homepics +"&flash=&site=&style=201&width=32&height=32&showcount=");




    // 去掉友盟a
    for (var i = 0; i < $("a").length; i++) {
        if ($("a").eq(i).attr("href") === "http://www.cnzz.com/stat/website.php?web_id=1271627874") {
            $("a").eq(i).hide();
        }
    }


    $("body").on("click",".dynamicbox .item",function(){
        var index = $(this).index();
        var path = './';
        if ($(this).parents(".dynamicbox").hasClass("index")) {
            path = './html/';
        }
        console.log(path);
        switch(index)
            {
                case 0:
                    window.location.href = path + 'appdev.html'
                break;

                case 1:
                    window.location.href = path + 'smarthome.html'
                break;

                case 2:
                    window.location.href = path + 'h5.html'
                break;

                case 5:
                    window.location.href = path + 'store.html'
                break;

                case 7:
                    window.location.href = path + 'game.html'
                break;

                case 8:
                    window.location.href = path + 'zhidxcom.html'
                break;

                case 10:
                    window.location.href = path + 'applet.html'
                break;
            }
    })


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
            type:"post",
            cache: true,
            url: "https://www.lessismore520.com/gwapi/gwUser/save.do",
            data: $.param({
                    'ip': returnCitySN.cip,
                    'city': returnCitySN.cname,
                    'platform': platform
                }) + '&' +
                $('#form').serialize(),
            async: false,
            error: function(request) {
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






