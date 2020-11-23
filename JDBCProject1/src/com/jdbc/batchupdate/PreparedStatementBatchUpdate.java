package com.jdbc.batchupdate;

import java.sql.*;

//to perform same operations with different values

public class PreparedStatementBatchUpdate
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="delete from product_info where product_id=?";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pejm11?user=root&password=akshay");

			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, 4);
			pstmt.addBatch();
			
			pstmt.setInt(1, 6);
			pstmt.addBatch();
			
			int[] count=pstmt.executeBatch();
			
			System.out.println(count.length+" RECORDS AFFECTED");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
