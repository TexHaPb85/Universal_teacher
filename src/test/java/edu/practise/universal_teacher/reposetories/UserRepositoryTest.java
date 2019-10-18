package edu.practise.universal_teacher.reposetories;

import edu.practise.universal_teacher.entities.User;
import edu.practise.universal_teacher.entities.UsrProfile;
import edu.practise.universal_teacher.services.usr.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest(classes = {UserRepository.class, UserServiceImpl.class})
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserServiceImpl service;

    @Test
    public void addUser() {
        UsrProfile profile = new UsrProfile("121321321312312",
                "Алина Самойленко",
                "https://lh3.googleusercontent.com/-N9qRybxVM0s/AAAAAAAAAAI/AAAAAAAAAAA/ACHi3rd1LQcLxJna-oV9MNawpiXJfvwzQQ/photo.jpg",
                0,
                0L,
                0,
                "ru",
                LocalDateTime.now(),
                null);
        User loggedUser = new User("121321321312312", "alinaezoterika@gmail.com", null, profile);
        //System.out.println(loggedUser);
        System.out.println(service.saveUser(loggedUser));
    }
}