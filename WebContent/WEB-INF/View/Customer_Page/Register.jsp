<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="Bootstrap/dist/css/Login.css">
<link rel="stylesheet" href="Bootstrap/dist/css/Register.css">
<title>Login Page</title>
</head>
<body>

<form action="Add_Customer_Controller" method="POST">
	<div class="container register-form">
            <div class="form">
                <div class="note">
                    <p style="font-size: 24px;">Register member</p>
                </div>
                
                <div class="form-content">
                
                	<div class="row">
                	
                		<div class="col-md-6">
                			<div class="form-group">
                            	<label for="validationTooltipUsername" style="font-weight: bold;">Account</label>
                                <input name="accu" type="text" class="form-control" placeholder="Your Account *" value="" required/>
                            </div>
                		</div>
                		
                		<div class="col-md-6">
                			<div class="form-group">
                            	<label for="validationTooltipUsername" style="font-weight: bold;">Password</label>
                                <input name="passw" type="password" class="form-control" placeholder="Your Password *" value="" required/>
                            </div>
                		</div>
                	</div>
        
                </div>
                
                


                <div class="form-content">
                    <div class="row">
                        <div class="col-md-6">
                        
                            <div class="form-group">
                            	<label for="validationTooltipUsername" style="font-weight: bold;">First name</label>
                                <input name="fname" type="text" class="form-control" placeholder="Your First Name *" value="" required/>
                            </div>
                            
                            <div class="form-group">
                            	<label for="validationTooltipUsername" style="font-weight: bold;">Last name</label>
                                <input name="lname" type="text" class="form-control" placeholder="Your Last Name *" value="" required/>
                            </div>
                            
                            <div class="form-group">
                            	<label for="validationTooltipUsername" style="font-weight: bold;">Gender</label>
                                <select name="dropDownGend" class="form-control" id="sel1">
									<option value="1">Male</option>
									<option value="0">Female</option>
							 	</select>
                            </div>
                            
                            <div class="form-group">
                            	<label for="validationTooltipUsername" style="font-weight: bold;">Day of birth</label>
                                <input name="dob" type="text" class="form-control" placeholder="YYYY-MM-DD *" value="" required/>
                            </div>
                            
                        </div>
                        
                        <div class="col-md-6">
                        
                        
                            <div class="form-group">
                            	<label for="validationTooltipUsername" style="font-weight: bold;">Id card</label>
                                <input name="card" type="text" class="form-control" placeholder="Your ID Card *" value="" required/>
                            </div>
                            
                            <div class="form-group">
                            	<label for="validationTooltipUsername" style="font-weight: bold;">Address</label>
                                <input name="addr" type="text" class="form-control" placeholder="Your Address *" value="" required/>
                            </div>
                            
                            <div class="form-group">
                            	<label for="validationTooltipUsername" style="font-weight: bold;">Phone number</label>
                                <input name="phone" type="text" class="form-control" placeholder="Your Phone Number *" value="" required/>
                            </div>                            
                                                       
                        </div>
                    </div>
                    <button type="submit" class="btnSubmit">Register</button>
                    <br>
                    <!-- Begin mess1 -->	
					<h5 style="background: #ccffcc; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg1") != null ? request.getAttribute("msg1") : "" %></h5>
					<!-- End mess1 -->
					<h5 style="background: #ff3333; margin-top: 10px; margin-left: 300px; width: 1000px"><%= request.getAttribute("msg2") != null ? request.getAttribute("msg2") : "" %></h5>
                </div>
            </div>
        </div>
</form>
<script src="Bootstrap/vendor/popper.min.js"></script>
<script src="Bootstrap/vendor/jquery-slim.min.js"></script>
<script src="Bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>