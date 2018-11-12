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
        				修改密码
                    </span>
                   
                </div>
                <div class="widget-body">
                    <form id="saveOrUpdate" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ ctx}/adminMgt/replace.do">
                    	<input type="hidden" name="id" value="${bean.id }"/>                    	
                        <div class="form-group">
	                         <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">原密码</label>
	                         <div class="col-sm-10">
	                             <input type="password" class="form-control"   value="${bean.userPwd }" placeholder="原密码"
	                           			data-bv-notempty="true"
	                                    data-bv-notempty-message="密码不能为空"/>
                            </div>
                        </div>   
                        <div class="form-group">
	                         <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">新密码</label>
	                         <div class="col-sm-10">
	                             <input type="password" class="form-control" id="userPwd" name="userPwd"  placeholder="新密码"
	                           			data-bv-notempty="true"
	                                    data-bv-notempty-message="新密码不能为空"/>
                            </div>
                        </div>                       
                        	<div class="form-group">
	                         <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">确认密码</label>
	                         <div class="col-sm-10">
	                             <input type="password" class="form-control" id="submitUserPwd" name="newUserPwd" placeholder="确认密码"
	                           			data-bv-notempty="true"
	                                    data-bv-notempty-message="确认密码不能为空"/>
                            </div>
                        </div>                                                        
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <a class="btn btn-palegreen" href="javascript:save()">提交</a>
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
		if(!$('#userPwd')){
			warningAlert("请输入密码"); 
			return;
		}	
		if(!$('#submitUserPwd')){
			warningAlert("请输入确认密码"); 
			return;
		}		
		
			/* $("#saveOrUpdate").ajaxSubmit(function(result) {
				  if(result.status == 1){
					  window.location.href = '${ctx}' + "/adminMgt/list.do";
				  }else{
					  warningAlert(result.message[0].msg);
				  }
				});
			return false; */
			$("#saveOrUpdate").ajaxSubmit(function(result) {
				  if(result.status == 1){
					  //window.location.href = '${ctx}' + "/adminMgt/list.do";
					   warningAlert("修改成功");					  
				  }else{
					  warningAlert(result.message[0].msg);
				  }
				});
		}
	

</script>
</html>
