package com.typogenius.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.typogenius.models.Student;


public class StudentDAO {

	private Connection con=DbConnector.getConnection();
	private static StudentDAO studentDAO;
	
	public static StudentDAO getInstance()
	{
		if(studentDAO==null)
		{
			studentDAO=new StudentDAO();	
			}
		return studentDAO;
	}

    public String getLastestStudentId(String insId) {
        String query = "SELECT * FROM student where institute_id=? Order by sno desc Limit 1";
        try (PreparedStatement statement = con.prepareStatement(query)) {
        	statement.setString(1,insId);
            try (ResultSet set = statement.executeQuery()) {
                if (set.next()) {
                    return set.getString("studentId");
                } else {
                    return "";              
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean addStudent(Student student) {
        String query = "INSERT INTO student (StudentId, institute_id, First_Name, Last_Name,gender, picture, Email, PhoneNumber, dateofbrith, join_date, created_date, courseId, age, bloodGroup, attendExam, educationLevel, educationDetails, doorNo, street, area, pincode, city, state, country) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, student.getStudentId());
            statement.setString(2, student.getInstituteId());
            statement.setString(3, student.getFirstName());
            statement.setString(4, student.getLastName());
            statement.setString(5, student.getGender());
            statement.setString(6, student.getProfileImagePath());
            statement.setString(7, student.getEmail());
            statement.setString(8, student.getPhoneNumber().toString());
	        statement.setDate(9, java.sql.Date.valueOf(student.getDateOfBrith()));
	        statement.setDate(10, java.sql.Date.valueOf(student.getDateOfJoining()));
	        statement.setTimestamp(11, java.sql.Timestamp.valueOf(student.getCreatedDate()));
            statement.setString(12, student.getCourses());
            statement.setInt(13, student.getAge());
            statement.setString(14, student.getBloodGroup());
            statement.setInt(15, student.getExamCheck());
            statement.setString(16, student.getEducationLevel());
            statement.setString(17, student.getEducationDetails());
            statement.setString(18, student.getDoorno());
            statement.setString(19, student.getStreet());
            statement.setString(20, student.getArea());
            statement.setString(21, student.getPincode());
            statement.setString(22, student.getCity());
            statement.setString(23, student.getState());
            statement.setString(24, student.getCountry());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        String query = "UPDATE student SET First_Name = ?, Last_Name = ?, picture = ?, Email = ?, PhoneNumber = ?, dateofbrith = ?, join_date = ?, courseId = ?, age = ?, bloodGroup = ?, attendExam = ?, educationLevel = ?, educationDetails = ?, doorNo = ?, street = ?, area = ?, pincode = ?, city = ?, state = ?, country = ?,gender=? "
                + "WHERE StudentId = ? AND institute_id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getProfileImagePath());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getPhoneNumber().toString()); 	       
            statement.setDate(6, java.sql.Date.valueOf(student.getDateOfBrith()));
	        statement.setDate(7, java.sql.Date.valueOf(student.getDateOfJoining()));
            statement.setString(8, student.getCourses());
            statement.setInt(9, student.getAge());
            statement.setString(10, student.getBloodGroup());
            statement.setInt(11, student.getExamCheck());
            statement.setString(12, student.getEducationLevel());
            statement.setString(13, student.getEducationDetails());
            statement.setString(14, student.getDoorno());
            statement.setString(15, student.getStreet());
            statement.setString(16, student.getArea());
            statement.setString(17, student.getPincode());
            statement.setString(18, student.getCity());
            statement.setString(19, student.getState());
            statement.setString(20, student.getCountry());
            statement.setString(21, student.getGender());
            statement.setString(22, student.getStudentId());
            statement.setString(23, student.getInstituteId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Student getStudentById(String studentId) {
    	 String query = "SELECT * FROM student s LEFT JOIN course c ON s.courseId = c.courseId WHERE s.StudentId = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, studentId);
            try (ResultSet set = statement.executeQuery()) {
                if (set.next()) {
                    return extractStudentFromResultSet(set);
                } else {
                    System.out.println("No student found with the provided ID.");
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        String query = "SELECT * FROM student s LEFT JOIN course c ON s.courseId = c.courseId";
        try (PreparedStatement statement = con.prepareStatement(query);
             ResultSet set = statement.executeQuery()) {
            while (set.next()) {
                Student student = extractStudentFromResultSet(set);
                if (student != null) {
                    studentList.add(student);
                }
            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteStudent(String studentId) {
        String query = "DELETE FROM student WHERE StudentId = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, studentId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Student extractStudentFromResultSet(ResultSet set) throws SQLException {
        Student student = new Student();
        student.setStudentId(set.getString("StudentId"));
        student.setInstituteId(set.getString("institute_id"));
        student.setFirstName(set.getString("First_Name"));
        student.setLastName(set.getString("Last_Name"));
        student.setProfileImagePath(set.getString("picture"));
        student.setEmail(set.getString("Email"));
        student.setPhoneNumber(Long.parseLong(set.getString("PhoneNumber"))); 
        Timestamp timestamp = set.getTimestamp("join_date");
        if (timestamp != null) {
            LocalDate dateOfJoining = timestamp.toLocalDateTime().toLocalDate();
            student.setDateOfJoining(dateOfJoining);
        } else {
            student.setDateOfJoining(null);
        }
        Timestamp timestampbrith = set.getTimestamp("DateofBrith");
        if (timestampbrith != null) {
            LocalDate dateOfbrith = timestampbrith.toLocalDateTime().toLocalDate();
            student.setDateOfBrith(dateOfbrith);
        } else {
            student.setDateOfBrith(null);
        }
        Timestamp timestampCreated = set.getTimestamp("created_date");
        if (timestampCreated != null) {
            LocalDateTime createdDateTime = timestampCreated.toLocalDateTime();
            student.setCreatedDate(createdDateTime);
        } else {
            student.setCreatedDate(null);
        }

        student.setCourses(set.getString("courseId"));
        student.setAge(set.getInt("age"));
        student.setBloodGroup(set.getString("bloodGroup"));
        student.setExamCheck(set.getInt("attendExam"));
        student.setEducationLevel(set.getString("educationLevel"));
        student.setEducationDetails(set.getString("educationDetails"));
        student.setDoorno(set.getString("doorNo"));
        student.setStreet(set.getString("street"));
        student.setArea(set.getString("area"));
        student.setPincode(set.getString("pincode"));
        student.setCity(set.getString("city"));
        student.setState(set.getString("state"));
        student.setCountry(set.getString("country"));
        student.setGender(set.getString("gender"));
        return student;
    }

}
