package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigDemo1 extends HttpServlet
{
	String technology;
	String framework;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{ 
		technology=config.getInitParameter("technology");
		framework=config.getInitParameter("framework");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>Technology Name is "+technology+"</h1>");
	
		pw.print("<h1>Framework Name is "+framework+"</h1>");
	}
}
