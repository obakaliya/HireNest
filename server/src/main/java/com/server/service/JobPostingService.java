package com.server.service;

import com.server.dto.requests.NewJobPostRequest;
import com.server.dto.responses.JobPostingResponse;
import com.server.dto.responses.NewJobPostResponse;
import com.server.entitiy.JobPosting;
import com.server.entitiy.User;
import com.server.exception.ResourceNotFoundException;
import com.server.repository.JobPostingRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobPostingService {
  private final JobPostingRepository jobPostingRepository;

  public NewJobPostResponse createNewJobPosting(NewJobPostRequest newJobPostRequest) {
    User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    JobPosting jobPosting =
        JobPosting.builder()
            .title(newJobPostRequest.getTitle())
            .description(newJobPostRequest.getDescription())
            .postedBy(authUser)
            .build();
    JobPosting savedJobPosting = jobPostingRepository.save(jobPosting);

    return new NewJobPostResponse(savedJobPosting.getId());
  }

  public List<JobPostingResponse> getJobPostings() {
    return jobPostingRepository.findAll().stream()
        .map(
            posting ->
                new JobPostingResponse(
                    posting.getId(),
                    posting.getTitle(),
                    posting.getDescription(),
                    new JobPostingResponse.User(
                        posting.getPostedBy().getFirstName(),
                        posting.getPostedBy().getLastName(),
                        posting.getPostedBy().getEmail())))
        .collect(Collectors.toList());
  }

  public JobPostingResponse getJobPosting(Integer jobPostingId) {
    JobPosting jobPosting =
        jobPostingRepository
            .findById(jobPostingId)
            .orElseThrow(() -> new ResourceNotFoundException("Job posting not found"));

    return new JobPostingResponse(
        jobPosting.getId(),
        jobPosting.getTitle(),
        jobPosting.getDescription(),
        new JobPostingResponse.User(
            jobPosting.getPostedBy().getFirstName(),
            jobPosting.getPostedBy().getLastName(),
            jobPosting.getPostedBy().getEmail()));
  }

  public JobPostingResponse updateJobPosting(
      Integer jobPostingId, NewJobPostRequest updatedJobPosting) {
    JobPosting jobPosting =
        jobPostingRepository
            .findById(jobPostingId)
            .orElseThrow(() -> new ResourceNotFoundException("Job posting not found"));

    jobPosting.setTitle(updatedJobPosting.getTitle());
    jobPosting.setDescription(updatedJobPosting.getDescription());
    JobPosting updatedPosting = jobPostingRepository.save(jobPosting);

    return new JobPostingResponse(
        updatedPosting.getId(),
        updatedPosting.getTitle(),
        updatedPosting.getDescription(),
        new JobPostingResponse.User(
            updatedPosting.getPostedBy().getFirstName(),
            updatedPosting.getPostedBy().getLastName(),
            updatedPosting.getPostedBy().getEmail()));
  }

  public void deleteJobPosting(Integer id) {
    JobPosting jobPosting =
        jobPostingRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Job posting not found"));

    jobPostingRepository.delete(jobPosting);
  }
}
