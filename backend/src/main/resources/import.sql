INSERT INTO authority (name) VALUES ('ADMIN'), ('MODERATOR'), ('ACCOUNTANT'), ('MANAGER'), ('GUEST');
INSERT INTO scope (name) VALUES ('OWN'), ('BRANCH'), ('ALL');
INSERT INTO privilege (name, scope_id) VALUES ('application.modify', 1), ('application.modify', 2), ('application.modify', 3), ('application.create', 3),('application.delete', 1), ('application.delete', 2), ('application.delete', 3), ('indicative.create', 3),('indicative.modify', 3), ('indicative.remove', 3), ('statistic.view', 1), ('statistic.view', 2),('statistic.view', 3), ('interface.admin', 3), ('interface.manager', 3), ('interface.moderator', 3),('interface.accountant', 3), ('interface.welcome', 3), ('application.view', 1), ('application.view', 2),('application.view', 3);
INSERT INTO role_privilege (role_id, privilege_id) VALUES (1, 3), (1, 4), (1, 3), (1, 8), (1, 9), (1, 10), (1, 11), (1, 12), (1, 13), (1, 14), (1, 15), (1, 16), (1, 17),(1, 18), (1, 21);
INSERT INTO role_privilege (role_id, privilege_id) VALUES (2, 1), (2, 4), (2, 5), (2, 11), (2, 12), (2, 18), (2, 16), (2, 19), (2, 20);
INSERT INTO role_privilege (role_id, privilege_id) VALUES (3, 3), (3, 11), (3, 17), (3, 21);
INSERT INTO role_privilege (role_id, privilege_id) VALUES (4, 11), (4, 12), (4, 13), (4, 15);
INSERT INTO role_privilege (role_id, privilege_id) VALUES (5, 18);
INSERT INTO user_action_type (name) VALUES ('application.accounter.modified'), ('application.accounter.processed'),('application.acoounter.tookInProcessed'), ('application.acoounter.setWarning'), ('application.user.created'),('application.user.modified'), ('application.user.remove');
INSERT INTO delivery_channel (name) VALUES ('Email'), ('Viber'), ('Sender');
INSERT INTO auxiliary_field_type (name) VALUES ('Number'), ('String'), ('List');
INSERT INTO application_status (name)VALUES ('NEW'), ('WAIT_FOR_PROCESS'), ('PROCESSED'), ('DEFFERED'), ('ACCOUNTER_IN_PROCESSING'), ('WAIT_FOR_ADDITION');