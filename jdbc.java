package org.jsp.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc {

	 
	 Connection con;
	 PreparedStatement pstmt;
	 
	 String qry;
	 public String SqlQery()
	 public void EstCon() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
	 }
	 
	 public void preStmt() {
		 pstmt=con.prepareStatement(qry);
	 }
}

//Connection con=null;
//PreparedStatement pstmt=null;
//String qry="insert into btm.student  values(?,?,?,?)";
//try {
//	Class.forName("com.mysql.jdbc.Driver");
//	con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
//	
//	pstmt=con.prepareStatement(qry);
//	
//	//set the data for place holder
//	pstmt.setString(1, fname);
//	pstmt.setString(2, lname);
//	pstmt.setInt(3, rollno);
//	pstmt.setString(4, cname);
//	
//	pstmt.executeUpdate();
//	System.out.println("Record Inserted Successfully");
//	
//} catch (ClassNotFoundException | SQLException e) {
//	e.printStackTrace();
//}
//
//finally {
//	
//	if(con!=null) {
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	if(pstmt!=null) {
//		try {
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//}