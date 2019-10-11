package edu.practise.universal_teacher.controller.user;

import edu.practise.universal_teacher.entities.User;
import edu.practise.universal_teacher.entities.UsrProfile;
import edu.practise.universal_teacher.services.usr.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllProfiles(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @PostMapping("/admin/users/add")
    public ResponseEntity<User> addProfile(@RequestBody User usr) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.saveUser(usr));
    }
}
