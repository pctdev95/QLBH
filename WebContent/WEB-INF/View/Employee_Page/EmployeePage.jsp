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
<title>Employee Page</title>
</head>
<body>
	<div class="row">
	
	  <div class="col-sm-2">
	  	<!-- Begin Sidebar -->
		<jsp:include page="/WEB-INF/View/Employee_Page/Employee_Sidebar.jsp"></jsp:include>
		<!-- End Sidebar -->
	  </div>
	  
	  <div class="col-sm-10" >
	  <!-- Begin Sidebar -->
	  <jsp:include page="/WEB-INF/View/Employee_Page/Employee_Navbar.jsp"></jsp:include>
	  <!-- End Sidebar -->
	  </div>
	</div>
	

	
	
	
	
<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>	
</body>
</html>