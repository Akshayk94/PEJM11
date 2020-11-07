package com.jdbc.preparedstatements;

import java.sql.*;


public class InsertMultipleRecords1 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="insert into login_info(username,password) values(?,?)";
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");

			//create a platform and compilation of sql query
			pstmt=con.prepareStatement(query);
			
			//set values for placeholders
			pstmt.setString(1, "ajksndckas");
			pstmt.setString(2, "sadd");
			
			int count1=pstmt.executeUpdate();
			
			//set values for placeholders
			pstmt.setString(1, "jjojoji");
			pstmt.setString(2, "wetgdc");
			
			int count2=pstmt.executeUpdate();
			
			System.out.println(count1+count2+" RECORDS INSERTED");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
