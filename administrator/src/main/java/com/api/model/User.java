package com.api.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "[User]")
@NamedStoredProcedureQuery(
        name = "InsertProfessorUser",
        procedureName = "InsertProfessorUser",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "email", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "password", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "role", type = String.class)
        }
)
public class User {

    @Id
    @Column(name = "Id", length = 50, nullable = false)
    private String id;

    @Column(name = "Name", length = 100)
    private String name;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Picture", columnDefinition = "nvarchar(max)")
    private String picture;

    @Column(name = "Description", columnDefinition = "nvarchar(max)")
    private String description;

    @Column(name = "LinkedIn", columnDefinition = "nvarchar(max)")
    private String linkedIn;

    @Column(name = "ProfessionalBackground", columnDefinition = "nvarchar(max)")
    private String professionalBackground;

    @Column(name = "Password", columnDefinition = "nvarchar(max)")
    private String password;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "Registration_Status", length = 50)
    private String registrationStatus;

    @Column(name = "Role", length = 20)
    private String role;

    public User() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getProfessionalBackground() {
        return professionalBackground;
    }

    public void setProfessionalBackground(String professionalBackground) {
        this.professionalBackground = professionalBackground;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
