package com.jdbc.batchupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementBatchUpdateDemo 
{

	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		
		String query1="insert into book_info values(0,'SPRING',12000.25,300)";
		String query2="delete from login_info where id=3";
		String query3="update course_info set course_name='SQL' where course_id=3";

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
			
			stmt=con.createStatement();
			
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);
			
			stmt.clearBatch();
			
			int[] count=stmt.executeBatch();
			
			System.out.println(count.length+" RECORDS AFFECTED");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
