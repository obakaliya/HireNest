package com.server.service.impl;

import com.server.dto.requests.NewJobPostRequest;
import com.server.dto.responses.JobPostingResponse;
import com.server.dto.responses.NewJobPostResponse;
import com.server.entity.JobPosting;
import com.server.entity.User;
import com.server.exception.ResourceNotFoundException;
import com.server.repository.JobPostingRepository;
import com.server.service.JobPostingService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobPostingServiceImpl implements JobPostingService {
  private final JobPostingRepository jobPostingRepository;

  @Override
  public List<JobPostingResponse> getJobPostings() {
    return jobPostingRepository.findAll().stream()
        .map(posting -> JobPostingResponse.toJobPosting(posting))
        .collect(Collectors.toList());
  }

  @Override
  public JobPostingResponse getJobPosting(Integer jobPostingId) {
    JobPosting jobPosting =
        jobPostingRepository
            .findById(jobPostingId)
            .orElseThrow(() -> new ResourceNotFoundException("Job posting not found"));

    return JobPostingResponse.toJobPosting(jobPosting);
  }

  @Override
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

  @Override
  public JobPostingResponse updateJobPosting(
      Integer jobPostingId, NewJobPostRequest updatedJobPosting) {
    JobPosting jobPosting =
        jobPostingRepository
            .findById(jobPostingId)
            .orElseThrow(() -> new ResourceNotFoundException("Job posting not found"));

    jobPosting.setTitle(updatedJobPosting.getTitle());
    jobPosting.setDescription(updatedJobPosting.getDescription());
    JobPosting updatedPosting = jobPostingRepository.save(jobPosting);

    return JobPostingResponse.toJobPosting(updatedPosting);
  }

  @Override
  public void deleteJobPosting(Integer id) {
    JobPosting jobPosting =
        jobPostingRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Job posting not found"));

    jobPostingRepository.delete(jobPosting);
  }
}
