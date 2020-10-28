package com.jdbc.connections;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo1 
{
	public static void main(String[] args) 
	{
		
		try
		{
			//STEP-1 LOAD AND REGISTER THE DRIVER
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DRIVER LOADED");
			
			//STEP-2 ESTABLISH THE CONNECTION
			DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11","root","akshay");
			System.out.println("CONNECTION ESTABLISHED");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
