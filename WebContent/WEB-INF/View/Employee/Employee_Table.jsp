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
		  	
		  	<!-- Begin search -->
		  	<div style="margin-top: 20px">
		  	<h3 style="text-align: center;">TABLE EMPLOYEE</h3>
		  	
		  	<div style="width: 200px; margin-left: 40px; margin-top: 10px" class="row" >
			  	<form action="Get_Employee_Controller" method="POST">
			  		<div class="row">
			  			<input name="Search_Id" class="form-control col-sm-10" type="text" placeholder="Id Employee">
			      		<button type="submit" class="btn btn-primary col-sm-2"><i class="fa fa-search fa-sm"></i></button>
			  		</div>
			    </form>
			</div>
		  	<!-- End Search -->
		  	
		  	<!-- Begin Table -->
		  	<table class="table table-sm" border="1px" style="margin-top: 25px; margin-left: 25px; margin-right: auto; width: 1550px" >
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col" style="width: 4%">Id</th>
			      <th scope="col" style="width: 80px">First name</th>
			      <th scope="col" style="width: 100px">Last name</th>
				  <th scope="col" style="width: 30px">Gender</th>
	 			  <th scope="col" style="width: 150px">DOB</th> 
				  <th scope="col" style="width: 80px">ID Card</th>
				  <th scope="col" style="width: 100px">Address</th> 
				  <th scope="col" style="width: 80px">Phone</th>
				  <th scope="col" style="width: 70px">Department</th> 
				  <th scope="col" style="width: 70px">Salary</th>
				  <th scope="col" style="width: 30px">Account</th>
				  <th scope="col" style="width: 30px">Update</th>
				  <th scope="col" style="width: 30px">Delete</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${listEmployee}" var="list">
			    	<tr>
				      <td>${list.id_Employee}</td> <!-- Chu cai dau tien phai la chu thuong mac du trong BEAN la chu hoa -->
				      <td>${list.first_Name}</td>
				      <td>${list.last_Name_Employee}</td>
				      <td>${list.gender_Employee == true ? "Male" : "Female"}</td>
				      <td>${list.DOB_Employee}</td>
		 		      <td>${list.id_Card_Employee}</td>
				      <td>${list.address_Employee}</td>
				      <td>${list.phone_Employee}</td> 
				      <td>${list.department_Employee}</td> 
				      <td>${list.salary_Employee}</td>
				      <td>${list.account_User}</td>
				      
     
				      <td>
				      	<a href="Update_Employee_Controller?id=${list.id_Employee}"><button type="submit" class="btn btn-info btn-sm">Update</button></a>
				      </td>
				      <td>
				      	<a href="Delete_Employee_Controller?id=${list.id_Employee}"><button type="submit" class="btn btn-danger btn-sm">Delete</button></a>
				      </td>			      
				    </tr>    
			    </c:forEach>
			  </tbody>
			</table>
			<!-- End Table -->
			
			<!-- Begin mess1 -->
			<h5 style="background: #ccffcc; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg1") != null ? request.getAttribute("msg1") : "" %></h5>
			<!-- End mess1 -->
			
			<!-- Begin mess2 -->
			<h5 style="background: #ff3333; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg2") != null ? request.getAttribute("msg2") : "" %></h5>
			<!-- End mess2 -->
			</div>
	  	</div>	
	</div>
	


<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>