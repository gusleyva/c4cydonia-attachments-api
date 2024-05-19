
package com.c4cydonia.attachments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<FileException> handleSecurityException(SecurityException ex) {
        return new ResponseEntity<>(new FileException(HttpStatus.FORBIDDEN, ex.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<FileException> handleNotFoundException(RuntimeException ex) {
        return new ResponseEntity<>(new FileException(HttpStatus.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FileException> handleGlobalException(Exception ex) {
        return new ResponseEntity<>(new FileException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FileException> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String message = "Validation error on fields: " + ex.getBindingResult().getFieldErrors();
        return new ResponseEntity<>(new FileException(HttpStatus.BAD_REQUEST, message), HttpStatus.BAD_REQUEST);
    }
}
