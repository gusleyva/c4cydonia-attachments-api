package com.c4cydonia.attachments.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OwnershipDetails {
    private Set<String> owners;
    private Set<String> receivers;
    private String addedBy;
}
