package com.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ResponseAdvisement")
public class ResponseAdvisement {

    @Id
    @Column(name = "Id", length = 50, nullable = false)
    private String id;

    @Column(name = "AdvisementId", length = 50)
    private String advisementId;

    @Column(name = "UserId", length = 50)
    private String userId;

    @Column(name = "Text", columnDefinition = "nvarchar(max)")
    private String text;

    @Column(name = "Date")
    private LocalDateTime date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAdvisementId() {
        return advisementId;
    }

    public void setAdvisementId(String advisementId) {
        this.advisementId = advisementId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
