<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha512-MoRNloxbStBcD8z3M/2BmnT+rg4IsMxPkXaGh2zD6LGNNFE80W3onsAhRcMAMrSoyWL9xD7Ert0men7vR8LUZg=="
	crossorigin="anonymous" />
</head>
<body>
<div class="container">
	<p id="msg" class="lead"></p>
	
	<a href="bookstore" class="btn btn-primary">Continue Shopping...</a>

</div>


<script>

	document.getElementById("msg").innerHTML = "<%= (request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()) %>";

</script>
</body>
</html>