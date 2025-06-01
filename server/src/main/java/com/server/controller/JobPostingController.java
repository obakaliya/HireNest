package com.server.controller;

import com.server.dto.requests.NewJobPostRequest;
import com.server.dto.responses.JobPostingResponse;
import com.server.dto.responses.NewJobPostResponse;
import com.server.service.JobPostingService;
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

  @GetMapping("/{id}")
  @PreAuthorize("hasAuthority('READ:JOB_POSTING')")
  public ResponseEntity<JobPostingResponse> getJobPosting(@PathVariable Integer id) {
    return ResponseEntity.ok(jobPostingService.getJobPosting(id));
  }

  @PostMapping
  @PreAuthorize("hasAuthority('CREATE:JOB_POSTING')")
  public ResponseEntity<NewJobPostResponse> createNewJobPosting(
      @Valid @RequestBody NewJobPostRequest newJobPostRequest) {
    return ResponseEntity.ok(jobPostingService.createNewJobPosting(newJobPostRequest));
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasAuthority('UPDATE:JOB_POSTING')")
  public ResponseEntity<JobPostingResponse> updateJobPosting(
      @PathVariable Integer id, @Valid @RequestBody NewJobPostRequest updatedJobPosting) {
    return ResponseEntity.ok(jobPostingService.updateJobPosting(id, updatedJobPosting));
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAuthority('DELETE:JOB_POSTING')")
  public ResponseEntity<?> deleteJobPosting(@PathVariable Integer id) {
    jobPostingService.deleteJobPosting(id);
    return ResponseEntity.noContent().build();
  }
}
