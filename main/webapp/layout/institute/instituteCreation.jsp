<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <link rel="shortcut icon" href="./assets/images/logo.jpeg" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Institute Creation</title>
</head>

<body>
<div class="wrapper">
    <%@ include file="../../views/navbar.jsp" %>
<div class="main pb-3">    
    <%@ include file="../../views/header.jsp" %>
     <div class="container text-center mt-5">
            <h2 class="directory-heading">Institute Creation</h2>
        </div>
        
        <div class="container custom-container rounded-5 mt-5 shadow-lg p-5">
                        <div class="progress-container">
                <div class="progress-bar-custom" id="progress1"></div>
                <div class="progress-bar-custom" id="progress2"></div>
                <div class="progress-bar-custom" id="progress3"></div>
                <div class="progress-bar-custom" id="progress4"></div>
            </div>

        
            <form id="regForm" action="instituteCreationCheck"  method="post" enctype="multipart/form-data">
                <div class="step active">
                    <div class="row mb-3">
                        <div class="col">
                            <label for="institute_id" class="form-label">Institute ID</label>
                            <input type="text" id="institute_id" name="institute_id" class="form-control" required readonly>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                            <label for="name" class="form-label">Institute Name</label>
                            <input type="text" id="name" name="name" class="form-control" required>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" id="email" name="email" class="form-control" required>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                            <label for="phone" class="form-label">Phone No</label>
                            <input type="number" id="phoneNo" name="phoneNo" class="form-control" required>
                        </div>
                    </div>
                </div>
                
        
              <div class="step">
    <div class="row mb-3">
        <div class="col-md-6">
            <label for="DoorNo" class="form-label">Door No</label>
            <input type="text" id="doorno" name="doorno" class="form-control">
        </div>
        <div class="col-md-6">
            <label for="street" class="form-label">Street</label>
            <input type="text" id="street" name="street" class="form-control">
        </div>
    </div>
    <div class="row mb-3">
        <div class="col-md-6">
            <label for="area" class="form-label">Area</label>
            <input type="text" id="area" name="area" class="form-control" required>
        </div>
        <div class="col-md-3">
            <label for="pincode" class="form-label">Pincode</label>
            <input type="text" id="pincode" name="pincode" class="form-control" required>
        </div>
        <div class="col-md-3">
            <label for="city" class="form-label">City</label>
            <input type="text" id="city" name="city" class="form-control" required>
        </div>
    </div>
    <div class="row mb-3">
        <div class="col-md-4">
            <label for="state" class="form-label">State</label>
            <input type="text" id="state" name="state" class="form-control" required>
        </div>
        <div class="col-md-8">
            <label for="country" class="form-label">Country</label>
            <input type="text" id="country" name="country" class="form-control" required>
        </div>
    </div>
</div>

        
                <div class="step">
                    <div class="row mb-3">
                        <div class="col">
                            <label for="AdminName" class="form-label">Admin Name</label>
                            <input type="text" id="adminName" name="adminName" class="form-control" required>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                            <label for="employee_count" class="form-label">Employee Count</label>
                            <input type="number" id="emp_count" name="emp_count" class="form-control" required>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                            <label for="profile_image" class="form-label">Profile Image</label>
                            <input type="file" id="profile_image" name="profile_image" class="form-control" required>
                            <div id="profile_image_error"></div>
                        </div>
                    </div>
                </div>
       
        <div class="step">
                    <div class="row mb-3">
                        <div class="col">
                            <label for="newPassword" class="form-label">New Password</label>
                            <input type="password" id="newPassword" name="newPassword" class="form-control" required>
                            <div id="newPasswordMessage" style="color: red;"></div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                            <label for="confirmPassword" class="form-label">Confirm Password</label>
                            <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
                            <div id="confirmPasswordMessage" style="color: red;"></div>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <button type="button" id="prevBtn" class="btn btn-secondary" onclick="nextPrev(-1)">Previous</button>
                    <button type="button" id="nextBtn" class="btn btn-primary" onclick="nextPrev(1)">Next</button>
                                        <button type="submit" id="submitBtn" class="btn btn-primary" style="display: none;">Submit</button>
                </div>
            </form>
        </div>    
    </div>

    </div>
           
           
                                <%@ include file="../../views/footer.jsp" %>
                               	<% String errorMessage=(String)session.getAttribute("RegisterFailed");
	String successMessage=(String)session.getAttribute("RegisterSuccess");						
		if(errorMessage!=null) { %>
		    <script>
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
    <script>
    Swal.fire({
        icon: 'success',
        title: 'Congratulations!!',
        text: '<%= successMessage %>',
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'OK'
     }).then(()=> {
    	 windows.location.href="instituteList";
     });
</script>
<% 
    }
    session.removeAttribute("RegisterFailed");

    session.removeAttribute("RegisterSuccess");

%>

                                <script>
                                $(document).ready(function() {
                                    $.ajax({
                                        url: 'getLatestId', // The action name mapped in struts.xml
                                        type: 'GET',
                                        dataType: 'json',
                                        success: function(response) {
                                            $('#institute_id').val(response.latestInstituteId);
                                        },
                                        error: function(error) {
                                            console.error('Error fetching latest institute ID:', error);
                                        }
                                    });
                                    $('#newPassword').on('keyup', function() {
                                        var newPassword = $('#newPassword').val();
                                        var confirmPassword = $('#confirmPassword').val();
                                        var passwordRegex = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-zA-Z]).{8,}$/;

                                        if (!passwordRegex.test(newPassword)) {
                                            $('#newPasswordMessage').text('Password must be at least 8 characters long and contain at least one number, one special character, and one letter.').css('color', 'red');
                                        } else {
                                            $('#newPasswordMessage').text('');
                                        }
                                    });
                                    
                                    $("#confirmPassword").on('keyup',function()
                                    		{
                                    	 var newPassword = $('#newPassword').val();
                                         var confirmPassword = $('#confirmPassword').val();

                                         if (newPassword !== confirmPassword || newPassword === '' || confirmPassword === '') {
                                             $('#confirmPasswordMessage').text('Passwords do not match!').css('color', 'red');
                                         } else {
                                             $('#confirmPasswordMessage').text('');
                                         }
                                    		});
                                    
                                    $('#profile_image').on('change', function() {
                                        var fileInput = this;
                                        if (fileInput.files && fileInput.files[0]) {
                                            var fileSize = fileInput.files[0].size; // Size of the selected file in bytes
                                            var maxSize = 2 * 1024 * 1024; // 2 MB in bytes

                                            if (fileSize > maxSize) {
                                                // Show error message
                                                $('#profile_image_error').text('File size should not exceed 2 MB').css('color', 'red');
                                                // Clear the file input
                                                $(this).val('');
                                            } else {
                                                // Clear error message
                                                $('#profile_image_error').text('');
                                            }
                                        }
                                    });
                                   
                                });
                                </script>

</body>
</html>