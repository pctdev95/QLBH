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
<title>Update Employee</title>
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
		  	<h3 style="text-align: center;">UPDATE EMPLOYEE</h3>
		  	
			<form action="Update_Employee_Controller" method="POST" class="needs-validation" style="margin-top: 20px; margin-left: 300px; width: 1000px">
			
			  <div class="form-row">
			  
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip01">ID Employee</label>
			      <input type="text" class="form-control" id="validationTooltip01"  required value="<%= request.getAttribute("idemp")%>" name="Idemp">
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip02">First name</label>
			      <input type="text" class="form-control" id="validationTooltip02"   required value="<%= request.getAttribute("fname")%>" name="Fname">
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltipUsername">Last name</label>
			      <input type="text" class="form-control" id="validationTooltipUsername"   required value="<%= request.getAttribute("lname")%>" name="Lname">
			    </div>
			    
			  </div>
			  
			  <div class="form-row">
			  
			  	<div class="col-md-4 mb-3">
			  	  <label for="formGroupExampleInput">Gender</label>
				  <select name="dropDownGen" class="form-control" id="sel1">
						<option value="1">Male</option>
						<option value="0">Female</option>
				  </select>
			  	</div>
			  	
			  	<div class="col-md-4 mb-3">
			      <label for="validationTooltipUsername">DOB</label>
			      <input type="text" class="form-control" id="validationTooltipUsername"   required value="<%= request.getAttribute("dob")%>" name="Dob">
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltipUsername">ID Card</label>
			      <input type="text" class="form-control" id="validationTooltipUsername"   required value="<%= request.getAttribute("card")%>" name="Card">
			    </div>
			  	
			  </div>
			  
			  <div class="form-row">
			  
			    <div class="col-md-6 mb-3">
			      <label for="validationTooltip03">Address</label>
			      <input type="text" class="form-control" id="validationTooltip03"  required value="<%= request.getAttribute("add")%>" name="Add">
			    </div>
			    
			    <div class="col-md-3 mb-3">
			      <label for="validationTooltip04">Phone number</label>
			      <input type="text" class="form-control" id="validationTooltip04"  required value="<%= request.getAttribute("pho")%>" name="Pho">
			    </div>
			    
			    <div class="col-md-3 mb-3">
			      <label for="validationTooltip05">Department</label>
			      <input type="text" class="form-control" id="validationTooltip05"  required value="<%= request.getAttribute("dep")%>" name="Dep">
			    </div>
			    
			  </div>
			  
			  <div class="form-row">
			  
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip03">Salary</label>
			      <input type="text" class="form-control" id="validationTooltip03" required value="<%= request.getAttribute("sal")%>" name="Sal">
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip04">Account</label>
			      <input type="text" class="form-control" id="validationTooltip04" required value="<%= request.getAttribute("acc")%>" name="Acc">
			    </div>
			    
			    
			  </div>
			  <div class="row">
			  <button class="btn btn-primary col-sm-3" type="submit">Update Employee</button>
			  </div>
			  
			</form>

			  

			</div>
			<!-- End Form -->
			
			<!-- Begin mess1 -->
			<h5 style="background: #ccffcc; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg1") != null ? request.getAttribute("msg1") : "" %></h5>
			<!-- End mess1 -->
			
			<!-- Begin mess2 -->
			<h5 style="background: #ff3333; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg2") != null ? request.getAttribute("msg2") : "" %></h5>
			<!-- End mess2 -->
			
			
	  	</div>
	  	
	</div>


<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>