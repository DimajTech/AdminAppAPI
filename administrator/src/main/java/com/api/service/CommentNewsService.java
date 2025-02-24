package com.api.service;

import com.api.DTO.CommentNewsDTO;
import com.api.model.CommentNews;
import com.api.repository.CommentNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class CommentNewsService {

    @Autowired
    private CommentNewsRepository commentNewsRepository;

    public List<CommentNewsDTO> getAllCommentNewsByNewsId(String id) {
        return commentNewsRepository.getCommentByPieceOfNewsId(id);
    }
    public void saveCommentNews(CommentNews comment) throws SQLException {

        if (comment.getId() == null || comment.getId().isEmpty()) {
            comment.setId(UUID.randomUUID().toString());
        }

        commentNewsRepository.addNewsComment(
                comment.getId(),
                comment.getPieceOfNewsId(),
                comment.getAuthorId(),
                comment.getText()
        );
    }
    public List<CommentNewsDTO> getCommentNewsById(String id) throws SQLException {
        return commentNewsRepository.getCommentByPieceOfNewsId(id);
    }

    public void deleteCommentNewsById(String id) throws SQLException {
        commentNewsRepository.deleteCommentById(id);
    }

}
