package com.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CommentNewsResponse")
public class CommentNewsResponse {

    @Id
    @Column(name = "Id", length = 50, nullable = false)
    private String id;

    @Column(name = "CommentNewsId", length = 50)
    private String commentNewsId;

    @Column(name = "AuthorId", length = 50)
    private String authorId;

    @Column(name = "Text", columnDefinition = "nvarchar(max)")
    private String text;

    @Column(name = "Date")
    private LocalDateTime date;

    // Getters y Setters
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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
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
