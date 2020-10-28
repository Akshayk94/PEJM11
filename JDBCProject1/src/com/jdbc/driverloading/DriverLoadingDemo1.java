package com.jdbc.driverloading;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DriverLoadingDemo1 
{
	public static void main(String[] args) 
	{
		//STEP-1 LOAD AND REGISTER DRIVER
		
		try
		{
			//CREATE AN OBJECT OF DRIVER CLASS
			Driver d=new Driver();
			
			//CALL REGISTER DRIVER METHOD
			DriverManager.registerDriver(d);
			
			System.out.println("DRIVER LOADED AND REGISTERED");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
