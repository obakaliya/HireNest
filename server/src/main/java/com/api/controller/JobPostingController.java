package com.api.controller;

import com.api.dto.requests.NewJobPostRequest;
import com.api.dto.responses.JobPostingResponse;
import com.api.dto.responses.NewJobPostResponse;
import com.api.service.JobPostingService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/jobPosting")
public class JobPostingController {
  private final JobPostingService jobPostingService;

  @GetMapping
  @PreAuthorize("hasAuthority('READ:JOB_POSTING')")
  public ResponseEntity<List<JobPostingResponse>> getJobPostings() {
    return ResponseEntity.ok(jobPostingService.getJobPostings());
  }

  @PreAuthorize("hasAuthority('READ:JOB_POSTING')")
  @GetMapping("/{id}")
  public ResponseEntity<JobPostingResponse> getJobPosting(@PathVariable Integer id) {
    return ResponseEntity.ok(jobPostingService.getJobPosting(id));
  }

  @PreAuthorize("hasAuthority('CREATE:JOB_POSTING')")
  @PostMapping
  public ResponseEntity<NewJobPostResponse> createNewJobPosting(
      @Valid @RequestBody NewJobPostRequest newJobPostRequest) {
    return ResponseEntity.ok(jobPostingService.createNewJobPosting(newJobPostRequest));
  }

  @PreAuthorize("hasAuthority('UPDATE:JOB_POSTING')")
  @PutMapping("/{id}")
  public ResponseEntity<JobPostingResponse> updateJobPosting(
      @PathVariable Integer id, @Valid @RequestBody NewJobPostRequest updatedJobPosting) {
    return ResponseEntity.ok(jobPostingService.updateJobPosting(id, updatedJobPosting));
  }

  @PreAuthorize("hasAuthority('DELETE:JOB_POSTING')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteJobPosting(@PathVariable Integer id) {
    jobPostingService.deleteJobPosting(id);
    return ResponseEntity.noContent().build();
  }
}
