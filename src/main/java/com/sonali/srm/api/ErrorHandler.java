package com.sonali.srm.api;

import com.sonali.srm.exception.ApplicationError;
import com.sonali.srm.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Value("${api_doc_url}")
    private String details;

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApplicationError> handleStudentNotFoundException(StudentNotFoundException exception, WebRequest webRequest) {
        ApplicationError error = new ApplicationError();
        error.setCode(101);
        error.setMessage(exception.getMessage());
        error.setDetails(details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}