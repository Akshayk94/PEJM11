package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nextlink")
public class BillCalculation extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch the details from HTML page
		String current=req.getParameter("current");
		String previous=req.getParameter("previous");
		String custtype=req.getParameter("customertype");
		
		//parsing
		int currentReading=Integer.parseInt(current);
		int previousReading=Integer.parseInt(previous);
		
		//calculate total reading
		int totalReading=currentReading-previousReading;
		
		//get the unit rates from previous servlet
		double commericalUnit=(double) req.getAttribute("unit1");
		double resdentialUnit=(double) req.getAttribute("unit2");
		
		//calculate total bill amount
		
		double totalAmount=0.0;
		
		if(custtype.equals("commercial"))
		{
			totalAmount=totalReading*commericalUnit;
		}
		else if(custtype.equals("resdential"))
		{
			totalAmount=totalReading*resdentialUnit;
		}
		PrintWriter pw=resp.getWriter();
		pw.print("<h1 style='color:blue'>BILL DETAILS</h1>");
		pw.print("<h2>CURRENT READING :"+currentReading+"</h2>");
		pw.print("<h2>PREVIOUS READING :"+previousReading+"</h2>");
		pw.print("<h2>TOTAL READING IS :"+totalReading+"</h2>");
		pw.print("<h2 style='color:red'>TOTAL BILL AMOUNT IS :"+totalAmount+"</h2>");
	}
}
