package com.jdbc.batchupdate;

import java.sql.*;

//execute a group of different SQL statements

public class StatementBatchUpdate 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		
		String query1="insert into book_info values(0,'J2EE',3500.25,500)";
		String query2="update book_info set book_price=1500.25 where book_id=1";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
		
			stmt=con.createStatement();
			
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			
			int[] count=stmt.executeBatch();
			
			System.out.println(count.length+" RECORDS AFFECTED");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
