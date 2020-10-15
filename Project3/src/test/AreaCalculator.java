package test;

public class AreaCalculator 
{
	public static final double PI=3.14;
	
	public void areaOfCircle(double rad)
	{
		double result=PI*rad*rad;
		
		System.out.println("AREA OF CIRCLE IS "+result);
	}
	
	public void areaOfTriangle(double height, double base)
	{
		double result=0.5*height*base;
		
		System.out.println("AREA OF TRIANGLE IS "+result);
	}
}
