package org.jsp.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="delete from btm.student where rollno=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt= con.prepareStatement(sql);
			
			int rn=Integer.parseInt(req.getParameter("rollno"));
			System.out.println("deleting....");
			pstmt.setInt(1, rn);
			pstmt.executeUpdate();
			
			System.out.println("Record deleted successfully");
			
			PrintWriter out=resp.getWriter();
			out.println("<html> <body bgcolor='cyan'> <div><h1>Student Record Deleted Successfully From Database </h1></body></html>");
//			resp.sendRedirect("./student.html");
			
			out.println("<html><body><button  onclick=\"location.href='index.html'\">Refresh</button></body></html>");
			
			System.out.println("printed");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		

		
	}

}
