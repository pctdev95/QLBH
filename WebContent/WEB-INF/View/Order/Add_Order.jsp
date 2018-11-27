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
	  
		<!-- Begin Form -->
		  	<div style="margin-top: 20px; margin-left: auto; margin-right: auto;">
		  	<h3 style="text-align: center;">ADD NEW ORDER</h3>
		  	
			<form action="Add_Order_Controller" method="POST" style="margin-top: 20px; margin-left: 300px; width: 1000px">
			
			  <div class="form-row">
			  
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip01">ID Customer</label>
			      <input type="text" class="form-control" id="validationTooltip01"  name="idcus" required>
			    </div>	
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip01">Order date</label>
			      <input type="text" class="form-control" id="validationTooltip01"  name="odate" required value="<%= request.getAttribute("sysdate") %>">
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip01">ID Employee</label>
			      <input type="text" class="form-control" id="validationTooltip01" name="idemp" required value="<%= session.getAttribute("sessionName") %>">
			    </div>
			    		    
			  </div>
			  
			 
			  
			  <button class="btn btn-primary" type="submit">Add Order</button>
			  
			</form>

			  

			</div>
			<!-- End Form -->
	  
	  
	  
	  
	  </div>
	</div>
	


	
	
	
<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>	
</body>
</html>