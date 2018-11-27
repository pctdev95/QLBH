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
<title>Insert title here</title>
</head>
<body>

<div class="nav-side-menu">
		    <div class="brand" style="height: 56px; text-align: center; font-size: 25px; line-height: 50px; display: block;background-color: #23282e;">Customer: <%= session.getAttribute("sessionName") %></div>
		    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
		  
		        <div class="menu-list">
		  
		            <ul id="menu-content" class="menu-content collapse out">
		                <li>
		                  <a href="#">
		                  <i class="fa fa-dashboard fa-sm" style="margin-right: 15px;"></i> Home
		                  </a>
		                </li>
		                                
		                <li data-toggle="collapse" data-target="#customer" class="collapsed">
		                  <a href="#"><i class="fa fa-users fa-sm" style="margin-right: 15px;"></i> Customer manage </a>
		                </li>  
		                <ul class="sub-menu collapse" id="customer">
		                  <li><a href="#"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Delete product </a></li>
		                  <li><a href="#"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Report customer </a></li>
		                </ul>		                

		
		                <li data-toggle="collapse" data-target="#order" class="collapsed">
		                  <a href="#"><i class="fa fa-shopping-cart fa-sm" style="margin-right: 15px;"></i> Order </a>
		                </li>
		                <ul class="sub-menu collapse" id="order">
		                  <li><a href="#"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Report order </a></li>
		                </ul>
		                
		            </ul>
		     </div>
		</div>

<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>