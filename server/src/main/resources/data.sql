-- -- DROP TABLES
-- DROP TABLE IF EXISTS users CASCADE;
-- DROP TABLE IF EXISTS roles_permissions CASCADE;
-- DROP TABLE IF EXISTS roles CASCADE;
-- DROP TABLE IF EXISTS permissions CASCADE;

-- INSERT ROLES
INSERT INTO roles VALUES (1, 'Superuser'), (2, 'Recruiter'), (3, 'Job Seeker');

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
  (1, (SELECT id FROM roles WHERE name='Superuser'), (SELECT id FROM permissions WHERE name='READ:JOB_POSTING')),
  (2, (SELECT id FROM roles WHERE name='Superuser'), (SELECT id FROM permissions WHERE name='CREATE:JOB_POSTING')),
  (3, (SELECT id FROM roles WHERE name='Superuser'), (SELECT id FROM permissions WHERE name='UPDATE:JOB_POSTING')),
  (4, (SELECT id FROM roles WHERE name='Superuser'), (SELECT id FROM permissions WHERE name='DELETE:JOB_POSTING')),
  (5, (SELECT id FROM roles WHERE name='Superuser'), (SELECT id FROM permissions WHERE name='APPLY:APPLICATION')),

  -- Recruiter permissions 
  (6, (SELECT id FROM roles WHERE name='Recruiter'), (SELECT id FROM permissions WHERE name='READ:JOB_POSTING')),
  (7, (SELECT id FROM roles WHERE name='Recruiter'), (SELECT id FROM permissions WHERE name='CREATE:JOB_POSTING')),
  (8, (SELECT id FROM roles WHERE name='Recruiter'), (SELECT id FROM permissions WHERE name='UPDATE:JOB_POSTING')),
  (9, (SELECT id FROM roles WHERE name='Recruiter'), (SELECT id FROM permissions WHERE name='DELETE:JOB_POSTING')),
  (10, (SELECT id FROM roles WHERE name='Recruiter'), (SELECT id FROM permissions WHERE name='READ:APPLICATION')),

  -- Job seeker permissions
  (11, (SELECT id FROM roles WHERE name='Job Seeker'), (SELECT id FROM permissions WHERE name='READ:JOB_POSTING')),
  (12, (SELECT id FROM roles WHERE name='Job Seeker'), (SELECT id FROM permissions WHERE name='APPLY:APPLICATION'));
