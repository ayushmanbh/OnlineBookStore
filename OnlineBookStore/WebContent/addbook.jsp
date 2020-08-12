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
<title>Add a Book</title>
</head>
<body>
	<div class="container" style="margin-top: 20px;">
		<form action="addbook" method="post" name="addbookform">
			<div class="form-group">
				<label for="inputEmail4">Book Title</label> <input type="text"
					class="form-control" id="inputEmail4" name="bname" onchange="checkExist()" required><p class="small" id="isE"></p>
			</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputPassword4">Book Author</label> <input type="text"
					class="form-control" id="inputPassword4" name="bauthor" required>
			</div>
			<div class="form-group col-md-6">
			<label for="inputAddress">Book Publisher</label> <input type="text"
				class="form-control" id="inputAddress" name="bpub">
		</div>
		</div>
		
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="inputCity">Book Price</label> <input type="text"
					class="form-control" id="inputCity" name="bprice" required>
			</div>
			<div class="form-group col-md-4">
				<label for="inputstock">Book stock</label> <input type="number"
					class="form-control" id="inputstock" name="bstock" min="1" max="100" required>
			</div>
			<div class="form-group col-md-4">
				<label for="inputState">Book Category</label> <select id="inputState"
					class="form-control" name="bcat" required>
					<option selected>Choose...</option>
					<option value="history">History</option>
					<option value="arts">Arts</option>
					<option value="science">Science</option>
					<option value="math">Math</option>
				</select>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Add Book</button>
		<a class="btn btn-secondary" href="adminoffice.jsp">Cancel</a>
	</form>		
	</div>	
</body>

<script type="text/javascript">
		function checkExist(){
		    var xmlhttp = new XMLHttpRequest();
		    var title = document.forms["addbookform"]["bname"].value;
		    var url = "exists.jsp?title=" + title;
		    xmlhttp.onreadystatechange = function(){
		        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
		            if(xmlhttp.responseText === "Book title already exists")
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