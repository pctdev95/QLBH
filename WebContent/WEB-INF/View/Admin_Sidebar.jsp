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
		    <div class="brand" style="height: 56px; text-align: center; font-size: 25px; line-height: 50px; display: block;background-color: #23282e;">Admin: <%= session.getAttribute("sessionName") %></div>
		    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
		  
		        <div class="menu-list">
		  
		            <ul id="menu-content" class="menu-content collapse out">
		                <li>
		                  <a href="#">
		                  <i class="fa fa-dashboard fa-sm" style="margin-right: 15px;"></i>     Home
		                  </a>
		                </li>
		
		                <li  data-toggle="collapse" data-target="#employee" class="collapsed">
		                  <a href="#"><i class="fa fa-user fa-sm" style="margin-right: 15px;"></i> Employee manage </a>
		                </li>
		                <ul class="sub-menu collapse" id="employee">
		                    <li><a href="Add_Employee_Forward_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Add new employee</a></li>
		                    <li><a href="Get_Employee_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Update employee</a></li>
		                    <li><a href="Get_Employee_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Delete employee</a></li>
		                    <li><a href="Get_Employee_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Report employee</a></li>
		                    <li><a href="#"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Report salary</a></li>
		                </ul>
		
		
		                <li data-toggle="collapse" data-target="#category" class="collapsed">
		                  <a href="#"><i class="fa fa-align-justify fa-sm" style="margin-right: 15px;"></i> Category manage </a>
		                </li>  
		                <ul class="sub-menu collapse" id="category">
		                  <li><a href="Add_Category_Forward_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Add new category </a></li>
		                  <li><a href="Get_Category_Controller" method="GET"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Update category </a></li>
		                  <li><a href="Get_Category_Controller" method="GET"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Delete category </a></li>
		                  <li><a href="Get_Category_Controller" method="GET"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Report category </a></li>
		                </ul>
		                

		                <li data-toggle="collapse" data-target="#typeproduct" class="collapsed">
		                  <a href="#"><i class="fa fa-cube fa-sm" style="margin-right: 15px;"></i> Product type manage </a>
		                </li>  
		                <ul class="sub-menu collapse" id="typeproduct">
		                  <li><a href="Add_Product_Type_Forward_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Add new product type </a></li>
		                  <li><a href="Get_Product_Type_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Update product type </a></li>
		                  <li><a href="Get_Product_Type_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Delete product type </a></li>
		                  <li><a href="Get_Product_Type_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Report product type </a></li>
		                </ul>
		                
		                
		                <li data-toggle="collapse" data-target="#product" class="collapsed">
		                  <a href="#"><i class="fa fa-cubes fa-sm" style="margin-right: 15px;"></i> Product manage </a>
		                </li>  
		                <ul class="sub-menu collapse" id="product">
		                  <li><a href="Add_Product_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Add new product </a></li>
		                  <li><a href="Get_Product_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Update product </a></li>
		                  <li><a href="Get_Product_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Delete product </a></li>
		                  <li><a href="Get_Product_Controller"><i class=" fa fa-angle-right fa-sm" style="margin-left: 30px; margin-right: 10px"></i> Report product </a></li>
		                </ul>
		                
		                
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