package com.api.controller;

import com.api.DTO.CommentNewsDTO;
import com.api.DTO.NewsDTO;
import com.api.model.CommentNews;
import com.api.service.CommentNewsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping(path="/api/commentNews")
public class CommentNewsController {


    @Autowired
    private CommentNewsService commentNewsService;

    @GetMapping("/getCommentNewsById/{id}")
    public List<CommentNewsDTO> getAllCommentNews(@PathVariable(value = "id") String id) throws SQLException {
        return commentNewsService.getCommentNewsById(id);
    }

    @PostMapping ("/saveCommentNews")
    public ResponseEntity<?> saveCommentNews(@RequestBody CommentNews commentNews){
        JSONObject response = new JSONObject();
        try {
            commentNewsService.saveCommentNews(commentNews);
            response.put("message", "CommentNews added successfully");
            response.put("isSuccess", true);
            return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
        } catch (SQLException ex) {
            return ResponseEntity
                    .badRequest()
                    .body("CommentNews not inserted");
        }
    }

    @PostMapping("/deleteCommentNewsById/{id}")
    public ResponseEntity<?> deleteCommentNewsById(@PathVariable(value = "id") String id) {
        JSONObject response = new JSONObject();
        try {
            commentNewsService.deleteCommentNewsById(id);
            response.put("message", "CommentNews deleted");
            response.put("isSuccess", true);
            return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
        } catch (SQLException ex) {
            return ResponseEntity
                    .badRequest()
                    .body("PieceOfNews not deleted");
        }
    }

}
