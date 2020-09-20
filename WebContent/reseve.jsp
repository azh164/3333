<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>预定</title>
</head>
<body>
<div align="center">
<table border=2>
<tr>
<td>房间号</td>
<td>房间信息</td>
<td>房间状态</td>
</tr>
<%
try{
	Class.forName("com.mysql.jdbc.Driver");
}catch(Exception e){out.print(e);}
String uri="jdbc:mysql://localhost:3306/hotel?"+"user=root&password=zdh1234567890..&characterEncoding=UTF-8";
Connection con;
Statement sql;
ResultSet rs;
try{
	con=DriverManager.getConnection(uri);
	sql=con.createStatement();
	rs=sql.executeQuery("select * from room");
	while(rs.next()){
		String roomnumber=rs.getString(1);
		String message=rs.getString(2);
		String state=rs.getString(3);
		out.print("<tr><td>"+roomnumber+"</td><td>"+message+"</td><td>"+state+"</td><tr>");
		
	}
	con.close();
}catch(SQLException e){out.print(e);}
%>
</table>
<br><br>
<form action="rerseve" method="post">
<table border=2>
<tr><td>预定房间号</td><td><input type=text name="roomnumber"></td></tr>
<tr><td>预定时间</td><td><input type=text name="time"></td></tr>
<tr><td>预定天数</td><td><input type=text name="days"></td></tr>
<tr><td>用户姓名</td><td><input type=text name="username"></td></tr>
</table>
<input type=submit value="提交">
</form>
</div>
</body>
</html>