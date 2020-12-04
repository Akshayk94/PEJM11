package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDemo3 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch the values from html page
		String username=req.getParameter("user");
		String password=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		
		if(username.equals("admin") && password.equals("123") )
		{
			pw.print("<h1 style='color:green'>LOGIN SUCCESSFUL</h1>");
		}
		else
		{
			pw.print("<h1 style='color:red'>INVALID LOGIN DETAILS</h1>");
		}
	}
}
