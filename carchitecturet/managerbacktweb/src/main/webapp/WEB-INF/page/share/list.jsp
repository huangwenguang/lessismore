<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>平台分享</title>
</head>

<body>
	<form action="${ctx }/share/list.do" id="submit-form">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">平台分享</span>
					</div>
					<%-- <div class="widget-body">
                        <div class="controls">
                             <div class="input-group">
								<input class="form-control" style="width:200px;margin-right: 5px;"  name="name" value="${bean.name}">
									
								<button type="submit" class="btn btn-default" style="height:34px" onClick="search()">搜索</button>
                             </div>
                    	</div>
                    </div>	 --%>				                    
                      <div class="table-toolbar">
						<a id="editabledatatable_new" href="${ctx }/share/add.do"
							class="btn btn-default">添加分享信息</a>
					</div>
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
								    <th>编号</th>								   
									<th>标题</th>
									 <th>LOGO</th>	
									 <th>描述</th>																								
									<th>url</th>	
									<th>类型</th>		
									<th>平台</th>	
									<th>状态</th>	
									<th>操作</th>															
								</tr>
							</thead>
							<tbody>								 
								 <c:forEach items="${pagination.rows }" var="item" varStatus="status">
								 <tr>                                      	                                             
				                     <td>${item.id }</td>                                  	 
			                         <td>${item.title }</td>  
			                          <td>
			                          		<img alt="暂无照片" src="${urls[status.index][0]}">
			                          </td>
			                          <td>${item.content }</td>	 
			                          <td>${item.url }</td>           
			                          <td>
			                          		<c:if test="${item.type==1}">朋友圈</c:if>
			                          		<c:if test="${item.type==2}">微信朋友</c:if>
			                          		<c:if test="${item.type==3}">微博</c:if>
			                          		<c:if test="${item.type==4}">QQ空间</c:if>
			                          		<c:if test="${item.type==5}">QQ</c:if>			                          		
			                          </td>   
			                          <td>
			                          		<c:if test="${item.platform==1}">ios</c:if>
			                          		<c:if test="${item.platform==2}">android</c:if>
			                          		<c:if test="${item.platform==3}">PC</c:if>
			                          		<c:if test="${item.platform==4}">H5</c:if>
			                          </td> 
			                          <td>
			                          		<c:if test="${item.state==1}">已开启</c:if>
			                          		<c:if test="${item.state==0}">已关闭</c:if>
			                          </td>                    			                                                                                                                                  									                                                                                                        
                                      <td>
		                                  <a href="javascript:void(0)" class="btn btn-info btn-xs edit" onclick="edit('user','${item.id}')"><i class="fa fa-edit"></i>编辑</a>
		                              	  <a href="javascript:void(0)" class="btn btn-danger btn-xs delete" onclick="del('user','${item.id}')"><i class="fa fa-trash-o"></i>删除</a>
                                     	  <c:if test="${item.state == 1}">
	                         					<a href="javascript:void(0)"  class="btn btn-info btn-xs edit" onclick="lock('user','${item.id}')"><i class="fa fa-lock"></i>冻结</a>
	                         			  </c:if>
	                                      <c:if test="${item.state ==0}">
	                         					<a href="javascript:void(0)"  class="btn btn-info btn-xs edit" onclick="lock('user','${item.id}')"><i class="fa fa-unlock"></i>解冻</a>
	                         			  </c:if>
                                      </td>                                            
                                  </tr>   
                                 </c:forEach>
 							</tbody>
						</table>
						<%@include file="../commons/page.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</form>
<script src="${ctx }/js/share/list.js"></script>
</body>
<script type="text/javascript">
	function search(){
		$("#submit-form").submit();
	}
	
</script>
</html>