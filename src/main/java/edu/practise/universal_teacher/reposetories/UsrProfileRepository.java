package edu.practise.universal_teacher.reposetories;

import edu.practise.universal_teacher.entities.study.Course;
import edu.practise.universal_teacher.entities.user.UsrProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsrProfileRepository extends JpaRepository<UsrProfile,String>{
}
