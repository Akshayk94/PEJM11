package com.jdbc.preparedstatements;

import java.sql.*;
import java.util.Scanner;

/*Update Product Details of specific product*/

public class UpdateProductDetails 
{
	static Scanner sc1=new Scanner(System.in);
	
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
	
	public static void main(String[] args) 
	{
		System.out.println("ENTER PRODUCT ID WHICH HAS TO BE UPDATED");
		int id=sc1.nextInt();
		
		System.out.println("SELECT WHICH FIELD HAS TO BE UPDATED");
		System.out.println("1: PRODUCT NAME");
		System.out.println("2: PRODUCT CATEGORY");
		System.out.println("3: PRODUCT PRICE");
		System.out.println("4: PRODUCT STOCK");
		int choice=sc1.nextInt();
		
		switch(choice)
		{
		case 1: updateProductName(id);
				break;
		
		case 2: updateProductCategory(id);
				break;
		
		case 3: updateProductPrice(id);
				break;
				
		case 4: updateProductStock(id);
				break;
		}
	}

	//UPDATE PRODUCT STOCK OF SPECIFIC PRODUCT
	private static void updateProductStock(int id)
	{
		System.out.println("ENTER LATEST STOCK VALUE");
		int stock=sc1.nextInt();
		
		PreparedStatement pstmt=null;
		
		String query="update product_info set product_stock=? where product_id=? ";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, stock);
			pstmt.setInt(2, id);
			
			int count=pstmt.executeUpdate();
			
			System.out.println(count+" PRODUCT STOCK UPDATED");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	//UPDATE PRODUCT PRICE OF SPECIFIC PRODUCT
	private static void updateProductPrice(int id)
	{
		System.out.println("ENTER LATEST PRODUCT PRICE");
		double price=sc1.nextDouble();
		
		PreparedStatement pstmt=null;
		
		String query="update product_info set product_price=? where product_id=? ";
	
		try
		{
			pstmt=con.prepareStatement(query);
			pstmt.setDouble(1, price);
			pstmt.setInt(2, id);
			
			int count=pstmt.executeUpdate();
			
			System.out.println(count+" PRODUCT PRICE UPDATED");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	//UPDATE PRODUCT CATEGORY FOR SPECIFIC PRODUCT
	private static void updateProductCategory(int id)
	{
		System.out.println("ENTER LATEST PRODUCT CATEGORY");
		String category=sc1.next();
		
		PreparedStatement pstmt=null;
		
		String query="update product_info set product_category=? where product_id=? ";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, category);
			pstmt.setInt(2, id);
			
			int count=pstmt.executeUpdate();
			
			System.out.println(count+" PRODUCT CATEGORY UPDATED");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	//UPDATE PRODUCT NAME FOR SPECIFIC PRODUCT
	private static void updateProductName(int id) 
	{
		System.out.println("ENTER LATEST PRODUCT NAME");
		String name=sc1.next();
		
		PreparedStatement pstmt=null;
		
		String query="update product_info set product_name=? where product_id=? ";
	
		try 
		{
			pstmt=con.prepareStatement(query);
		
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			
			int count=pstmt.executeUpdate();
			
			System.out.println(count+" PRODUCT NAME UPDATED");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
