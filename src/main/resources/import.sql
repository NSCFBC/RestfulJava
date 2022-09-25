INSERT INTO usuario(id, email, nome, senha) VALUES (1, 'admin@gmail.com', 'bruna', 'adminAdmin');
INSERT INTO usuario(id, email, nome, senha) VALUES (2, 'generator@generator', 'joao', 'joaoadin');
INSERT INTO usuario(id, email, nome, senha) VALUES (3, 'Luana@Gmail.com', 'Luana', 'ajhdsakhanjksa');
INSERT INTO usuario(id, email, nome, senha) VALUES (4, 'Maria@gmail.com', 'Maria', 'ddsnuisfdm');
INSERT INTO usuario(id, email, nome, senha) VALUES (5, 'Fabricio@gmail.com', 'Fabricio', '1233213');
INSERT INTO usuario(id, email, nome, senha) VALUES (6, 'Luiza@gmail.com', 'Luiza', 'da231das');
INSERT INTO usuario(id, email, nome, senha) VALUES (7, 'Marcos@gmail.com', 'Marcos', '232dasew');
INSERT INTO usuario(id, email, nome, senha) VALUES (8, 'admin@gmail.com', 'admin', '$2a$10$Qvt9h4nSifz9Tu8N.wiR.OHUrdU3BXXVoMWCdETKTQQK0S6LZMrJOW');

INSERT INTO role(id, role) VALUES (1,'ROLE_OPERATOR');
INSERT INTO role(id, role)VALUES (2,'ROLE_ADMIN');
INSERT INTO role(id, role)VALUES (3,'ROLE_SECRETARIO');
INSERT INTO role(id, role)VALUES (4,'ROLE_OTHER');

INSERT INTO users_role(user_id, role_id) VALUES (1, 1);
INSERT INTO users_role(user_id, role_id) VALUES (2, 1);
INSERT INTO users_role(user_id, role_id) VALUES (2, 2);