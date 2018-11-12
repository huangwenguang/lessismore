<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/commons/commons.jsp"%>
<!DOCTYPE html>

<head>
    <meta charset="utf-8" />
    <title>Data Tables</title>
	<script type="text/javascript">
		var save =function(){
		if(!$('#content').val()){
			warningAlert("请输入内容");
			return;
		}		
		$("#picUpload").ajaxSubmit(function(result) {
			  if(result.status == 1){
				  window.location.href = '${ctx}' + "/company/list.do";
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
                                    <span class="widget-caption">编辑</span>
                                   
                                </div>
                                <div class="widget-body">
                                    
                                    <form id="picUpload" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ pageContext.request.contextPath }/company/update.do">
                                            <input type="hidden" name="id"  id="id" value="${bean.id }"/>                                          
                                            <div class="form-group">
                                                <label for="inputEmail3" class="col-sm-2 control-label no-padding-right">公司简介</label>
                                                <div class="col-sm-10">
                                                    <%-- <input type="text" class="form-control" id="content" name="content" value="${company.content}" placeholder="公司简介"
														data-bv-notempty="true"
                                                        data-bv-notempty-message="公司简介不可为空"/> --%>
                                                   <textarea rows="4" cols="20" class="form-control" id="content" name="content" placeholder="内容编辑" data-bv-notempty="true" 
                                                   	 data-bv-notempty-message="公司简介不可为空"
                                                   >${bean.content}</textarea>
                                                </div>
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <!-- <button type="submit" class="btn btn-palegreen">提交</button> -->                                                    
                                               	 <a class="btn btn-palegreen" href="javascript:save()">提交</a>
                                				<a class="btn btn-palegreen" href="${ctx}/company/list.do">返回</a>
                                                </div>
                                            </div>           
                                                                                                                        
                                            <div class="form-group">
                                                
                                            
                                        </form>    
                                                                       
                                        <form action="${ pageContext.request.contextPath }/company/uploadPic.do" method="post" enctype="multipart/form-data">
                                        	<input type="hidden" name="id"  id="id" value="${bean.id }"/>  
	                                         <div class="form-group">
	                                                <label for="inputEmail3" class="col-sm-2 control-label no-padding-right">公司图片上传</label>                                               
	                                                <div class="col-sm-10"> 	                                                	                                                 
															<input type="file" name="file"><br>
															<input type="file" name="file"><br>
															<input type="file" name="file"><br>
															<input type="file" name="file"><br>
															<input type="file" name="file">		
															<input class="btn btn-palegreen" type="submit" value="上传">																								
	                                                </div>
	                                            </div>  
                                           </form>   
                                        </div>                                   
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Page Body -->
           
            <!-- /Page Content -->
        
        <!-- /Page Container -->
        <!-- Main Container -->

   

</body>
<!--  /Body -->

</html>
