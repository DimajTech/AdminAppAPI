package com.api.model;

import jakarta.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "PieceOfNews")
public class PieceOfNews {

    @Id
    @Column(name = "Id", length = 50, nullable = false)
    private String id;

    @Column(name = "Title", length = 200)
    private String title;

    @Column(name = "File", columnDefinition = "nvarchar(max)")
    private String file;

    @Lob
    @Column(name = "Picture")
    private byte[] picture;

    @Column(name = "AuthorId", length = 30)
    private String authorId;

    @Column(name = "Description", columnDefinition = "nvarchar(max)")
    private String description;

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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
