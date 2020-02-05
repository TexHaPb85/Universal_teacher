package edu.practise.universal_teacher.reposetories;

import edu.practise.universal_teacher.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
