package com.api.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Date;

public class CommentNewsDTO {

    private String id;
    private String pieceOfNewsId;
    private String text;
    private Date date;
    private String name;
    private String role;
    private Integer totalResponses;

    public CommentNewsDTO(String id, String pieceOfNewsId, String text, Date date, String name, String role, Integer totalResponses) {
        this.id = id;
        this.pieceOfNewsId = pieceOfNewsId;
        this.text = text;
        this.date = date;
        this.name = name;
        this.role = role;
        this.totalResponses = totalResponses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPieceOfNewsId() {
        return pieceOfNewsId;
    }

    public void setPieceOfNewsId(String pieceOfNewsId) {
        this.pieceOfNewsId = pieceOfNewsId;
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

    public Integer getTotalResponses() {
        return totalResponses;
    }

    public void setTotalResponses(Integer totalResponses) {
        this.totalResponses = totalResponses;
    }
}
