package factorydesignpattern;

//IMPLEMENTATION LAYER
public class FeaturePhone implements Mobile
{
	@Override
	public void getMobileType() 
	{
		System.out.println("MOBILE TYPE IS: FEATURE PHONE");
	}

	@Override
	public void calculateBill(int qty, double price) 
	{
		double total=qty*price;
		
		//APPLY 5% GST
		double finalAmount=total+total*0.05;
		
		System.out.println("FINAL BILL AMOUNT IS "+finalAmount);
	}

}
