package com.c4cydonia.attachments.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileMetadataRequestDto {
    @NotBlank(message = "Filename is mandatory.")
    private String filename;
    private String text;
    private String title;

    @Valid
    private OwnershipRequestDto ownershipDetails;
}
