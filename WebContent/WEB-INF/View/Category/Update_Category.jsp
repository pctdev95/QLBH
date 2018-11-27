<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
			<form action="Update_Category_Controller" method="POST" style="margin-left: 200px; width: 1000px; ">
			  <div class="form-row">
			  </div>
			  <div class="form-group">
			   Id Category <input name="F_Id_Cate" type="text" class="form-control" id="inputAddress" value="<%= request.getAttribute("id") %>">
			  </div>
			  
			  <div class="form-group">
			   Name Category <input name="F_Name_Cate" type="text" class="form-control" id="inputAddress2" value="<%= request.getAttribute("name") %>">
			  </div>
			  
			  <div class="form-group">
			    Decription Category <input name="F_Decription_Cate" type="text" class="form-control" id="inputAddress2" value="<%= request.getAttribute("dec") %>">
			  </div>

			  <button type="submit" class="btn btn-primary">Update</button>
			</form>
			<!-- End Table Category -->
			<h5 style="background: red;"><%= request.getAttribute("mess1") != null ? request.getAttribute("mess1") : "" %></h5>
	  	</div>
	  	
	  	
	</div>
</body>
</html>