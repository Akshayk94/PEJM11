package com.jdbc.storedprocedures;

import java.sql.*;
import java.util.Scanner;

public class ProcedureDemo3 
{
	public static void main(String[] args) 
	{	
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT CATEGORY");
		String category=sc1.next();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");

			cstmt=con.prepareCall("{call countproducts(?,?)}");
			
			cstmt.setString(1, category);
			cstmt.registerOutParameter(2, Types.INTEGER);
			
			cstmt.execute();
			
			System.out.println("TOTAL NO OF PRODUCTS ARE "+cstmt.getInt(2));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
