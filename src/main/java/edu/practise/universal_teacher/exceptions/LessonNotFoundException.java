package edu.practise.universal_teacher.exceptions;

public class LessonNotFoundException extends RuntimeException{
    public LessonNotFoundException(String id) {
        super("Lesson with id: " + id + " not found");
    }
}
