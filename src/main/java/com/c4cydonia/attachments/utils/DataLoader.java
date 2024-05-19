package com.c4cydonia.attachments.utils;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.c4cydonia.attachments.model.FileMetadata;
import com.c4cydonia.attachments.model.OwnershipDetails;
import com.c4cydonia.attachments.repository.FileMetadataRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(FileMetadataRepository fileRepository) {
        return args -> {
            OwnershipDetails ownershipDetails = OwnershipDetails.builder()
                    .owners(Set.of("example@example.com"))
                    .receivers(Set.of("other@example.com"))
                    .addedBy("creator@example.com")
                    .build();
            FileMetadata fileMetadata = FileMetadata.builder()
                    .fileId("123456")
                    .fileName("example.pdf")
                    .fileSize(123456L)
                    .contentType("application/pdf")
                    .createdBy("creator@example.com")
                    .text("Sample text")
                    .title("Sample Title")
                    .fileUrl("files/example.pdf")
                    .ownershipDetails(ownershipDetails)
                    .build();
            fileRepository.save(fileMetadata);
        };
    }
}
