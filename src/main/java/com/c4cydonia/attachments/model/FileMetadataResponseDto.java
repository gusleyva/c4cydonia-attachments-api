package com.c4cydonia.attachments.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileMetadataResponseDto {
    private String fileId;
    private String fileName;
    private Long fileSize;
    private String contentType;
    private Instant createdDate;
    private Instant modifiedDate;
    private String createdBy;
    private String text;
    private String title;
    private OwnershipDetails ownershipDetails;
}
