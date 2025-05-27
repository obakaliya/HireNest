-- -- DROP TABLES
-- DROP TABLE IF EXISTS users CASCADE;
-- DROP TABLE IF EXISTS roles_permissions CASCADE;
-- DROP TABLE IF EXISTS roles CASCADE;
-- DROP TABLE IF EXISTS permissions CASCADE;

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
