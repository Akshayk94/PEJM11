package com.jdbc.driverloading;

public class DriverLoadingDemo2 
{
	public static void main(String[] args) 
	{
		//STEP-1 LOAD AND REGISTER THE DRIVER
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("DRIVER LOADED AND REGISTERED");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
