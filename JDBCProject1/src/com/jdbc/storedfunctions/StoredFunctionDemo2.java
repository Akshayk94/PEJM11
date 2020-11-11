package com.jdbc.storedfunctions;

import java.sql.*;

import java.util.Scanner;

public class StoredFunctionDemo2
{

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT QTY");
		int qty=sc1.nextInt();
		
		System.out.println("ENTER PRODUCT PRICE");
		double price=sc1.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
			
			cstmt=con.prepareCall("{?=call calculateProductBill(?,?)}");
		
			cstmt.setInt(2, qty);
			cstmt.setDouble(3, price);
			
			cstmt.registerOutParameter(1, Types.DOUBLE);
		
			cstmt.execute();
			
			System.out.println("FINAL BILL AMOUNT "+cstmt.getDouble(1));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
