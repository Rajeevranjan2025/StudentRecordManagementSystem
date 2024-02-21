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

@WebServlet("/add")
public class PostServlet  extends HttpServlet{
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		String fname=req.getParameter("n1");
		String lname=req.getParameter("n2");
		int rollno=Integer.parseInt(req.getParameter("rn"));
		String cname=req.getParameter("cn");
		
		
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='#E0FFFF'><h1>Student Name  "+fname+" "+lname+"  has enrolled in Course "+cname+
				     " !"+"</h1> <h2>  Thank Your for Joining Us</h2></body></html>");
		
		
		out.println("<html><body><button  onclick=\"location.href='index.html'\">Refresh</button></body></html>");
		
		//resp.sendRedirect("./student.html");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.student  values(?,?,?,?)";
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			
			pstmt=con.prepareStatement(qry);
			
			//set the data for place holder
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setInt(3, rollno);
			pstmt.setString(4, cname);
			
			pstmt.executeUpdate();
			System.out.println("Record Inserted Successfully");
			
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
