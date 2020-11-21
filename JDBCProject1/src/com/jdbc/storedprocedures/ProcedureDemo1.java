package com.jdbc.storedprocedures;

import java.sql.*;

public class ProcedureDemo1 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		CallableStatement cstmt=null;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
			
			cstmt=con.prepareCall("{call insertproduct(?,?,?,?)}");
		
			cstmt.setString(1, "PROJECTOR");
			cstmt.setString(2, "ELECTRONICS");
			cstmt.setDouble(3, 12500.25);
			cstmt.setInt(4, 20);
			
			cstmt.execute();
			
			System.out.println("PRODUCT INSERTED");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
