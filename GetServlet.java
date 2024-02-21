package org.jsp.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/fetch")
public class GetServlet extends HttpServlet{
	
		
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from btm.student where rollno=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt= con.prepareStatement(sql);
			
			int rn=Integer.parseInt(req.getParameter("rollno"));
			
			pstmt.setInt(1, rn);
			rs=pstmt.executeQuery();
			
			String fname=null;
			String lname=null;
			String cname=null;
			
			while(rs.next()) {
				
				 fname=rs.getString("fname");
				lname=rs.getString("lname");
				 cname=rs.getString("cname");
				
			}
			
			PrintWriter out=resp.getWriter();
			out.println("<html> <body bgcolor='cyan'> <div><h1> Student Name is "+fname+"  "+lname+" Inrolled in Course : "+cname+ "</h1></body></html>");
//			resp.sendRedirect("./student.html");
			
			
			
			out.println("<html><body><button  onclick=\"location.href='index.html'\">Refresh</button></body></html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		

		
	}

}
