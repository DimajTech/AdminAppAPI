package com.api.repository;

import com.api.DTO.GetCoursesDTO;
import com.api.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    @Query("""
       SELECT new com.api.DTO.GetCoursesDTO(c.id, c.code, c.name, c.professorId, u.name, c.semester, c.year, c.isActive)
       FROM Course c
       JOIN User u ON c.professorId = u.id
       """)
    List<GetCoursesDTO> findAllCourses();

    @Query("""
       SELECT new com.api.DTO.GetCoursesDTO(c.id, c.code, c.name, c.professorId, u.name, c.semester, c.year, c.isActive)
       FROM Course c
       JOIN User u ON c.professorId = u.id
       WHERE c.id = :id
       """)
    GetCoursesDTO findCourseById(String id);
}
