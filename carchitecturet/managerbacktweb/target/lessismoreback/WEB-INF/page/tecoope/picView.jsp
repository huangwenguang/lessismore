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
                    <form id="saveOrUpdate" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ ctx}/typePic/save.do">
                    	<input type="hidden" id = "id" name="id" value="${bean.id }"/>   
                    	 <input type="hidden"  name="foid" id="forId" value="${foid}"/>                  	                    	
                    	<c:if test="${empty bean.id}">                    		                            	                     	   
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">公司图片</label>
	                        	<div class="col-sm-10">
	                        		<input type="file" class="file" id="file" name="file" 
	                        				placeholder="公司logo" data-bv-notempty="true" data-bv-notempty-message="公司logo不能为空" />
	                        	</div>	                        	
                        	</div>                          	                 
                        </c:if>
                        <c:if test="${!empty bean.id}">                        	                       	                  	
                        	<div class="form-group">
	                        	<label for="inputEmail3" class="col-sm-2 control-label no-padding-right">公司logo</label>
	                        	<div class="col-sm-10">
	                        		<%-- <img alt="暂无照片" src="${urls[1]}">	 --%>
	                        		<input type="file" class="file" id="file" name="file" 
	                        				placeholder="公司logo" data-bv-notempty="true" data-bv-notempty-message="公司logo不能为空" />
	                        	</div>	                        
                        	</div>                            	                 
                        </c:if>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <a class="btn btn-palegreen" href="javascript:save()">提交</a>
                                <a class="btn btn-palegreen" href="${ctx}/typePic/list.do?foid=${foid}">返回</a>
                              
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
			warningAlert("请输入公司logo");
			return;
		}		
		$("#saveOrUpdate").ajaxSubmit(function(result) {			
			  if(result.status == 1){
				  window.location.href = '${ctx}' + "/typePic/list.do?foid="+$("#forId").val();
			  }else{
				  warningAlert(result.message[0].msg);
			  }
		});
	}

</script>
</html>
