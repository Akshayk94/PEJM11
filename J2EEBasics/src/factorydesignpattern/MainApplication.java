package factorydesignpattern;

import java.util.Scanner;

//UTILIZATION LAYER
public class MainApplication
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("SELECT MOBILE CATEGORY");
		System.out.println("SMARTPHONE");
		System.out.println("FEATUREPHONE");
		
		String choice=sc1.next();
		
		System.out.println("ENTER QUANTITY");
		int qty=sc1.nextInt();
		
		System.out.println("ENTER UNIT PRICE");
		double price=sc1.nextDouble();
		
		MobileFactory factory=new MobileFactory();
		
		Mobile m=factory.getMobileObject(choice);
		
		m.getMobileType();
		m.calculateBill(qty, price);
		
	}
}
