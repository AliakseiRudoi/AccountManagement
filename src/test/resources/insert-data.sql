INSERT INTO USERS VALUES (1, 'user1', 'user1', 'user1', 'user1@user.com');
INSERT INTO USERS VALUES (2, 'user2', 'user2', 'user2', 'user2@user.com');
INSERT INTO USERS VALUES (3, 'user3', 'user3', 'user3', 'user3@user.com');
INSERT INTO USERS VALUES (4, 'user4', 'user4', 'user4', 'user4@user.com');

INSERT INTO PERMISSIONS VALUES (1, 'createRole');
INSERT INTO PERMISSIONS VALUES (2, 'readRole');
INSERT INTO PERMISSIONS VALUES (3, 'updateRole');
INSERT INTO PERMISSIONS VALUES (4, 'deleteRole');

INSERT INTO PERMISSION_GROUPS VALUES (1, 'permGroup-admin');
INSERT INTO PERMISSION_GROUPS VALUES (2, 'permGroup-role-manager');
INSERT INTO PERMISSION_GROUPS VALUES (3, 'permGroup-content-manage');

INSERT INTO CONTENT VALUES (1, 'mkyong', 'mkyong');
INSERT INTO CONTENT VALUES (2, 'alex', 'alex');
INSERT INTO CONTENT VALUES (3, 'joel', 'joel');

INSERT INTO ROLES VALUES (1, 'admin');
INSERT INTO ROLES VALUES (2, 'role-manager');
INSERT INTO ROLES VALUES (3, 'content-manager');

INSERT INTO PERMISSIONS_PERMISSION_GROUPS VALUES (1, 1);
INSERT INTO PERMISSIONS_PERMISSION_GROUPS VALUES (2, 1);
INSERT INTO PERMISSIONS_PERMISSION_GROUPS VALUES (3, 1);
INSERT INTO PERMISSIONS_PERMISSION_GROUPS VALUES (1, 2);

INSERT INTO ROLES_PERMISSION_GROUPS VALUES (1, 1);
INSERT INTO ROLES_PERMISSION_GROUPS VALUES (1, 2);
INSERT INTO ROLES_PERMISSION_GROUPS VALUES (2, 1);
INSERT INTO ROLES_PERMISSION_GROUPS VALUES (2, 2);

INSERT INTO USERS_ROLES VALUES (1, 1);
INSERT INTO USERS_ROLES VALUES (1, 2);
INSERT INTO USERS_ROLES VALUES (2, 1);
INSERT INTO USERS_ROLES VALUES (2, 2);

INSERT INTO USERS_PERMISSIONS VALUES (1, 1);
INSERT INTO USERS_PERMISSIONS VALUES (1, 2);
INSERT INTO USERS_PERMISSIONS VALUES (2, 1);
INSERT INTO USERS_PERMISSIONS VALUES (2, 2);


