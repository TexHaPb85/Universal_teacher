package edu.practise.universal_teacher.services.course;

import edu.practise.universal_teacher.model.study.Course;
import edu.practise.universal_teacher.model.study.Lesson;
import edu.practise.universal_teacher.exceptions.CourseNotFoundException;
import edu.practise.universal_teacher.reposetories.CourseRepository;
import edu.practise.universal_teacher.reposetories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, LessonRepository lessonRepository) {
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseByName(String nameOfCourse) {
        return courseRepository
                .findById(nameOfCourse)
                .orElseThrow(()->new CourseNotFoundException(nameOfCourse));
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Lesson addLessonToCourse(Lesson lesson, String nameOfCourse) {
        Course course = courseRepository.findById(nameOfCourse).orElse(null);
        lesson.setCourse(course);
        return lessonRepository.save(lesson);
    }
}
