package com.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Advisement")
public class Advisement {

    @Id
    @Column(name = "Id", length = 50, nullable = false)
    private String id;

    @Column(name = "CourseId", length = 50)
    private String courseId;

    @Column(name = "Content", columnDefinition = "nvarchar(max)")
    private String content;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "IsPublic")
    private Boolean isPublic;

    @Column(name = "StudentId", length = 50)
    private String studentId;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
