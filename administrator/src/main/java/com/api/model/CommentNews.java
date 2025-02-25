package com.api.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CommentNews")
public class CommentNews {

    @Id
    @Column(name = "Id", length = 50, nullable = false)
    private String id;

    @Column(name = "PieceOfNewsId", length = 50)
    private String pieceOfNewsId;

    @Column(name = "AuthorId", length = 50)
    private String authorId;

    @Column(name = "Text", columnDefinition = "nvarchar(max)")
    private String text;

    @Column(name = "Date")
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
