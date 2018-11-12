<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/commons/commons.jsp"%>
<!DOCTYPE html>

<head>
    <meta charset="utf-8" />
    <title>Data Tables</title>
	<script type="text/javascript">
		var save =function(){
		if(!$('#name').val()){
			warningAlert("请输入公司名称");
			return;
		}		
		if(!$('#telephone').val()){
			warningAlert("请输入电话号码");
			return;
		}	
		if(!$('#phone').val()){
			warningAlert("请输入手机");
			return;
		}	
		if(!$('#qq').val()){
			warningAlert("请输入QQ");
			return;
		}	
		if(!$('#subway').val()){
			warningAlert("请输入地铁");
			return;
		}	
		if(!$('#address').val()){
			warningAlert("请输入地址");
			return;
		}	
		$("#picUpload").ajaxSubmit(function(result) {
			  if(result.status == 1){
				  window.location.href = '${ctx}' + "/info/list.do";
			  }else{
				  warningAlert(result.message[0].msg);
			  }
		});
	}
	</script>
    
</head>
<!-- /Head -->
<!-- Body -->
<body>
  
                <!-- Page Body -->
                <div class="page-body">
                  
                    <div class="row">
                        <div class="col-xs-12 col-md-12">
                            <div class="widget">
                                <div class="widget-header ">
                                    <span class="widget-caption">编辑公司地址</span>
                                   
                                </div>
                                <div class="widget-body">
                                    
                                    <form id="picUpload" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ pageContext.request.contextPath }/info/update.do">
                                            <input type="hidden" name="id"  id="id" value="${bean.id }"/>

                                          
                                            <div class="form-group">
                                                <label for="inputEmail3" class="col-sm-2 control-label no-padding-right">公司名称</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="name" name="name" value="${bean.name}" placeholder="公司名称"
														data-bv-notempty="true"
                                                        data-bv-notempty-message="公司名称不可为空"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">电话号码</label>
                                               <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="telephone" name="telephone" value="${bean.telephone }" placeholder="电话号码"
														data-bv-notempty="true"
                                                        data-bv-notempty-message="电话号码不可为空"/>
                                                </div>
                                            </div>                                            
                                            <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">手机</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="phone" name="phone" value="${bean.phone }" placeholder="手机"
                                                   			data-bv-notempty="true"
                                                            data-bv-notempty-message="手机不可为空"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">QQ</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="qq" name="qq" value="${bean.qq }" placeholder="QQ"
                                                    		data-bv-notempty="true"
                                                            data-bv-notempty-message="QQ不可为空" />
                                                </div>
                                            </div>
                                                                                        <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">地铁</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="subway" name="subway" value="${bean.subway }" placeholder="地铁"
                                                    		data-bv-notempty="true"
                                                            data-bv-notempty-message="地铁不可为空" />
                                                </div>
                                            </div>
                                            
                                                             <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">地址</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="address" name="address" value="${bean.address }" placeholder="地址"
                                                    		data-bv-notempty="true"
                                                            data-bv-notempty-message="地址不可为空" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <!-- <button type="submit" class="btn btn-palegreen">提交</button> -->
                                               		 <a class="btn btn-palegreen" href="javascript:save()">提交</a>
                                				<a class="btn btn-palegreen" href="${ctx}/info/list.do">返回</a>
                                                </div>
                                            </div>
                                        </form>
                                      
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Page Body -->
            </div>
            <!-- /Page Content -->
        </div>
        <!-- /Page Container -->
        <!-- Main Container -->

    </div>

</body>
<!--  /Body -->

</html>
