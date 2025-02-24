package com.api.DTO;

public class AdvisementDTO {
    private String id;
    private String courseName;
    private String studentName;
    private String content;
    private String status;
    private Boolean isPublic;

    public AdvisementDTO(String id, String courseName, String studentName, String content, String status, Boolean isPublic) {
        this.id = id;
        this.courseName = courseName;
        this.studentName = studentName;
        this.content = content;
        this.status = status;
        this.isPublic = isPublic;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }
}
