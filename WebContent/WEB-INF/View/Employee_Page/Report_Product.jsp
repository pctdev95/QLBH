<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="Bootstrap/dist/css/sidebar.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<title>Product Table</title>
</head>
<body>
	
	<div class="row">
	  	<div class="col-sm-2">
			<!-- Begin Navbar -->
			<jsp:include page="/WEB-INF/View/Employee_Page/Employee_Sidebar.jsp"></jsp:include>
			<!-- End Navbar -->
		</div>
		
	  	<div class="col-sm-10">
	  		<!-- Begin Sidebar -->
			<jsp:include page="/WEB-INF/View/Employee_Page/Employee_Navbar.jsp"></jsp:include>
		  	<!-- End Sidebar -->
		  	
		  	<!-- Begin search -->
		  	<div style="margin-top: 20px">
		  	<h3 style="text-align: center;">REPORT PRODUCT</h3>
		  	
			  	<form action="Report_Product_Emp" method="POST" style="margin-left: 50px; margin-top: 20px">
			  		<div class="form-row">
			  			<div class="col-md-2 mb-4">
			  				<label for="formGroupExampleInput">Id Product</label>
			  				<input name="Search_Id" class="form-control" type="text" placeholder="Id Product">
			  			</div>
			  			
			  			
			  			<div class="col-md-4 mb-4">
					  	  <label for="formGroupExampleInput">Product type</label>
						  <select name="dropDownProt" class="form-control" id="sel1">
						  		<option value="">Choose Product Type</option>
							  <c:forEach items="${listProt}" var="list">
								<option value="${list.id_Product_Type}">${list.name_Product_Type}</option><%-- ${list.name_Product_Type} --%>
							  </c:forEach>
						  </select>
						</div>
						
						<div class="col-md-4 mb-4">
					  	  <label for="formGroupExampleInput">Category</label>
						  <select name="dropDownCate" class="form-control" id="sel1">
						  		<option value="">Choose Category</option>
							  <c:forEach items="${listCategory}" var="list">
								<option value="${list.id_Category}">${list.name_Category}</option><%-- ${list.name_Category} --%>
							  </c:forEach>
						  </select>
						</div>
						
					  	<div class="col-md-2 mb-4" style="margin-top: 32px;">
			      			<button type="submit" class="btn btn-primary" style="width: 60px; height: 40px"><i class="fa fa-search fa-lg"></i></button>
			      		</div>
			  		</div>
			    </form>
		  	<!-- End Search -->
		  	
		  	
		  	<!-- Begin Table -->
		  	<table class="table table-sm" border="1px" style="margin-top: 25px; margin-left: 25px; margin-right: auto; width: 1550px" >
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col" style="width: 4%">Id</th>
			      <th scope="col" style="width: 80px">Name</th>
			      <th scope="col" style="width: 100px">Calculation</th>
				  <th scope="col" style="width: 30px">Manufacturer</th>
				  <th scope="col" style="width: 100px">Export Price</th> 
				  <th scope="col" style="width: 80px">In Stock</th>
				  <th scope="col" style="width: 70px">Id Product Type</th> 
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${listProduct}" var="list">
			    	<tr>
				      <td>${list.id_Product}</td> <!-- Chu cai dau tien phai la chu thuong mac du trong BEAN la chu hoa -->
				      <td>${list.name_Product}</td>
				      <td>${list.calculation_Unit}</td>
 				      <td>${list.manufacturer}</td>
				      <td>${list.export_Prices_Product}</td>
				      <td>${list.in_Stock}</td> 
				      <td>${list.id_Product_Type}</td>
     
				      		      
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