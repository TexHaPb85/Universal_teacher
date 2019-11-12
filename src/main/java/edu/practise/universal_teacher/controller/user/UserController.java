package edu.practise.universal_teacher.controller.user;

import edu.practise.universal_teacher.entities.user.User;
import edu.practise.universal_teacher.services.usr.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @PostMapping("/admin/users")
    public ResponseEntity<User> addProfile(@RequestBody User usr) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.saveUser(usr));
    }
}
