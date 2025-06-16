package com.api.service;

import com.api.dto.requests.NewJobPostRequest;
import com.api.dto.responses.JobPostingResponse;
import com.api.dto.responses.NewJobPostResponse;
import java.util.List;

public interface JobPostingService {

  List<JobPostingResponse> getJobPostings();

  JobPostingResponse getJobPosting(Integer jobPostingId);

  NewJobPostResponse createNewJobPosting(NewJobPostRequest newJobPostRequest);

  JobPostingResponse updateJobPosting(Integer jobPostingId, NewJobPostRequest updatedJobPosting);

  void deleteJobPosting(Integer id);
}
