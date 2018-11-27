<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		  
		  <!-- Begin search -->
		  	<div style="margin-top: 20px">
		  	<h3 style="text-align: center;">REPORT CATEGORY</h3>
		  	
		  	<div style="width: 200px; margin-left: 40px; margin-top: 10px" class="row" >
			  	<form action="Report_Category_Emp" method="POST">
			  		<div class="row">
			  			<input name="Search_Id" class="form-control col-sm-10" type="text" placeholder="Id Category">
			      		<button type="submit" class="btn btn-primary col-sm-2"><i class="fa fa-search fa-sm"></i></button>
			  		</div>
			    </form>
			</div>
		  	<!-- End Search -->
		  
	  		<!-- Begin Table Category -->
		  	<table class="table table-sm" border="1px" style="width: 1550px; margin-top: 25px; margin-left: 25px " >
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Name</th>
			      <th scope="col">Decription</th>
			    </tr>
			  </thead>
			  <tbody>
			  
			    <c:forEach items="${listCategory}" var="list">
			    	<tr>
				      <td>${list.id_Category}</td> <!-- Chu cai dau tien phai la chu thuong mac du trong BEAN la chu hoa -->
				      <td>${list.name_Category}</td>
				      <td>${list.decription_Category}</td>		      
				    </tr>    
			    </c:forEach>
			    
			  </tbody>
			</table>
			<!-- End Table Category -->
	  </div>
	</div>
	</div>
</body>
</html>