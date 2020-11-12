package com.jdbc.storedfunctions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class StoredFunctionDemo3 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER FIRST NO");
		double n1=sc1.nextDouble();
		
		System.out.println("ENTER SECOND NO");
		double n2=sc1.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
			//CALL FUNCTION 
			cstmt=con.prepareCall("{?=call calculatordemo(?,?)}");
		
			//SET INPUT VALUES
			cstmt.setDouble(2, n1);
			cstmt.setDouble(3, n2);
			
			//REGISTER OUTPUT VALUE
			cstmt.registerOutParameter(1, Types.DOUBLE);
		
			cstmt.execute();
			
			//DISPLAY OUTPUT
			System.out.println("AREA OF CIRCLE IS "+cstmt.getDouble(1));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
