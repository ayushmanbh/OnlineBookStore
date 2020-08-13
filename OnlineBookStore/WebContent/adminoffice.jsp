<%@page import="com.bookstore.models.Book"%>
<%@page import="com.bookstore.models.User"%>
<%@page import="com.bookstore.models.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Office</title>

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
			out.print("<h1>Welcome " + n + "</h1>");
			%>
			<h4><a href="addbook.jsp">Add a new book</a> | <a href="logout.jsp">Logout</a></h4>
			<h3>Total revenue: $${revenue.toString()}</h3>
	<%
			out.print("<table class='table'>");
			out.print("<tr><th>Title</th><th>Author</th><th>Publisher</th><th>Price</th><th>Stock</th><th>Category</th></tr>");
			
			for(Book c: (List<Book>)session.getAttribute("books"))
			{
				out.print("<tr><td>"+c.getTitle()+"</td><td>"+c.getAuthor()+"</td><td>"+c.getPublisher()+"</td><td>"+c.getPrice()+"</td><td>"+c.getStock()+"</td><td>" + c.getCategory() + "</td></tr>");  		
			}
			
			out.print("</table>");
			
			out.print("<h3>Users List</h3>");
			out.print("<table class='table'>");
			out.print("<tr><th>Name</th><th>Email</th><th>Address</th><th>Phone</th></tr>");
			
			for(User c: (List<User>)session.getAttribute("users"))
			{
				out.print("<tr><td>"+c.getUname()+"</td><td>"+c.getEmail()+"</td><td>"+c.getAddress()+"</td><td>"+c.getPhone()+"</td></tr>");  		
			}
			
			out.print("</table>");
			
			out.print("<h3>Completed Orders</h3>");
			out.print("<table class='table'>");
			out.print("<tr><th>Order Date</th><th>Total Amount</th></tr>");
			
			for(Order c: (List<Order>)session.getAttribute("orders"))
			{
				out.print("<tr><td>"+c.getOrderdate()+"</td><td>"+c.getTotalamount()+"</td></tr>");  		
			}
			
			out.print("</table>");
			
			out.print("</div>");
		}
       %> 
</div>
<script>

	document.getElementById("msg").innerHTML = "<%= (request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()) %>";
	
	setTimeout(function(){
	    document.getElementById("msg").innerHTML = '';
	}, 3000);
</script>
	
</body>
</html>