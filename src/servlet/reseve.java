/*package servlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
public class reseve extends HttpServlet {
	public void init(ServletConfig config)throws ServletException {
		super.init(config);
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {e.printStackTrace();}
		String uri="jdbc:mysql://localhost:3306/hotel?"+"user=root&password=zdh1234567890..&characterEncoding=UTF-8";
		Connection con;
		PreparedStatement sql;
		String roomnumber=request.getParameter("roomnumber");
		String time=request.getParameter("time");
		String day=request.getParameter("days");
		String[] times=time.split("[^0123456789]");
		LocalDate date=LocalDate.of(Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2]));
		LocalDate end=date.plusDays(Integer.parseInt(day));
		String username=request.getParameter("username");
		try {
			con=DriverManager.getConnection(uri);
			String Sql="insert into reseve (number,time,username,end,days)values(?,?,?,?,?)";
			sql=con.prepareStatement(Sql);
			sql.setString(1, roomnumber);
			sql.setString(2, date.toString());
			sql.setString(3, username);
			sql.setString(5,day);
			sql.setString(4,end.toString());
			sql.executeUpdate();
			con.close();
		}catch(SQLException e) {e.printStackTrace();}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Ô¤¶¨³É¹¦');window.location='reseve.jsp';</script>");
		out.flush();
	}
}*/
