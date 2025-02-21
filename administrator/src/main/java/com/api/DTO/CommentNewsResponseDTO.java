package com.api.DTO;

import java.util.Date;

public class CommentNewsResponseDTO {

    private String id;
    private String commentNewsId;
    private String text;
    private Date date;
    private String name;
    private String role;

    public CommentNewsResponseDTO(String id, String pieceOfNewsId, String text, Date date, String name, String role) {
        this.id = id;
        this.commentNewsId = pieceOfNewsId;
        this.text = text;
        this.date = date;
        this.name = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentNewsId() {
        return commentNewsId;
    }

    public void setCommentNewsId(String commentNewsId) {
        this.commentNewsId = commentNewsId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
