<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="Bootstrap/dist/css/payment.css">
<link rel="stylesheet" href="Bootstrap/dist/css/sidebar.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<title>Employee Page</title>
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
	  
	  		<h5 style="background: #ccffcc; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg1") != null ? request.getAttribute("msg1") : "" %></h5>
			<!-- End mess1 -->
			<h5 style="background: #ff3333; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg2") != null ? request.getAttribute("msg2") : "" %></h5>
	  		<h5 style="background: #ccffcc; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg3") != null ? request.getAttribute("msg3") : "" %></h5>
			<!-- End mess1 -->
			<h5 style="background: #ff3333; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg4") != null ? request.getAttribute("msg4") : "" %></h5>
		<!-- Begin Form -->
			<div class="row">
			
<%-- 			<div class="col-sm-2">
			
				<form action="Add_Order_Detail_Controller" method="POST">
					<div class="form-group">
				     	<label for="">ID Product</label>     
				        <input type="text" class="form-control"  aria-label="MM" aria-describedby="basic-addon1" name="idpro" required>         
					</div>
					
					<div class="form-group">
				     	<label for="">Quantity</label>     
				        <input type="text" class="form-control"  aria-label="MM" aria-describedby="basic-addon1" name="quantity" required>         
					</div>
					
					<div class="form-group">
				     	<label for="">ID Order</label>     
				        <input type="text" class="form-control"  aria-label="MM" aria-describedby="basic-addon1" name="idord" value="<%= request.getAttribute("Idorder") %>">         
					</div>
					
					<div class="form-group col-sm-12">
				    	<button type="submit" class="btn btn-primary btn-block">Add product to order</button>
				    </div>
				</form>
				
			<h5 style="background: #ccffcc; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg3") != null ? request.getAttribute("msg3") : "" %></h5>
			<!-- End mess1 -->
			<h5 style="background: #ff3333; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg4") != null ? request.getAttribute("msg4") : "" %></h5>
			</div> --%>
			
			<div class="col-sm-12">
	  			  <main class="page payment-page">
				      <section class="payment-form dark">
				        <div class="container">				        
				          <!-- <form action="Add_Order_Detail_Controller" method="POST"> -->
				          <form name="form" method="POST">
<!-- 							<div class="block-heading">
				            	<h2>Payment</h2>
				          	</div> -->				           
							
				            <div class="card-details">
				              <h3 class="title">Customer Information</h3>
				              <div class="row">
								
				                <div class="form-group col-sm-3">
				                  <label for="">ID Customer</label>
				                  <div class="input-group expiration-date">
				                    
				                    <input type="text" class="form-control"  aria-label="MM" aria-describedby="basic-addon1" 
				                    	value="<%= request.getAttribute("Idcus") %>" name="idcus">
				
				                  </div>
				                </div>
				
				                <div class="form-group col-sm-6">
				                  <label for="card-holder">First name</label>
				                  <input id="card-holder" type="text" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" 
				                  	value="<%= request.getAttribute("Lname") %>" name="lname">
				                </div>
				                
				                <div class="form-group col-sm-3">
				                  <label for="card-holder">Last name</label>
				                  <input id="card-holder" type="text" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" 
				                  	value="<%= request.getAttribute("Fname") %>" name="fname">
				                </div>
				
				
				
				                <div class="form-group col-sm-3">
				                  <label for="card-number">Point</label>
				                  <input id="card-number" type="text" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1"
				                	value="<%= request.getAttribute("Point") %>" name="point">
				                </div>
				
				                <div class="form-group col-sm-9">
				                  <label for="card-number">Payment date</label>
				                  <input id="card-number" type="text" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1"
				                  	value="<%= request.getAttribute("Sysdate") %>" name="sysdate">
				                </div>						
				
				              </div>
				            </div>
				            
				            <div class="products">
				              <h3 class="title">Checkout</h3>
				              <div class="row">
				              		<div class="form-group col-sm-5">
					                  <label for="card-number">ID Product</label>
					                  <input id="card-number" type="text" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" name="idpro">
					                </div>
					                
					                <div class="form-group col-sm-7">
					                  <label for="card-number">Quantity</label>
					                  <input id="card-number" type="text" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" name="quantity">
					                </div>
					                
					              	<div class="form-group col-sm-3">
					                  <label for="card-number">ID order</label>
					                  <input id="card-number" type="text" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1"
					                 	 value="<%= request.getAttribute("Idorder") %>" name="idord">
					                </div>
					
					                <div class="form-group col-sm-9">
					                  <label for="card-number">Id Cashier</label>
					                  <input id="card-number" type="text" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1" 
					                  	value="<%= request.getAttribute("Idemp") %>" name="idemp">
					               	</div>
					               
					               	<div class="form-group col-sm-6">
				                  		<!-- <button type="submit" class="btn btn-dark btn-block">Add Product</button> -->
				                  		<button type="submit" class="btn btn-dark btn-block" onclick="javascript: form.action='Add_Order_Detail_Controller';">Add Product</button>
				                	</div>
				                	<div class="form-group col-sm-6">
				                  		<!-- <button type="submit" class="btn btn-primary btn-block">Checkout</button> -->
				                  		<button type="submit" class="btn btn-dark btn-block" onclick="javascript: form.action='Order_Checkout_Controller';">Checkout</button>
				                	</div>
					          </div>
									<span class="remove" style="float: right; font-weight: 600;">REMOVE</span>
							        <span class="sumDetail" style="float: right; font-weight: 600; margin-right: 40px">SUM</span>
					                <span class="price" style="float: right; margin-right: 40px">PRICE</span>
					                <span style="float: right; margin-right: 40px; font-weight: 600">QUANTITY</span>
					                <p class="item-name">PRODUCT NAME</p> 
				              <c:forEach items="${listBill}" var="list">
				              	<div class="item">
				              			<button type="submit" style=" font-size: 10px; float: right; font-weight: 400; width: 60px;" value="Remove" class="btn btn-warning"
				              			onclick="javascript: form.action='Delete_Order_Detail_Controller?id=${list.stt}';">Remove</button>
<%-- 				              		<a class="removelist" href="Delete_Order_Detail_Controller?id=${list.stt}" style="color: red; float: right; font-weight: 600;">remove</a> --%>
				              		<span class="sumDetail" style="float: right; font-weight: 600; margin-right: 40px">${list.sum_Amount_Order_Detail}</span>
					                <span class="price" style="float: right; margin-right: 40px">${list.export_Prices_Product}</span>
					                <span style="float: right; margin-right: 60px; font-weight: 600">${list.quantity}</span>
					                <p class="item-name">${list.name_Product}</p> 
					                <p class="item-description">${list.calculation_Unit}</p>
					                
				              	</div>
				              </c:forEach> 
				              <div class="total">Total<span class="price" style="float: right;"><%= request.getAttribute("total") != null ? request.getAttribute("total") : "0"%></span></div>
				            </div>
				            
				          </form>
				        </div>
				      </section>
				    </main>
	  		</div>
			

			<!-- End Form -->
			</div>

			
	  
	  
	  
	  
	  </div>
	</div>
	


	
	
	
<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>	
</body>
</html>