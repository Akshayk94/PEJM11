package com.jdbc.daodto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//IMPLEMENTATION LAYER

public class BookDAO 
{
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

	//store data inside the database table
	public int storeBook(BookModel bm)
	{
		PreparedStatement pstmt=null;
		int count=0;
		
		String query="insert into book_info(book_name,book_price,book_qty) values(?,?,?)";
	
		try 
		{
			pstmt=con.prepareStatement(query);
			//fetch the data from DTO object
			pstmt.setString(1, bm.getBookName());
			pstmt.setDouble(2, bm.getBookPrice());
			pstmt.setInt(3, bm.getBookQty());
			
			count=pstmt.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return count;
	}

	public int deleteBook(BookModel bm) 
	{
		PreparedStatement pstmt=null;
		int count=0;
		
		String query="delete from book_info where book_id=?";
	
		try
		{
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, bm.getBookId());
			
			count=pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return count;
	}

	public List<BookModel> displayAllBooks() 
	{
		Statement stmt=null;
		ResultSet rs=null;
		List<BookModel> booklist=new ArrayList<BookModel>();
		
		String query="select * from book_info";
		
		try 
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				int qty=rs.getInt(4);
				
				//Add values into DTO object
				BookModel bm=new BookModel();
				bm.setBookId(id);
				bm.setBookName(name);
				bm.setBookPrice(price);
				bm.setBookQty(qty);
				
				//Add DTO object into array list
				booklist.add(bm);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//return list of books
		
		return booklist;
	}
}
