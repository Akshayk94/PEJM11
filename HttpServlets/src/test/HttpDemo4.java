package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDemo4 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch the values from html
		String name=req.getParameter("studentname");
		
		String[] courselist=req.getParameterValues("courses");
		
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>WELCOME "+name+"</h1>");
		
		pw.print("<h1>SELECTED COURSE ARE:</h1>");
		
		for(int i=0;i<courselist.length;i++)
		{
			pw.print("<h1>"+courselist[i]+"</h1>");
		}
	}
}
