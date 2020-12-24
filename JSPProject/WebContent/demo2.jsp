<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><%
		String min=request.getParameter("min");
		String max=request.getParameter("max");
		
		int no1=Integer.parseInt(min);
		int no2=Integer.parseInt(max);
		
		ArrayList<Integer> evennos=new ArrayList<Integer>();
		ArrayList<Integer> oddnos=new ArrayList<Integer>();
		
		for(int i=no1;i<=no2;i++)
		{
			if(i%2==0)
			{
				evennos.add(i);
			}
			else
			{
				oddnos.add(i);
			}
		}
		
		out.println(evennos+"<br>");
		out.println(oddnos);
	%></h1>
</body>
</html>