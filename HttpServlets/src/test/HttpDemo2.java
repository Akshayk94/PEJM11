package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDemo2 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//FETCH THE VALUES
		String n1=req.getParameter("num1");
		String n2=req.getParameter("num2");
		
		//PARSING
		double no1=Double.parseDouble(n1);
		double no2=Double.parseDouble(n2);
		
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>ADDITION IS "+(no1+no2)+"</h1>");
		
		
	}
}
