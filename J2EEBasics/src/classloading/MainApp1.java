package classloading;

public class MainApp1 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("classloading.Central1");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
