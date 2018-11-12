<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>官网管理</title>
</head>

<body>
	<form action="${ctx }/gwUserMgt/list.do" id="submit-form">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">官网管理</span>
					</div>
					<div class="widget-body">
                        <div class="controls">
                             <div class="input-group">
								<input type="text" class="form-control" style="width:200px;margin-right: 5px;" value="${bean.phone }" name="phone" placeholder="手机号码">
								<button type="submit" class="btn btn-default" style="height:34px" onClick="search()">搜索</button>
                             </div>
                    	</div>
                    </div>
                    
                     
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
								    <th>编号</th>
									<th>用户名</th>
									<th>手机号码</th>
									<th>平台(浏览器)</th>
									<th>微信号</th>
									<th>QQ</th>
									<th>客户需求</th>
									<th>备注</th>
									<!-- <th>访问平台</th> -->
									<th>ip</th>
									<th>城市</th>
									<th>客户提交时间</th>
									<th>是否回访</th>
									<th>诚意度</th>
									<th>回访结果记录</th>
									<th>回访时间</th>
									<th>操作</th>
								
								</tr>
							</thead>
							<tbody>
								 <c:forEach items="${pagination.rows }" var="item">
                                      	   <%--  <input type="hidden" name="id" value="${"lottery.openTime }"/> --%>
                                            <tr>
	                                 <td>${item.id }</td>
                                     <td>${item.username }</td>
                                     <td>${item.phone }</td>                                  
                                   <td>${item.platform }</td>
									<td>${item.weixin }</td>
									<td>${item.qq }</td>
									<td>${item.needs }</td>
									<td>${item.remark }</td>
									<%-- <td>${item.type }</td> --%>
									<td>${item.ip }</td>
									<td>${item.city }</td>
									<td>	
									<fmt:formatDate value="${item.createTime }" type="date" pattern="yyyy-MM-dd HH:mm" />
                                           
                             </td>
                             <td>
                              <c:if test="${item.isvisit == 1}">是</c:if>
                            
                                <c:if test="${item.isvisit == 2}">否</c:if></td>
                             <td>${item.sincerity }</td>
                              <td>${item.visitresult }</td>
                             <td>	
									<fmt:formatDate value="${item.visitTime }" type="date" pattern="yyyy-MM-dd HH:mm" />
                                           
                             </td>
                             <td>
                             <%-- <a href="${ctx }/gwUserMgt/edit.do?id=${item.id}" class="btn btn-info btn-xs edit"><i class="fa fa-edit"></i>编辑</a> --%>
	                        <a href="javascript:void(0)" class="btn btn-info btn-xs edit" onclick="edit('user','${item.id}')"><i class="fa fa-edit"></i>编辑</a>
	                         <a href="javascript:void(0)" class="btn btn-danger btn-xs delete" onclick="del('user','${item.id}')"><i class="fa fa-trash-o"></i>删除</a>
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
<script src="${ctx }/js/gwuser/list.js"></script>
</body>
<script type="text/javascript">
	function search(){
		$("#submit-form").submit();
	}
	
</script>
</html>