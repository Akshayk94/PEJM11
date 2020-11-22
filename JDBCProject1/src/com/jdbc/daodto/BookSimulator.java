package com.jdbc.daodto;

import java.util.List;
import java.util.Scanner;

//PRESENTATION LAYER

public class BookSimulator
{
	static Scanner sc1=new Scanner(System.in);

	public static void main(String[] args) 
	{
		System.out.println("SELECT MODE OF OPERATION");
		System.out.println("1: ADD NEW BOOK");
		System.out.println("2: DELETE BOOK");
		System.out.println("3: DISPLAY BOOKS");
		
		int choice=sc1.nextInt();
		
		switch(choice)
		{
		case 1: addnewBook();
				break;
		
		case 2: removeBook();
				break;
				
		case 3: showBooks();
				break;
		}
	}

	private static void showBooks() 
	{
		//CALL METHOD OF DAO CLASS
		BookDAO bdao=new BookDAO();
		List<BookModel> booklist=bdao.displayAllBooks();
		
		System.out.println("ID\tNAME\tPRICE\tQTY");
		System.out.println("------------------------------");
		for(BookModel bm:booklist)
		{
			System.out.println(bm.getBookId()+"\t"+bm.getBookName()+"\t"+bm.getBookPrice()+"\t"+bm.getBookQty());
		}
	}

	private static void removeBook() 
	{
		System.out.println("ENTER BOOK ID");
		int bookId=sc1.nextInt();
		
		//DTO class object
		BookModel bm=new BookModel();
		bm.setBookId(bookId);
		
		//call method of DAO class
		BookDAO bdao=new BookDAO();
		int count=bdao.deleteBook(bm);
		
		System.out.println(count+" BOOK DELETED");
		
	}

	private static void addnewBook() 
	{
		System.out.println("ENTER BOOK NAME");
		String bookName=sc1.next();
		
		System.out.println("ENTER BOOK PRICE");
		double bookPrice=sc1.nextDouble();
		
		System.out.println("ENTER BOOK QTY");
		int bookQty=sc1.nextInt();
		
		//CREATE OBJECT OF JAVA BEAN CLASS (DTO)
		BookModel bm=new BookModel();
		bm.setBookName(bookName);
		bm.setBookPrice(bookPrice);
		bm.setBookQty(bookQty);
		
		//CALL METHOD OF DAO CLASS
		BookDAO bdao=new BookDAO();
		
		//CALL PERSISTANCE METHOD
		int count=bdao.storeBook(bm);
		
		System.out.println(count+" BOOK INSERTED");
	}

}
