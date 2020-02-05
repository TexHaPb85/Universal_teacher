package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.model.user.User;
import edu.practise.universal_teacher.exceptions.UserNotFoundException;
import edu.practise.universal_teacher.reposetories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public User getUserById(String id) {
        return repository
                .findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUserById(String userId) {
        repository.deleteById(userId);
    }

    @Override
    public User editUserById(String userId, User user) {
        User userFromDB = getUserById(userId);
        BeanUtils.copyProperties(user,userFromDB,"id");
        return repository.save(userFromDB);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
