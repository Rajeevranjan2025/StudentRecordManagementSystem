package org.jsp.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	
public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		
		int rn=Integer.parseInt(req.getParameter("rollno"));
		String cname=req.getParameter("cname");
		
		
		
	
//		resp.sendRedirect("./student.html");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry=" update btm.student set cname=? where rollno=?";
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			
			pstmt=con.prepareStatement(qry);
			
			//set the data for place holder
			pstmt.setString(1, cname);
			
			pstmt.setInt(2,rn);
			
			
			pstmt.executeUpdate();
			System.out.println("Record Updated Successfully");
			PrintWriter out=resp.getWriter();
			out.println("<html><body bgcolor='red'><h1>Student with Rollno has updated course "+cname+"</h1></body></html>");
			
			out.println("<html><body><button  onclick=\"location.href='index.html'\">Refresh</button></body></html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	    
	    finally {
	    	
	    	if(con!=null) {
	    		try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
	    	if(pstmt!=null) {
	    		try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
	    	
	    }
	    
		
	}


}
