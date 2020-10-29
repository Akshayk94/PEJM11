package com.jdbc.statements;

import java.sql.*;

public class PlatformDemo1 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		try 
		{
			//STEP-1
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			//STEP-2
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
			System.out.println("Connection Established");
			
			//STEP-3
			con.createStatement();
			System.out.println("Platform Created");
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
		}
	}
}
