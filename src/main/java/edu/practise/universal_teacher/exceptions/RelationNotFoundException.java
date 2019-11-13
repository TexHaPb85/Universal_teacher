package edu.practise.universal_teacher.exceptions;

public class RelationNotFoundException extends RuntimeException {
    public RelationNotFoundException(String id) {
        super("Profile with id: " + id + " not found");
    }
}
