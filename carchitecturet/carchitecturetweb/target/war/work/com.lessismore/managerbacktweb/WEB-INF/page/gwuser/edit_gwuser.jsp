<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/commons/commons.jsp"%>
<!DOCTYPE html>

<head>
    <meta charset="utf-8" />
    <title>Data Tables</title>
	<script type="text/javascript">
		var save =function(){						
			$("#picUpload").ajaxSubmit(function(result) {			
				  if(result.status == 1){
					  window.location.href = '${ctx}' + "/gwUserMgt/list.do";
				  }else{
					  warningAlert(result.message[0].msg);
				  }
			});
		}
		$(function(){
			if($("#isvisit option:eq(2)").val()==$("#isvisit option:eq(0)").val()){
				$("#isvisit option:eq(2)").remove();
			}
			if($("#isvisit option:eq(2)").val()==$("#isvisit option:eq(1)").val()){
				$("#isvisit option:eq(2)").remove();
			}	
			var eqZero=$("#sincerity option:eq(0)");
			var eqOne=$("#sincerity option:eq(1)");
			var eqTwo=$("#sincerity option:eq(2)");
			var eqThree=$("#sincerity option:eq(3)");
			var eqFor=$("#sincerity option:eq(4)");
			var eqFive=$("#sincerity option:eq(5)");							
			if(eqZero.val()==""||eqZero.val()==null){
				eqZero.html("--请选择--");
			}	
			if($.trim(eqZero.val())==$.trim(eqOne.val())){
				var oneNu=eqOne.html();
				eqZero.html(oneNu);
				eqOne.remove();
			}
			if($.trim(eqZero.val())==$.trim(eqTwo.val())){
				var twoNu=eqTwo.html();
				eqZero.html(twoNu);
				eqTwo.remove();
			}
			if($.trim(eqZero.val())==$.trim(eqThree.val())){
				var threeNu=eqThree.html();
				eqZero.html(threeNu);
				eqThree.remove();
			}		
			if($.trim(eqZero.val())==$.trim(eqFor.val())){
				var forNu=eqFor.html();
				eqZero.html(forNu);
				eqFor.remove();
			}	
			if($.trim(eqZero.val())==$.trim(eqFive.val())){
				var fiveNu=eqFive.html();
				eqZero.html(fiveNu);
				eqFive.remove();
			}		
		});
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
                                    <span class="widget-caption">编辑官网用户</span>
                                   
                                </div>
                                <div class="widget-body">
                                    
                                    <form id="picUpload" class="form-horizontal form-bordered" role="form" enctype="multipart/form-data" method="post" action="${ pageContext.request.contextPath }/gwUserMgt/update.do">
                                            <input type="hidden" name="id"  id="id" value="${gwuser.id }"/>

                                          
                                            <div class="form-group">
                                                <label for="inputEmail3" class="col-sm-2 control-label no-padding-right">微信号</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="weixin" name="weixin" value="${gwuser.weixin}" placeholder="微信号"
														data-bv-notempty="true"
                                                        data-bv-notempty-message="微信号名称不可为空"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">QQ</label>
                                               <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="qq" name="qq" value="${gwuser.qq }" placeholder="QQ"
														data-bv-notempty="true"
                                                        data-bv-notempty-message="QQ名称不可为空"/>
                                                </div>
                                            </div>                                            
                                            <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">是否回访</label>
                                                <div class="col-sm-10">
                                                   <%--  <input type="text" class="form-control" id="isvisit" name="isvisit" value="${gwuser.isvisit }" placeholder="是否回访"
                                                   			data-bv-notempty="true"
                                                            data-bv-notempty-message="回访不可为空"/> --%>
                                               		<select name="isvisit" id="isvisit" class="form-control" >
                                               			<option value="1">是</option>
                                               			<option value="2">否</option>
                                               			<option value="${gwuser.isvisit }" selected="selected">${gwuser.isvisit==1?"是":gwuser.isvisit==2?"否":"--请选择--"}</option>
                                               		</select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">诚意度</label>
                                                <div class="col-sm-10">
                                                    <%-- <input type="text" class="form-control" id="sincerity" name="sincerity" value="${gwuser.sincerity }" placeholder="诚意度"
                                                    		data-bv-notempty="true"
                                                            data-bv-notempty-message="诚意度不可为空" /> --%>
                                                	<select id="sincerity" name="sincerity">
                                                		<option value="${gwuser.sincerity }" selected="selected"></option>
                                                		<option value="优">90以上</option>
                                                		<option value="良">80~90</option>
                                                		<option value="中">70~80</option>
                                                		<option value="及格">60~70</option>
                                                		<option value="差">60以下</option>                                                		
                                                	</select>
                                                </div>
                                            </div>
                                                                                        <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">回访结果</label>
                                                <div class="col-sm-10">
                                                    <%-- <input type="text" class="form-control" id="visitresult" name="visitresult" value="${gwuser.visitresult }" placeholder="回访结果"
                                                    		data-bv-notempty="true"
                                                            data-bv-notempty-message="回访结果不可为空" /> --%>
                                                            <textarea rows="4" cols="150" id="visitresult" name="visitresult">${gwuser.visitresult }</textarea>
                                                </div>
                                            </div>
                                            
                                                             <div class="form-group">
                                                <label for="inputPassword3" class="col-sm-2 control-label no-padding-right">回访时间</label>
                                                <div class="col-sm-10">
                                                   <%--  <input type="date" class="form-control" id="visitTimee" name="visitTimee" value="<fmt:formatDate value="${gwuser.visitTime }" type="date" pattern="yyyy-MM-dd HH:mm" />" placeholder="回访时间"
                                                    		data-bv-notempty="true"
                                                            data-bv-notempty-message="回访时间不可为空" /> --%>
                                                	<input type="date" class="form-control" id="visitTimee" name="visitTimee"  value="${visitTimee }" placeholder="回访时间"
                                                    		data-bv-notempty="true"
                                                            data-bv-notempty-message="回访时间不可为空" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <!-- <button type="submit" class="btn btn-palegreen">提交</button> -->
                                               			 <a class="btn btn-palegreen" href="javascript:save()">提交</a>
                                						<a class="btn btn-palegreen" href="${ctx}/gwUserMgt/list.do">返回</a>
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
