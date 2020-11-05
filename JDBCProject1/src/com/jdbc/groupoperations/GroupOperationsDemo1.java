package com.jdbc.groupoperations;

import java.sql.*;
import java.util.Scanner;

/*
 Q. Write a program to accept product category from end
	 end user. Display total number of products
	 available in specified category
*/
public class GroupOperationsDemo1
{

	public static void main(String[] args) 
	{
		//Declare Resources
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER PRODUCT CATEGORY");
		String category=sc1.next();
		
		//create sql query
		String query="select count(*) from product_info where product_category='"+category+"' ";
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
		
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			if(rs.next())
			{
				int count=rs.getInt(1);
				System.out.println("TOTAL NO OF PRPDUCTS: "+count);
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
