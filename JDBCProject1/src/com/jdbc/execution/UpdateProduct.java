package com.jdbc.execution;

import java.sql.*;

//Q.2 Write a JDBC program to update product price of specific product.

public class UpdateProduct 
{

	public static void main(String[] args) 
	{
		//Declare resources
		Connection con=null;
		Statement stmt=null;
		
		//Create SQL query
		String query="update product_info set product_price=7500.25 where product_id=2";
		
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
			
			System.out.println(numberOfRecordsAffected+" PRODUCT UPDATED SUCCESSFULLY");
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
