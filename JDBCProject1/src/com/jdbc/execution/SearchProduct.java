package com.jdbc.execution;

import java.sql.*;

import java.util.Scanner;

//Q.6 Write a program to search details of specific product

//select * from product_info where product_id=id or product_name=name;

public class SearchProduct 
{
	public static void main(String[] args) 
	{
		//Accept input from end user
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("SELECT SEARCH CRITERIA");
		System.out.println("1: SEARCH BY PRODUCT ID");
		System.out.println("2: SEARCH BY PRODUCT NAME");
		int choice=sc1.nextInt();
		
		int productId=0;
		String productName=null;
		
		if(choice==1)
		{
			System.out.println("ENTER PRODUCT ID");
			productId=sc1.nextInt();
		}
		else if(choice==2)
		{
			System.out.println("ENTER PRODUCT NAME");
			productName=sc1.next();
		}
		
		//declare resources
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		//follow connectivity steps
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
 
		    stmt=con.createStatement();
		    
		    if(choice==1)
		    {
		    	rs=stmt.executeQuery("select * from product_info where product_id="+productId);
		    }
		    else if(choice==2)
		    {
		    	rs=stmt.executeQuery("select * from product_info where product_name='"+productName+"' ");
		    }
		    
		    if(rs.next())
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
