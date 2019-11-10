package edu.practise.universal_teacher.controller.courses;

import edu.practise.universal_teacher.entities.Course;
import edu.practise.universal_teacher.services.course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/courses")
public class CoursesController {
    private final CourseServiceImpl courseService;

    @Autowired
    public CoursesController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courseService.getAllCourses());
    }
}
