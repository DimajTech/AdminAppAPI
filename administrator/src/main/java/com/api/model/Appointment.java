package com.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @Column(name = "Id", length = 50, nullable = false)
    private String id;

    @Column(name = "Date")
    private LocalDateTime date;

    @Column(name = "Mode", length = 20)
    private String mode;

    @Column(name = "Status", length = 20)
    private String status;

    @Column(name = "CourseId", length = 50)
    private String courseId;

    @Column(name = "StudentId", length = 50)
    private String studentId;

    @Column(name = "ProfessorComment", length = 200)
    private String professorComment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProfessorComment() {
        return professorComment;
    }

    public void setProfessorComment(String professorComment) {
        this.professorComment = professorComment;
    }
}
