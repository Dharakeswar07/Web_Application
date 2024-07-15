<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <link rel="shortcut icon" href="./assets/images/logo.jpeg" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>

<body>

<div class="wrapper">
    <%@ include file="../views/navbar.jsp" %>
<div class="main pb-3">    
    <%@ include file="../views/header.jsp" %>
             <div class="content-wrapper mb-3">
        <div class="container">
            <div class="row">
                <div class="col-md-2 text-center text-md-end">
                    <!-- Make the GIF responsive -->
                    <img src="assets/images/laptop4.gif" class="img-fluid" style="max-width: 50%;">
                </div>
                <div class="col-md-8">
                    <div class="page-title text-center text-md-start" style="margin-bottom: 8px;">
                        <!-- Make the greeting div responsive -->
                        <h5 class="welcome-text" id="greeting"></h5>
                        <h6 class="welcome-sub-text" id="motivationalQuote">
                            Nothing happens unless first we dream.
                        </h6>
                    </div>
                </div>
                <div class="col-md-2 text-center text-md-start">
                    <!-- Make the GIF responsive -->
                    <img src="assets/images/laptop3.gif" class="img-fluid" style="max-width: 50%;">
                </div>
            </div>
        </div>
    </div>


    <div class="container py-5 shadow-lg rounded-5 ">

        <!-- Important Announcements -->
        <div class="row mb-4">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Recent Students</h5>
                        <ul class="list-group">
                            <li class="list-group-item">John Doe</li>
                            <li class="list-group-item">Jane Smith</li>
                            <li class="list-group-item">Mike Johnson</li>
                            <li class="list-group-item">Emily Brown</li>
                            <li class="list-group-item">David Lee</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Upcoming Events</h5>
                        <ul class="list-group">
                            <li class="list-group-item">Semester Exams - 25th March</li>
                            <li class="list-group-item">Annual Sports Day - 10th April</li>
                            <li class="list-group-item">Science Fair - 15th April</li>
                            <li class="list-group-item">Parent-Teacher Meeting - 30th April</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Important Notices</h5>
                        <ul class="list-group">
                            <li class="list-group-item">Holiday Notice - 1st May</li>
                            <li class="list-group-item">School Closed for Maintenance - 10th May</li>
                            <li class="list-group-item">New Admission Open - Apply Now!</li>
                            <li class="list-group-item">Scholarship Application Deadline - 15th May</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    
        <!-- Attendance Section -->
        <div class="row">
            <div class="col-md-6 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Today's Attendance</h5>
                        <p class="card-text">John Doe - Present</p>
                        <p class="card-text">Jane Smith - Present</p>
                        <p class="card-text">Mike Johnson - Absent</p>
                        <p class="card-text">Emily Brown - Present</p>
                    </div>
                </div>
            </div>
            <div class="col-md-6 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Staff Attendance</h5>
                        <p class="card-text">Teacher 1 - Present</p>
                        <p class="card-text">Teacher 2 - Absent</p>
                        <p class="card-text">Staff 1 - Present</p>
                        <p class="card-text">Staff 2 - Present</p>
                    </div>
                </div>
            </div>
        </div>
    
    </div>

</div>
</div>
                <%@ include file="../views/footer.jsp" %>
<script>
    $(document).ready(function () {
        function displayGreeting() {
            var currentHour = new Date().getHours();
            var greeting;

            if (currentHour < 12) {
                greeting = 'Good Morning';
            } else if (currentHour < 16) {
                greeting = 'Good Afternoon';
            } else {
                greeting = 'Good Evening';
            }
            $('#greeting').text(greeting + ', User!');
        }
        function fetchRandomQuote() {
            fetch('https://api.quotable.io/random')
                .then(response => response.json())
                .then(data => {
                    $('#motivationalQuote').text(data.content);
                })
                .catch(error => {
                    console.error('Error fetching quote:', error);
                });
        }
        displayGreeting();
        fetchRandomQuote();
    });
</script>
</body>

</html>
