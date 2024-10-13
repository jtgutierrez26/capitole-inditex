package com.capitole.inditex.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProjectExceptionHandler {

    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<String> handleStudentDeleteException(ProjectException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
