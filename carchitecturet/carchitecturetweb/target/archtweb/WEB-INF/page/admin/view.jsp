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
        				<c:if test="${empty id}">新增</c:if>            
                    	<c:if test="${!empty id}">编辑</c:if>
                    </span>
                   
                </div>
                <div class="widget-body">
                    <form id="saveOrUpdate" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ ctx}/adminMgt/save.do">
                    	<input type="hidden" name="id" value="${id }"/>
                    	<div class="form-group">
	                        <label for="inputEmail3" class="col-sm-2 control-label no-padding-right">用户名</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" id="userName" name="userName" value="${bean.userName }" placeholder="用户名" data-bv-notempty="true"
	                                          data-bv-notempty-message="用户名不能为空"/>
	                        </div>
                        </div>
                         <div class="form-group">
                        	<label for="inputPassword3" class="col-sm-2 control-label no-padding-right">手机号码</label>
                        	<div class="col-sm-10">
                                  <input type="text" class="form-control" id="phone" name="phone" value="${bean.phone }" placeholder="手机号码"
                                  		data-bv-notempty="true"
                                          data-bv-notempty-message="手机号码不能为空" />
                              </div>
                        </div>
                         <div class="form-group">
                        	<label for="inputPassword3" class="col-sm-2 control-label no-padding-right">email</label>
                        	<div class="col-sm-10">
                                  <input type="text" class="form-control" id="email" name="email" value="${bean.email }" placeholder="email"
                                  		data-bv-notempty="true"
                                          data-bv-notempty-message="email不能为空" />
                              </div>
                        </div>
                        <div class="form-group">
	                        <label for="inputEmail3" class="col-sm-2 control-label no-padding-right">姓名</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" id="name" name="name" value="${bean.name }" placeholder="姓名" data-bv-notempty="true"
	                                          data-bv-notempty-message="姓名不能为空"/>
	                        </div>
                        </div>
                        <div class="form-group">
	                         <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">密码</label>
	                         <div class="col-sm-10">
	                             <input type="password" class="form-control" id="userPwd" name="userPwd" value="${bean.userPwd }" placeholder="密码"
	                           			data-bv-notempty="true"
	                                    data-bv-notempty-message="密码不能为空"/>
                            </div>
                        </div>
                         <div class="form-group">
	                         <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">确认密码</label>
	                         <div class="col-sm-10">
	                             <input type="password" class="form-control" id="userPwd2" name="userPwd2" value="${bean.userPwd }" placeholder="确认密码"
	                           			data-bv-notempty="true"
	                                    data-bv-notempty-message="确认密码不能为空"/>
                            </div>
                        </div>
                       <!-- 
                        	<div class="form-group">
	                         <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">确认密码</label>
	                         <div class="col-sm-10">
	                             <input type="text" class="form-control" id="submitUserPwd"  placeholder="确认密码"
	                           			data-bv-notempty="true"
	                                    data-bv-notempty-message="确认密码不能为空"/>
                            </div>
                        </div> -->
                      
                       <!--  -->
                        <div class="form-group">
	                         <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">角色</label>
	                         <div class="col-lg-4 col-sm-4 col-xs-4">
                                 <div class="checkbox" id="test">
                                 	<c:forEach items="${roles }" var="role">
	                                 	 <label>
	                                         <input name="roleids" type="checkbox" 
	                                         	<c:if test="${role.id==1}">
	                                         			disabled="disabled"
	                                         		</c:if>
	                                         value="${role.id }" >
	                                         <span class="text">${role.roleName }</span>
	                                     </label>
                                 	</c:forEach>
                                 </div>
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
	 
	  $('#test').find('input[type=checkbox]').bind('click', function(){  
        $('#test').find('input[type=checkbox]').not(this).attr("checked", false);  
    }); 
	var save =function(){	
		if(!$('#userName').val()){
			warningAlert("请输入用户名");
			return;
		}
		if(!$('#phone').val()){
			warningAlert("请输入电话号码");
			return;
		}
		if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test($('#phone').val()))){
			warningAlert("不是完整的11位手机号或者正确的手机号前七位"); 
			return;
		}
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
		if(!$('#email').val()){
			warningAlert("请输入email");
			return;
		}	
		if(!(reg.test($('#email').val()))){
			warningAlert("请输入正确的email");
			return;
		}	
		if(!$('#name').val()){
			warningAlert("请输入姓名");
			return;
		}
		if(!$('#userPwd').val()){
			warningAlert("请输入密码");
			return;
		}
		if($('#userPwd').val().length<6){
			warningAlert("密码长度不能小于6位");
			return;
		}
		if($('#userPwd').val()!=$('#userPwd2').val()){
			warningAlert("两次密码不一致");
			return;
		}
		var chk_value =[]; 
		$('input[name="roleids"]:checked').each(function(){ 
			chk_value.push($(this).val()); 
			}); 
		if(chk_value.length == 0){
			warningAlert("请选择角色");
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
					  window.location.href = '${ctx}' + "/adminMgt/list.do";
				  }else{
					  warningAlert(result.message[0].msg);
				  }
				});
		}
	

</script>
</html>
