package edu.practise.universal_teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "http://localhost:3000" })
@SpringBootApplication
public class UniversalTeacherApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversalTeacherApplication.class, args);
	}

}
