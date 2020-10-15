package test;

import java.util.Scanner;

public class AreaSimulator 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("SELECT MODE OF OPERATION");
		System.out.println("1: AREA OF CIRCLE");
		System.out.println("2: AREA OF TRIANGLE");
		int choice=sc1.nextInt();
		
		AreaCalculator a1=new AreaCalculator();
		
		switch(choice)
		{
		case 1: System.out.println("ENTER THE RADIUS");
		 		double rad=sc1.nextDouble();
		 		a1.areaOfCircle(rad);
		 		break;
		 		
		case 2: System.out.println("ENTER HEIGHT");
		 		double height=sc1.nextDouble();
		 		
		 		System.out.println("ENTER BASE");
		 		double base=sc1.nextDouble();
		 		a1.areaOfTriangle(height, base);
		 		break;
		}
	}
}
