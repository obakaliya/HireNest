package com.server.dto.requests;

import lombok.Data;

@Data
public class NewJobPostRequest {
  private String title;
  private String description;
}
