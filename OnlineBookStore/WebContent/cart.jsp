<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bookstore.models.Order"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Cart</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha512-MoRNloxbStBcD8z3M/2BmnT+rg4IsMxPkXaGh2zD6LGNNFE80W3onsAhRcMAMrSoyWL9xD7Ert0men7vR8LUZg=="
	crossorigin="anonymous" />
</head>
<body>
<div class="container">
	<div id="msg"></div>
	 <% 
		if(session.getAttribute("name") == null || session.getAttribute("name").equals("")){
			out.print("<h3>Please login first</h3>");
			out.print("<a href=\"static/html/index.html\">Home</a>");
		}else{
			String n = (String)session.getAttribute("name");
			out.print("<h1>" + n + "'s cart</h1>");
			%>
			<a class="btn btn-secondary mb-2" href="logout.jsp">Logout</a>
	<%
			out.print("<h3>Pending orders:</h3>");
			out.print("<table class='table'>");
			out.print("<tr><th>Order id</th><th>Book title</th><th>Order Date</th><th>Total Amount</th></tr>");
			
			for(Order c: (List<Order>)session.getAttribute("userOrders"))
			{
				out.print("<tr><td>"+c.getOrderid()+"</td><td>"+c.getTitle()+"</td><td>"+c.getOrderdate()+"</td><td>"+c.getTotalamount()+"</td></tr>");  		
			}
			
			out.print("</table>");
			out.print("<a href=\"pay\" class=\"btn btn-primary mr-2\">Check out and Pay</a>");
			out.print("<a href=\"bookstore\" class=\"btn btn-primary\">Continue Shopping...</a>");
			
			out.print("</div>");
		}
       %> 
       
       
</div>

</body>
</html>