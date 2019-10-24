package edu.practise.universal_teacher.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String id) {
        super("Course with name: " + id + " not found");
    }
}
