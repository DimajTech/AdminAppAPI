package com.api.DTO;

public class GetCoursesDTO {
    public String id;
    public String code;
    public String name;
    public String professorId;
    public String professorName;
    public String semester;
    public Integer year;
    public Boolean isActive;

    public GetCoursesDTO() {}

    public GetCoursesDTO(String id, String code, String name, String professorId, String professorName, String semester, Integer year, Boolean isActive) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.professorId = professorId;
        this.professorName = professorName;
        this.semester = semester;
        this.year = year;
        this.isActive = isActive;
    }

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

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
