package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displaylink")
public class DisplayProducts extends HttpServlet
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
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from product_master";
		
		try 
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			PrintWriter pw=resp.getWriter();
			pw.print("<html>");
			pw.print("<body>");
			pw.print("<table border='2'>");
			pw.print("<tr>");
			pw.print("<td>PRODUCTID</td>");
			pw.print("<td>PRODUCTNAME</td>");
			pw.print("<td>PRODUCTPRICE</td>");
			pw.print("<td>PRODUCTQTY</td>");
			pw.print("</tr>");
			while(rs.next())
			{
				pw.print("<tr>");
				pw.print("<td>"+rs.getInt(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getDouble(3)+"</td>");
				pw.print("<td>"+rs.getInt(4)+"</td>");
				pw.print("</tr>");
			}
			pw.print("</table>");
			pw.print("</body>");
			pw.print("</html>");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
