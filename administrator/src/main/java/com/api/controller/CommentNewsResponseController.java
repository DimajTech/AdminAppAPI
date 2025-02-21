package com.api.controller;

import com.api.DTO.CommentNewsDTO;
import com.api.DTO.CommentNewsResponseDTO;
import com.api.model.CommentNews;
import com.api.model.CommentNewsResponse;
import com.api.service.CommentNewsResponseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping(path="/api/commentNewsResponse")
public class CommentNewsResponseController {


    @Autowired
    private CommentNewsResponseService commentNewsResponseService;

    @GetMapping("/getCommentNewsResponseById/{id}")
    public List<CommentNewsResponseDTO> getCommentNewsResponseById(@PathVariable(value = "id") String id) throws SQLException {
        return commentNewsResponseService.getCommentNewsResponseById(id);
    }

    @PostMapping ("/saveCommentNewsResponse")
    public ResponseEntity<?> saveCommentNewsResponse(@RequestBody CommentNewsResponse commentNews){
        JSONObject response = new JSONObject();
        try {
            commentNewsResponseService.saveCommentNewsResponse(commentNews);
            response.put("message", "CommentNewsResponse added successfully");
            response.put("isSuccess", true);
            return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
        } catch (SQLException ex) {
            return ResponseEntity
                    .badRequest()
                    .body("CommentNewsResponse not inserted");
        }
    }

    @PostMapping("/deleteCommentNewsResponseById/{id}")
    public ResponseEntity<?> deleteCommentNewsResponseById(@PathVariable(value = "id") String id) {
        JSONObject response = new JSONObject();
        try {
            commentNewsResponseService.deleteCommentNewsResponseById(id);
            response.put("message", "CommentNewsResponse deleted");
            response.put("isSuccess", true);
            return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
        } catch (SQLException ex) {
            return ResponseEntity
                    .badRequest()
                    .body("CommentNewsResponse not deleted");
        }
    }

}
