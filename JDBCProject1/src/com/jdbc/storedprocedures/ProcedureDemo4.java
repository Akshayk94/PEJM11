package com.jdbc.storedprocedures;

import java.sql.*;
import java.util.Scanner;

public class ProcedureDemo4 
{

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER USERNAME");
		String user=sc1.next();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
 
			cstmt=con.prepareCall("{call displaytext(?)}");
			cstmt.setString(1, user);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			
			cstmt.execute();
			
			System.out.println(cstmt.getString(1));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
