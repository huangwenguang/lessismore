<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>官网管理</title>
</head>

<body>
	<form action="${ctx }/company/list.do" id="submit-form">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">公司简介</span>
					</div>					                                         
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
								    <th>编号</th>
									<th>公司简介</th>									
									<th>操作</th>								
								</tr>
							</thead>
							<tbody>
								 <c:forEach items="${pagination.rows }" var="item">
                                      	   <%--  <input type="hidden" name="id" value="${"lottery.openTime }"/> --%>
                                            <tr>
	                                 <td>${item.id }</td>                                    
									<td>${item.content }</td>									                           
                             <td><a href="${ctx }/company/edit.do?id=${item.id}" class="btn btn-info btn-xs edit"><i class="fa fa-edit"></i>编辑</a>
	                                            </td>
                                                
                                                
                                                                                </tr>
                                      	  </c:forEach>
							</tbody>
						</table>	
						<c:if test="${fn:length(picList)>0}">
							<div class="widget">
							<div class="widget-header ">
								<span class="widget-caption">公司图片</span>
							</div>	
							<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
								<c:forEach items="${picList }" var="imgName" >
									<%-- <img alt="暂无图片" src="http://otok28xbn.bkt.clouddn.com/${imgName }?imageView2/0/h/600">&nbsp;&nbsp;&nbsp; --%>									
										<img alt="暂无图片" src="${imgName[1] }">&nbsp;&nbsp;									
								</c:forEach>
							</table>
						</div>
						</c:if>
					<%@include file="../commons/page.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	
	
</script>
</html>