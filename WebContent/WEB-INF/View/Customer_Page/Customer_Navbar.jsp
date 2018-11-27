<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="Bootstrap/css/Admin.css">
<link rel="stylesheet" href="Bootstrap/dist/css/sidebar.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		
		    <!-- Begin Logout Button-->
			<form class="form-inline my-2 my-lg-0" action="Logout_Controller" method="POST">
		      <button type="submit" class="btn btn-outline-danger" style="margin-left: 1490px;">Logout</button>
		    </form>
		    <!-- End Logout Button-->
		    
		  </div>
		</nav>

<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script> 
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>