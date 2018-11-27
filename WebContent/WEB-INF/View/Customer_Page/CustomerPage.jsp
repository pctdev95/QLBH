<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Bootstrap/dist/css/bootstrap.min.css">
<title>Customer Page</title>
</head>
<body>
<%-- 	<div class="row">
	
	  <div class="col-sm-3">
	  	<!-- Begin Sidebar -->
		<jsp:include page="Customer_Sidebar.jsp"></jsp:include>
		<!-- End Sidebar -->
	  </div>
	  
	  <div class="col-sm-10" style="margin-top: 0px; mar">
	  <!-- Begin Sidebar -->
	  <jsp:include page="Customer_Navbar.jsp"></jsp:include>
	  <!-- End Sidebar -->
	  </div>
	</div> --%>
	
	<div class="row">
	 	<div class="col-md-3">
			<!-- Begin Sidebar -->
			<jsp:include page="Customer_Sidebar.jsp"></jsp:include>
			<!-- End Sidebar -->
	 	</div>
	 	
	 	<div class="col-md-15" >
		  	<!-- Begin Sidebar -->
			<jsp:include page="Customer_Navbar.jsp"></jsp:include>
			<!-- End Sidebar -->
		</div>
  	</div>
	
	
	
<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>	
</body>
</html>