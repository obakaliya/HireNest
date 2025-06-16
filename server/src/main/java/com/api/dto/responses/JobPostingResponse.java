package com.api.dto.responses;

import com.api.entity.JobPosting;
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

  public static JobPostingResponse toJobPosting(JobPosting jobPosting) {
    return new JobPostingResponse(
        jobPosting.getId(),
        jobPosting.getTitle(),
        jobPosting.getDescription(),
        new JobPostingResponse.User(
            jobPosting.getPostedBy().getFirstName(),
            jobPosting.getPostedBy().getLastName(),
            jobPosting.getPostedBy().getEmail()));
  }
}
