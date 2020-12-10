package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addproduct")
public class AddProduct extends HttpServlet
{
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		//fetch resources
		ServletContext context=config.getServletContext();
		String driver=context.getInitParameter("driver");
		String url=context.getInitParameter("url");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		
		try 
		{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,user,password);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch the values from html page
		String productName=req.getParameter("pname");
		String productPrice=req.getParameter("pprice");
		String productQty=req.getParameter("pqty");
	
		//parsing
		double price=Double.parseDouble(productPrice);
		int qty=Integer.parseInt(productQty);
		
		//declare resources
		PreparedStatement pstmt=null;
		
		String query="insert into product_master values(?,?,?,?)";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, productName);
			pstmt.setDouble(3, price);
			pstmt.setInt(4, qty);
			
			int count=pstmt.executeUpdate();
			
			PrintWriter pw=resp.getWriter();
			
			pw.print("<h1>"+count+" PRODUCT INSERTED SUCCESSFULLY");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
