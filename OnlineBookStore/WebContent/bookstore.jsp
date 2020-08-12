<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Online Book Store</title>
</head>
<body>

<h1>Welcome <%=session.getAttribute("name").toString() %></h1>

</body>
</html>