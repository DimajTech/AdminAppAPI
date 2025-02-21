package com.api.service;

import com.api.DTO.CommentNewsResponseDTO;
import com.api.model.CommentNewsResponse;
import com.api.repository.CommentNewsResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class CommentNewsResponseService {

    @Autowired
    private CommentNewsResponseRepository commentNewsResponseRepository;

    public void saveCommentNewsResponse(CommentNewsResponse comment) throws SQLException {

        if (comment.getId() == null || comment.getId().isEmpty()) {
            comment.setId(UUID.randomUUID().toString());
        }

        commentNewsResponseRepository.addNewsCommentResponse(
                comment.getId(),
                comment.getCommentNewsId(),
                comment.getAuthorId(),
                comment.getText()
        );
    }
    public List<CommentNewsResponseDTO> getCommentNewsResponseById(String id) throws SQLException {
        return commentNewsResponseRepository.getResponsesByCommentNewsId(id);
    }

    public void deleteCommentNewsResponseById(String id) throws SQLException {
        commentNewsResponseRepository.deleteById(id);
    }

}
