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
<title>Add Product</title>
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
		  	
		  	<!-- Begin Form -->
		  	<div style="margin-top: 20px; margin-left: auto; margin-right: auto;">
		  	<h3 style="text-align: center;">ADD NEW PRODUCT</h3>
		  	
			<form action="Add_Product_Controller" method="POST" style="margin-top: 20px; margin-left: 300px; width: 1000px" onsubmit="return validate()">
			
			  <div class="form-row">
			  
			  
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltip01">ID Product</label>
			      <input type="text" class="form-control" id="validationTooltip01" placeholder="BIA01" name="idpro" required>
			    </div>
			    
			    <div class="col-md-4 mb-3">	
			      <label for="validationTooltip02">Name</label>
			      <input type="text" class="form-control" id="validationTooltip02" placeholder="Bia SaiGon" name="namepro" required>
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltipUsername">Calculation</label>
			      <input type="text" class="form-control" id="validationTooltipUsername" placeholder="Chai" name="calpro" required>
			    </div>
			    
			  </div>
			  
			  <div class="form-row">
			  
			  	<div class="col-md-4 mb-3">
			      <label for="validationTooltipUsername">Manuafacturer</label>
			      <input type="text" class="form-control" id="validationTooltipUsername" placeholder="SaiGon" name="manua" required>
			    </div>
			  	
			  	<div class="col-md-4 mb-3">
			      <label for="validationTooltipUsername">Import date</label>
			      <input type="text" class="form-control" id="validationTooltipUsername" placeholder="YYYY-MM-DD" name="imdate" required>
			    </div>
			    
			    <div class="col-md-4 mb-3">
			      <label for="validationTooltipUsername">Import Price</label>
			      <input type="text" class="form-control" id="validationTooltipUsernameIm" name="imprice" required>
			    </div>
			  	
			  </div>
			  
			  <div class="form-row">
			  
			    <div class="col-md-6 mb-3">
			      <label for="validationTooltip03">Export price</label>
			      <input type="text" class="form-control" id="validationTooltip03" name="exprice" required>
			    </div>
			    
			    <div class="col-md-3 mb-3">
			      <label for="validationTooltip04">In stock</label>
			      <input type="text" class="form-control" id="validationTooltip04" name="instock" required>
			    </div>
			    
			    <div class="col-md-4 mb-3">
			  	  <label for="formGroupExampleInput">Product type</label>
				  <select name="dropDownProt" class="form-control" id="sel1">
					  <c:forEach items="${listProt}" var="list">
						<option value="${list.id_Product_Type}">${list.name_Product_Type}</option>
					  </c:forEach>
				  </select>
			  	</div>
			    
			  </div>
			  
			  <button class="btn btn-primary" type="submit">Add Product</button>
			  
			</form>

			  

			</div>
			<!-- End Form -->
			
			<!-- Begin mess1 -->	
			<h5 style="background: #ccffcc; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg1") != null ? request.getAttribute("msg1") : "" %></h5>
			<!-- End mess1 -->
			<h5 style="background: #ff3333; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg2") != null ? request.getAttribute("msg2") : "" %></h5>
		
			
			
			
	  	</div>
	  	
	</div>

<script type="text/javascript">
function validate() {
    var n1 = document.getElementById("validationTooltip04");
    var Im = document.getElementById("validationTooltipUsernameIm");
    var Ex = document.getElementById("validationTooltip03");
   
    if(n1.value > 0) 
    {
    	if (Ex.value > Im.value) 
    	{
    		return true;
		} 
    	else 
		{
    		alert("Export prices must be > Import prices");
    		return false;
		}
    }
    else
    {
    	alert("Quantity in stock must be more than 0");
   		return false;
    }
  }
</script>
<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>