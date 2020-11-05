package com.jdbc.groupoperations;

import java.sql.*;
import java.util.Scanner;

/*
 * Q. Write a JDBC Program to display details of product
 * with maximum and minimum stock
 * */

public class GroupOperationsDemo2 
{
	static Connection con;
	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("SELECT MODE OF OPERATION");
		System.out.println("1: MIN STOCK");
		System.out.println("2: MAX STOCK");
		int choice=sc1.nextInt();
		
		if(choice==1)
		{
			minStockDetails();
		}
		else if(choice==2)
		{
			maxStockDetails();
		}
	}

	private static void maxStockDetails() 
	{
		//find details with max stock
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from product_info where product_stock=(select MAX(product_stock) from product_info)";
		
		try
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println("PRODUCT ID "+rs.getInt(1));
				System.out.println("PRODUCT NAME "+rs.getString(2));
				System.out.println("PRODUCT CAREGORY "+rs.getString(3));
				System.out.println("PRODUCT PRICE "+rs.getDouble(4));
				System.out.println("PRODUCT STOCK "+rs.getInt(5));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	private static void minStockDetails() 
	{
		//find details with min stock
		Statement stmt=null;
		ResultSet rs=null;
				
		String query="select * from product_info where product_stock=(select MIN(product_stock) from product_info)";
				
		try
		{
			stmt=con.createStatement();
					
			rs=stmt.executeQuery(query);
					
			while(rs.next())
			{
				System.out.println("PRODUCT ID "+rs.getInt(1));
				System.out.println("PRODUCT NAME "+rs.getString(2));
				System.out.println("PRODUCT CAREGORY "+rs.getString(3));
				System.out.println("PRODUCT PRICE "+rs.getDouble(4));
				System.out.println("PRODUCT STOCK "+rs.getInt(5));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
