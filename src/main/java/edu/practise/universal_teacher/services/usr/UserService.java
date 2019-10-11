package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User saveUser(User user);

    void deleteUserById(Long userId);

    User editUserById(Long userId, User user);
}
