package com.server.repository;

import com.server.entity.SubmittedApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<SubmittedApplications, Long> {}
