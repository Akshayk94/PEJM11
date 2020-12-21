package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cartlink")
public class ShoppingCart extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String productName=req.getParameter("pname");
		String productPrice=req.getParameter("pprice");
		String add=req.getParameter("add");
		String view=req.getParameter("view");
		
		if(add!=null)
		{
			//create a new cookie
			Cookie c1=new Cookie(productName, productPrice);
			resp.addCookie(c1);
			resp.sendRedirect("index.html");
		}
		else if(view!=null)
		{
			Cookie[] carray=req.getCookies();
			
			PrintWriter pw=resp.getWriter();
			
			for(int i=0;i<carray.length;i++)
			{
				pw.print("<h1>"+carray[i].getName()+":"+carray[i].getValue()+"</h1>");
			}
		}
	}
}
