package com.api.controller;

import com.api.DTO.GetCoursesDTO;
import com.api.model.Course;
import com.api.service.CourseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping(path="/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getAllCourses")
    public ResponseEntity<?> getAllCourses(){
        try{
            List<GetCoursesDTO> courses = courseService.getAllCourses();
            return ResponseEntity.ok(courses);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Error loading user list");
        }
    }

    @PostMapping("/saveCourse")
    public ResponseEntity<?> saveCourse(@RequestBody Course course){
        try{
            if(course.getId() == null || course.getId().isEmpty()){
                course.setId(UUID.randomUUID().toString());
            }
            courseService.saveCourse(course);
            return ResponseEntity.ok(new JSONObject().put("message", "Course added successfully"));
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Error creating course");
        }
    }

    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable(value = "id") String id){
        try{
            GetCoursesDTO course = courseService.getCourseById(id);
            return ResponseEntity.ok(course);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Error loading course");
        }
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable(value = "id") String id){
        try{
            courseService.deleteCourse(id);
            return ResponseEntity.ok(new JSONObject().put("message", "Course deleted successfully"));
        }catch(Exception ex){
            return ResponseEntity.badRequest().body("Error deleting course");
        }
    }
}
