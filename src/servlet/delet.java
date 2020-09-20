/*package servlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class delet extends HttpServlet{
	public void init(ServletConfig config)throws ServletException {
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {e.printStackTrace();}
		String num=request.getParameter("java");
		String Sql="DELETE FROM reseve WHERE id='"+num+"'";
		Connection con;
		Statement sql;
		try {String uri="jdbc:mysql://localhost:3306/hotel";
		String user="root";
		String password="zdh1234567890..";
		con=DriverManager.getConnection(uri,user,password);
		sql=con.createStatement();
		sql.executeUpdate(Sql);
		con.close();
		sql.close();
		}
		catch(SQLException e) {e.printStackTrace();}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('É¾³ý³É¹¦');window.location='Alter.jsp';</script>");
		out.flush();
		
		
	}
}*/
