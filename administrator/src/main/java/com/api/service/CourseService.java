package com.api.service;

import com.api.DTO.GetCoursesDTO;
import com.api.model.Course;
import com.api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<GetCoursesDTO> getAllCourses(){
        return courseRepository.findAllCourses();
    }

    public void saveCourse(Course course) throws Exception{
        courseRepository.save(course);
    }

    public GetCoursesDTO getCourseById(String id) throws Exception{
        return courseRepository.findCourseById(id);
    }

    public void deleteCourse(String id) throws Exception{
        courseRepository.deleteById(id);
    }
}
