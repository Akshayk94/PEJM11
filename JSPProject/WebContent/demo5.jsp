<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP SCRIPTLET --%>
	<%-- ALL JAVA STATEMENTS WILL BE STORED IN SERVICE METHOD --%>
	<%
		String number=request.getParameter("radius");
	
		double radius=Double.parseDouble(number);
	%>
	
	<%--JSP DECLARATION --%>
	<%-- ALL JAVA STATEMENTS WILL BE STORED OUTSIDE THE SERVICE METHOD --%>
	<%!
		double areaofcircle(double rad)
		{
			return 3.14*rad*rad;
		}
	%>
	
	<%-- JSP EXPRESSION --%>
	<%-- CALL AREA METHOD INSIDE THE EXPRESSION TAG --%>
	
	<h1>AREA OF CIRCLE IS <%=areaofcircle(radius) %></h1>
</body>
</html>