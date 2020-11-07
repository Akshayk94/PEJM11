package com.jdbc.preparedstatements;

import java.sql.*;

public class InsertMultipleRecords 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		
		String query1="insert into login_info(username,password) values('dinesh','sk123')";
		String query2="insert into login_info(username,password) values('suresh','dk@123')";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
		
			stmt=con.createStatement();
			
			int count1=stmt.executeUpdate(query1);
			int count2=stmt.executeUpdate(query2);
			
			System.out.println(count1+count2+" RECORDS INSERTED");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
