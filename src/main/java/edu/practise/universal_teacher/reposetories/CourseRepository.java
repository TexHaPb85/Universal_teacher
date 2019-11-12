package edu.practise.universal_teacher.reposetories;

import edu.practise.universal_teacher.entities.study.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String>{
}
