(function(config) {
    // 请求搜狐获取用户ip和地区
    var returnCitySN = {
        cip:'',
        cname:''
    };
    $.ajax({
            type:"get",
            cache: true,
            url: config.server + "/Protype/list.do",
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
    $.ajax({
        cache: true,
        dataType: 'jsonp',
        jsonp: 'callback',
        url: "https://pv.sohu.com/cityjson?ie=utf-8",
        data: '',
        async: false,
        error: function(request) {

        },
        success: function(data) {
            
        }
    });
    // 提交表单
    $('#submit').on('click', function() {
        // 动画开启
        var demand = $("#mySelect").find("option:selected").val();
        var name = $("#form input[type='text']").eq(0).val();
        var phone = $("#form input[type='text']").eq(1).val();
        var qq = $("#form input[type='text']").eq(2).val();
        var needs = $("#form input[type='text']").eq(3).val();
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
            url: config.server + "/gwUser/save.do",
            data: $.param({
                    'ip': returnCitySN.cip,
                    'city': returnCitySN.cname
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
                        location.reload();
                    });
                // 动画关闭
                $('.loading').hide();
            },
            success: function(data) {
                swal({
                        title: "提交成功",
                        text: "",
                        type: "success",
                        confirmButtonText: "OK",
                        closeOnConfirm: false
                    },
                    function() {
                        location.reload();
                    });
                // 动画关闭
                $('.loading').hide();
            }
        });
    })


})(config)
