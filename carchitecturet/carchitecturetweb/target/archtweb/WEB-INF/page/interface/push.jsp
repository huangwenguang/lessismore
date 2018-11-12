<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@include file="../commons/commons.jsp"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cl"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <%@include file="messageModals.jsp"%> --%>
<c:set var="ctx" value="<%=request.getContextPath()%>"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .box{
            width: 1350px;
            margin: 0 auto;
            border: 1px solid #000;
            height: 880px;
        }
        .box > div{
            width: 100%;
        }
        .box > div > label{
            text-align: center;
            display: block;
        }
        .box > div.title > label{
            text-align: center;
            display: block;
            float: left;
            width: 20%;
            height: 50px;
            line-height: 50px;
        }
        .box > div.title > textarea{
            width: 80%;
            resize: vertical;
            min-height: 50px;
            height: 50px;
            overflow-y: hidden;
        }
        .box > div.title1 > label{
            text-align: center;
            display: block;
            float: left;
            width: 20%;
            height: 20px;
            line-height: 20px;
        }
        .box > div.title1 > div{
            width: 80%;
            resize: vertical;
            height: 20px;
            overflow-y: hidden;
            float: left;
        }
        .box > div.title > select{
            width: 80%;
            resize: vertical;
            height: 50px;
            overflow-y: hidden;
            float: left;
        }
        .submit{
            height: 50px;
            text-align: center;
            line-height: 50px;
        }
        .submit >span{
            cursor: pointer;
            border-radius:  10px;
            border: 1px solid #000;
            padding: 5px;    
        }
    </style>
    <script src="https://cdn.bootcss.com/jquery/1.8.1/jquery.min.js"></script>
</head>
<body>
    <div class="box">    	
    	<!-- 项目名 -->
    	<input type="hidden" name="proName" id="proName" value="${bean.proName }"> 
    	<!-- 接口名 -->
    	<input type="hidden" name="interName" id="interName" value="${bean.interName }">
        <div><label for="">消息推送</label></div>
        <div class="title">
            <label for="">APP</label>
            <select>
              <option value ="突发新闻1">突发新闻1</option>
              <option value ="突发新闻2">突发新闻2</option>
              <option value="突发新闻3">突发新闻3</option>
              <option value="突发新闻4">突发新闻4</option>
            </select>
        </div>
        <div class="title">
            <label for="">通知内容</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">IOS推送环境</label>
            <select>
              <option value ="测试环境1">测试环境</option>
              <option value ="测试环境2">测试环境</option>
              <option value="测试环境3">测试环境</option>
              <option value="测试环境4">测试环境</option>
            </select>
        </div>
        <div class="title">
            <label for="">消息内容</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">MSG</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">URl</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">标识属性名称</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title1">
            <label for="">推送平台</label>
            <div>
                <input type="radio" name='1'>全部
                <input type="radio" name='1'>安卓
                <input type="radio" name='1'>ios
            </div>
        </div>
        <div class="title">
            <label for="">推送目标(设备id)</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">历史记录(只保存上次推送信息)</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">上次推送</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">时间</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">通知内容</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
        </div>
        <div class="title">
            <label for="">接收人</label>
            <select id="accName" name="receiver">
            	
            </select>           
        </div>
         <div class="title">
            <label for="">通知方式</label>
            <select id="message" name="messType">
            	
            </select>           
        </div>
        <div class="title">
            <label for="">是否紧急</label>
            <select id="status" name="status">
            	<option value="1">是</option>
            	<option value="0">否</option>
            </select>           
        </div>
        <div class="submit">
            <span onclick="fasong()">推送</span>
        </div>       
    </div>
    <script type="text/javascript">
    	/* 获取所有需要通知的对象 */
    		$.ajax({
            //几个参数需要注意一下
            type: "get",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: '${ctx}' +"/adminMgt/getOther.do" ,
            success: function (result) {           
            	var html ='';    
                for ( var i= 0 ; i < result.data.length ;i++) {
                	//管理员不添加
                	if(result.data[i].id!=1){
                		html += '<option value="'+result.data[i].id +'">'+ result.data[i].userName +'</option>'
                	}					
				}
				$("#accName").html(html);
				console.log($("#parentId1"))
            },
            error : function() {
                alert("异常！");
            }
            
        });
        /* 点击接收对象，获取通讯信息 */
        $("#accName").change(function () {				
	    		$.ajax({
		            //几个参数需要注意一下
		            type: "get",//方法类型
		            dataType: "json",//预期服务器返回的数据类型
		            data:{
		            	id:$("#accName").find("option:selected").val()
		            },
		            url: '${ctx}' +"/adminMgt/getById.do" ,
		            success: function (result) {
		                /* var html1 = '<option value="'+result.data[i].phone +'">手机</option>'; */
		                var html1 = '<option value="'+result.data.phone +'">'+ result.data.phone +'</option></br>'+'<option value="'+result.data.email +'">'+ result.data.email +'</option></br>'
		               /*  for ( var i= 0 ; i < result.data.length ;i++) {
							html1 += '<option value="'+result.data[i].id +'" selected="selected">'+ result.data[i].name +'</option>'
						} */
						$("#message").html(html1);
						console.log($("#parentId2"))
						$("#zijiedian").show()
		            },
		            error : function() {
		                alert("异常！");
		            }
		            
		        });	   
		});  
		function fasong(){
			alert("开始推送...")
			if(!$("#message").val()){
				warningAlert("通知方式不能为空!");
			}
					$.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: '${ctx}' +"/push/saveDo.do" ,//url
                data:{id:null,proName:$("#proName").val(),interName:$("#interName").val(),receiver:$("#accName").val(),
                messType:$("#message").val(),status:$("#status").val()},
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.status==1) {
                       alert("推送成功");
                    }else{
                    	 alert("推送失败");
                    }
                    ;
                },
                error : function() {
                    alert("异常！");
                }
            });
		}
    </script>
</body>
</html>