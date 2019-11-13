package edu.practise.universal_teacher.reposetories;

import edu.practise.universal_teacher.entities.study.Course;
import edu.practise.universal_teacher.entities.study.CourseProfileRelation;
import edu.practise.universal_teacher.entities.user.UsrProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationRepository extends JpaRepository<CourseProfileRelation,String> {
    CourseProfileRelation getCourseProfileRelationByUsrProfile(UsrProfile profile);
}
