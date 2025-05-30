package com.server.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobPostingResponse {
  private Integer id;
  private String title;
  private String description;
  private User postedBy;

  @Data
  @AllArgsConstructor
  public static class User {
    private String firstName;
    private String lastName;
    private String email;
  }
}
