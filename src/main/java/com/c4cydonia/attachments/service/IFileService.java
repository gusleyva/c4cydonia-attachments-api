package com.c4cydonia.attachments.service;

import org.springframework.web.multipart.MultipartFile;

import com.c4cydonia.attachments.model.FileMetadata;
import com.c4cydonia.attachments.model.FileMetadataRequestDto;
import com.c4cydonia.attachments.model.FileMetadataResponseDto;

public interface IFileService {
    FileMetadataResponseDto uploadFile(MultipartFile file, String createdBy, FileMetadataRequestDto fileMetadataDto);
    FileMetadataResponseDto retrieveFileMetadata(String fileId, String requesterEmail);
    FileMetadataResponseDto updateFileMetadata(String fileId, FileMetadata updates, String requesterEmail);
    void deleteFile(String fileId, String requesterEmail);
}
