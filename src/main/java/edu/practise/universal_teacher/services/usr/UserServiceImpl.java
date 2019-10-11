package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.entities.User;
import edu.practise.universal_teacher.exceptions.UserNotFoundException;
import edu.practise.universal_teacher.reposetories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public User editUserById(Long userId, User user) {
        User userFromDB = getUserById(userId);
        BeanUtils.copyProperties(user,userFromDB,"id");
        return repository.save(userFromDB);
    }
}
