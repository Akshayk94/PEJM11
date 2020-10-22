package propertiesfiles;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
//Q. PROGRAM TO READ THE DATA FROM PROPERTIES FILE
public class AccessPropertiesFile 
{

	public static void main(String[] args) 
	{
		FileReader frd=null;
		Properties prop=new Properties();
		
		try 
		{
			//LOCATE THE PROPERTIES FILE
			frd=new FileReader("G:\\PEJM11\\data\\coursedetails.properties");
			
			//LOAD THE DATA INSIDE THE PROPERTIES OBJECT
			prop.load(frd);
			
			//READ THE DATA
			String coursename=prop.getProperty("course");
			String databasename=prop.getProperty("database");
			String technologyname=prop.getProperty("technology","KEY NOT FOUND");
			
			//PRINT THE DATA 
			System.out.println("COURSE :=>"+coursename);
			System.out.println("DATABASE :=>"+databasename);
			System.out.println("TECHNOLOGY :=>"+technologyname);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//CLOSE COSTLY RESOURCES
			if(frd!=null)
			{
				try
				{
					frd.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

}
