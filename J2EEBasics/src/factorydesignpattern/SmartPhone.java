package factorydesignpattern;

//IMPLEMENTATION LAYER
public class SmartPhone implements Mobile 
{

	@Override
	public void getMobileType() 
	{
		System.out.println("MOBILE TYPE IS : SMARTPHONE");
	}

	@Override
	public void calculateBill(int qty, double price) 
	{
		double total=qty*price;
		
		//APPLY 10% GST
		
		double finalamount=total+total*0.1;
		
		System.out.println("FINAL BILL AMOUNT IS "+finalamount);
	}

}
