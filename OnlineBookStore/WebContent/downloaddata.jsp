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

</head>
<body>
<h1><%=session.getAttribute("name").toString() %>'s Data</h1>
      
         <table border="1">
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
               if (orders != null) {
                   response.setContentType("application/vnd.ms-excel");
                   response.setHeader("Content-Disposition", "attachment; filename="+ "data.xls");
               }
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
</body>
</html>