package edu.practise.universal_teacher.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MessageNotFoundException extends RuntimeException{
    public MessageNotFoundException(String id) {
        super("Profile with id: " + id + " not found");
    }
}
