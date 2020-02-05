package edu.practise.universal_teacher.reposetories;

import edu.practise.universal_teacher.model.study.CourseProfileRelation;
import edu.practise.universal_teacher.model.user.UsrProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<CourseProfileRelation,String> {
    CourseProfileRelation getCourseProfileRelationByUsrProfile(UsrProfile profile);
}
