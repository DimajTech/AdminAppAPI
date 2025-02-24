package com.api.repository;

import com.api.DTO.CommentNewsDTO;
import com.api.DTO.NewsDTO;
import com.api.model.CommentNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface CommentNewsRepository extends JpaRepository<CommentNews, String> {

    @Modifying
    @Transactional
    @Query(value = "EXEC InsertNewsComment @Id = ?1, @PieceOfNewsId = ?2, @AuthorId = ?3, @Text = ?4", nativeQuery = true)
    void addNewsComment(String id, String pieceOfNewsId, String authorID, String text);

    @Query(value = "EXEC GetCommentByPieceOfNewsId @Id = ?1", nativeQuery = true)
    List<CommentNewsDTO> getCommentByPieceOfNewsId(String id);

    @Modifying
    @Transactional
    @Query(value = "EXEC DeleteCommentNewsById @Id = ?1", nativeQuery = true)
    void deleteCommentById(String id);

}


