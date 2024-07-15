<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%-- <%
    // Check if user is already logged in
    HttpSession sessions = request.getSession(false);

    if (sessions == null) {
        System.out.println("Session is null. Redirecting to login page.");
        response.sendRedirect("login");
        return;
    } else if (sessions.getAttribute("AdminData") == null) {
        System.out.println("AdminData attribute is null. Redirecting to login page.");
        response.sendRedirect("login");
        return;
    } else {
        System.out.println("Session and AdminData attribute are valid.");
    }
%> --%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/navbarStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="wrapper">
        <aside id="sidebar">
            <div class="d-flex">
                <button class="toggle-btn" type="button">
                    <i class="lni lni-grid-alt"></i>
                </button>
                <div class="sidebar-logo">
                    <a href="#">Typo Genius</a>
                </div>
            </div>
            <ul class="sidebar-nav">
                <li class="sidebar-item">
                    <a href="dashboard" class="sidebar-link">
                          <img src="assets/images/Navbar/dashboard.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="sidebar-item">
    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
        data-bs-target="#institute" aria-expanded="false" aria-controls="institute">
        <img src="assets/images/Navbar/Institute.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
        <span>Institute</span>
    </a>
    <ul id="institute" class="sidebar-dropdown list-unstyled collapse  ms-auto text-center" data-bs-parent="#sidebar">
        <li class="sidebar-item">
            <a href="instituteCreation" class="sidebar-link">
                <img src="assets/images/Navbar/insCreation.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                Institute Creation
            </a>
        </li>
        <li class="sidebar-item">
            <a href="instituteList" class="sidebar-link">
                <img src="assets/images/Navbar/insList.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                Institute List
            </a>
        </li>
    </ul>
</li>
<li class="sidebar-item">
    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
        data-bs-target="#staff" aria-expanded="false" aria-controls="staff">
        <img src="assets/images/Navbar/grouping.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
        <span>Staff</span>
    </a>
    <ul id="staff" class="sidebar-dropdown list-unstyled collapse  ms-auto text-center" data-bs-parent="#sidebar">
        <li class="sidebar-item">
            <a href="staffCreation" class="sidebar-link">
                <img src="assets/images/Navbar/add_staff.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                Add Staff
            </a>
        </li>
        <li class="sidebar-item">
            <a href="staffList" class="sidebar-link">
                <img src="assets/images/Navbar/staff.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                Staff List
            </a>
        </li>
    </ul>
</li>

                                 <li class="sidebar-item">
                    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
                        data-bs-target="#student" aria-expanded="false" aria-controls="student">
                          <img src="assets/images/Navbar/student.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                        <span>Student</span>
                    </a>
                    <ul id="student" class="sidebar-dropdown list-unstyled collapse  ms-auto text-center" data-bs-parent="#sidebar">
                        <li class="sidebar-item">
                            <a href="addStudent" class="sidebar-link">
                                                      <img src="assets/images/Navbar/stdadd.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                            Add Students</a>
                        </li>
                        <li class="sidebar-item">
                            <a href="studentList" class="sidebar-link">
                                                     <img src="assets/images/Navbar/stdlist.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                            Student List</a>
                        </li>
                    </ul>
                </li>
                <li class="sidebar-item">
    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
        data-bs-target="#course" aria-expanded="false" aria-controls="course">
        <img src="assets/images/Navbar/course.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
        <span>Course</span>
    </a>
    <ul id="course" class="sidebar-dropdown list-unstyled collapse  ms-auto text-center" data-bs-parent="#sidebar">
        <li class="sidebar-item">
            <a href="courseAdd" class="sidebar-link">
                <img src="assets/images/Navbar/courseadd.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                Add Course
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/courseList.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                Course List
            </a>
        </li>
    </ul>
</li>
                <li class="sidebar-item">
                    <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/admission.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                        <span>Admission Request</span>
                    </a>
                </li>
 <li class="sidebar-item">
    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
        data-bs-target="#exam" aria-expanded="false" aria-controls="exam">
        <img src="assets/images/Navbar/exam.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
        <span>Examination</span>
    </a>
    <ul id="exam" class="sidebar-dropdown list-unstyled collapse  ms-auto text-center" data-bs-parent="#sidebar">
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/time-table.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
              Time Table
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/question.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                Question Paper
            </a>
        </li>
    </ul>
</li>
                <li class="sidebar-item">
                    <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/batch.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                        <span>Batch</span>
                    </a>
                </li>
  <li class="sidebar-item">
    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
        data-bs-target="#attendance" aria-expanded="false" aria-controls="attendance">
        <img src="assets/images/Navbar/attendance.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
        <span>Attendance</span>
    </a>
    <ul id="attendance" class="sidebar-dropdown list-unstyled collapse  ms-auto text-center" data-bs-parent="#sidebar">
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/staffatt.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
             Staff
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/stdatt.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                Student
            </a>
        </li>
    </ul>
</li>
<li class="sidebar-item">
    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
        data-bs-target="#expense" aria-expanded="false" aria-controls="attendance">
        <img src="assets/images/Navbar/exp-track.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
        <span>Expense Tracker</span>
    </a>
    <ul id="expense" class="sidebar-dropdown list-unstyled collapse  ms-auto text-center" data-bs-parent="#sidebar">
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/expenseadd.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
             Add Expense's
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/expenseslsit.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
              Expense List
            </a>
        </li>
    </ul>
</li>
<li class="sidebar-item">
    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
        data-bs-target="#reminder" aria-expanded="false" aria-controls="attendance">
        <img src="assets/images/Navbar/attendance.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
        <span>Reminder</span>
    </a>
    <ul id="reminder" class="sidebar-dropdown list-unstyled collapse  ms-auto text-center" data-bs-parent="#sidebar">
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/staffatt.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
             Fees Reminder
            </a>
        </li>
    </ul>
</li>
<li class="sidebar-item">
    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
        data-bs-target="#reports" aria-expanded="false" aria-controls="attendance">
        <img src="assets/images/Navbar/report.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
        <span>Reports</span>
    </a>
    <ul id="reports" class="sidebar-dropdown list-unstyled collapse  ms-auto text-center" data-bs-parent="#sidebar">
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/charge.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
             Fees Report
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/salary.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                Salary Report
            </a>
        </li>
                <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/ex-re.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
               Expense Report
            </a>
        </li>
          <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/tadmission.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
              Admission Report
            </a>
        </li>
    </ul>
</li>

<!--                 <li class="sidebar-item">
                    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
                        data-bs-target="#multi" aria-expanded="false" aria-controls="multi">
                        <i class="lni lni-layout"></i>
                        <span>Multi Level</span>
                    </a>
                    <ul id="multi" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                        <li class="sidebar-item">
                            <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse"
                                data-bs-target="#multi-two" aria-expanded="false" aria-controls="multi-two">
                                Two Links
                            </a>
                            <ul id="multi-two" class="sidebar-dropdown list-unstyled collapse">
                                <li class="sidebar-item">
                                    <a href="#" class="sidebar-link">Link 1</a>
                                </li>
                                <li class="sidebar-item">
                                    <a href="#" class="sidebar-link">Link 2</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li> -->
                <li class="sidebar-item">
                    <a href="#" class="sidebar-link">
         <img src="assets/images/Navbar/notification.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                        <span>Notification</span>
                    </a>
                </li>
                <li class="sidebar-item">
    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
        data-bs-target="#settings" aria-expanded="false" aria-controls="attendance">
        <img src="assets/images/Navbar/settings.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
        <span>Settings</span>
    </a>
    <ul id="settings" class="sidebar-dropdown list-unstyled collapse  ms-auto text-center" data-bs-parent="#sidebar">
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/profile.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
             Profile
            </a>
        </li>
        <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/stdatt.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
            Content
            </a>
        </li>
                <li class="sidebar-item">
            <a href="#" class="sidebar-link">
                <img src="assets/images/Navbar/gallery.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
          Gallery
            </a>
        </li>
    </ul>
</li>
                <li class="sidebar-item">
                    <a href="logout" class="sidebar-link">
                <img src="assets/images/Navbar/exit.png" alt="" style="width: 20px; height: 20px;">&nbsp;&nbsp;
                        <span>Logout</span>
                    </a>
                </li>
               
            </ul>
                    </aside>
    </div>
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js" nonce="bxUDOG8V1uW1iyKUoG30PpQs"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" nonce="bxUDOG8V1uW1iyKUoG30PpQs"></script>
    <script src="assets/navbarScript.js" nonce="bxUDOG8V1uW1iyKUoG30PpQs"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10" nonce="bxUDOG8V1uW1iyKUoG30PpQs"></script>
</body>

</html>