<%@page import="com.bookstore.server.Server"%>
<%@page import="com.bookstore.services.OrderDao"%>
<%@page import="com.bookstore.models.Order"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Download your data</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha512-MoRNloxbStBcD8z3M/2BmnT+rg4IsMxPkXaGh2zD6LGNNFE80W3onsAhRcMAMrSoyWL9xD7Ert0men7vR8LUZg=="
	crossorigin="anonymous" />
</head>
<body>
<div class="container">
<h1><%=session.getAttribute("name").toString() %>'s Data</h1>
      <form action="download" method="post">
         <table class="table">
            <tr>
               <td>Order Id</td>
               <td>Order Date</td>
               <td>Book title</td>
               <td>Book Price</td>
            </tr>
            <%
            	OrderDao.connection = Server.getConnect();
            	OrderDao orderDao = new OrderDao();
               List<Order> orders  = orderDao.getCompletedOrdersByUserid((Integer)session.getAttribute("userid"));
               for(Order e: orders){
               %>
            <tr>
               <td><%=e.getOrderid()%></td>
               <td><%=e.getOrderdate()%></td>
               <td><%=e.getTitle()%></td>
               <td><%=e.getTotalamount()%></td>
            </tr>
            <% 
               }
               %>
         </table>
         <input class="btn btn-primary" type="submit" value="Download"/>
         <a href="bookstore" class="btn btn-primary">Continue Shopping...</a>
      </form>
      </div>
</body>
</html>