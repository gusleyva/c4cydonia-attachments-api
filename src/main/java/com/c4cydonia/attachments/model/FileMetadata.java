package com.c4cydonia.attachments.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document
public class FileMetadata {
    @Id
    private String id;
    private String fileId;
    private String fileName;
    private Long fileSize;
    private String contentType;
    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant modifiedDate;
    private String createdBy;
    private String text;
    private String title;
    private String fileUrl;
    private OwnershipDetails ownershipDetails;
}
