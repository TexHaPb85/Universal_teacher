package edu.practise.universal_teacher.controller;

import edu.practise.universal_teacher.entities.UsrProfile;
import edu.practise.universal_teacher.services.usr.UserServiceImpl;
import edu.practise.universal_teacher.services.usr.UsrProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UsrProfileServiceImpl profileService;
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UsrProfileServiceImpl profileService, UserServiceImpl userService) {
        this.profileService = profileService;
        this.userService = userService;
    }

    @GetMapping("/admin/profiles")
    public ResponseEntity getAllProfiles(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(profileService.getAllProfiles());
    }

    @PostMapping("/admin/profiles/add")
    public ResponseEntity<UsrProfile> addProfile(@RequestBody UsrProfile usrProfile){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(profileService.saveProfile(usrProfile));
    }
}
