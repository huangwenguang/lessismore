<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>官网管理</title>
</head>

<body>
	<form action="${ctx }/info/list.do" id="submit-form">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">公司地址</span>
					</div>					                                         
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
								    <th>编号</th>
									<th>公司名称</th>
									<th>电话号码</th>
									<th>手机号码</th>									
									<th>QQ</th>
									<th>地铁</th>
									<th>地址</th>									
									<th>操作</th>
								
								</tr>
							</thead>
							<tbody>
								 <c:forEach items="${pagination.rows }" var="item">
                                      	   <%--  <input type="hidden" name="id" value="${"lottery.openTime }"/> --%>
                                            <tr>
	                                 <td>${item.id }</td>
                                     <td>${item.name }</td>
                                     <td>${item.telephone }</td>                                  
                                   <td>${item.phone }</td>
									<td>${item.qq }</td>
									<td>${item.subway }</td>
									<td>${item.address }</td>															
                             <td><a href="${ctx }/info/edit.do?id=${item.id}" class="btn btn-info btn-xs edit"><i class="fa fa-edit"></i>编辑</a>
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

</body>
<script type="text/javascript">
	function search(){
		$("#submit-form").submit();
	}
	
</script>
</html>