package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(String id);

    User saveUser(User user);

    void deleteUserById(String userId);

    User editUserById(String userId, User user);
}
