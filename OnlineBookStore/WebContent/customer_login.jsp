<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha512-MoRNloxbStBcD8z3M/2BmnT+rg4IsMxPkXaGh2zD6LGNNFE80W3onsAhRcMAMrSoyWL9xD7Ert0men7vR8LUZg=="
	crossorigin="anonymous" />

</head>

<body>
	<div class="container" style="margin-top: 20px;">
	<div id="msg"></div>
		<form action="customerlogin" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Username</label> <input
					type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="uname" required> <small id="emailHelp"
					class="form-text text-muted">We'll never share your details
					with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="exampleInputPassword1" name="pass" required>
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
			<a class="btn btn-primary" href="register.jsp">Sign up</a>
			<a class="btn btn-primary" href="static/html/index.html">Home</a>
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