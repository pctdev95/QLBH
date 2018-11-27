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

<title>Update Product Type</title>
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
		  	
		  	<!-- Begin Form Add Product Type -->
		  	<div style="margin-top: 20px;">
		  	<h3 style="text-align: center;">UPDATE PRODUCT TYPE</h3>
		  	
			<form action="Update_Product_Type_Controller" method="POST" style="margin-left: 200px; margin-top:10px; width: 1000px; ">
			  <div class="form-row">
			  </div>
			  <div class="form-group">
			   Id Product type <input name="F_Id_PT" type="text" class="form-control" id="inputAddress" value="<%= request.getAttribute("idPT")%>">
			  </div>
			  
			  <div class="form-group">
			   Name Product type <input name="F_Name_PT" type="text" class="form-control" id="inputAddress2" value="<%= request.getAttribute("namePT")%>">
			  </div>

			  <div class="form-group">
			    Decription Product type <input name="F_Decription_PT" type="text" class="form-control" id="inputAddress2" value="<%= request.getAttribute("decPT")%>">
			  </div> 
			  
			  
			  <div class="form-group">
			  <label for="sel1">Category:</label>
			  <select name="dropDownCate" class="form-control" id="sel1">
				  <c:forEach items="${listCate}" var="list">
					<option value="${list.id_Category}">${list.name_Category}</option>
				  </c:forEach>
			  </select>
			  </div>
			  
			  
			  <br/>
			  <br/>
			  <br/>
			  <br/>

			   <button type="submit" class="btn btn-primary">Save</button> 
			</form>
			</div>
			<!-- End Form Add Product Type -->
			<h5 style="background: red;"><%= request.getAttribute("msg1") != null ? request.getAttribute("msg1") : "" %></h5>
	  	</div>
	  	
	  	
	  	
	  	
	  	
	  	
	</div>
	
<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>	
</body>
</html>