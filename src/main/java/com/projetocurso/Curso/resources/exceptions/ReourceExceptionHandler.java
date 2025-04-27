package com.projetocurso.Curso.resources.exceptions;

import com.projetocurso.Curso.services.exceptions.DataBaseException;
import com.projetocurso.Curso.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.crypto.Data;
import java.time.Instant;

@ControllerAdvice
public class ReourceExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
     String error = "Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error1 = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error1);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> database (DataBaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error1 = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error1);
    }
}
