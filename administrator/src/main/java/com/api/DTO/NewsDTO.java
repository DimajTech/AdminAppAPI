package com.api.DTO;

import java.util.Base64;
import java.util.Date;
import java.util.Optional;

public class NewsDTO {
    private String id;
    private String title;
    private String description;
    private String picture;
    private Date date;
    private String authorId;
    private String authorName;
    private String authorRole;
    private String file;
    private String authorEmail;
    private String authorPic;

    // Constructor vacío para facilitar la deserialización
    public NewsDTO() {}

    public NewsDTO(String id, String title, String description, byte[] picture, Date date, String authorId, String authorName, String authorRole) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picture = "data:image/jpeg;base64,"+ Base64.getEncoder().encodeToString((byte[]) picture);
        this.date = date;
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorRole = authorRole;
    }

    public NewsDTO(String id, String title, String file, byte[] picture, String description, Date date, String authorId, String authorEmail, String authorName, String authorPic, String authorRole) {
        this.id = id;
        this.title = title;
        this.file = file;
        this.picture = "data:image/jpeg;base64,"+ Base64.getEncoder().encodeToString(picture);
        this.description = description;
        this.date = date;
        this.authorId = authorId;
        this.authorEmail = authorEmail;
        this.authorName = authorName;
        this.authorPic = authorPic;
        this.authorRole = authorRole;
    }

    public String getAuthorPic() {
        return authorPic;
    }

    public void setAuthorPic(String authorPic) {
        this.authorPic = authorPic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorRole() {
        return authorRole;
    }

    public void setAuthorRole(String authorRole) {
        this.authorRole = authorRole;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

}
