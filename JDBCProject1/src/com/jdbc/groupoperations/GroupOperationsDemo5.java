package com.jdbc.groupoperations;

import java.sql.*;

/*
 * Display minimum price of product from each
 * category. Maintain ascending order according to price while showing
 * details.
 * */

public class GroupOperationsDemo5 
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select MIN(product_price), product_category from product_info group by product_category order by MIN(product_price)";
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");

			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			System.out.println("CATEGORY : MIN PRICE");
			while(rs.next())
			{
				double price=rs.getDouble(1);
				String category=rs.getString(2);
				
				System.out.println(category+" : "+price);
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
