package com.jdbc.connections;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo2
{

	public static void main(String[] args) 
	{
		
		try 
		{
			//STEP-1 LOADING DRIVER
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			//STEP-2 CONNECTION
			DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
			System.out.println("Connection Established");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
