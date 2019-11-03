package edu.practise.universal_teacher.services.course;

import edu.practise.universal_teacher.entities.Course;
import edu.practise.universal_teacher.entities.Lesson;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseByName(String nameOfCourse);

    Course addCourse(Course course);

    Lesson addLessonToCourse(Lesson lesson, String nameOfCourse);
}
