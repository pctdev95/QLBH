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
<title>Table Category</title>
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
		  	
		  	<!-- Begin Table Category -->
		  	<table class="table table-sm" border="1px" style="width: 1550px; margin-top: 25px; margin-left: 25px " >
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Name</th>
			      <th scope="col">Decription</th>
				  <th scope="col">Update</th>
				  <th scope="col">Delete</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${listCategory}" var="list">
			    	<tr>
				      <td>${list.id_Category}</td> <!-- Chu cai dau tien phai la chu thuong mac du trong BEAN la chu hoa -->
				      <td>${list.name_Category}</td>
				      <td>${list.decription_Category}</td>
				      <td>
				      	<a href="Update_Category_Controller?id=${list.id_Category}"><button type="submit" class="btn btn-info btn-sm">Update</button></a>
				      </td>
				      <td>
				      	<a href="Delete_Category_Controller?id=${list.id_Category}"><button type="submit" class="btn btn-danger btn-sm">Delete</button></a>
				      </td>			      
				    </tr>    
			    </c:forEach>
			  </tbody>
			</table>
			<!-- End Table Category -->
			
			<!-- Begin mess1 -->
			<h5 style="background: red;"><%= request.getAttribute("mess1") != null ? request.getAttribute("mess1") : "" %></h5>
			<!-- End mess1 -->
			
			<!-- Begin mess2 -->
			<h5 style="background: red;"><%= request.getAttribute("mess2") != null ? request.getAttribute("mess2") : "" %></h5>
			<!-- End mess2 -->
			
			
	  	</div>
	  	
	</div>


<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>