<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons.jsp"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>后台记录</title>
</head>

<body>
	<form action="${ctx }/push/list.do" id="submit-form">
	<div class="page-body">
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<div class="widget">
					<div class="widget-header ">
						<span class="widget-caption">推送记录</span>
					</div>
					<div class="widget-body">
                       <!--  <div class="controls">
                             <div class="input-group">
								<input type="date"   name="staDate" placeholder="开始时间">
								<input type="date" class="form-control" style="width:200px;margin-right: 5px;"  name="endDate" placeholder="结束时间">
								<button type="submit" class="btn btn-default" style="height:34px" onClick="search()">搜索</button>
                             </div>
                    	</div> -->
                    </div>
                    
                     
						<table class="table table-striped table-bordered table-hover"
							id="simpledatatable">
							<thead>
								<tr>
								    <th>编号</th>
									<th>项目名</th>
									<th>接口名</th>
									<th>通知者</th>
									<th>接收者</th>
									<th>是否紧急</th>
									<th>推送时间</th>		
									<th>推送目标</th>												
								</tr>
							</thead>
							<tbody>
								 <c:forEach items="${pagination.rows }" var="item" varStatus="sta">                                      	   
                                        <tr>
	                                 <td>${sta.index+1 }</td>
	                                 <td>${item.proName }</td>
	                                  <td>${item.interName }</td>
	                                   <td>${item.sender }</td>
	                                    <td>${item.receiver }</td>
                                     <td>
                                     	<c:if test="${item.status==1 }">是</c:if>
                                     	<c:if test="${item.status==0 }">否</c:if>
                                     </td>                                
									<td><fmt:formatDate value="${item.createDate }" type="date" pattern="yyyy-MM-dd HH:mm" /></td>
									<td>${item.type }</td>
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
<script src="${ctx }/js/push/list.js"></script>
</body>
<script type="text/javascript">
	function search(){
		$("#submit-form").submit();
	}
	
</script>
</html>