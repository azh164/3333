package servlet;
import javax.servlet.http.*;
import mybean.Login;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class login extends HttpServlet {
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
			String Sql="select * from user where name=? and password=?";
			sql=con.prepareStatement(Sql);
			sql.setString(1, name);
			sql.setString(2, password);
			ResultSet rs=sql.executeQuery();
			boolean m=rs.next();
			if(m==true) {
				Login loginBean=null;
				HttpSession session=reqest.getSession(true);
				try {
					loginBean=(Login)session.getAttribute("loginBean");
					if(loginBean==null) {
						loginBean=new Login();
						session.setAttribute("loginBean", loginBean);
						loginBean=(Login)session.getAttribute("loginBean");
					}
					String name1=loginBean.getLogname();
					if(name.equals(name1)) {
						loginBean.setLogname(name1);
						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('ÒÑ¾­µÇÂ¼,ÇëÎðÖØ¸´µÇÂ¼');window.location='login.jsp';</script>");
						out.flush();
					}
					else {
						loginBean.setLogname(name);
					}
				}catch(Exception ee) {
					loginBean=new Login();
				session.setAttribute("loginBean",loginBean);
				loginBean.setLogname(name);
				}
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('µÇÂ¼³É¹¦');window.location='login.jsp';</script>");
				out.flush();
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('ÃÜÂë´íÎó»òÓÃ»§²»´æÔÚµÇÂ¼Ê§°Ü');window.location='login.jsp';</script>");
				out.flush();
			}
			con.close();
		}catch(SQLException e) {e.printStackTrace();}
		
	}
}















