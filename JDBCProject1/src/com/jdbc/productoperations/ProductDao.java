package com.jdbc.productoperations;

import java.sql.*;

//IMPLEMENTATION LAYER

//Database operations

public class ProductDao 
{
	static Connection con;
	
	//Load driver and build connection
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
	
	//insert new product into database table
	public void storeProduct(String name, String category, double price, int stock)
	{
		//declare resources
		Statement stmt=null;
		
		//create sql query
		String query="insert into product_info(product_name,product_category,product_price,product_stock) values('"+name+"','"+category+"',"+price+","+stock+")";
		
		
		try 
		{
			//create a statement platform
			stmt=con.createStatement();
			
			//execute query
			int count=stmt.executeUpdate(query);
			
			System.out.println(count+" PRODUCT INSERTED SUCCESSFULLY");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	//display product details from database table
	public void searchProduct(int id)
	{
		//declare resource
		Statement stmt=null;
		ResultSet rs=null;
		
		//create sql query
		String query="select * from product_info where product_id="+id;
		
		try 
		{
			//create statement platform
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			System.out.println("ID\tNAME\tCATEGORY\tPRICE\tSTOCK");
			System.out.println("--------------------------------------------");
			if(rs.next())
			{
				int pid=rs.getInt(1);
				String pname=rs.getString(2);
				String pcategory=rs.getString(3);
				double pprice=rs.getDouble(4);
				int stock=rs.getInt(5);
				
				System.out.println(pid+"\t"+pname+"\t"+pcategory+"\t\t"+pprice+"\t"+stock);
			}
			else
			{
				System.out.println("PRODUCT NOT FOUND");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	//calculate final bill amount for the purchase
	public void purchaseProduct(int id, int qty) 
	{
		//input---->id===>output----->price,stock
		//input---->price*qty====>output----->final bill 
		
		Statement stmt=null;
		ResultSet rs=null;
		//select price,stock from product_info where id=value;
		String query1="select product_price,product_stock from product_info where product_id="+id;
		
		try 
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query1);
			
			//STEP-1 check availability of product
			
			if(rs.next())
			{
				double price=rs.getDouble("product_price");
				int stock=rs.getInt("product_stock");
				
				//STEP-2 check the stock of specific product
				if(qty<=stock)
				{
					//STEP-3 calculate bill amount
					double finalAmount=qty*price;
					System.out.println("FINAL BILL AMOUNT IS "+finalAmount);
				
					//STEP-4 update the product stock in db table
					String query2="update product_info set product_stock=product_stock-"+qty+" where product_id="+id;
					
					stmt.executeUpdate(query2);
				}
				else
				{
					System.out.println("PRODUCT IS OUT OF STOCK");
				}
			}
			else
			{
				System.out.println("INVALID PRODUCT ID");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}
