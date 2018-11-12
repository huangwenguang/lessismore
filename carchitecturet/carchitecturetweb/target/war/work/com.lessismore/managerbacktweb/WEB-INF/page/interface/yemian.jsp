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
	<style type="text/css">
		li select{
		    height:  100%;
		    width:  100%;
		    line-height:  100%;
		    padding: 0;
		}
		.test_box{
			border: 1px solid #000;
			width: 1350px;
		}
		.test_box > div{
			border-bottom: 1px solid #000;
		}
		.test_box  div >label{
			width: 100%;
			display: block;
			height: 50px;
			line-height: 50px;
			text-indent: 10em;
		}
		.test_box  div >textarea{
			width: 100%;
			display: block;
			height: 100px;
			resize: vertical;
			border: none;
			font-size: 17px;
		}
		.whether_realize{
			height: 50px;
			position: relative;
		}
		.whether_realize label{
			height: 50px;
			float: left;
			width: 20%;
		}
		.whether_realize div{
			position: absolute;
			top: 15px;
    		left: 270px;
		}
		.whether_realize div:nth-of-type(2){
		left:370px;
		}
		.new_request_explain{
			position: relative;
		}
		.new_request_explain .popup{
			position: absolute;
			right: 35px;
			top: 0;
			width: 100px;
			/*height: 40px;*/
			background: #fa4da1;
			display: none;
		}
		.new_request_explain .popup div{
			height: 20px;
			line-height: 20px;
			text-align: center;
			cursor: pointer;
		}
		.new_request_explain ul{
			height: 25px;
			padding: 0;
			margin: 0;
			border-top: 1px solid #000;
		}
		.new_request_explain .data textarea{
			width: 100%;
			resize: vertical;
			border: none;
		}
		.new_request_explain .value li:nth-last-of-type(1){
			cursor: pointer;
		}
		.new_request_explain ul li{
			float: left;
			height: 25px;
			width: 12.5%;
			border: 1px solid #000; 
			border-left: none;
			border-top: none;
			border-bottom: none;
			box-sizing: border-box;
			list-style: none;
			text-align: center;
		}
		.new_request_explain ul li input{
			width: 100%;
			border: none;
			height: 100%;
			text-align: center; 
		}
		.whether_realize input{
			border: none;
			text-align: center; 
			opacity: 1;
		    position: static;
		    z-index: 1;
		    cursor: auto;
		    margin: 0;
		}
		.new_request_explain ul:nth-last-of-type(1){
			border-bottom: 1px solid #000;
		}
		.new_request_explain ul li:nth-of-type(1){
			border-left: none; 
		}
		.new_request_explain ul li:nth-last-of-type(1){
			border-right: none; 
		}
        .baocun{
            height: 100px;
            position: relative;
        }
        .baocun div{
            position: absolute;
            border: 1px solid #000;
            width: 80px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            cursor: pointer;
        }
        .baocun div:nth-of-type(1){
            top:50%;
            transform: translateY(-50%,-50%);
            left: 45%;
        }
        .baocun div:nth-of-type(2){
            top:50%;
            transform: translateY(-50%,-50%);
            left: 55%;
        }
	</style>
	<script src="https://cdn.bootcss.com/jquery/1.8.1/jquery.min.js"></script>
</head>
<body>
	<div style="
			top: 15px;			
    		left: 270px;
    		cursor: pointer;
    		font-size:15.4px;
    		">    
    		<c:if test="${sessionScope.USER.id==1}">	
				<span id="bianji">编辑</span>			
			</c:if>	
			<span id="quxiao"></span>
		</div>
	<div class="test_box" >	
		<form action="${ ctx}/interface/saveDo.do" method="post" id="saveOrUpdate">
		<input type="hidden" name="id" value="${id }" id="id">
		<div class="whether_realize">			
			<label for="">是否实现：</label>
			<%-- <div><input name="status" type="radio" value="0"  <c:if test="${bean.status==0 }">checked="checked"</c:if> />	未实现</div>
			<div><input name="status" type="radio" value="1" <c:if test="${bean.status==1 }">checked="checked"</c:if> />	已实现</div>			 --%>
			<div><input name="status" type="checkbox"  <c:if test="${bean.status==0 }">checked="checked"</c:if> value="0" />	未实现</div>
		</div>
		<div class="proName" >
			<label for="">项目名：</label>
			<textarea name="proName" id="" cols="30" rows="10"  value="${bean.proName}">${bean.proName }</textarea>
		</div>
		<div class="interName">
			<label for="">接口名：</label>
			<textarea name="interName" id="" cols="30" rows="10"  value="${bean.interName}">${bean.interName }</textarea>
		</div>
		<div class="functional_description">
			<label for="">功能描述：</label>
			<textarea name="content" id="" cols="30" rows="10"  value="${bean.content}">${bean.content }</textarea>
		</div>
		<div class="request_description">
			<label for="">请求url：</label>
			<textarea name="url" id="" cols="30" rows="10" value="${bean.url}">${bean.url }</textarea>
		</div>
		<div class="request_mode">
			<label for="">请求方式：</label>
			<textarea name="type" id="" cols="30" rows="10" value="${bean.type}">${bean.type }</textarea>
		</div>
		<%-- <div class="request_data">
			<label for="">请求数据：</label>
			<textarea name="" id="" cols="30" rows="10" value="${bean.requeData}">${bean.requeData }</textarea>
		</div> --%>
		<div class="new_request_explain" data-id="1">
			<div>请求参数说明：</div>
			<div class="popup" style="display: block;">
				<!-- <div>编辑</div> -->
				<div>新增</div>
			</div>
			<ul class="title">
				<li>ID</li>
				<li>字段名称</li>
				<li>字段类型</li>
				<li>是否允许空</li>
				<li>说明</li>
				<li>锁定</li>
				<li>排序值</li>
				<li class="popupbox">操作</li>
			</ul>
			<c:forEach items="${req }" var="re">
				<ul class="value">
				<li><input type="hidden" name="requeIds" value="${re.id }">${re.id }</li>
				<li>
					<input type="text" name="reqNames" value="${re.reqName }">					
				</li>
				<li>
					<%-- <input type="text" name="reqTypes" value="${re.reqType }"> --%>
					<select name="reqTypes">
						<c:forEach items="${types }" var="t">
							<option value="${t.name }" <c:if test="${re.reqType==t.name }">selected="selected"</c:if> >${t.name }</option>
						</c:forEach>						
					</select>
				</li>
				<li><input type="text" name="reqIsnulls" value="${re.reqIsnull }"></li>
				<li><input type="text" name="reqContents" value="${re.reqContent }"></li>
				<li><input type="text"></li>
				<li><input type="text"></li>				
				<%-- <li class="del" data-id="${re.id }">删除</li> --%>
				<li><span class="bc">增加</span>&nbsp;<span class="del" data-id="${re.id }">删除</span></li>
			</ul>
			</c:forEach>
			<input type="hidden" id="reqLen" value="${reqMaxId}">			
			<!-- <ul class="value">
				<li><input type="hidden" name="requeIds" value="1">1</li>
				<li><input type="text" name="reqNames"></li>
				<li><input type="text" name="reqTypes"></li>
				<li><input type="text" name="reqIsnulls"></li>
				<li><input type="text" name="reqContents"></li>
				<li><input type="text"></li>
				<li><input type="text"></li>
				<li class="del">删除</li>
			</ul> -->
			<div class="data">
				<label for="">请求数据：</label>
				<textarea name="requeData" id="" cols="30" rows="10" value="${bean.requeData}">${bean.requeData }</textarea>
			</div>
		</div>
		<div class="new_request_explain" data-id="2">
			<div>返回参数说明：</div>
			<div class="popup" style="display: block;">
				<!-- <div>编辑</div> -->
				<div>新增</div>
			</div>
			<ul class="title">
				<li>ID</li>
				<li>字段名称</li>
				<li>字段类型</li>
				<li>是否允许空</li>
				<li>说明</li>
				<li>锁定</li>
				<li>排序值</li>
				<li class="popupbox">操作</li>               
			</ul>
			<c:forEach items="${retu }" var="re">
			<ul class="value">
				<li><input type="hidden" name="retuIds" value="${re.id }">${re.id }</li>
				<li>
					<input type="text" name="retuNames" value="${re.retuName }">					
				</li>
				<li>
					<!-- <select name="reqNames"></select> -->
					<%-- <input type="text" name="retuTypes" value="${re.retuType }"> --%>
					<select name="retuTypes">
						<c:forEach items="${types }" var="t">
							<option value="${t.name }" <c:if test="${re.retuType==t.name }">selected="selected"</c:if> >${t.name }</option>
						</c:forEach>						
					</select>
				</li>
				<li><input type="text" name="retuIss" value="${re.retuIs }"></li>
				<li><input type="text" name="retuContents" value="${re.retuContent }"></li>
				<li><input type="text"></li>
				<li><input type="text"></li>
				<li><span class="bc" onclick="add()">增加</span>&nbsp;<span class="del" data-id="${re.id }">删除</span></li>
				<%-- <li class="del" data-id="${re.id }">删除</li> --%>
			</ul>
			</c:forEach>
			<input type="hidden" id="retuLen" value="${retuMaxId}">			
			<!-- <ul class="value">
				<li><input type="hidden" name="retuIds" value="1">1</li>
				<li><input type="text" name="retuNames"></li>
				<li><input type="text" name="retuTypes"></li>
				<li><input type="text" name="retuIss"></li>
				<li><input type="text" name="retuContents"></li>
				<li><input type="text"></li>
				<li><input type="text"></li>
				<li class="del">删除</li>
			</ul> -->
			<div class="data">
				<label for="">返回数据：</label>
				<textarea value="${bean.returnData}" name="returnData" id="typeId" cols="30" rows="10"  onpropertychange="this.style.height=this.scrollHeight + 'px'" oninput="this.style.height=this.scrollHeight + 'px'">
  ${bean.returnData }</textarea>
			</div>
			<div class="functional_description x">
            <label for="">备注/说明：</label>
            <textarea name="" id="" cols="30" rows="10"></textarea>
		</div>
		</form>
		
       <div class="baocun">
            <div id="tuisong" data-id="${id }">推送</div>
            <!-- <div>保存</div> -->
        </div>
	</div>
	<script>
		$(window.parent.document).find("#iframepage").load(function () {
		    var main = $(window.parent.document).find("#iframepage");
		    var thisheight = $(document).height() + 30;
		    main.height(thisheight);
		});		
		/* 点击推送 */
		$(".baocun").on("click","#tuisong",function(e){			
			var id=$(this).attr("data-id");
			//alert("推送"+id);
			window.location.href = '${ctx}' + "/interface/tsPage.do?id="+id;
		})
		$(".new_request_explain").on("click",".value .bc",function(e){
				console.log('1111')
		})
		$(".new_request_explain").on("click",".value .del",function(e){
			if($(this).parents(".new_request_explain").attr("data-id") == 1){
				/* alert("请求"+$(this).attr("data-id")) */
				$.ajax({
            //几个参数需要注意一下
                type: "GET",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "delReq.do" ,//url
                data:{id:$(this).attr("data-id")},
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.status==1) {
                       
                    }else{
                    	 alert("error");
                    }
                    ;
                },
               /*  error : function() {
                    alert("异常！");
                } */
            });
			console.log(this)
		/* 	$(this).parent().remove(); */
		$(this).parents(".value").remove();
			}
			if($(this).parents(".new_request_explain").attr("data-id") == 2){
				/* alert("返回"+$(this).attr("data-id")) */
				$.ajax({
            //几个参数需要注意一下
                type: "GET",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "delRetu.do" ,//url
                data:{id:$(this).attr("data-id")},
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.status==1) {
                       
                    }else{
                    	 alert("error");
                    }
                    ;
                },
              /*   error : function() {
                    alert("异常！");
                } */
            });
				console.log(this)
				$(this).parents(".value").remove();
			}
			/* console.log(this)
			$(this).parent().remove(); */
		})
		if($("#reqLen").val()>0){
			var htmlnum1 = parseInt($("#reqLen").val())+1;
		}else{
			var htmlnum1 = 1;
		}
		if($("#retuLen").val()>0){
			var htmlnum2 = parseInt($("#retuLen").val())+1;
		}else{
			var htmlnum2 = 1;
		}		
		$(".new_request_explain .popup >div").click(function(){
			var _this =$(this);
			if (_this.parents(".new_request_explain").attr("data-id") == 1) {
				htmlnum = htmlnum1++;
				var html = '<ul class="value"><li><input type="hidden" name="requeIds" value="'+ htmlnum +'">'+ htmlnum +'</li><li><input type="text" name="reqNames"></li><li><select name="reqTypes">';
			}else{				
				htmlnum = htmlnum2++;
				var html = '<ul class="value"><li><input type="hidden" name="retuIds" value="'+ htmlnum +'">'+ htmlnum +'</li><li><input type="text" name="retuNames"></li><li><select name="retuTypes">';
			}
			$.ajax({
            //几个参数需要注意一下
                type: "get",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "http://localhost:8077/lessismoreback/paramType/ajaxGet.do",//url
                success: function (result) {
                   	for( let value of result.data){
                   		html += '<option value="'+value.name+'">' + value.name + '</option>'
                   	}
                   	html += '</select></li><li><input type="text" name="reqIsnulls"></li><li><input type="text" name="reqContents"></li><li><input type="text"></li><li><input type="text"></li><li><span class="bc">保存</span>&nbsp;<span class="del" data-id="${re.id }">删除</span></li></ul>'
                   	
                   	if (_this.html() === "新增") {
						if (_this.parents(".new_request_explain").find(".value").length === 0) {
							_this.parent().siblings(".title").after(html)
						}else{
							_this.parent().siblings(".value:last").after(html)	;
						}
					}else if (_this.html() === "编辑"){
						console.log(2)
					}
                },
                error : function() {
                    alert("异常！");
                }
            });
			/* var html = '<ul class="value"><li>'+ htmlnum +'</li><li><input type="text"></li><li><input type="text"></li><li><input type="text"></li><li><input type="text"></li><li><input type="text"></li><li><input type="text"></li><li class="del">删除</li></ul>'; */			
			
		})
		//页面默认为只读状态
		var textLength=$("textarea").size();
			var inputLength=$(".value input").size();
  			console.log(1111111+" "+textLength+" "+inputLength);
  			for (var i=0;i<textLength;i++){
				$("textarea").attr("disabled",true);
			}
			for (var i=0;i<inputLength;i++){
				$("input").attr("readonly",true);
			}				
		//取消
		$("#quxiao").click(function(){
			var inputLength=$(".value input").size();
			for (var i=0;i<textLength;i++){
				$("textarea").attr("disabled",true);
			}
			for (var i=0;i<inputLength;i++){
				$("input").attr("readonly",true);
			}
			$("#bianji").html("编辑");
			$("#quxiao").html("");
		});
		//进入可编辑
		$("#bianji").click(function(){
			if($("#bianji").html()=="确定"){				
				var idValue=$("#id").val();				
				$.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "saveDo.do" ,//url
                data: $('#saveOrUpdate').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.status==1) {
                        alert("SUCCESS");
                    }
                    ;
                },
                error : function() {
                    alert("异常！");
                }
            });
			}else{
				var textLength=$("textarea").size();
			var inputLength=$(".value input").size();
  			console.log(1111111+" "+textLength+" "+inputLength);
  			for (var i=0;i<textLength;i++){
				$("textarea").attr("disabled",false);
			}
			for (var i=0;i<inputLength;i++){
				$("input").attr("readonly",false);
			}
			$("#bianji").html("确定");
			$("#quxiao").html("取消");
			}
		});
	</script>
</body>
</html>