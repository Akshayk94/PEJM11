package factorydesignpattern;

//FACTORY CLASS OR HELPER CLASS
public class MobileFactory 
{
	//FACTORY METHOD OR HELPER METHOD
	Mobile getMobileObject(String mobileType)
	{
		Mobile m1=null;
		if(mobileType.equalsIgnoreCase("SMARTPHONE"))
		{
			m1=new SmartPhone();//UPCASTING
		}
		else if(mobileType.equalsIgnoreCase("FEATUREPHONE"))
		{
			m1=new FeaturePhone();//UPCASTING
		}
		
		return m1;
	}
}
