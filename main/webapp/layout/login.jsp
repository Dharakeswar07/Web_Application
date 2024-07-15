<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache"); 
    response.setDateHeader("Expires", 0); 
    HttpSession sessions = request.getSession(false);
    if (sessions != null && sessions.getAttribute("AdminData") != null && sessions.getAttribute("successMessage")==null) {
        response.sendRedirect("dashboard");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="./assets/css/loginStyle.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

	  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
	
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6 col-md-6 form-container">
			<div class="home-icon">
                    <a href="home" class="text-white">
<img src="./assets/images/left-arrow.png">
			Home
                    </a>
                </div>
				<div class="col-lg-8 col-md-12 col-sm-9 col-xs-12 form-box text-center">
					<div class="logo mt-5 mb-3">
						<img src="./assets/images/login.gif" width="150px" >
					</div>
					<form action="loginCheck" method="post">
					
						<div class="form-input">
							<span><i class="fa fa-envelope"></i></span>
							<input type="text" placeholder="UserName" name="username" required>
						</div>
						<div class="form-input">
							<span><i class="fa fa-lock"></i></span>
							<input type="password" placeholder="Password" name="password" required>
						</div>
						<div class="row mb-3">
							<div class="col-6 d-flex">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input" id="cb1">
									<label class="custom-control-label text-white" for="cb1">Remember me</label>
								</div>
							</div>
							<div class="col-6 text-right">
								<a href="forget.html" class="forget-link">Forget password</a>
							</div>
						</div>
						<div class="text-left mb-3">
							<button type="submit" class="btn">Login</button>
						</div>
						<div class="text-white mb-3">or login with</div>
						<div class="row mb-3">
							<div class="col-4">
								<a href="" class="btn btn-block btn-social btn-facebook">
									<i class="fa fa-facebook"></i>
								</a>
							</div>
							<div class="col-4">
								<a href="" class="btn btn-block btn-social btn-google">
									<i class="fa fa-google"></i>
								</a>
							</div>
							<div class="col-4">
								<a href="" class="btn btn-block btn-social btn-twitter">
									<i class="fa fa-twitter"></i>
								</a>
							</div>
						</div>
						<div class="text-white">Don't have an account?
							<a href="admission" class="register-link">Register here</a>
						</div>
					</form>
					
				</div>
				
			</div>

			<div class="col-lg-6 col-md-6 d-none d-md-block image-container"></div>
			
		</div>
	</div>

	<% String errorMessage = (String) session.getAttribute("errorMessage");
   String successMessage = (String) session.getAttribute("successMessage");
   if (errorMessage != null) { %>
    <script nonce="V39FAd-LEL3fAwcmsiyrVA78">
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: '<%= errorMessage %>',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'OK'
        });
    </script>
<% 
   } if (successMessage != null) { 
%>
    <script nonce="V39FAd-LEL3fAwcmsiyrVA78">
    
        Swal.fire({
            icon: 'success',
            title: 'Congratulations!!',
            text: '<%= successMessage %>',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'OK'
        }).then(() => {
            window.location.href = "dashboard";
        });
    </script>
<% 
       session.removeAttribute("successMessage");
   }
   session.removeAttribute("errorMessage");
%>
</body>
</html>