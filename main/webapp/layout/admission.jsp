<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css"
	href="./assets/css/loginStyle.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>

<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6 col-md-6 form-container">
				<div class="home-icon">
					<a href="home" class="text-white"> <img
						src="./assets/images/left-arrow.png"> Home
					</a>
				</div>
				<div
					class="col-lg-8 col-md-12 col-sm-9 col-xs-12 form-box text-center">
					<div class="logo mt-5 mb-3">
						<img src="./assets/images/signup.gif" width="150px">
					</div>
					<div class="heading mb-3">
						<h4>Create an account</h4>
					</div>
					<form action="signup" method="post">
						<div class="row">
							<div class="col-md-6">
								<div class="form-input">
									<span><i class="fa fa-user"></i></span> <input type="text"
										placeholder="First Name" name="first_name" id="first_name"
										required>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-input">
									<span><i class="fa fa-user"></i></span> <input type="text"
										placeholder="Last Name" name="last_name" id="last_name"
										required>
								</div>
							</div>
						</div>
										<div class="form-input">
							<span><i class="fa fa-envelope"></i></span> <input type="email"
								placeholder="Email Address" name="email" required>
						</div>
										<div class="form-input">
							<span><i class="fa fa-phone"></i></span> <input type="number" maxlength="10"
								placeholder="Mobile Number" name="mobileNo" id="mobileNo" required>
						</div>
						<div class="form-group">
    <select name="course" id="course" class="form-control" required>
        <option value="" disabled selected>Select your course</option>
        <option value="computer_science">Computer Science</option>
        <option value="information_technology">Information Technology</option>
        <option value="electrical_engineering">Electrical Engineering</option>
        <option value="mechanical_engineering">Mechanical Engineering</option>
        <option value="civil_engineering">Civil Engineering</option>
    </select>
</div>
						<div class="form-input">
							<span><i class="fa fa-calendar"></i></span> <input type="date"
								placeholder="Date of Joining" name="doj" id="doj" required>
						</div>
						<div class="row mb-3">
							<div class="col-12 d-flex">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input" id="cb1">
									<label class="custom-control-label text-white" for="cb1">I
										agree all terms & conditions</label>
								</div>
							</div>
						</div>
						<div class="text-left mb-3">
							<button type="submit" class="btn">Register</button>
						</div>
						<div class="text-white mb-3">or register with</div>
						<div class="row mb-3">
							<div class="col-4">
								<a href="" class="btn btn-block btn-social btn-facebook"> <i
									class="fa fa-facebook"></i>
								</a>
							</div>
							<div class="col-4">
								<a href="" class="btn btn-block btn-social btn-google"> <i
									class="fa fa-google"></i>
								</a>
							</div>
							<div class="col-4">
								<a href="" class="btn btn-block btn-social btn-twitter"> <i
									class="fa fa-twitter"></i>
								</a>
							</div>
						</div>
						<div class="text-white">
							Already have an account? <a href="login" class="login-link">Login
								here</a>
						</div>
					</form>
				</div>
			</div>

			<div class="col-lg-6 col-md-6 d-none d-md-block image-container"></div>
		</div>

	</div>
	<%
	String errorMessage = (String) session.getAttribute("errorMessage");
	String successMessage = (String) session.getAttribute("successMessage");

	if (errorMessage != null) {
	%>
	<script>
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: '<%=errorMessage%>',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'OK'
        });
    </script>
	<%
	}
	if (successMessage != null) {
	%>
	<script>
        Swal.fire({
            icon: 'success',
            title: 'Congratulations!!',
            text: '<%=successMessage%>
		',
			confirmButtonColor : '#3085d6',
			confirmButtonText : 'OK'
		});
	</script>
	<%
	}
	// Clearing session attributes to prevent message from being displayed again
	session.removeAttribute("errorMessage");
	session.removeAttribute("successMessage");
	%>


</body>
</html>