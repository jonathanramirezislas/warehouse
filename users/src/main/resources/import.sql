INSERT INTO `user` (username, password, enabled, nombre, apellido, email) VALUES ('Jonas','this_passwrod_will_be_encrypt',1, 'Jonathan', 'Ramirez','jona@warehouse.com');
INSERT INTO `user` (username, password, enabled, nombre, apellido, email) VALUES ('adminjonhh','this_passwrod_will_be_encrypt',1, 'John', 'Ramirez','jhon.ram@warehouse.com');

INSERT INTO `role` (nombre) VALUES ('ROLE_USER');
INSERT INTO `role` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 1);
