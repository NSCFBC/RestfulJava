INSERT INTO usuario(id, email, nome, senha) VALUES (1, 'admin@gmail.com', 'admin', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO usuario(id, email, nome, senha) VALUES (2, 'generator@generator', 'joao', 'joaoadin');
INSERT INTO usuario(id, email, nome, senha) VALUES (3, 'Luana@Gmail.com', 'Luana', 'ajhdsakhanjksa');
INSERT INTO usuario(id, email, nome, senha) VALUES (4, 'Maria@gmail.com', 'Maria', 'ddsnuisfdm');
INSERT INTO usuario(id, email, nome, senha) VALUES (5, 'Fabricio@gmail.com', 'Fabricio', '1233213');
INSERT INTO usuario(id, email, nome, senha) VALUES (6, 'Luiza@gmail.com', 'Luiza', 'da231das');
INSERT INTO usuario(id, email, nome, senha) VALUES (7, 'Marcos@gmail.com', 'Marcos', '232dasew');


INSERT INTO categoria(id, nome)VALUES (1, 'Esporte');
INSERT INTO categoria(id, nome)VALUES (2, 'Saude');
INSERT INTO categoria(id, nome)VALUES (3, 'Educacao');
INSERT INTO categoria(id, nome)VALUES (4, 'Lazer');
INSERT INTO categoria(id, nome)VALUES (5, 'Passeio');

INSERT INTO role(id, role) VALUES (1,'ROLE_OPERATOR');
INSERT INTO role(id, role)VALUES (2,'ROLE_ADMIN');
INSERT INTO role(id, role)VALUES (3,'ROLE_SECRETARIO');
INSERT INTO role(id, role)VALUES (4,'ROLE_OTHER');

INSERT INTO users_role(user_id, role_id) VALUES (1, 1);
INSERT INTO users_role(user_id, role_id) VALUES (2, 1);
INSERT INTO users_role(user_id, role_id) VALUES (2, 2);

INSERT INTO noticia(id, conteudo, subtitulo, titulo) VALUES(1, 'Conteudo muito grande 1', 'Tupla 1', 'Titulo tupla 1');
INSERT INTO noticia(id, conteudo, subtitulo, titulo) VALUES(2, 'Conteudo muito grande 2', 'Tupla 2', 'Titulo tupla 2');
INSERT INTO noticia(id, conteudo, subtitulo, titulo) VALUES(3, 'Conteudo muito grande 3', 'Tupla 3', 'Titulo tupla 3');
INSERT INTO noticia(id, conteudo, subtitulo, titulo) VALUES(4, 'Conteudo muito grande 4', 'Tupla 4', 'Titulo tupla 4');
INSERT INTO noticia(id, conteudo, subtitulo, titulo) VALUES(5, 'Conteudo muito grande 5', 'Tupla 5', 'Titulo tupla 5');


