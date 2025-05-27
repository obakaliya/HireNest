package com.server.entitiy;

import jakarta.persistence.*;

@Entity
@Table(name = "submitted_applications")
public class SubmittedApplications {
  @Id @GeneratedValue private Integer id;

  @ManyToOne
  @JoinColumn(name = "job_posting_id", nullable = false)
  private JobPosting jobPosting;

  @ManyToOne
  @JoinColumn(name = "applicant_id", nullable = false)
  private User applicant;
}
