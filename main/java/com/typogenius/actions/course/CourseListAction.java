package com.typogenius.actions.course;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.typogenius.database.CourseDAO;
import com.typogenius.models.Course;

public class CourseListAction extends ActionSupport {

    private List<Course> courseList;
    private Course course;
    private String courseId;

    public String execute() {
        courseList = CourseDAO.getInstance().getCourseList();
        return SUCCESS;
    }

    public String getCourseDetails() {
        if (courseId != null && !courseId.isEmpty()) {
            course = CourseDAO.getInstance().getCourseById(courseId);
        }
        return SUCCESS;
    }

    // Getters and Setters
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
