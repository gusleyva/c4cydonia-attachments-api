package com.c4cydonia.attachments.controller;

import com.c4cydonia.attachments.exception.FileException;
import com.c4cydonia.attachments.model.FileMetadata;
import com.c4cydonia.attachments.model.FileMetadataRequestDto;
import com.c4cydonia.attachments.model.FileMetadataResponseDto;
import com.c4cydonia.attachments.model.FileUploadRequest;
import com.c4cydonia.attachments.service.IFileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private IFileService fileService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public FileMetadataResponseDto uploadFile(
            @RequestPart("file") MultipartFile file,
            @RequestPart("metadata") @Valid FileMetadataRequestDto metadataDto,
            HttpServletRequest request) {
        String createdBy = (String) request.getAttribute("email");

        var fileMetadataResponse = fileService.uploadFile(file, createdBy, metadataDto);
        return fileMetadataResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{fileId}")
    public FileMetadataResponseDto retrieveFileMetadata(@PathVariable String fileId,
                                                                        HttpServletRequest request) {
        String requesterEmail = (String) request.getAttribute("email"); // Extracts the user's email from the request
        FileMetadataResponseDto fileMetadataResponse = fileService.retrieveFileMetadata(fileId, requesterEmail);
        return fileMetadataResponse;
    }

    @PatchMapping("/{fileId}")
    public ResponseEntity<FileMetadataResponseDto> updateFileMetadata(@PathVariable String fileId,
                                                                      @RequestBody @Valid FileMetadataRequestDto updates,
                                                                      HttpServletRequest request) {
        String requesterEmail = (String) request.getAttribute("email"); // Validation could be added here as needed
        FileMetadataResponseDto updatedMetadata = fileService.updateFileMetadata(fileId, updates, requesterEmail);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedMetadata);
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<Void> deleteFile(@PathVariable String fileId, HttpServletRequest request) {
        String requesterEmail = (String) request.getAttribute("email"); // Use this email to check if user can delete
        fileService.deleteFile(fileId, requesterEmail);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
