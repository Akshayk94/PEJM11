package com.jdbc.storedfunctions;

import java.sql.*;
import java.util.Scanner;

public class StoredFunctionDemo4
{

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);

		System.out.println("ENTER CREDIT LIMIT");
		double credit=sc1.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");

			cstmt=con.prepareCall("{?=call customertype(?)}");
			
			cstmt.setDouble(2, credit);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			
			cstmt.execute();
			
			System.out.println("CUSTOMER TYPE IS "+cstmt.getString(1));
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
