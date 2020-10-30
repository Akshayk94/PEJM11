package com.jdbc.execution;

import java.sql.*;
import java.util.Scanner;

public class InsertDynamicProduct 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		sc1.nextLine();
		System.out.println("ENTER PRODUCT NAME");
		String name=sc1.nextLine();
		
		System.out.println("ENTER PRODUCT CATEGORY");
		String category=sc1.next();
		
		System.out.println("ENTER PRODUCT PRICE");
		double price=sc1.nextDouble();
		
		System.out.println("ENTER PRODUCT STOCK");
		int stock=sc1.nextInt();
		
		//Declare resources
		Connection con=null;
		Statement stmt=null;
		
		//Create SQL query
		String query="insert into product_info values("+id+",'"+name+"','"+category+"',"+price+","+stock+")";
	
		//Follow connectivity steps
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11","root","akshay");

			stmt=con.createStatement();
			
			int count=stmt.executeUpdate(query);
		
			System.out.println(count+" PRODUCT INSERTED SUCCESSFULLY");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}
