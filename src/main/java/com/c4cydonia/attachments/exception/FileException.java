package com.c4cydonia.attachments.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileException extends RuntimeException {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String errorMessage;

    public FileException(HttpStatus status, String errorMessage) {
        super(errorMessage);
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
