<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <link rel="shortcut icon" href="./assets/images/logo.jpeg" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initxial-scale=1.0">
<title>Institute List</title>
<style>
    .modal-lg {
      max-width: 90%;
    }
    .profile-img img {
      width: 150px;
      height: 150px;
      border-radius: 50%;
      object-fit: cover;
    }
    .profile-img .file {
      position: relative;
      overflow: hidden;
      margin-top: -30px;
      width: 150px;
      border: none;
      border-radius: 0;
      font-size: 15px;
      background: #212529b8;
    }
    .profile-img .file input {
      position: absolute;
      opacity: 0;
      right: 0;
      top: 0;
    }
    .profile-head h5 {
      color: #333;
    }
    .profile-head h6 {
      color: #0062cc;
    }
    .profile-head .nav-tabs {
      margin-bottom: 10px;
    }
    .profile-tab label {
      font-weight: 600;
    }
    .profile-tab p {
      font-weight: 600;
      color: #0062cc;
    }
  </style>
</head>
<body>
<div class="wrapper">
    <%@ include file="../../views/navbar.jsp" %>
<div class="main pb-3">    
    <%@ include file="../../views/header.jsp" %>
    
    <div class="container rounded-5 mt-5 shadow-lg p-5">
    <h2 class="mb-4">Institute List</h2>
            <div class="table-responsive">
                <table  id="instituteTable" class="table nowrap w100 table-striped resize-table table-hover">
                    <thead>
                        <tr>
                            <th >Sno</th>
                            <th >ID</th>
                            <th >Profile</th>
                            <th >Name</th>
                            <th >Admin</th>
                            <th >Email</th>
                            <th >Phone</th>
                            <th >Address</th>
                            <th >City</th>
                            <th >State</th>
                            <th >Pincode</th>
                            <th >Country</th>
                            <th >Date</th>
                            <th >Count</th>
                            <th >Status</th>
                            <th >Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    </tbody>
                </table>
            </div>
        </div>
</div>
</div>
                <%@ include file="../../views/footer.jsp" %>
<div class="modal fade" id="instituteModal" tabindex="-1" role="dialog" aria-labelledby="instituteModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="instituteModalLabel">Institute Details</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
        </button>
      </div>
      <div class="modal-body">
        <div class="container emp-profile">
          <form action="updateInstitute" method="post" enctype="multipart/form-data">
            <div class="row">
              <div class="col-md-4">
                <div class="profile-img">
                  <img id="profileImage" src="" alt=""/>
                  <div class="file btn btn-lg btn-primary">
                    Change Photo
                    <input type="file" id="profileImageInput" name="profile_image"/>
                  </div>
                </div>
              </div>
              <div class="col-md-8">
                <div class="profile-head">
<p class="instituteName"></p>
                  <h6 id="adminName" class="adminName">
                  </h6>
                  <p class="proile-rating">Email : <span  class="email"></span></p>
                  <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                      <a class="nav-link active" id="about-tab" data-bs-toggle="tab" href="#about" role="tab" aria-controls="about" aria-selected="true">About</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" id="timeline-tab" data-bs-toggle="tab" href="#timeline" role="tab" aria-controls="timeline" aria-selected="false">Location</a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-4">
                </div>
              <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                  <div class="tab-pane fade show active" id="about" role="tabpanel" aria-labelledby="about-tab">
                    <div class="row">
                      <div class="col-md-6">
                        <label>Institute Id</label>
                      </div>
                      <div class="col-md-6">
                                          <input type="hidden" name="extraPath" id="extraPath">
                      <input type="text" id="instituteId" class="form-control" name="institute_id" readonly>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <label>Name</label>
                      </div>
                      <div class="col-md-6">
                      <input type="text" id="instituteName"  name="name"  class="form-control instituteName">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <label>Email</label>
                      </div>
                      <div class="col-md-6">
                      <input type="text" id="email"  name="email" class="form-control email">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <label>Phone</label>
                      </div>
                      <div class="col-md-6">
                      <input type="text" id="phone" name="phoneNo" class="form-control">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <label>Admin Name</label>
                      </div>
                      <div class="col-md-6">
                      <input type="text" id="adminName" name="adminName" class="form-control adminName">
                      </div>
                    </div>
                                        <div class="row">
                      <div class="col-md-6">
                        <label>Emp Count</label>
                      </div>
                      <div class="col-md-6">
                      <input type="text" id="empCount" name="emp_count" class="form-control">
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane fade" id="timeline" role="tabpanel" aria-labelledby="timeline-tab">
                    <div class="row">
                      <div class="col-md-6">
                        <label>DoorNo</label>
                      </div>
                      <div class="col-md-6">
						<input type="text" id="doorNo" name="doorno" class="form-control">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <label>Street</label>
                      </div>
                      <div class="col-md-6">
						<input type="text" id="street" name="street" class="form-control">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <label>Area</label>
                      </div>
                      <div class="col-md-6">
						<input type="text" id="area" name="area" class="form-control">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <label>Pincode</label>
                      </div>
                      <div class="col-md-6">
						<input type="text" id="pincode" name="pincode" class="form-control">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <label>City</label>
                      </div>
                      <div class="col-md-6">
                      <input type="text" id="city" name="city" class="form-control">
                      </div>
                    </div>
                     <div class="row">
                      <div class="col-md-6">
                        <label>State</label>
                      </div>
                      <div class="col-md-6">
                      <input type="text" id="state" name="state" class="form-control">
                      </div>
                    </div>
                                        <div class="row">
                      <div class="col-md-6">
                        <label>Country</label>
                      </div>
                      <div class="col-md-6">
                      <input type="text" id="country" name="country" class="form-control">
                      </div>
                    </div>
                  </div>
                </div>
                <br>
                    <div class="row">
                      <div class="col-md-10">
                      </div>
                      <div class="col-md-2">
                     <button type="submit" class="btn btn-primary" id="saveChanges">Update</button>
                      </div>
                    </div>
              </div>

            </div>
          </form>           
        </div>
      </div>
    </div>
  </div>
</div>

<% String errorMessage=(String)session.getAttribute("UpdateFailed");
	String successMessage=(String)session.getAttribute("UpdateSuccess");

	
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
        title: '<%= successMessage %>',
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'OK'
     }).then(() => {
   	  window.location.href = "instituteList";
     });
     
</script>
<% 
    }
    session.removeAttribute("UpdateFailed");

    session.removeAttribute("UpdateSuccess");
%>


<script>
$(document).ready(function() {
	
    // Fetch institute list via AJAX
    $.ajax({
        url: 'instituteListAction',
        method: 'GET',
        dataType: 'json',
        success: function(response) {
        	console.log(response);
            let instituteTable = $('#instituteTable tbody');
            instituteTable.empty();
            $.each(response.instituteList, function(index, institute) {
                let row = '<tr>' +
                    '<td>' + (index + 1) + '</td>' +
                    '<td>' + institute.institute_Id + '</td>' +
                    '<td><img src="' + institute.profile + '" alt="Profile Image" class="rounded-circle" width="50" height="50"></td>' +
                    '<td>' + institute.ins_name + '</td>' +
                    '<td>' + institute.admin_name + '</td>' +
                    '<td>' + institute.email + '</td>' +
                    '<td>' + institute.phone_no + '</td>' +
                    '<td>' + institute.doorno + ', ' + institute.area + ', ' + institute.street + '</td>' +
                    '<td>' + institute.city + '</td>' +
                    '<td>' + institute.state + '</td>' +
                    '<td>' + institute.pincode + '</td>' +
                    '<td>' + institute.country + '</td>' +
                    '<td>' + institute.date.dayOfMonth + '-' + institute.date.month + '-' + institute.date.year + '</td>' +
                    '<td>' + institute.emp_count + '</td>' +
                    '<td>' + institute.status + '</td>' +
                    '<td>' +
                    '<img src="assets/images/List/edit.png" title="Edit" alt="edit" class="edit-btn" data-id="' + institute.institute_Id + '" style="cursor:pointer;"> &nbsp;' +
                    '<img src="assets/images/List/delete.png" title="Delete" class="delete-btn" data-id="' + institute.institute_Id + '" alt="delete" style="cursor:pointer;">' +
                    '</td>' +
                    '</tr>';
                instituteTable.append(row);
            });
        },
        error: function(xhr, status, error) {
            console.error('Error fetching data:', error);
        }
    });

    // Add click event listener for edit buttons
    $(document).on('click', '.edit-btn', function() {
        let instituteId = $(this).data('id');
        // Make an AJAX call to get the institute details
        $.ajax({
            url: 'getInstituteDetailsAction', // URL to get institute details
            method: 'GET',
            data: { id: instituteId },
            dataType: 'json',
            success: function(response) {

            	  let institute = response.institute;
                  // Populate the modal with institute details
                  $('#instituteId').val(institute.institute_Id);
                  $('#profileImage').attr('src', institute.profile);
                  $('#extraPath').val(institute.profile);
                  var instituteNameInput = $('.instituteName');
                  instituteNameInput.val(institute.ins_name);
                  instituteNameInput.text(institute.ins_name);
                  let adminName=$('.adminName');
                  adminName.val(institute.admin_name);
                  adminName.text(institute.admin_name);
                  let email=$('.email');
                  email.val(institute.email);
                  email.text(institute.email);
                  $('#phone').val(institute.phone_no);
                  $('#doorNo').val(institute.doorno);
                  $('#area').val(institute.area);
                  $('#street').val(institute.street);
                   $('#city').val(institute.city);
                  $('#state').val(institute.state);
                  $('#pincode').val(institute.pincode);
                  $('#country').val(institute.country);
                  $('#date').val(new Date(institute.date.year, institute.date.monthValue - 1, institute.date.dayOfMonth).toISOString().substr(0, 10));
                  $('#empCount').val(institute.emp_count);
                  $('#status').val(institute.status);

                  // Show the modal
                  $('#instituteModal').modal('show');
            },
            error: function(xhr, status, error) {
                console.error('Error fetching institute details:', error);
            }
        });
    });
    
    
    document.getElementById('profileImage').addEventListener('click', function() {
        document.getElementById('profileImageInput').click();
    });

    document.getElementById('profileImageInput').addEventListener('change', function(event) {
        const file = event.target.files[0];
        if (file) {
            // Check file size
            if (file.size > 2 * 1024 * 1024) {
                alert('Image size should not exceed 2 MB');
                // Clear the file input
                this.value = "";
                return;
            }

            const reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById('profileImage').src = e.target.result;
            };
            reader.readAsDataURL(file);
        }
    });

      $(document).on('click', '.delete-btn', function() {
    	    let instituteId = $(this).data('id');
    	    Swal.fire({
    	        title: 'Are you sure?',
    	        text: "You won't be able to revert this!",
    	        icon: 'warning',
    	        showCancelButton: true,
    	        confirmButtonColor: '#3085d6',
    	        cancelButtonColor: '#d33',
    	        confirmButtonText: 'Yes, delete it!'
    	    }).then((result) => {
    	        if (result.isConfirmed) {
    	            $.ajax({
    	                url: 'deleteInstituteAction',
    	                method: 'POST',
    	                data: { institute_id: instituteId },
    	                dataType: 'json',
    	                success: function(response) {
    	                    console.log(response);
    	                    if (response.success) {
    	                        Swal.fire({
    	                            icon: 'success',
    	                            title: 'Deleted!',
    	                            text: 'The institute has been deleted.',
    	                            confirmButtonColor: '#3085d6',
    	                            confirmButtonText: 'OK'
    	                        }).then(() => {
    	                            // Reload the table or page to reflect changes
    	                            location.reload();
    	                        });
    	                    } else {
    	                        Swal.fire({
    	                            icon: 'error',
    	                            title: 'Oops...',
    	                            text: response.message,
    	                            confirmButtonColor: '#3085d6',
    	                            confirmButtonText: 'OK'
    	                        });
    	                    }
    	                },
    	                error: function(xhr, status, error) {
    	                    console.error('Error deleting institute:', error);
    	                    Swal.fire({
    	                        icon: 'error',
    	                        title: 'Oops...',
    	                        text: 'Something went wrong! Please try again later.',
    	                        confirmButtonColor: '#3085d6',
    	                        confirmButtonText: 'OK'
    	                    });
    	                }
    	            });
    	        }
    	    });
    	});

});

</script>
</body>
</html>