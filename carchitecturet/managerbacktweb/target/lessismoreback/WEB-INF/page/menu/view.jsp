<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>

<head>
    <meta charset="utf-8" />
    <title>Data Tables</title>
</head>
<body>
<div class="page-body">
    <div class="row">
        <div class="col-xs-12 col-md-12">
            <div class="widget">
                <div class="widget-header ">
                    <span class="widget-caption">
        				<c:if test="${empty bean.id}">新增</c:if>   
                    	<c:if test="${!empty bean.id}">编辑</c:if>
                    </span>
                </div>               
               
                <div class="widget-body">                	                                           
                    <form id="saveOrUpdate" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ ctx}/menu/saveDo.do">
                    	<input type="hidden" id = "id" name="id" value="${bean.id }"/>   
						<input type="hidden" id = "maxId" name="maxId" value="${maxId }"/>                       	                 	                    	
                    	<c:if test="${empty bean.id}">                    		    
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">菜单名称</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="name" name="name" 
	                        				placeholder="菜单名称" data-bv-notempty="true" data-bv-notempty-message="菜单名称不能为空" />
	                        	</div>
	                        	
                        	</div>  
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">菜单url</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="url" name="url" 
	                        				placeholder="菜单url" data-bv-notempty="true" data-bv-notempty-message="菜单url不能为空" />
	                        	</div>
	                        	
                        	</div> 
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">父节点</label>
	                        	<div class="col-sm-10">
	                        		<select name="parentId" id="parentId1">	                       			
	                        			             			
	                        		</select>
	                        	</div>	                        	
                        	</div>   
                        	<div class="form-group" id="zijiedian" style="display: none">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">子节点</label>
	                        	<div class="col-sm-10">
	                        		<select name="parentId" id="parentId2">	                 			
	                        		</select>
	                        	</div>	                        	
                        	</div>                             	              	
                        </c:if>
                        <c:if test="${!empty bean.id}">
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">菜单名称</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="name" name="name" value="${bean.name}"
	                        				placeholder="菜单名称" data-bv-notempty="true" data-bv-notempty-message="菜单名称不能为空" />
	                        	</div>	                        	
                        	</div>  
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">菜单url</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="url" name="url" value="${bean.url}"
	                        				placeholder="菜单url" data-bv-notempty="true" data-bv-notempty-message="菜单url不能为空" />
	                        	</div>	                        	
                        	</div>   
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">父节点</label>
	                        	<div class="col-sm-10">
	                        		<select name="parentId" id="parentId1">	
	                        			                        			
	                        		</select>
	                        	</div>	                        	
                        	</div>  
                        	<div class="form-group" id="zijiedian" style="display: none">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">子节点</label>
	                        	<div class="col-sm-10">
	                        		<select name="parentId" id="parentId2">	                 			
	                        		</select>
	                        	</div>	                        	
                        	</div>                           	                   	
                        </c:if>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <a class="btn btn-palegreen" href="javascript:save()">提交</a>
                                <a class="btn btn-palegreen" href="${ctx}/menu/list.do">返回</a>
                              
                            </div>
                     	</div>
                 	</form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
		$("#parentId1").change(function () {
		
			if($("#parentId1").find("option:selected").html()  == '接口管理'&&$("#parentId2").find("option:selected").val()  != '0'){			
			$("#url").parent().parent().css("display","none"); 			
			$("#url").val("interface/list.do?id="+$("#maxId").val());
		}
		
			if($(this).find("option:selected").val() === '0'){
				$("#zijiedian").hide()
				return false;
			}
	    		$.ajax({
		            //几个参数需要注意一下
		            type: "get",//方法类型
		            dataType: "json",//预期服务器返回的数据类型
		            data:{
		            	id:$(this).find("option:selected").val()
		            },
		            url: '${ctx}' +"/menu/getNodes.do" ,
		            success: function (result) {
		                var html1 = '<option value="0" selected="selected">无父节点--</option>';
		                for ( var i= 0 ; i < result.data.length ;i++) {
							html1 += '<option value="'+result.data[i].id +'" selected="selected">'+ result.data[i].name +'</option>'
						}
						$("#parentId2").html(html1);
						console.log($("#parentId2"))
						$("#zijiedian").show()
		            },
		            error : function() {
		                alert("异常！");
		            }
		            
		        });	   
		});   
		
		$.ajax({
            //几个参数需要注意一下
            type: "get",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: '${ctx}' +"/menu/getPars.do" ,
            success: function (result) {
                var html = '<option value="0" selected="selected">无父节点--</option>';
                for ( var i= 0 ; i < result.data.length ;i++) {
					html += '<option value="'+result.data[i].id +'">'+ result.data[i].name +'</option>'
				}
				$("#parentId1").html(html);
				console.log($("#parentId1"))
            },
            error : function() {
                alert("异常！");
            }
            
        });
        
     
	$(document).ready(function () {
	    $('#picUpload').bootstrapValidator();	   
	});
	
	
	$("#parentId2").change(function(){
		if($("#parentId1").find("option:selected").html()  == '接口管理'&&$("#parentId2").find("option:selected").val()  != '0'){			
			$("#url").parent().parent().css("display","none"); 			
			$("#url").val("interface/list.do?id="+$("#maxId").val());
		}else{
			$("#url").parent().parent().css("display","block"); 
		}
	})
	
	
	var save =function(){
		var num = 0;
		if(!$('#name').val()){
			warningAlert("请输入菜单名称");
			return;
		}
		if($("#parentId1").find("option:selected").val()  === '0'){

		}else if($("#parentId1").find("option:selected").val()  != '0'  &&   $("#parentId2").find("option:selected").val()  === '0'){
			num = $("#parentId1").find("option:selected").val()
		}else{
			num = $("#parentId2").find("option:selected").val()
		}
		/* if(!$('#url').val()){
			warningAlert("请输入url");
			return;
		} */
		//接口提交
		
		$.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: '${ctx}' +"/menu/saveDo.do" ,
            data: {
            	id:$("#id").val(),
            	name:$("#name").val(),
            	url:$("#url").val(),
            	parentId:num
            },
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if(result.status == 1){
				  window.location.href = '${ctx}' + "/menu/list.do";
				 parent.location.reload();
			  }else{
				  warningAlert(result.message[0].msg);
			  }
                
            },
            error : function() {
                alert("异常！");
            }
            
        });
        
		/* $("#saveOrUpdate").ajaxSubmit(function(result) {			
			  if(result.status == 1){
				  window.location.href = '${ctx}' + "/menu/list.do";
			  }else{
				  warningAlert(result.message[0].msg);
			  }
		}); */
	}

</script>
</html>
