package edu.practise.universal_teacher;

import edu.practise.universal_teacher.entities.user.User;
import edu.practise.universal_teacher.entities.user.UsrProfile;
import edu.practise.universal_teacher.reposetories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UniversalTeacherApplicationTests {

	@Autowired
	private UserRepository repository;

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
		User loggedUser = new User("121321321312312", "alinaezoterika@gmail.com", null, null);
		System.out.println(repository.save(loggedUser));
		System.out.println(repository.findAll());
	}
}
