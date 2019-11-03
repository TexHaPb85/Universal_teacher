package edu.practise.universal_teacher.reposetories;

import edu.practise.universal_teacher.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson,String>{
    List<Lesson> findLessonsByCourseCourseName(String courseName);
}
