package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getbill")
public class BillDetails extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//declare unit rates for all types of customer
		double commercialUnit=10.50;
		double resdentialUnit=4.50;
		
		//attribute object
		//add values into attribute object 
		req.setAttribute("unit1", commercialUnit);
		req.setAttribute("unit2", resdentialUnit);
		
		
		//forward the req to next servlet
		RequestDispatcher rd=req.getRequestDispatcher("nextlink");
		rd.forward(req, resp);
	}
}
