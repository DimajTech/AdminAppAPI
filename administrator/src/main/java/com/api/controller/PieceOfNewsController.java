package com.api.controller;

import com.api.DTO.NewsDTO;
import com.api.model.PieceOfNews;
import com.api.model.User;
import com.api.service.PieceOfNewsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping(path="/api/pieceOfNews")
public class PieceOfNewsController {


    @Autowired
    private PieceOfNewsService pieceOfNewsService;

    @GetMapping("/getAllPieceOfNews")
    public List<NewsDTO> getAllPieceOfNews() {
        return pieceOfNewsService.getAllPieceOfNews();
    }

    @PostMapping ("/savePieceOfNews")
    public ResponseEntity<?> savePieceOfNews(@RequestBody NewsDTO pieceOfNews){
        JSONObject response = new JSONObject();
        try {
            pieceOfNewsService.savePieceOfNews(pieceOfNews);
            response.put("message", "PieceOfNews added successfully");
            response.put("isSuccess", true);
            return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
        } catch (SQLException ex) {
            return ResponseEntity
                    .badRequest()
                    .body("PieceOfNews not inserted");
        }
    }

    @PostMapping("/deletePieceOfNewsById/{id}")
    public ResponseEntity<?> deletePieceOfNewsById(@PathVariable(value = "id") String id) {
        JSONObject response = new JSONObject();
        try {
            pieceOfNewsService.deletePieceOfNewsById(id);
            response.put("message", "PieceOfNews deleted");
            response.put("isSuccess", true);
            return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
        } catch (SQLException ex) {
            return ResponseEntity
                    .badRequest()
                    .body("PieceOfNews not deleted");
        }
    }

    @GetMapping("/getPieceOfNewsDetailById/{id}")
    public ResponseEntity<NewsDTO> getPieceOfNewsDetailById(@PathVariable String id) {
        try {
            NewsDTO pieceOfNews = pieceOfNewsService.getPieceOfNewsById(id);
            return new ResponseEntity<>(pieceOfNews, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
