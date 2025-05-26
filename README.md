## Backend of HireNest

* **Database Tables**:

    * **Users**
        * Each user should have an associated role.
      
    * **Roles**
        * `Superuser`
        * `Recruiter`
        * `Job Seeker`
      
    * **Role Permissions**
        * **Superuser**: Can perform all actions within the application.
        * **Recruiter**: Can post jobs, edit job postings, view submitted applications, and delete their own postings.
        * **Job Seeker**: Can view job postings, apply for jobs, and withdraw their applications.
  
    * **Job Postings**
        * Stores records of jobs posted by recruiters.

    * **Submitted Applications**
        * Stores records of applications submitted by job seekers.
  
    * **Extra Features (optional)**
      * **Saved Applications**
          * Stores records of applications saved by job seekers.

---
