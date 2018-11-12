 //获取详情
 function getDetail(cId) {
     $.ajax({
         type: "GET",
         url: config.server + "/detail/detailList.do",
         data: {
             cId: cId
         },
         success: function (result) {
             var data = result.data;
             var html1 = ''
             html1 += '<ul class="clearfix">';
             for (var i = 0; i < data.length; i++) {
                html1 += '<li class="appItem"><div><img src="'+ data[i].urls.lg+'" alt=""><span>'+data[i].contents+'</span></div></li>'
             };
            html1 += '</ul>';
            $('.cidclass' + cId).find('.title').after(html1);
         }
     })
 }
 //加载项目数据
 function getProject(typeId) {
     $.ajax({
         type: "GET",
         url: config.server + "/cover/coverList.do",
         data: {
             typeId: typeId
         },
         success: function (result) {
             var data = result.data;
             console.log(result);
             // getDetail(data[0].cId, 1);
             var html = '';
             for (var i = 0; i < result.data.length; i++) {
                cidclass = 'cidclass'+ result.data[i].cId;
                html +='<div class="appList container '+ cidclass +'"><div class="title">'+ result.data[i].content+'</div></div>'
                getDetail(result.data[i].cId)
             }
             $("#casus").after(html);

         }
     });
 }