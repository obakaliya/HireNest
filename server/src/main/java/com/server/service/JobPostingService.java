package com.server.service;

import com.server.dto.requests.NewJobPostRequest;
import com.server.dto.responses.JobPostingResponse;
import com.server.dto.responses.NewJobPostResponse;
import java.util.List;

public interface JobPostingService {

  List<JobPostingResponse> getJobPostings();

  JobPostingResponse getJobPosting(Integer jobPostingId);

  NewJobPostResponse createNewJobPosting(NewJobPostRequest newJobPostRequest);

  JobPostingResponse updateJobPosting(Integer jobPostingId, NewJobPostRequest updatedJobPosting);

  void deleteJobPosting(Integer id);
}
