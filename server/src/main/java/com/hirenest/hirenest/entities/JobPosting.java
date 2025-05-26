package com.hirenest.hirenest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "job_postings")
public class JobPosting {
    @Id
    @GeneratedValue
    Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "posted_by", nullable = false)
    private User postedBy;
}
