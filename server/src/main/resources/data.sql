-- DROP TABLES
-- DROP TABLE IF EXISTS users CASCADE;
-- DROP TABLE IF EXISTS roles_permissions CASCADE;
-- DROP TABLE IF EXISTS roles CASCADE;
-- DROP TABLE IF EXISTS permissions CASCADE;
-- DROP TABLE IF EXISTS user_roles CASCADE;
-- DROP TABLE IF EXISTS submitted_applications CASCADE;
-- DROP TABLE IF EXISTS job_postings CASCADE;

-- INSERT ROLES
INSERT INTO roles VALUES (1, 'SUPERUSER'), (2, 'RECRUITER'), (3, 'JOB_SEEKER');

-- INSERT PERMISSIONS
INSERT INTO permissions VALUES 
	(1, 'READ:JOB_POSTING'), 
	(2, 'CREATE:JOB_POSTING'), 
	(3, 'UPDATE:JOB_POSTING'), 
	(4, 'DELETE:JOB_POSTING'),
	(5, 'APPLY:APPLICATION'),
	(6, 'READ:APPLICATION');


-- INSERT ROLE_PERMISSIONS
INSERT INTO roles_permissions (id, role_id, permission_id) VALUES
  -- Superuser permissions
  (1, (SELECT id FROM roles WHERE name='SUPERUSER'), (SELECT id FROM permissions WHERE name='READ:JOB_POSTING')),
  (2, (SELECT id FROM roles WHERE name='SUPERUSER'), (SELECT id FROM permissions WHERE name='CREATE:JOB_POSTING')),
  (3, (SELECT id FROM roles WHERE name='SUPERUSER'), (SELECT id FROM permissions WHERE name='UPDATE:JOB_POSTING')),
  (4, (SELECT id FROM roles WHERE name='SUPERUSER'), (SELECT id FROM permissions WHERE name='DELETE:JOB_POSTING')),
  (5, (SELECT id FROM roles WHERE name='SUPERUSER'), (SELECT id FROM permissions WHERE name='APPLY:APPLICATION')),

  -- Recruiter permissions 
  (6, (SELECT id FROM roles WHERE name='RECRUITER'), (SELECT id FROM permissions WHERE name='READ:JOB_POSTING')),
  (7, (SELECT id FROM roles WHERE name='RECRUITER'), (SELECT id FROM permissions WHERE name='CREATE:JOB_POSTING')),
  (8, (SELECT id FROM roles WHERE name='RECRUITER'), (SELECT id FROM permissions WHERE name='UPDATE:JOB_POSTING')),
  (9, (SELECT id FROM roles WHERE name='RECRUITER'), (SELECT id FROM permissions WHERE name='DELETE:JOB_POSTING')),
  (10, (SELECT id FROM roles WHERE name='RECRUITER'), (SELECT id FROM permissions WHERE name='READ:APPLICATION')),

  -- Job seeker permissions
  (11, (SELECT id FROM roles WHERE name='JOB_SEEKER'), (SELECT id FROM permissions WHERE name='READ:JOB_POSTING')),
  (12, (SELECT id FROM roles WHERE name='JOB_SEEKER'), (SELECT id FROM permissions WHERE name='APPLY:APPLICATION'));

-- DUMY USERS (for all the users the password is 'password')
INSERT INTO users(id, email, first_name, last_name, password) 
VALUES 
	(1, 'supu@gmail.com', 'Super', 'User', '$2b$10$NhhAOyc8k0Mv4dxrovVYF.9CNARtxSGwEzPjLqMrmCUKvcjJ2onxK'),
	(2, 'recu@gmail.com', 'Recruiter', 'User', '$2b$10$rRIj2n0e6FDBoIkhDQ1uOO3ykUe5ZWmjKsmTBa4jiVg3ERcP1j542'), 
	(3, 'jobsu@gmail.com', 'JobSeeker', 'User', '$2b$10$Qvz5NyGi.aQLc3R2vTTYvelI4EWhz38t9SBmD9vWtQ3E2YbBzE092');

INSERT INTO user_roles(user_id, role_id)
VALUES 
	(1, 1),
	(2, 2),
	(3, 3);
	