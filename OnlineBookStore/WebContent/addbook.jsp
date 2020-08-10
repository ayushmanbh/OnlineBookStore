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
		<form action="addbook" method="post">
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputEmail4">Book Title</label> <input type="text"
					class="form-control" id="inputEmail4" name="bname" required>
			</div>
			<div class="form-group col-md-6">
				<label for="inputPassword4">Book Author</label> <input type="text"
					class="form-control" id="inputPassword4" name="bauthor" required>
			</div>
		</div>
		<div class="form-group">
			<label for="inputAddress">Book Publisher</label> <input type="text"
				class="form-control" id="inputAddress" name="bpub">
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputCity">Book Price</label> <input type="text"
					class="form-control" id="inputCity" name="bprice" required>
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
	</form>		
	</div>	
</body>
</html>