## HireNest 
TODO:

### Database Tables

* **Users**

  * Each user is associated with a specific role.

* **Roles**

  * `Superuser`
  * `Recruiter`
  * `Job Seeker`

* **Role Permissions**

  * **Superuser**: Full access to all actions within the application.
  * **Recruiter**: Can post jobs, edit their job postings, view submitted applications, and delete their own postings.
  * **Job Seeker**: Can view job postings, apply for jobs, and withdraw applications.

* **Job Postings**

  * Stores details of jobs posted by recruiters.

* **Submitted Applications**

  * Records of job applications submitted by job seekers.

* **Saved Applications** *(optional feature)*

  * Stores applications bookmarked by job seekers for later review.

---

### Formatter

To format the backend codebase, run:

```bash
mvn spotless:apply
```
