<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha512-MoRNloxbStBcD8z3M/2BmnT+rg4IsMxPkXaGh2zD6LGNNFE80W3onsAhRcMAMrSoyWL9xD7Ert0men7vR8LUZg=="
	crossorigin="anonymous" />
<title>Sign up</title>
</head>
<body>
	<div class="container" style="margin-top: 20px;">
		<form action="register" method="post" name="registerform">
			<div class="form-group">
				<label for="inputEmail4">Name</label> <input type="text"
					class="form-control" id="inputEmail4" name="uname" onchange="checkExist()" required><p class="small" id="isE"></p>
			</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputPassword4">Password</label> <input type="password"
					class="form-control" id="inputPassword4" name="pass" required>
			</div>
			<div class="form-group col-md-6">
			<label for="inputAddress">Email</label> <input type="email"
				class="form-control" id="inputAddress" name="mail" required>
		</div>
		</div>
		
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="inputCity">Address</label> <input type="text"
					class="form-control" id="inputCity" name="address" required>
			</div>
			<div class="form-group col-md-4">
				<label for="inputstock">Phone</label> <input type="text"
					class="form-control" id="inputstock" name="phone" placeholder="xxx-xxx-xxxx" pattern="^\d{3}-\d{3}-\d{4}$" required>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Sign up</button>
		<a class="btn btn-secondary" href="customer_login.jsp">Cancel</a>
	</form>		
	</div>	
</body>

<script type="text/javascript">
		function checkExist(){
		    var xmlhttp = new XMLHttpRequest();
		    var uname = document.forms["registerform"]["uname"].value;
		    var url = "custexists.jsp?uname=" + uname;
		    xmlhttp.onreadystatechange = function(){
		        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
		            if(xmlhttp.responseText === "User name already taken")
		            	document.getElementById("isE").className = "small text-warning";
		            else
		            	document.getElementById("isE").className = "small text-warnings";
		            	document.getElementById("isE").innerHTML = xmlhttp.responseText;
		        }
		        
		    };
		    try{
			    xmlhttp.open("GET",url,true);
			    xmlhttp.send();
			}catch(e){
				alert("unable to connect to server");
			}
		}


</script>



</html>