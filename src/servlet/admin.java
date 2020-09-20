package servlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class admin extends HttpServlet {
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	public void doPost(HttpServletRequest reqest,HttpServletResponse response) throws ServletException,IOException{
		try {
			reqest.setCharacterEncoding("UTF-8");
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {e.printStackTrace();}
		String uri="jdbc:mysql://localhost:3306/hotel?"+"user=root&password=zdh1234567890..&characterEncoding=UTF-8";
		Connection con;
		PreparedStatement sql;
		String name=reqest.getParameter("name");
		String password=reqest.getParameter("password");
		try {
			con=DriverManager.getConnection(uri);
			String Sql="select * from admin where admin=? and password=?";
			sql=con.prepareStatement(Sql);
			sql.setString(1, name);
			sql.setString(2, password);
			ResultSet rs=sql.executeQuery();
			boolean m=rs.next();
			if(m==true) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('登录成功');window.location='admin.jsp';</script>");
				out.flush();
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('密码错误或用户不存在登录失败');window.location='admin.jsp';</script>");
				out.flush();
			}
			con.close();
		}catch(SQLException e) {e.printStackTrace();}
		
	}
}

























