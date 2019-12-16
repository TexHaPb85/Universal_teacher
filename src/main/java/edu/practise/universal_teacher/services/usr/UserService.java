package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.entities.study.Course;
import edu.practise.universal_teacher.entities.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    User getUserById(String id);

    User saveUser(User user);

    void deleteUserById(String userId);

    User editUserById(String userId, User user);
}
