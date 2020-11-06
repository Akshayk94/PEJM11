package com.jdbc.loginvalidation;

import java.sql.*;
import java.util.Scanner;

public class TestLoginApplication
{
	static Scanner sc1=new Scanner(System.in);

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
		System.out.println("SELECT MODE OF OPERATION");
		System.out.println("1: LOGIN");
		System.out.println("2: SIGN UP");
		int choice=sc1.nextInt();
		
		if(choice==1)
		{
			login();
		}
		else if(choice==2)
		{
			signup();
		}
	}

	//INSERT USERNAME AND PASSWORD INTO DB TABLE
	private static void signup() 
	{
		//Accept values from end user
		System.out.println("ENTER DETAILS FOR SIGN UP");
		System.out.println("**************************");
		System.out.println("ENTER USERNAME");
		String user=sc1.next();
		
		System.out.println("ENTER PASSWORD");
		String password=sc1.next();
		
		//Declare resources
		Statement stmt=null;
		
		//create sql query
		String query="insert into login_info(username,password) values('"+user+"','"+password+"')";
	
		try 
		{
			stmt=con.createStatement();
			
			stmt.executeUpdate(query);
			
			System.out.println("Congratulations!!! Registration Successful");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	//CHECK USERNAME AND PASSWORD IS VALID OR INVALID
	private static void login() 
	{
		System.out.println("PLEASE ENTER LOGIN DETAILS");
		System.out.println("********************************");
	
		System.out.println("ENTER USERNAME");
		String user=sc1.next();
		
		System.out.println("ENTER PASSWORD");
		String password=sc1.next();
		
		Statement stmt=null;
		ResultSet rs=null;
		
		//check user and password is valid or invalid
		
		String query="select username,password from login_info";
		
		try 
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			boolean flag=false;
			
			while(rs.next()) //==>1 --> T===> 2 -- F ===> 3 -- F
			{
				String dbuser=rs.getString("username");
				String dbpassword=rs.getString("password");
				
				if(user.equals(dbuser) && password.equals(dbpassword))
				{
					flag=true;
				}
			}
			if(flag==true)
			{
				System.out.println("LOGIN SUCCESSFUL");
			}
			else
			{
				System.err.println("INVALID LOGIN DETAILS");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
