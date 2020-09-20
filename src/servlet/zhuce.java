/*package servlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class zhuce extends HttpServlet{
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
		String password2=reqest.getParameter("password2");
		String number=reqest.getParameter("number");
		if(name.length()==0||password.length()==0||number.length()==0||password2.length()==0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('信息不完整');window.location('zhuce.jsp')</script>");
			out.flush();
			
		}
		else if(!password.equals(password2)){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('两次密码不正确');window.location='zhuce.jsp';</script>");
			out.flush();
			
		}
		else {
			try {
				con=DriverManager.getConnection(uri);
				String Sql="insert into user (name,password,number)values(?,?,?)";
				sql=con.prepareStatement(Sql);
				sql.setString(1, name);
				sql.setString(2, password);
				sql.setString(3, number);
				sql.executeUpdate();
				con.close();
			}catch(SQLException e) {e.printStackTrace();}
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('注册成功');window.location='zhuce.jsp';</script>");
			out.flush();
			
		}
		
	}

}*/
