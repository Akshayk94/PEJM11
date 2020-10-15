package demo;

//BUSINESS LOGIC CLASS
public class Facebook
{
	//DATA MEMBERS
	public String username;
	public int contactno;
	public String filename;
	
	//CONSTRUCTOR
	public Facebook(String username, int contactno, String filename) 
	{
		this.username = username;
		this.contactno = contactno;
		this.filename = filename;
	}
	
	//NON-STATIC METHOD
	void uploadPhoto()
	{
		System.out.println("USERNAME IS "+username);
		System.out.println("CONTACT NO IS "+contactno);
		System.out.println("FILENAME IS "+filename);
		System.out.println("YOUR FILE IS UPLOADED");
	}
}
