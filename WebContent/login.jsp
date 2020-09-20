<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="loginBean" class="mybean.Login" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="login" method="post">
<table border=2>
	<tr>
		<td>*用户名</td>
		<td><input type=text name="name">
		</td>
	</tr>
	<tr>
		<td>*密码</td>
		<td><input type=password name="password"></td>
		<td><input type=submit value="登录"></td>
	</tr>
</table>
</form>
</div>
</body>
</html>