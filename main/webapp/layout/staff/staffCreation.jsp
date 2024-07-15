<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="shortcut icon" href="./assets/images/logo.jpeg"
	type="image/x-icon">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Staff Creation</title>
</head>
<body>
	<div class="wrapper">
		<%@ include file="../../views/navbar.jsp"%>
		<div class="main pb-3">
			<%@ include file="../../views/header.jsp"%>
			<div class="container text-center mt-5">
				<h2 class="directory-heading">Staff Creation</h2>
			</div>

			<div class="container custom-container rounded-5 mt-5 shadow-lg p-5">
				<div class="progress-container">
					<div class="progress-bar-custom" id="progress1"></div>
					<div class="progress-bar-custom" id="progress2"></div>
					<div class="progress-bar-custom" id="progress3"></div>
					<div class="progress-bar-custom" id="progress4"></div>
					<div class="progress-bar-custom" id="progress5"></div>
				</div>

				<form id="regForm" action="addStaff" method="post"
					enctype="multipart/form-data">
					<!-- Step 1 -->
					<div class="step active">
						<div class="row mb-3">
							<div class="col">
								<label for="instituteId" class="form-label">Institute Id</label>
								<select id="instituteId" name="instituteId" class="form-control"
									onchange="getInstituteId()" required></select>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="staffId" class="form-label">Staff ID</label> <input
									type="text" id="staffId" name="staffId" class="form-control"
									required readonly>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="firstName" class="form-label">First Name</label> <input
									type="text" id="firstName" name="firstName"
									class="form-control" required>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="lastName" class="form-label">Last Name</label> <input
									type="text" id="lastName" name="lastName" class="form-control"
									required>
							</div>
						</div>
					</div>

					<!-- Step 2 -->
					<div class="step">
						<div class="row mb-3">
							<div class="col">
								<label for="email" class="form-label">Email</label> <input
									type="email" id="email" name="email" class="form-control">
								<div id="emailError" class="invalid-feedback">Email
									already exists.</div>
							</div>
						</div>

						<div class="row mb-3">
							<div class="col">
								<label for="phoneNumber" class="form-label">Phone Number</label>
								<input type="tel" id="phoneNumber" name="phoneNumber"
									maxlength=10 pattern="[0-9]{10}"
									title="Please enter a 10-digit phone number"
									class="form-control">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="dateOfJoining" class="form-label">Date of
									Joining</label> <input type="date" id="dateOfJoining"
									name="dateOfJoining" class="form-control">
							</div>
						</div>
					</div>

					<!-- Step 3 -->
					<div class="step">
						<div class="row mb-3">
							<div class="col">
								<label for="courses" class="form-label">Course</label> <select
									id="courses" name="courses" class="form-control"></select>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="salary" class="form-label">Salary</label> <input
									type="number" id="salary" name="salary" class="form-control">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="qualification" class="form-label">Qualification</label>
								<input type="text" id="qualification" name="qualification"
									class="form-control">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="experience" class="form-label">Experience
									(in years)</label> <input type="number" id="experience"
									name="experience" class="form-control">
							</div>
						</div>
					</div>

					<!-- Step 4 -->
					<div class="step">
						<div class="row mb-3">
							<div class="col-md-6">
								<label for="doorno" class="form-label">Door No</label> <input
									type="text" id="doorno" name="doorno" class="form-control">
							</div>
							<div class="col-md-6">
								<label for="street" class="form-label">Street</label> <input
									type="text" id="street" name="street" class="form-control">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-6">
								<label for="area" class="form-label">Area</label> <input
									type="text" id="area" name="area" class="form-control" required>
							</div>
							<div class="col-md-3">
								<label for="pincode" class="form-label">Pincode</label> <input
									type="text" id="pincode" name="pincode" class="form-control"
									required>
							</div>
							<div class="col-md-3">
								<label for="city" class="form-label">City</label> <input
									type="text" id="city" name="city" class="form-control" required>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-4">
								<label for="state" class="form-label">State</label> <input
									type="text" id="state" name="state" class="form-control"
									required>
							</div>
							<div class="col-md-8">
								<label for="country" class="form-label">Country</label> <input
									type="text" id="country" name="country" class="form-control"
									required>
							</div>
						</div>
					</div>
					<div class="step">
						<div class="row mb-3">
							<div class="col">
								<label for="profile_image" class="form-label">Profile
									Image</label> <input type="file" id="profile_image"
									name="profile_image" class="form-control" required>
								<div id="profile_image_error"></div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="newPassword" class="form-label">New Password</label>
								<input type="password" id="newPassword" name="newPassword"
									class="form-control" required>
								<div id="newPasswordMessage" style="color: red;"></div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="confirmPassword" class="form-label">Confirm
									Password</label> <input type="password" id="confirmPassword"
									name="confirmPassword" class="form-control" required>
								<div id="confirmPasswordMessage" style="color: red;"></div>
							</div>
						</div>
					</div>
					<div class="text-center">
						<button type="button" id="prevBtn" class="btn btn-secondary"
							onclick="nextPrev(-1)">Previous</button>
						<button type="button" id="nextBtn" class="btn btn-primary"
							onclick="nextPrev(1)">Next</button>
						<button type="submit" id="submitBtn" class="btn btn-primary"
							style="display: none;">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@ include file="../../views/footer.jsp"%>
	<% 
    String errorMessage = (String) session.getAttribute("RegisterFailed");
    String successMessage = (String) session.getAttribute("RegisterSuccess");
    if (errorMessage != null) { 
%>
	<script nonce="random_nonce_value">
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
	<script nonce="random_nonce_value">
    Swal.fire({
        icon: 'success',
        title: 'Congratulations!!',
        text: '<%= successMessage %>',
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'OK'
    });
</script>
	<% 
    }
    session.removeAttribute("RegisterFailed");
    session.removeAttribute("RegisterSuccess");
%>


	<script>
$(document).ready(function() {
	
	 let typingTimer; 
	    const doneTypingInterval = 1000; 

	    document.getElementById('email').addEventListener('keyup', function() {
	        clearTimeout(typingTimer); 
	        typingTimer = setTimeout(checkEmailExists, doneTypingInterval);
	    });

	    async function checkEmailExists()
	    {
	    	const email=$('#email').val();
	    	
	    }
	    
    // Fetch the institute list
    $.ajax({
        url: 'instituteListAction',
        method: 'GET',
        dataType: 'json',
        success: function(response) {
        	console.log(response);
            let institute = $('#instituteId');
            institute.empty();
            institute.append(
                $("<option></option>")
                    .attr("style", "text-align:center;")
                    .text("-------Select InstituteId-------")
            );

            $.each(response.instituteList, function(index, instituteItem) {
                institute.append(
                    $("<option></option>")
                        .val(instituteItem.institute_Id)
                        .text(instituteItem.institute_Id)
                );
            });
        },
        error: function(xhr, status, error) {
            console.error('Error fetching data:', error);
        }
    });

    // Password validation
    $('#newPassword').on('keyup', function() {
        var newPassword = $(this).val();
        var passwordRegex = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-zA-Z]).{8,}$/;

        if (!passwordRegex.test(newPassword)) {
            $('#newPasswordMessage').text('Password must be at least 8 characters long and contain at least one number, one special character, and one letter.').css('color', 'red');
        } else {
            $('#newPasswordMessage').text('');
        }

        validatePasswordMatch();
    });

    $('#confirmPassword').on('keyup', validatePasswordMatch);

    function validatePasswordMatch() {
        var newPassword = $('#newPassword').val();
        var confirmPassword = $('#confirmPassword').val();

        if (newPassword !== confirmPassword || newPassword === '' || confirmPassword === '') {
            $('#confirmPasswordMessage').text('Passwords do not match!').css('color', 'red');
        } else {
            $('#confirmPasswordMessage').text('');
        }
    }

    // Date of joining logging
    $('#dateOfJoining').on('change', function() {
        console.log($(this).val());
    });

    // Profile image size validation
    $('#profile_image').on('change', function() {
        var fileInput = this;
        if (fileInput.files && fileInput.files[0]) {
            var fileSize = fileInput.files[0].size;
            var maxSize = 2 * 1024 * 1024;

            if (fileSize > maxSize) {
                $('#profile_image_error').text('File size should not exceed 2 MB').css('color', 'red');
                $(this).val('');
            } else {
                $('#profile_image_error').text('');
            }
        }
    });
});

function getInstituteId() {
    var selectedInstituteId = $('#instituteId').val();
    if (selectedInstituteId !== "-------Select InstituteId-------") {
        // Fetch latest staff ID by institute
        $.ajax({
            url: 'getLatestStaffByInstitute',
            type: 'GET',
            data: { instituteId: selectedInstituteId },
            dataType: 'json',
            success: function(response) {
                $('#staffId').val(response);
            },
            error: function(error) {
                console.error('Error fetching latest staff ID:', error);
            }
        });

        // Fetch course list by institute
        $.ajax({
            url: 'courseListAction',
            method: 'GET',
            data: { instituteId: selectedInstituteId },  // Pass the selected institute ID
            dataType: 'json',
            success: function(response) { // Log the response to verify it
                let course = $('#courses');
                course.empty();
                course.append(
                    $("<option></option>")
                        .attr("style", "text-align:center;")
                        .text("-------Select Course-------")
                );

                if (response.courseList && response.courseList.length > 0) {
                    $.each(response.courseList, function(index, courseItem) {
                        course.append(
                            $("<option></option>")
                                .val(courseItem.course_Id)
                                .text(courseItem.course_name)
                        );
                    });
                } else {
                    course.append(
                        $("<option></option>")
                            .attr("style", "text-align:center;")
                            .text("No courses available")
                    );
                }
            },
            error: function(xhr, status, error) {
                console.error('Error fetching courses:', error);
            }
        });
    } else {
        $('#staffId').val("");

        let course = $('#course');
        course.empty();
        course.append(
            $("<option></option>")
                .attr("style", "text-align:center;")
                .text("No courses available")
        );
    }
}
</script>
</body>
</html>
