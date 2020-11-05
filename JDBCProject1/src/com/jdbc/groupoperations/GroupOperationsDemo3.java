package com.jdbc.groupoperations;

import java.sql.*;

/*
 * Q. Display total no of products present in each
 * category
 * */

public class GroupOperationsDemo3 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select count(*), product_category from product_info group by product_category";
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");

			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			System.out.println("CATEGORY : TOTAL PRODUCTS");
			while(rs.next())
			{
				int count=rs.getInt(1);
				String category=rs.getString(2);
				
				System.out.println(category+" : "+count);
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
