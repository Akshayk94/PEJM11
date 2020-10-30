package com.jdbc.execution;

import java.sql.*;

//Q.1 Write a JDBC program to insert record in database table

public class InsertProduct 
{
	public static void main(String[] args) 
	{
		//Declare Resources
		Connection con=null;
		Statement stmt=null;
		
		//Create SQL query
		String query="insert into product_info values(2,'Smart Watch','Gadgets',6500.25,250)";
	
		//Follow connectivity steps
		
		try
		{
			//load driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//build connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11","root","akshay");
		
			//create platform
			stmt=con.createStatement();
			
			//execute query
			int numberOfRecordsAffected=stmt.executeUpdate(query);
			
			System.out.println(numberOfRecordsAffected+" PRODUCT INSERTED SUCCESSFULLY");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
