package com.typogenius.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.typogenius.models.Course;

public class CourseDAO {

	 private Connection con = DbConnector.getConnection();
	    private static CourseDAO courseDAO;

	    public static CourseDAO getInstance() {
	        if (courseDAO == null) {
	        	courseDAO = new CourseDAO();
	        }
	        return courseDAO;
	    }
	
	    public String getLastestCourseId(String insId) {
	        String query = "SELECT * FROM course where institute_id=? Order by sno desc Limit 1";
	        try (PreparedStatement statement = con.prepareStatement(query)) {
	        	statement.setString(1,insId);
	            try (ResultSet set = statement.executeQuery()) {
	                if (set.next()) {
	                    return set.getString("course_resId");
	                } else {
	                    return "";              
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "";
	        }
	    }
 
	    
	    public boolean addCourse(Course course) {
	        String query = "INSERT INTO course (course_resId,institute_id, course_name, description, duration, fees, status) VALUES (?,?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement statement = con.prepareStatement(query)) {
	        	statement.setString(1, course.getCourse_Id());
	            statement.setString(2, course.getInstitute_Id());
	            statement.setString(3, course.getCourse_name());
	            statement.setString(4, course.getDescription());
	            statement.setString(5, course.getDuration());
	            statement.setLong(6, course.getFees());
	            statement.setString(7, course.getStatus());

	            int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    
	    public List<Course> getCourseList() {
	        List<Course> courseList = new ArrayList<>();
	        String query = "SELECT * FROM course";

	        try (PreparedStatement statement = con.prepareStatement(query);
	             ResultSet set = statement.executeQuery()) {

	            while (set.next()) {
	                Course course = new Course();
	                course.setCourse_Id(set.getString("course_resid"));
	                course.setInstitute_Id(set.getString("institute_id"));
	                course.setCourse_name(set.getString("course_name"));
	                course.setDescription(set.getString("description"));
	                course.setDuration(set.getString("duration"));
	                course.setFees(set.getLong("fees"));
	                course.setStatus(set.getString("status"));

	                courseList.add(course);
	            }
	            return courseList;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    public boolean updateCourse(Course course) {
	        String query = "UPDATE course SET course_name = ?, description = ?, duration = ?, fees = ?, status = ?  WHERE course_resid = ?";
	        
	        try (PreparedStatement statement = con.prepareStatement(query)) {
	            statement.setString(1, course.getCourse_name());
	            statement.setString(2, course.getDescription());
	            statement.setString(3, course.getDuration());
	            statement.setLong(4, course.getFees());
	            statement.setString(5, course.getStatus());
	            statement.setString(6, course.getCourse_Id());
	            
	            int rowsUpdated = statement.executeUpdate();
	            return rowsUpdated > 0; 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public Course getCourseById(String id) {
	        String query = "SELECT * FROM course WHERE course_resid = ?";
	        try (PreparedStatement statement = con.prepareStatement(query)) {
	            statement.setString(1, id);
	            try (ResultSet set = statement.executeQuery()) {
	                if (set.next()) {
	                    Course course = new Course();
	                    course.setCourse_Id(set.getString("course_resid"));
	                    course.setInstitute_Id(set.getString("institute_id"));
	                    course.setCourse_name(set.getString("course_name"));
	                    course.setDescription(set.getString("description"));
	                    course.setDuration(set.getString("duration"));
	                    course.setFees(set.getLong("fees"));
	                    course.setStatus(set.getString("status"));
	                    return course;
	                } else {
	                    System.out.println("No Data found with the provided course ID.");
	                    return null;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    
	    public boolean deleteCourse(String course_id) {
	        String query = "DELETE FROM course WHERE course_resid = ?";
	        try (PreparedStatement statement = con.prepareStatement(query)) {
	            statement.setString(1, course_id);
	            int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0; 
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }


}
