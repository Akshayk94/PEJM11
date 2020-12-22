package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginlink")
public class ServletDemo1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String user=req.getParameter("user");
		String password=req.getParameter("password");
		
		if(password.equals("admin"))
		{
			//URL REWRITING
			resp.sendRedirect("welcome?enduser="+user);
		}
	}
}
