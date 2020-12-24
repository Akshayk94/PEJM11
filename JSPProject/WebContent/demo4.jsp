<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	#msg1
	{
		color:green;
		border:5px solid green;
		padding:15px;
		margin:10px;
	}
	
	#msg2
	{
		color:red;
		border:5px solid red;
		padding:15px;
		margin:10px;
	}
</style>
</head>
<body>
	<!-- FETCH THE VALUES FROM HTML -->
		<%
		String user=request.getParameter("user");
		String password=request.getParameter("password");
	
		if(user.equals("admin") && password.equals("pune"))
		{%>
			<h1 id="msg1">LOGIN SUCCESSFUL</h1>
		<%}
		else
		{%>
			<h1 id="msg2">INVALID LOGIN DETAILS</h1>
		<%}%>
	
</body>
</html>