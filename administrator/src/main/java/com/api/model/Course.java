package com.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @Column(name = "Id", length = 50, nullable = false)
    private String id;

    @Column(name = "Code", length = 50)
    private String code;

    @Column(name = "Name", length = 100)
    private String name;

    @Column(name = "ProfessorId", length = 50)
    private String professorId;

    @Column(name = "Semester", length = 20)
    private String semester;

    @Column(name = "Year")
    private Integer year;

    @Column(name = "IsActive")
    private Boolean isActive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
