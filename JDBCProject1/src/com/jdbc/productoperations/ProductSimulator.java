package com.jdbc.productoperations;

import java.util.Scanner;
//UTILIZATION LAYER

public class ProductSimulator 
{
	//DISPLAY OPTIONS FOR END USER
	static Scanner sc1=new Scanner(System.in);
	
	static ProductDao dao=new ProductDao();
	
	public static void main(String[] args)
	{
		System.out.println("1: ADD NEW PRODUCT");
		System.out.println("2: SEARCH PRODUCT");
		System.out.println("3: PURCHASE PRODUCT");
	
		int choice=sc1.nextInt();
		
		switch(choice)
		{
		case 1: addProducts();
				break;
				
		case 2: findProduct();
				break;
				
		case 3: buyProducts();
				break;
		}
	}

	//Accept input for purchase of a new product
	private static void buyProducts() 
	{
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		System.out.println("ENTER QUANTITY");
		int qty=sc1.nextInt();
		
		//call method from dao class
		dao.purchaseProduct(id,qty);
	}

	//Accept input to find the details of product
	private static void findProduct() 
	{
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		//call method from dao class
		dao.searchProduct(id);
	}

	//Accept input to insert new product
	private static void addProducts() 
	{
		System.out.println("ENTER PRODUCT NAME");
		String name=sc1.next();
		
		System.out.println("ENTER PRODUCT CATEGORY");
		String category=sc1.next();
		
		System.out.println("ENTER PRODUCT PRICE");
		double price=sc1.nextDouble();
		
		System.out.println("ENTER PRODUCT STOCK");
		int stock=sc1.nextInt();
		
		//call method from dao class
		dao.storeProduct(name, category, price, stock);
	}
}
