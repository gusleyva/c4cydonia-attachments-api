package com.c4cydonia.attachments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnershipRequestDto {
    @NotEmpty(message = "Owners set must contain at least one owner.")
    private Set<String> owners;

    private Set<String> receivers;
}
