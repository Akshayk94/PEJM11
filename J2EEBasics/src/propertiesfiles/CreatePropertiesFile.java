package propertiesfiles;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//Q. WRITE A PROGRAM TO CREATE PROPERTIES FILE
public class CreatePropertiesFile 
{
	public static void main(String[] args) 
	{
		//DECLARE RESOURCES
		FileWriter fw=null;
		Properties prop=new Properties();
		
		try 
		{
			//PROVIDE FILE LOCATION
			fw=new FileWriter("G:\\PEJM11\\data\\demo.properties");
		
			//ADD PROPERTY
			prop.setProperty("language", "java");
			prop.setProperty("version", "1.8");
			
			//STORE INSIDE THE PROPERTIES OBJECT
			prop.store(fw, "JAVA INFORMATION");
			
			System.out.println("FILE CREATED SUCCESSFULLY");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(fw!=null)
			{
				try 
				{
					fw.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
