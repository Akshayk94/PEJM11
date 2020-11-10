package com.jdbc.preparedstatements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

/* Write a program to insert image file
 * 
 * BLOB=> Binary Large Object and CLOB
   Tiny BLOB ===> 32kb
   BLOB ===> 64kb
   MEDIUM BLOB ===> 16MB
   LONG BLOB ===> 4GB
 *
 */

public class InsertImageFile 
{
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		FileInputStream fin=null;
		
		String query="insert into course_info(course_name,course_image) values(?,?)";
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");
		
			pstmt=con.prepareStatement(query);
			//set course name
			pstmt.setString(1, "ABCD");
			
			//location of image file
			fin=new FileInputStream("G:\\PEJM11\\data\\samsung4.jpg");
		
			//set image location
			pstmt.setBinaryStream(2, fin);
			
			int count=pstmt.executeUpdate();
			
			System.out.println(count+" COURSE INSERTED");
			
		} 
		catch (ClassNotFoundException | SQLException | FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(fin!=null)
			{
				try {
					fin.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
