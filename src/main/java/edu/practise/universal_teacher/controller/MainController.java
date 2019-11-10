package edu.practise.universal_teacher.controller;

import edu.practise.universal_teacher.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/", produces = {"application/json"})
public class MainController {

    @GetMapping("/")
    public HashMap<String, Object> main(@AuthenticationPrincipal User user) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("profile", user);

        return data;
    }


    @GetMapping("/home")
    public ResponseEntity<Object> home(@AuthenticationPrincipal User user) {
        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(auth);
    }
}
