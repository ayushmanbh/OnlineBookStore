<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Office</title>
</head>
<body>
	 <% 
		if(session.isNew()){
			out.print("<h3>Please login first</h3>");
			out.print("<a href=\"static/html/index.html\">Home</a>");
		}else{
			String n = (String)session.getAttribute("name");
			out.print("<h1>Welcome " + n + "</h1>");
			%>
			<a href="logout.jsp">Logout</a>
	<h3>Total Books in stock: ${books.size().toString()}</h3>
	<h3><a href="addbook.jsp">Add a new book</a></h3>
	<%
		}
       %> 

	
</body>
</html>