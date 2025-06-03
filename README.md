## HireNest

HireNest is a recruitment management platform designed to streamline the hiring process for organizations and job seekers. It provides secure user authentication, role-based access, job posting, application management, and resume uploads.

---

## Project Setup

### Prerequisites

- **Java 17** or higher ([download](https://adoptopenjdk.net/))
- **Maven** ([download](https://maven.apache.org/download.cgi))
- **PostgreSQL** (default port: 5432)
- (Recommended) **Lombok plugin** for your IDE ([setup guide](https://projectlombok.org/setup/))

### Backend Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/obakaliya/HireNest.git
   cd HireNest/server
   ```

2. **Configure the database:**
   - Create a PostgreSQL database named `hirenest`:
     ```bash
     createdb -U postgres hirenest
     ```
   - Update credentials in [`server/src/main/resources/application.yml`](server/src/main/resources/application.yml) if needed:
     ```yaml
     spring:
       datasource:
         url: jdbc:postgresql://localhost:5432/hirenest
         username: postgres
         password: password
     ```
   - Ensure your PostgreSQL user has permission to create tables and insert data.

3. **Install dependencies and build the project:**
   ```bash
   mvn install
   ```

4. **Seed the database:**
   - Run the SQL script to create initial roles, permissions, and users:
     ```bash
     psql -U postgres -d hirenest -f src/main/resources/data.sql
     ```
   - Or use a GUI tool like DBeaver or pgAdmin.

5. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
   The backend will start on [http://localhost:8080](http://localhost:8080) by default.

6. **Default Users:**
   - See [`data.sql`](server/src/main/resources/data.sql) for seeded users and their roles.
   - Default password for all users is `password`.

### Formatting

To format the backend codebase, run:

```bash
mvn spotless:apply
```

---

### Notes

- If you change the JWT secret or database credentials, update [`application.yml`](server/src/main/resources/application.yml).
- Ensure port 5432 is available for PostgreSQL, and port 8080 for the Spring Boot server.
- The backend uses Lombok. Install the [Lombok plugin](https://projectlombok.org/setup/) in your IDE for best experience.
- For local file uploads (e.g., resumes), files are stored in a project folder. For production, configure AWS S3 or another storage provider.
- Make sure to review and update environment variables and secrets before deploying to production.

---

## Codebase Review & Recommendations

- **Backend:** Spring Boot (Java 17), Maven, PostgreSQL, Lombok, JWT authentication, role-based access.
- **Database:** Ensure PostgreSQL is running and accessible. The `data.sql` script seeds roles and users.
- **Code Quality:** Uses Spotless for formatting. Consider adding unit/integration tests if not present.
- **File Uploads:** Local storage by default; production should use a cloud provider.
- **Environment:** All sensitive config (DB credentials, JWT secret) should be managed securely (e.g., environment variables or a secrets manager) in production.
- **Frontend:** If present, document its setup in this README.
