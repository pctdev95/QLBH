<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="Bootstrap/css/Admin.css">
<link rel="stylesheet" href="Bootstrap/dist/css/sidebar.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<title>Add Employee</title>
</head>
<body>
	
	<div class="row">
	  	<div class="col-sm-2">
			<!-- Begin Navbar -->
			<jsp:include page="/WEB-INF/View/Admin_Sidebar.jsp"></jsp:include>
			<!-- End Navbar -->
		</div>
	  	<div class="col-sm-10">
	  		<!-- Begin Sidebar -->
			<jsp:include page="/WEB-INF/View/Admin_Navbar.jsp"></jsp:include>
		  	<!-- End Sidebar -->
		  	
		  	<!-- Begin Form -->
		  	<div style="margin-top: 20px; margin-left: auto; margin-right: auto;">
		  	<h3 style="text-align: center;">ADD NEW EMPLOYEE</h3>
		  	
			<form action="Add_Employee_Controller" method="POST" style="margin-top: 20px; margin-left: 300px; width: 1000px">
			
			  <div class="form-row">
			  
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip01">ID Employee</label>
			      <input type="text" class="form-control" id="validationTooltip01" placeholder="EMP01" name="idemp">
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip02">First name</label>
			      <input type="text" class="form-control" id="validationTooltip02" placeholder="Nam" name="fname">
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltipUsername">Last name</label>
			      <input type="text" class="form-control" id="validationTooltipUsername" placeholder="Nguyen Van " name="lname">
			    </div>
			    
			  </div>
			  
			  <div class="form-row">
			  
			  	<div class="col-md-4 mb-3">
			  	  <label for="formGroupExampleInput">Gender</label>
				  <select name="dropDownGend" class="form-control" id="sel1">
						<option value="1">Male</option>
						<option value="0">Female</option>
				  </select>
			  	</div>
			  	
			  	<div class="col-md-4 mb-3">
			      <label for="validationTooltipUsername">DOB</label>
			      <input type="text" class="form-control" id="validationTooltipUsername" placeholder="YYYY-MM-DD" name="dob">
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltipUsername">ID Card</label>
			      <input type="text" class="form-control" id="validationTooltipUsername" name="card">
			    </div>
			  	
			  </div>
			  
			  <div class="form-row">
			  
			    <div class="col-md-6 mb-3">
			      <label for="validationTooltip03">Address</label>
			      <input type="text" class="form-control" id="validationTooltip03" placeholder="123 - LeLoi St, DongThap" name="addr">
			    </div>
			    
			    <div class="col-md-3 mb-3">
			      <label for="validationTooltip04">Phone number</label>
			      <input type="text" class="form-control" id="validationTooltip04" placeholder="012345679" name="phone">
			    </div>
			    
			    <div class="col-md-3 mb-3">
			      <label for="validationTooltip05">Department</label>
			      <input type="text" class="form-control" id="validationTooltip05" placeholder="Seller" name="depar">
			    </div>
			    
			  </div>
			  
			  <div class="form-row">
			  
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip03">Salary</label>
			      <input type="text" class="form-control" id="validationTooltip03" name="salar">
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip04">Account</label>
			      <input type="text" class="form-control" id="validationTooltip04" name="accu">
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip04">Password</label>
			      <input type="password" class="form-control" id="validationTooltip04" name="passw">
			    </div>
			    
			  </div>
			  
			  <button class="btn btn-primary" type="submit">Add Employee</button>
			  
			</form>

			  

			</div>
			<!-- End Form -->
			
			<!-- Begin mess1 -->	
			<h5 style="background: #ccffcc; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg1") != null ? request.getAttribute("msg1") : "" %></h5>
			<!-- End mess1 -->
			<h5 style="background: #ff3333; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg2") != null ? request.getAttribute("msg2") : "" %></h5>
		
			
			
			
	  	</div>
	  	
	</div>


<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>