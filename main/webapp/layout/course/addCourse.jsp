<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="./assets/images/logo.jpeg" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course Creation</title>
</head>
<body>
<div class="wrapper">
    <%@ include file="../../views/navbar.jsp" %>
    <div class="main pb-3">
        <%@ include file="../../views/header.jsp" %>
        <div class="container text-center mt-5">
            <h2 class="directory-heading">Course Creation</h2>
        </div>
        <div class="container custom-container rounded-5 mt-5 shadow-lg p-5">
            <form id="courseForm" action="courseCreation" method="post" enctype="multipart/form-data">
               
                                   <div class="row mb-3">
  <div class="col">
    <label for="instituteId" class="form-label">Institute Id</label>
    <select id="instituteId" name="instituteId" class="form-control" onchange="getInstituteId()" required></select>
  </div>
   <div class="col">
    <label for="courseId" class="form-label">Course Id</label>
    <input type="text" id="courseId" name="courseId" class="form-control" readonly required>
  </div>
</div>
 <div class="row mb-3">
                    <div class="col">
                        <label for="course_name" class="form-label">Course Name</label>
                        <input type="text" id="courseName" name="courseName" class="form-control" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="description" class="form-label">Description</label>
                        <textarea id="description" name="description" class="form-control" required></textarea>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="duration" class="form-label">Duration (Months)</label>
                        <input type="text" id="duration" name="duration" class="form-control" required>
                    </div>
                    <div class="col">
                        <label for="fees" class="form-label">Fees(Per Month)</label>
                        <input type="number" id="fees" name="fees" class="form-control" required>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="status" class="form-label">Status</label>
                        <select id="status" name="status" class="form-select" required>
                            <option value="Active">Active</option>
                            <option value="Inactive">Inactive</option>
                        </select>
                    </div>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Create Course</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="../../views/footer.jsp" %>

<%
    String errorMessage = (String)session.getAttribute("CourseCreationFailed");
    String successMessage = (String)session.getAttribute("CourseCreationSuccess");
    if(errorMessage != null) {
%>
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
    } 
    if(successMessage != null) { 
%>
<script>
    Swal.fire({
        icon: 'success',
        title: 'Success!',
        text: '<%= successMessage %>',
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'OK'
    }).then(() => {
        window.location.href = "courseAdd"; // Redirect to course list page
    });
</script>
<% 
    }
    session.removeAttribute("CourseCreationFailed");
    session.removeAttribute("CourseCreationSuccess");
%>

<script>
    $(document).ready(function() {
        $.ajax({
            url: 'instituteListAction',
            method: 'GET',
            dataType: 'json',
            success: function(response) {
                let institute = $('#instituteId');
                institute.empty();
                institute.append(
                        $("<option></option>")
                            .attr("style", "text-align:center;")
                            .text("-------Select InstituteId-------")
                    );
            	
                $.each(response.instituteList, function(index, institute) {
                	
                	$("#instituteId").append(
                        $("<option></option>")
                            .val(institute.institute_Id)
                            .text(institute.institute_Id)
                    );
                });
            },
            error: function(xhr, status, error) {
                console.error('Error fetching data:', error);
            }
        });
    });
    
    function getInstituteId() {
        var selectedInstituteId = $('#instituteId').val();
        if (selectedInstituteId !== "-------Select InstituteId-------") {
        $.ajax({
            url: 'getLatestCourseByInstitute',
            type: 'GET',
            data: { instituteId: selectedInstituteId },
            dataType: 'json',
            success: function(response) {
                $('#courseId').val(response);
            },
            error: function(error) {
                console.error('Error fetching latest staff ID:', error);
            }
        });
        }
        else
        	{
        	$('#courseId').val("");
        	}
        
    }
    </script>

</body>
</html>
