package edu.practise.universal_teacher.controller.courses;

import edu.practise.universal_teacher.entities.study.Course;
import edu.practise.universal_teacher.entities.study.CourseProfileRelation;
import edu.practise.universal_teacher.entities.user.User;
import edu.practise.universal_teacher.services.course.CourseServiceImpl;
import edu.practise.universal_teacher.services.usr.UsrProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/courses")
public class CoursesController {
    private final CourseServiceImpl courseService;
    private final UsrProfileServiceImpl usrProfileService;

    @Autowired
    public CoursesController(CourseServiceImpl courseService, UsrProfileServiceImpl usrProfileService) {
        this.courseService = courseService;
        this.usrProfileService = usrProfileService;
    }

    @GetMapping
    public ResponseEntity<HashMap<String,List<Course>>> getAllCourses(@AuthenticationPrincipal User user) {
        HashMap<String,List<Course>> courses = new HashMap<>();
        courses.put("my-courses",usrProfileService.getCoursesByProfile(user.getProfile()));
        courses.put("all-courses",courseService.getAllCourses());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courses);
    }

    @PostMapping
    public ResponseEntity<Course> addNewCourse(@RequestBody Course course) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courseService.addCourse(course));
    }

    @PutMapping
    public ResponseEntity<CourseProfileRelation> addNewCourseToUser(@AuthenticationPrincipal User user,
                                                                    @RequestParam String courseId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usrProfileService.addCourseToUser(user, courseId));
    }

}
