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

@WebServlet("/removeproduct")
public class DeleteProduct extends HttpServlet
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String productid=req.getParameter("pid");
		
		//parsing
		int id=Integer.parseInt(productid);
		
		PreparedStatement pstmt=null;
		
		String query="delete from product_master where product_id=?";
		
		try
		{
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			int count=pstmt.executeUpdate();
			
			PrintWriter pw=resp.getWriter();
			if(count==0)
			{
				pw.print("<h1>PRODUCT NOT FOUND</h1>");
			}
			else
			{
				pw.print("<h1>"+count+" PRODUCT DELETED</h1>");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
