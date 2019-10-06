package edu.practise.universal_teacher.exceptions;

public class ProfileNotFoundException  extends RuntimeException{
    public ProfileNotFoundException(Long id) {
        super("Profile with id: "+id+" not found");
    }
}
