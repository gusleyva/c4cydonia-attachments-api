package com.c4cydonia.attachments.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.c4cydonia.attachments.model.FileMetadata;
import com.c4cydonia.attachments.model.FileMetadataRequestDto;
import com.c4cydonia.attachments.model.FileMetadataResponseDto;
import com.c4cydonia.attachments.service.IFileService;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private IFileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileMetadataResponseDto> uploadFile(@RequestParam("file") MultipartFile file,
                                                              @Valid @RequestBody FileMetadataRequestDto fileMetadataDto,
                                                              HttpServletRequest request) {
        String createdBy = (String) request.getAttribute("email");
        var fileMetadataResponse = fileService.uploadFile(file, createdBy, fileMetadataDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fileMetadataResponse);
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<FileMetadataResponseDto> retrieveFileMetadata(@PathVariable String fileId,
                                                                        HttpServletRequest request) {
        String requesterEmail = (String) request.getAttribute("email"); // Extracts the user's email from the request
        FileMetadataResponseDto fileMetadataResponse = fileService.retrieveFileMetadata(fileId, requesterEmail);
        return ResponseEntity.status(HttpStatus.OK).body(fileMetadataResponse);
    }

    @PatchMapping("/{fileId}")
    public ResponseEntity<FileMetadataResponseDto> updateFileMetadata(@PathVariable String fileId,
                                                                      @RequestBody FileMetadata updates,
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
