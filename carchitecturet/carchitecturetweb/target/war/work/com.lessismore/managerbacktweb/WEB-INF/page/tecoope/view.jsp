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
                    <form id="saveOrUpdate" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ ctx}/tecCoope/save.do">
                    	<input type="hidden" id = "id" name="id" value="${bean.id }"/>                    	                    	
                    	<c:if test="${empty bean.id}">                    		    
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">公司名</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="companyName" name="companyName" 
	                        				placeholder="公司名" data-bv-notempty="true" data-bv-notempty-message="公司名不能为空" />
	                        	</div>
	                        	
                        	</div>                            	    
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">公司logo</label>
	                        	<div class="col-sm-10">
	                        		<input type="file" class="file" id="file" name="file" 
	                        				placeholder="公司logo" data-bv-notempty="true" data-bv-notempty-message="公司logo不能为空" />
	                        	</div>	                        	
                        	</div>  
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">合作内容</label>
	                        	<div class="col-sm-10">
	                        		<!-- <input type="text" class="form-control" id="content" name="content" 
	                        				placeholder="合作内容" data-bv-notempty="true" data-bv-notempty-message="合作内容不能为空" /> -->
	                        				<textarea rows="5" cols="70" id="content" name="content" 
	                        				placeholder="合作内容" data-bv-notempty="true" data-bv-notempty-message="合作内容不能为空"></textarea>
	                        	</div>
	                        	
                        	</div>                     	
                        </c:if>
                        <c:if test="${!empty bean.id}">
                        	<div>
                        		<input type="hidden" name="pid" value="${bean.pid }">
                        	</div>
                        	<div><input type="hidden" value="${bean.pid }"> </div>
                    		<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">公司名</label>
	                        	<div class="col-sm-10">
	                        		<input type="text" class="form-control" id="companyName" name="companyName"   value = "${bean.companyName}"
	                        				placeholder="公司名" data-bv-notempty="true" data-bv-notempty-message="公司名不能为空" />
	                        	</div>
                        	</div>  
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">公司logo</label>
	                        	<div class="col-sm-10">
	                        		<%-- <img alt="暂无照片" src="${urls[1]}"> --%>	
	                        		<input type="file" class="file" id="file" name="file" 
	                        				placeholder="公司logo" data-bv-notempty="true" data-bv-notempty-message="公司logo不能为空" />
	                        	</div>	                        
                        	</div>    
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">合作内容</label>
	                        	<div class="col-sm-10">
	                        		<!-- <input type="text" class="form-control" id="content" name="content" 
	                        				placeholder="合作内容" data-bv-notempty="true" data-bv-notempty-message="合作内容不能为空" /> -->
	                        				<textarea rows="5" cols="70" id="content" name="content" 
	                        				placeholder="合作内容" data-bv-notempty="true" data-bv-notempty-message="合作内容不能为空" value = "${bean.content}">${bean.content}</textarea>
	                        	</div>
	                        	
                        	</div>                       	
                        </c:if>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <a class="btn btn-palegreen" href="javascript:save()">提交</a>
                                <a class="btn btn-palegreen" href="${ctx}/tecCoope/list.do">返回</a>
                              
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
		if(!$('#companyName').val()){
			warningAlert("请输入公司名");
			return;
		}
		if(!$("#id").val()&&!$('#file').val()){
			warningAlert("请输入公司logo");
			return;
		}
		if(!$('#content').val()){
			warningAlert("请输入合作内容");
			return;
		}
		$("#saveOrUpdate").ajaxSubmit(function(result) {			
			  if(result.status == 1){
				  window.location.href = '${ctx}' + "/tecCoope/list.do";
			  }else{
				  warningAlert(result.message[0].msg);
			  }
		});
	}

</script>
</html>
