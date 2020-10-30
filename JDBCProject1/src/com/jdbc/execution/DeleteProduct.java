package com.jdbc.execution;

import java.sql.*;
import java.util.Scanner;

/*Q.3 Write a JDBC program to delete a specific records from database table
  (accept product id from end user) */
public class DeleteProduct 
{
	public static void main(String[] args) 
	{
		//Accept Id from end user
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		//Declare resources
		Connection con=null;
		Statement stmt=null;
		
		//Create SQL query
		String query="delete from product_info where product_id="+id;
	
		//Follow Connectivity Steps
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11","root","akshay");
		
			stmt=con.createStatement();
			
			int count=stmt.executeUpdate(query);
			
			if(count!=0)
			{
				System.out.println(count+" PRODUCT DELETED");
			}
			else
			{
				System.out.println("PRODUCT NOT FOUND");
			}
			
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
