package com.jdbc.execution;

import java.sql.*;

//Q.5 Write a JDBC Code to display products.

public class DisplayProducts
{

	public static void main(String[] args)
	{
		//Declare resources
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		//Create SQL query
		String query="select * from product_info";
		
		//Follow connectivity steps
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
			
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				int id=rs.getInt("product_id");
				String name=rs.getString("product_name");
				String category=rs.getString("product_category");
				double price=rs.getDouble("product_price");
				int stock=rs.getInt("product_stock");
				
				System.out.println("PRODUCT ID IS "+id);
				System.out.println("PRODUCT NAME IS "+name);
				System.out.println("PRODUCT CATEGORY IS "+category);
				System.out.println("PRODUCT PRICE IS "+price);
				System.out.println("PRODUCT STOCK IS "+stock);
				System.out.println("******************************************");
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
			
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
