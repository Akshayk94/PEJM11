package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigDemo2 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		ServletConfig config=getServletConfig();
		
		String technology=config.getInitParameter("technology");
		String framework=config.getInitParameter("framework");
		
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>TECHNOLOGY : "+technology);
		pw.print("<h1>FRAMEWORK: "+framework);
	}
}
