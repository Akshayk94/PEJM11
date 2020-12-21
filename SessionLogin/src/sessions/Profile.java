package sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profilelink")
public class Profile extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//get the reference of existing session
		HttpSession ses=req.getSession(false);
		PrintWriter pw=resp.getWriter();
		
		if(ses!=null)
		{
			String user=(String) ses.getAttribute("enduser");
			pw.print("<h1>Welcome "+user+"</h1>");
		}
		else
		{
			resp.sendRedirect("index.html");
		}
		
		pw.print("<a href='logoutlink'><button>LOGOUT</button></a>");
	}
}
