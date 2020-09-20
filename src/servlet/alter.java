package servlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.time.*;
public class alter extends HttpServlet{
	public void init (ServletConfig config)throws ServletException {
		super.init(config);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try {
			request.setCharacterEncoding("UTF-8");
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {e.printStackTrace();}
		String uri="jdbc:mysql://localhost:3306/hotel?"+"user=root&password=zdh1234567890..&characterEncoding=UTF-8";
		Connection con;
		PreparedStatement sql;
		String number=request.getParameter("number");
		String time=request.getParameter("time");
		String day=request.getParameter("days");
		String[] times=time.split("[^0123456789]");
		LocalDate date=LocalDate.of(Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2]));
		LocalDate end=date.plusDays(Integer.parseInt(day));
		String id=request.getParameter("java");
		try {
			con=DriverManager.getConnection(uri);
			String Sql="UPDATE reseve SET number=?,time=?,days=?,end=?where id="+id;
			sql=con.prepareStatement(Sql);
			sql.setString(1, number);
			sql.setString(2, date.toString());
			sql.setString(3, day);
			sql.setString(4, end.toString());
			sql.executeUpdate();
			con.close();
			sql.close();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('ÐÞ¸Ä³É¹¦');window.location='Alter.jsp';</script>");
			out.flush();
		}catch(SQLException e) {e.printStackTrace();}
	}
}
