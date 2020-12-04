package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDemo5 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String employeename=req.getParameter("empname");
		String designation=req.getParameter("designation");
		String gender=req.getParameter("gender");
		
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>EMPLOYEE NAME IS "+employeename+"</h1>");
		pw.print("<h1>EMPLOYEE DESIGNATION IS "+designation+"</h1>");
		pw.print("<h1>EMPLOYEE GENDER IS "+gender+"</h1>");
	}
}
