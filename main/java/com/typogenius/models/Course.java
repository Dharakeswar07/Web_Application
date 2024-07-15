package com.typogenius.models;


public class Course  {

    private String course_Id;
    private String institute_Id;
    private String course_name;
    private String description;
    private String duration;
    private long fees;
    private String status;

    // Constructors
    public Course() {
    }

    public Course(String course_Id, String institute_Id, String course_name, String description, String duration, long fees, String status) {
        this.course_Id = course_Id;
        this.institute_Id = institute_Id;
        this.course_name = course_name;
        this.description = description;
        this.duration = duration;
        this.fees = fees;
        this.status = status;
    }

    // Getters and Setters
    public String getCourse_Id() {
        return course_Id;
    }

    public void setCourse_Id(String course_Id) {
        this.course_Id = course_Id;
    }

    public String getInstitute_Id() {
        return institute_Id;
    }

    public void setInstitute_Id(String institute_Id) {
        this.institute_Id = institute_Id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getFees() {
        return fees;
    }

    public void setFees(long fees) {
        this.fees = fees;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString() method
    @Override
    public String toString() {
        return "Course{" +
                "course_Id=" + course_Id +
                ", institute_Id='" + institute_Id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", fees=" + fees +
                ", status='" + status + '\'' +
                '}';
    }
}
