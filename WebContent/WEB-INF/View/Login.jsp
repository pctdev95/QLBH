<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Bootstrap/dist/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="Bootstrap/css/Admin.css"> -->
<link rel="stylesheet" href="Bootstrap/dist/css/Login.css">
<title>Login Page</title>
</head>
<body id="LoginForm">
<%-- 	<div class="container">
	  <div class="row">
	    <div class="col">
	      You can put something in here
	    </div>
	    <div class="col">
	    
	      <form action="Login_Controller" method="POST" style="background-color: white; margin-top: 200px">
	      
			  <div class="form-group">
			    <label class="col-form-label" for="formGroupExampleInput">Account</label>
			    <input name="F_Account" type="text" class="form-control" id="formGroupExampleInput" placeholder="Please Input your Account" required>
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input name="F_Password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Please Input your Password" required>
			  </div>
			  
			  <button type="submit" class="btn btn-dark">Login</button>
			  
			</form>
			
			<br/>
			
			<h5><%= request.getAttribute("mess1") != null ? request.getAttribute("mess1") : "" %></h5> 
			
	    </div>
	    <div class="col">
	      You can put something in here
	    </div>
	  </div>
	</div> --%>
	
	<div class="container">
		<div class="login-form">
		<div class="main-div">
		   <div class="panel">
		   <h1>LOGIN</h1>
		   <p>Please enter your account and password</p>
		   </div>
		   <form id="Login" action="Login_Controller" method="POST">
		
		        <div class="form-group">
		            <input name="F_Account" type="text" class="form-control" placeholder="Account" required>
		        </div>
		
		        <div class="form-group">
		            <input name="F_Password" type="password" class="form-control" id="inputPassword" placeholder="Password" required>
		        </div>
		        
		        <div class="forgot">
		        	<a href="Register_Controller">Register</a>
				</div>
		        <button type="submit" class="btn btn-primary">Login</button>
		
		   </form>
		   
		<div class="noi">
			<h5><%= request.getAttribute("mess1") != null ? request.getAttribute("mess1") : "" %></h5>
		</div>
		
		</div>
		</div>
	</div>
	
<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>