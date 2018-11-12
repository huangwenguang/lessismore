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
                    <form id="saveOrUpdate" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ ctx}/share/save.do">
                    	<input type="hidden" id = "id" name="id" value="${bean.id }"/>                    	                    	
                    	<c:if test="${empty bean.id}">                    		    
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">标题</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="title" name="title" 
	                        				placeholder="标题" data-bv-notempty="true" data-bv-notempty-message="标题不能为空" />
	                        	</div>	                        	
                        	</div>                          	                          	    
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">logo</label>
	                        	<div class="col-sm-10">
	                        		<input type="file" class="file" id="file" name="file" 
	                        				placeholder="logo" data-bv-notempty="true" data-bv-notempty-message="logo不能为空" />
	                        	</div>	                        	
                        	</div>  
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">描述</label>
	                        	<div class="col-sm-10">	                        		
	                        		<textarea rows="5" cols="70" id="content" name="content" 
	                        		placeholder="描述" data-bv-notempty="true" data-bv-notempty-message="描述不能为空"></textarea>
	                        	</div>	                        	
                        	</div> 
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">url</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="url" name="url" 
	                        				placeholder="url" data-bv-notempty="true" data-bv-notempty-message="url不能为空" />
	                        	</div>	                        	
                        	</div>  
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">类型</label>
	                        	<div class="col-sm-10">
	                        		<select name="type">
	                        			<option value="1" selected="selected">朋友圈</option>
	                        			<option value="2">微信朋友</option>
	                        			<option value="3">微博</option>
	                        			<option value="4">QQ空间</option>
	                        			<option value="5">QQ</option>
	                        		</select>
	                        	</div>	                        	
                        	</div>   
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">平台</label>
	                        	<div class="col-sm-10">
	                        		<select name="platform">
	                        			<option value="1" selected="selected">ios</option>
	                        			<option value="2">android</option>
	                        			<option value="3">PC</option>
	                        			<option value="4">H5</option>	                        			
	                        		</select>
	                        	</div>	                        	
                        	</div>                   	
                        </c:if>
                        <c:if test="${!empty bean.id}">
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">标题</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="title" name="title" value="${bean.title}"
	                        				placeholder="标题" data-bv-notempty="true" data-bv-notempty-message="标题不能为空" />
	                        	</div>	                        	
                        	</div>                          	                          	    
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">logo</label>
	                        	<div class="col-sm-10">
	                        		<%-- <img alt="暂无照片" src="${urls[1]}">	 --%>
	                        		<input type="file" class="file" id="file" name="file" 
	                        				placeholder="logo" data-bv-notempty="true" data-bv-notempty-message="logo不能为空" />
	                        	</div>	                        	
                        	</div>  
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">描述</label>
	                        	<div class="col-sm-10">	                        		
	                        		<textarea rows="5" cols="70" id="content" name="content"  value="${bean.content}"
	                        		placeholder="描述" data-bv-notempty="true" data-bv-notempty-message="描述不能为空">${bean.content}</textarea>
	                        	</div>	                        	
                        	</div> 
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">url</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="url" name="url"  value="${bean.url}"
	                        				placeholder="url" data-bv-notempty="true" data-bv-notempty-message="url不能为空" />
	                        	</div>	                        	
                        	</div>  
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">类型</label>
	                        	<div class="col-sm-10">
	                        		<select name="type">
	                        			<option value="1" <c:if test="${bean.type==1}">selected="selected"</c:if> >朋友圈</option>
	                        			<option value="2" <c:if test="${bean.type==2}">selected="selected"</c:if> >微信朋友</option>
	                        			<option value="3" <c:if test="${bean.type==3}">selected="selected"</c:if> >微博</option>
	                        			<option value="4" <c:if test="${bean.type==4}">selected="selected"</c:if> >QQ空间</option>
	                        			<option value="5" <c:if test="${bean.type==5}">selected="selected"</c:if> >QQ</option>
	                        		</select>
	                        	</div>	                        	
                        	</div>   
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">平台</label>
	                        	<div class="col-sm-10">
	                        		<select name="platform">
	                        			<option value="1" <c:if test="${bean.platform==1}">selected="selected"</c:if> >ios</option>
	                        			<option value="2" <c:if test="${bean.platform==2}">selected="selected"</c:if> >android</option>
	                        			<option value="3" <c:if test="${bean.platform==3}">selected="selected"</c:if> >PC</option>
	                        			<option value="4" <c:if test="${bean.platform==4}">selected="selected"</c:if> >H5</option>	                        			
	                        		</select>
	                        	</div>	                        	
                        	</div>                   	
                        </c:if>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <a class="btn btn-palegreen" href="javascript:save()">提交</a>
                                <a class="btn btn-palegreen" href="${ctx}/share/list.do">返回</a>
                              
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
	$(document).ready(function () {
	    $('#picUpload').bootstrapValidator();	   
	});	  
	var save =function(){		
		if(!$("#id").val()&&!$('#file').val()){
			warningAlert("请输入logo");
			return;
		}
		if(!$('#title').val()){
			warningAlert("请输入标题内容");
			return;
		}
		if(!$('#content').val()){
			warningAlert("请输入描述内容");
			return;
		}
		if(!$('#url').val()){
			warningAlert("请输入url内容");
			return;
		}		
		$("#saveOrUpdate").ajaxSubmit(function(result) {			
			  if(result.status == 1){
				  window.location.href = '${ctx}' + "/share/list.do";
			  }else{
				  warningAlert(result.message[0].msg);
			  }
		});
	}

</script>
</html>
