package com.c4cydonia.attachments.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.c4cydonia.attachments.model.FileMetadata;

@Repository
public interface FileMetadataRepository extends MongoRepository<FileMetadata, String> {
    List<FileMetadata> findByCreatedBy(String createdBy);

    Optional<FileMetadata> findByFileName(String fileName);
}
