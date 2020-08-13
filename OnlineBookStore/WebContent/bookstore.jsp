<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Online Book Store</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha512-MoRNloxbStBcD8z3M/2BmnT+rg4IsMxPkXaGh2zD6LGNNFE80W3onsAhRcMAMrSoyWL9xD7Ert0men7vR8LUZg=="
	crossorigin="anonymous" />
</head>
<body>
<div class="container">
<div id="msg"></div>
<%
	if(session == null){
		out.print("<p>Please Login first.</p>");
		out.print("<a href=\"static/html/index.html\">Home</a>");
	}
%>
<h1>Welcome to Online Bootstore, <%=session.getAttribute("name").toString() %></h1>
<a class="btn btn-secondary mb-2" href="logout.jsp">Logout</a>
<%
 try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bookstore?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from books where stock > 0");
    %>
    <form action="addtocart" method="post">
    <table class="table">
      <thead>
          <tr>
             <th>Title</th>
             <th>Author</th>
             <th>Publisher</th>
             <th>Category</th>
             <th>Price</th>

          </tr>
      </thead>
      <tbody>
        <%while(rs.next())
        {
            %>
            <tr>
                
                <td><span><input type="checkbox" name="titles" value="<%=rs.getString("title") %>" /></span> <%=rs.getString("title") %></td>
                <td><%=rs.getString("author") %></td>
                <td><%=rs.getString("publisher") %></td>
                <td><%=rs.getString("category") %></td>
                <td><%=rs.getDouble("price") %></td>   
 
            </tr>
            <%}%>
           </tbody>
        </table><br>
    <%}
    catch(Exception e){
        out.print(e);%><br><%
    }
    %>
    <input class="btn btn-primary" type="submit" value="Add to cart" />
    <a class="btn btn-primary" href="cart">Show cart</a>
    <a class="btn btn-primary" href="data.jsp">Download your Data</a>
</form>
</div>


<script>

	document.getElementById("msg").innerHTML = "<%= (request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()) %>";
	
	setTimeout(function(){
	    document.getElementById("msg").innerHTML = '';
	}, 3000);
</script>
</body>
</html>