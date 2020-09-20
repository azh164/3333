<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改房间</title>
</head>
<body>
<div align=center>
<form action="alter" method=post>
<table border=2>
<tr>
<td>
房间号
</td>
<td>预定天数</td>
<td>
时间
</td>
<td>
截止时间
</td>

<td>用户名字</td>
<td>修改</td>
<td>删除</td>
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
	rs=sql.executeQuery("select * from reseve");
	while(rs.next()){
		String num=rs.getString(6);
		String days=rs.getString(5);
		String end=rs.getString(4);
		String number=rs.getString(1);
		String time=rs.getString(2);
		String username=rs.getString(3);
		out.print("<tr><td><input type=text name='number' value="+number+"></td><td><input type=text name='days'value="+days+"></td><td><input type=text name='time' value="+time+"></td><td><input type=text name='end' value="+end+"></td><td>"+username+"</td><td><input type='hidden' name='java' value= "+num+"><input type='submit' value='修改'></form></td><td><form action='delete' method=post><input type='hidden' name='java' value= "+num+"><input type=submit value='删除'></form></td><tr>");
		
	}
	con.close();
}catch(SQLException e){out.print(e);}
%>
</table>
</div>
</body>
</html>