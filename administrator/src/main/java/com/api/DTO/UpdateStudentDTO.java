package com.api.DTO;

public class UpdateStudentDTO {
    public String Id;
    public String Name;
    public String Password;
    public String Description;
    public String LinkedIn;
    public String Picture;
    public String ProfessionalBackground;

    public UpdateStudentDTO() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLinkedIn() {
        return LinkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        LinkedIn = linkedIn;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getProfessionalBackground() {
        return ProfessionalBackground;
    }

    public void setProfessionalBackground(String professionalBackground) {
        ProfessionalBackground = professionalBackground;
    }
}
