package com.sample.api.exception;

public class TeacherNotFoundException extends RuntimeException { 

    public TeacherNotFoundException(Long id) {
        super("The teacher id '" + id + "' does not exist in our records");
    }
    
}
