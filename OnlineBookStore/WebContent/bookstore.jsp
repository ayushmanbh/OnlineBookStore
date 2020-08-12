<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Online Book Store</title>
</head>
<body>
<div id="msg"></div>
<%
	if(session == null){
		out.print("<p>Please Login first.</p>");
		out.print("<a href=\"static/html/index.html\">Home</a>");
	}
%>
<h1>Welcome to Online Bootstore, <%=session.getAttribute("name").toString() %></h1>
<h3><a href="logout.jsp">Logout</a></h3>
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
    <table border=1>
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
                
                <td><input type="checkbox" name="titles" value="<%=rs.getString("title") %>" /><%=rs.getString("title") %></td>
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
    <input type="submit" value="Add to cart" />
    <a href="cart">Show cart</a>
</form>


<script>

	document.getElementById("msg").innerHTML = "<%= (request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()) %>";
	
	setTimeout(function(){
	    document.getElementById("msg").innerHTML = '';
	}, 3000);
</script>
</body>
</html>