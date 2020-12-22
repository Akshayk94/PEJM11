package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeelink")
public class EmployeeDemo extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String employeename=req.getParameter("empname");
		
		PrintWriter pw=resp.getWriter();
		
		pw.print("<form action='details' method='post'>");
		pw.print("<input type='hidden' name='ename' value='"+employeename+"' />");
		pw.print("<input type='submit' value='NEXT' />");
		pw.print("</form>");
	}
}
