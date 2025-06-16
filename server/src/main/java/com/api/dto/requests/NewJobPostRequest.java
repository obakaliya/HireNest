package com.api.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewJobPostRequest {
  @NotBlank private String title;
  @NotBlank private String description;
}
