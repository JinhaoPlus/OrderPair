<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>07111205!</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@	include file="include.jsp"%>
<script type="text/javascript">
	$(function() {
		valid_form();
	});
	function valid_form(){
		var validator = $('#form-signin').bootstrapValidator(
		{
			message : 'This value is not valid',
			fields : {
				userName : {
					message : '姓名不为空',
					validators : {
						notEmpty : {
							message : '姓名不为空'
						},
						regexp : {
							regexp : /^[a-zA-Z0-9_\.]+$/,
							message : '请填姓名拼音全拼'
						}
					}
				},
				bitcode : {
					message : '学号不为空',
					validators : {
						notEmpty : {
							message : '学号不为空'
						}
					}
				}
			}
		});
	}
</script>
</head>
<body>
	<%@	include file="topnav.jsp"%>
	<div class="container">
		<div class="container">
			<form class="form-signin" id="form-signin" action="${ctx }/pairOrder" method="post">
				<h3 class="form-signin-heading">输入你的姓名全拼和学号</h3>
				<h4 class="form-signin-heading">抽取答辩排号</h4>
				<hr>
				<div class="row form-group">
					<input autofocus="autofocus" id="userName" maxlength="30"
						name="userName" placeholder="姓名拼音全拼，如wangxiaoming" type="text" 
						class="form-control" value="${pair.userName }" />
				</div>
				<div class="row form-group">
					<input id="bitCode" maxlength="12"
						name="bitCode" placeholder="学号，如1120121900" type="text" 
						class="form-control" value="${pair.bitCode }"/>
				</div>
				<div class="row form-group">
					<button class="col-md-4 btn btn-primary" type="submit"
						onclick="valid_submit();">获取排号</button>
					<a class="col-md-7 col-md-offset-1 btn btn-success" href="${ctx }/orders">去看现有的排号</a>
				</div>
				<c:if test="${signupInfo != null}">
					<div class="row form-group alert alert-warning">${signupInfo }</div>
				</c:if>
			</form>
			
		</div>
	</div>
</body>
</html>