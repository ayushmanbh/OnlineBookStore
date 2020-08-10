<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<% session.invalidate(); %>
	<h3>You are successfully logged out.</h3>
	<a href="./static/html/index.html">Home</a>
</body>
</html>