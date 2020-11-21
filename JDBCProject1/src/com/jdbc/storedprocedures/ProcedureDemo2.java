package com.jdbc.storedprocedures;

import java.sql.*;
import java.util.Scanner;

public class ProcedureDemo2 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");

			cstmt=con.prepareCall("{call productoperations(?)}");
			
			cstmt.setInt(1, id);
			
			//executeQuery =======> ResultSet
			
			boolean b=cstmt.execute();
			System.out.println(b);
			if(b==true)
			{
				rs=cstmt.getResultSet();
				System.out.println("ID\tNAME\tCATEGORY\tPRICE\tSTOCK");
				System.out.println("--------------------------------------------------------");

				while(rs.next())
				{
					int pid=rs.getInt(1);
					String name=rs.getString(2);
					String category=rs.getString(3);
					double price=rs.getDouble(4);
					int stock=rs.getInt(5);
					
					System.out.println(pid+"\t"+name+"\t"+category+"\t"+price+"\t"+stock);
					System.out.println("--------------------------------------------------------");
				}
			}
			
			System.out.println("PRODUCT DELETED SUCCESSFULLY");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}

	}
}
