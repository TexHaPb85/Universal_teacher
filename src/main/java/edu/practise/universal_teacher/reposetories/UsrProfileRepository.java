package edu.practise.universal_teacher.reposetories;

import edu.practise.universal_teacher.model.user.UsrProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrProfileRepository extends JpaRepository<UsrProfile,String>{
}
