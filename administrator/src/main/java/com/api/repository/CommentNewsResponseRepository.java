package com.api.repository;

import com.api.DTO.CommentNewsDTO;
import com.api.DTO.CommentNewsResponseDTO;
import com.api.DTO.NewsDTO;
import com.api.model.CommentNews;
import com.api.model.CommentNewsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface CommentNewsResponseRepository extends JpaRepository<CommentNewsResponse, String> {

    @Modifying
    @Transactional
    @Query(value = "EXEC InsertNewsCommentResponse @Id = ?1, @CommentNewsId = ?2, @AuthorId = ?3, @Text = ?4", nativeQuery = true)
    void addNewsCommentResponse(String id, String commentNewsId, String authorID, String text);

    @Query(value = "EXEC GetResponsesByCommentNewsId @Id = ?1", nativeQuery = true)
    List<CommentNewsResponseDTO> getResponsesByCommentNewsId(String id);
}


