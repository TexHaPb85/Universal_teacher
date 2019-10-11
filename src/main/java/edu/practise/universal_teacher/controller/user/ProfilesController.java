package edu.practise.universal_teacher.controller.user;

import edu.practise.universal_teacher.entities.User;
import edu.practise.universal_teacher.entities.UsrProfile;
import edu.practise.universal_teacher.services.usr.UserServiceImpl;
import edu.practise.universal_teacher.services.usr.UsrProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfilesController {
    private final UsrProfileServiceImpl profileService;


    @Autowired
    public ProfilesController(UsrProfileServiceImpl profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/admin/profiles")
    public ResponseEntity<List<UsrProfile>> getAllProfiles(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(profileService.getAllProfiles());
    }

    @GetMapping("/admin/profiles/{id}")
    public ResponseEntity<UsrProfile> getProfileById(@PathVariable("id")Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(profileService.getProfileById(id));
    }

    @PostMapping("/admin/profiles/add")
    public ResponseEntity<UsrProfile> addProfile(@RequestBody UsrProfile usrProfile){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(profileService.saveProfile(usrProfile));
    }

    @DeleteMapping("/admin/profiles/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable("id")Long id){
        profileService.deleteProfileById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("profile was removed, id:"+ id);
    }
}
