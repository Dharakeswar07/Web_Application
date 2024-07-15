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
<title>Student Creation</title>
</head>
<body>
	<div class="wrapper">
		<%@ include file="../../views/navbar.jsp"%>
		<div class="main pb-3">
			<%@ include file="../../views/header.jsp"%>
			<div class="container text-center mt-5">
				<h2 class="directory-heading">Student Creation</h2>
			</div>

			<div class="container custom-container rounded-5 mt-5 shadow-lg p-5">
				<div class="progress-container">
					<div class="progress-bar-custom" id="progress1"></div>
					<div class="progress-bar-custom" id="progress2"></div>
					<div class="progress-bar-custom" id="progress3"></div>
					<div class="progress-bar-custom" id="progress4"></div>
					<div class="progress-bar-custom" id="progress5"></div>
				</div>

				<form id="regForm" action="createStudent" method="post"
					enctype="multipart/form-data">
					<!-- Step 1: Basic Information -->
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
								<label for="studentId" class="form-label">Student ID</label> <input
									type="text" id="studentId" name="studentId"
									class="form-control" required readonly>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="firstName" class="form-label">First Name</label> <input
									type="text" id="firstName" name="firstName"
									class="form-control" required>
							</div>
							<div class="col">
								<label for="lastName" class="form-label">Last Name</label> <input
									type="text" id="lastName" name="lastName" class="form-control"
									required>
							</div>
						</div>
					</div>

					<!-- Step 2: Contact Information -->
					<div class="step">
						<div class="row mb-3">
							<div class="col">
								<label for="email" class="form-label">Email</label> <input
									type="email" id="email" name="email" class="form-control">
							</div>
							<div class="col">
								<label for="phoneNumber" class="form-label">Phone Number</label>
								<input type="tel" id="phoneNumber" name="phoneNumber"
									maxlength="10" pattern="[0-9]{10}"
									title="Please enter a 10-digit phone number"
									class="form-control">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="dateofBrith" class="form-label">Date of
									Brith</label> <input type="date" id="dateofBrith" name="dateofBrith"
									class="form-control">
							</div>
							<div class="col">
								<label for="dateOfJoining" class="form-label">Date of
									Joining</label> <input type="date" id="dateOfJoining"
									name="dateOfJoining" class="form-control">
							</div>

						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="age" class="form-label">Age</label> <input
									type="number" id="age" name="age" class="form-control">
							</div>
							<div class="col">
								<label for="bloodGroup" class="form-label">Blood Group</label> <input
									type="text" id="bloodGroup" name="bloodGroup"
									class="form-control">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label class="form-label">Gender</label>
								<div class="d-flex">
									<div class="form-check me-3">
										<input type="radio" id="genderMale" name="gender" value="Male"
											class="form-check-input"> <label for="genderMale"
											class="form-check-label">Male</label>
									</div>
									<div class="form-check me-3">
										<input type="radio" id="genderFemale" name="gender"
											value="Female" class="form-check-input"> <label
											for="genderFemale" class="form-check-label">Female</label>
									</div>
									<div class="form-check me-3">
										<input type="radio" id="genderOther" name="gender"
											value="Other" class="form-check-input"> <label
											for="genderOther" class="form-check-label">Other</label>
									</div>
								</div>
							</div>
						</div>


					</div>

					<!-- Step 3: Exam Attendance -->
					<div class="step">
						<div class="row mb-3">
							<div class="col">
								<label for="educationLevel" class="form-label">Education
									Level</label> <select id="educationLevel" name="educationLevel"
									class="form-control" required>
									<option value="">Select Education Level</option>
									<option value="School">School</option>
									<option value="College">College</option>
									<option value="Work">Work</option>
								</select>
							</div>
						</div>
						<div class="row mb-3" id="schoolOptions" style="display: none;">
							<div class="col">
								<label for="classLevel" class="form-label">Class Level</label> <select
									id="classLevel" name="classLevel" class="form-control">
									<option value="">Select Class Level</option>

									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
							</div>
						</div>
						<div class="row mb-3" id="collegeOptions" style="display: none;">
							<div class="col">
								<label for="degree" class="form-label">Degree</label> <input
									type="text" id="degree" name="degree" class="form-control">
							</div>
						</div>
						<div class="row mb-3" id="workOptions" style="display: none;">
							<div class="col">
								<label for="jobTitle" class="form-label">Job Title</label> <input
									type="text" id="jobTitle" name="jobTitle" class="form-control">
							</div>
						</div>
						<div class="row mb-3" id="examField">
							<div class="col">
								<input type="checkbox" id="attendExam" name="attendExam"
									class="form-check-input" value="1"> <label
									for="attendExam" class="form-label">Attend Exam</label>
							</div>
						</div>
					</div>

					<!-- Step 5: Address Details -->
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

					<!-- Step 6: Profile Picture -->
					<div class="step">
						<div class="row mb-3">
							<div class="col">
								<label for="courses" class="form-label">Course</label> <select
									id="courses" name="courses" class="form-control"></select>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col">
								<label for="profile_image" class="form-label">Profile
									Image</label> <input type="file" id="profile_image"
									name="profile_image" class="form-control" required>
								<div id="profile_image_error"></div>
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
	String errorMessage = (String) session.getAttribute("StudentRegisterFailed");
	String successMessage = (String) session.getAttribute("StudentRegisterSuccess");
	if (errorMessage != null) {
	%>
	<script nonce="random_nonce_value">
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
	<script nonce="random_nonce_value">
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
	session.removeAttribute("StudentRegisterFailed");
	session.removeAttribute("StudentRegisterSuccess");
	%>

	<script>
		$(document)
				.ready(
						function() {
							// Fetch the institute list
							$
									.ajax({
										url : 'instituteListAction',
										method : 'GET',
										dataType : 'json',
										success : function(response) {
											let institute = $('#instituteId');
											institute.empty();
											institute
													.append($(
															"<option></option>")
															.attr("style",
																	"text-align:center;")
															.text(
																	"-------Select InstituteId-------"));

											$
													.each(
															response.instituteList,
															function(index,
																	instituteItem) {
																institute
																		.append($(
																				"<option></option>")
																				.val(
																						instituteItem.institute_Id)
																				.text(
																						instituteItem.institute_Id));
															});
										},
										error : function(xhr, status, error) {
											console.error(
													'Error fetching data:',
													error);
										}
									});

							// Toggle visibility of education level specific fields
							$('#educationLevel')
									.on(
											'change',
											function() {
												var educationLevel = $(this)
														.val();
												$(
														'#schoolOptions, #collegeOptions, #workOptions, #examField')
														.hide();
												if (educationLevel === 'School') {
													$('#schoolOptions').show();
													$('#examField').show();
												} else if (educationLevel === 'College') {
													$('#collegeOptions').show();
													$('#examField').show();
												} else if (educationLevel === 'Work') {
													$('#workOptions').show();
													$('#examField').show();
												}
											});

							$('#classLevel').on('change', function() {
								var classLevel = $(this).val();
								if (classLevel < 8) {
									$('#examField').hide();
								} else {
									$('#examField').show();
								}

							})

							// Profile image size validation
							$('#profile_image')
									.on(
											'change',
											function() {
												var fileInput = this;
												if (fileInput.files
														&& fileInput.files[0]) {
													var fileSize = fileInput.files[0].size;
													var maxSize = 2 * 1024 * 1024;

													if (fileSize > maxSize) {
														$(
																'#profile_image_error')
																.text(
																		'File size should not exceed 2 MB')
																.css('color',
																		'red');
														$(this).val('');
													} else {
														$(
																'#profile_image_error')
																.text('');
													}
												}
											});

							// Date of joining logging
							$('#joinDate').on('change', function() {
								console.log($(this).val());
							});
						});

		function getInstituteId() {
			var selectedInstituteId = $('#instituteId').val();
			if (selectedInstituteId !== "-------Select InstituteId-------") {
				// Fetch latest student ID by institute
				$.ajax({
					url : 'getLatestStudentByInstitute',
					type : 'GET',
					data : {
						instituteId : selectedInstituteId
					},
					dataType : 'json',
					success : function(response) {
						$('#studentId').val(response);
					},
					error : function(error) {
						console.error('Error fetching latest student ID:',
								error);
					}
				});
				// Fetch course list by institute
				$.ajax({
					url : 'courseListAction',
					method : 'GET',
					data : {
						instituteId : selectedInstituteId
					}, // Pass the selected institute ID
					dataType : 'json',
					success : function(response) { // Log the response to verify it
						let course = $('#courses');
						course.empty();
						course.append($("<option></option>").attr("style",
								"text-align:center;").text(
								"-------Select Course-------"));

						if (response.courseList
								&& response.courseList.length > 0) {
							$.each(response.courseList, function(index,
									courseItem) {
								course.append($("<option></option>").val(
										courseItem.course_Id).text(
										courseItem.course_name));
							});
						} else {
							course.append($("<option></option>").attr("style",
									"text-align:center;").text(
									"No courses available"));
						}
					},
					error : function(xhr, status, error) {
						console.error('Error fetching courses:', error);
					}
				});
			} else {
				$('#studentId').val("");
				let course = $('#course');
				course.empty();
				course.append($("<option></option>").attr("style",
						"text-align:center;").text("No courses available"));
			}
		}
	</script>
</body>
</html>
