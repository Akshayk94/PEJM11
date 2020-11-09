package com.jdbc.preparedstatements;

import java.sql.*;
import java.util.Scanner;

/* Write a program to accept id 
 * and display details of product*/

public class DisplayDetails 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String query="select * from product_info where product_id=?";
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
		
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getDouble(4));
				System.out.println(rs.getInt(5));
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
			
			if(pstmt!=null)
			{
				try {
					pstmt.close();
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
