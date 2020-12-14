package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginlink")
public class Validation extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//FETCH THE VALUES FROM HTML FORM
		String username=req.getParameter("user");
		String password=req.getParameter("password");
		
		//static comparison
		if(username.equals("admin") && password.equals("123"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("welcomelink");
			rd.forward(req, resp);
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.print("<h1 style='color:red'>INVALID LOGIN DETAILS</h1>");
		
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}
}
