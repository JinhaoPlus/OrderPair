<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>07111205!</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="refresh" content="15"> 
<%@	include file="include.jsp"%>
</head>
<body>
	<%@	include file="topnav.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-1 col-md-10">
				<div class="row">
					<div id="brief_stats" class="col-md-12">
						<h3>
							<span class="orange">07111205</span>班的德育中期答辩
						</h3>
						<h4>
							目前的排号结果如下
						</h4>
					</div>
				</div>
				<hr/>
				<div class="row form-group">
					<a class="btn btn-primary" href="${ctx }/index">获取我的排号</a>
				</div>
				<div id="problemPostListRow" class="row">
					<table id="problemList"
						class="table table-hover table-striped table-centered">
						<thead>
							<tr>
								<th class="header-id">
									<div>#</div>
								</th>
								<th class="header-name">
									<div>姓名</div>
								</th>
								<th class="header-bitcode">
									<div>学号</div>
								</th>
								<th class="header-order">
									<div>排号</div>
								</th>
							</tr>
						</thead>
						<tbody>
						<% int i = 1 ;%>
							<c:forEach items="${pairs }" var="pair">
								<tr>
									<td><%=i++ %></td>
									<td>${pair.userName }</td>
									<td>${pair.bitCode }</td>
									<td>${pair.rOrder }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>