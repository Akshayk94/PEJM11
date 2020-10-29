package com.jdbc.connections;

import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo3 
{

	public static void main(String[] args) 
	{
		FileReader frd=null;
		Properties prop=new Properties();
		
		try 
		{
			//load driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			//read data from properties file
			frd=new FileReader("G:\\PEJM11\\data\\login.properties");
			
			prop.load(frd);
			
			//build the connection
			DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11",prop);
			System.out.println("Connection Established");
		} 
		catch (ClassNotFoundException | IOException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(frd!=null)
			{
				try 
				{
					frd.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}

}
