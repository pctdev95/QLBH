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
<title>Product Table</title>
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
		  	<h3 style="text-align: center;">TABLE PRODUCT</h3>
		  	
		  	<div style="width: 200px; margin-left: 40px; margin-top: 10px" class="row" >
			  	<form action="Get_Product_Controller" method="POST">
			  		<div class="row">
			  			<input name="Search_Id" class="form-control col-sm-10" type="text" placeholder="Id Product">
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
			      <th scope="col" style="width: 80px">Name</th>
			      <th scope="col" style="width: 100px">Calculation</th>
				  <th scope="col" style="width: 30px">Manufacturer</th>
	 			  <th scope="col" style="width: 150px">Import Date</th> 
				  <th scope="col" style="width: 80px">Import Price</th>
				  <th scope="col" style="width: 100px">Export Price</th> 
				  <th scope="col" style="width: 80px">In Stock</th>
				  <th scope="col" style="width: 70px">Id Product Type</th> 
				  <th scope="col" style="width: 70px">Update</th> 
				  <th scope="col" style="width: 70px">Delete</th> 
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${listProduct}" var="list">
			    	<tr>
				      <td>${list.id_Product}</td> <!-- Chu cai dau tien phai la chu thuong mac du trong BEAN la chu hoa -->
				      <td>${list.name_Product}</td>
				      <td>${list.calculation_Unit}</td>
 				      <td>${list.manufacturer}</td>
				      <td>${list.import_Date}</td>
		 		      <td>${list.import_Prices_Product}</td>
				      <td>${list.export_Prices_Product}</td>
				      <td>${list.in_Stock}</td> 
				      <td>${list.id_Product_Type}</td>
     
				      <td>
				      	<a href="Update_Product_Controller?id=${list.id_Product}"><button type="submit" class="btn btn-info btn-sm">Update</button></a>
				      </td>
				      <td>
				      	<a href="Delete_Product_Controller?id=${list.id_Product}"><button type="submit" class="btn btn-danger btn-sm">Delete</button></a>
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