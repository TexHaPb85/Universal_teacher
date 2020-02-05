package edu.practise.universal_teacher.controller.courses;

import edu.practise.universal_teacher.model.study.Course;
import edu.practise.universal_teacher.services.course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/admin/courses")
public class AdminCoursesController {
    private final CourseServiceImpl courseService;

    @Autowired
    public AdminCoursesController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courseService.getAllCourses());
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courseService.addCourse(course));
    }
}
