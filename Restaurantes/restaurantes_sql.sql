CREATE DATABASE restaurante;

USE restaurante;


CREATE TABLE usuario (
    id       INT          AUTO_INCREMENT PRIMARY KEY,
    nome     VARCHAR(100) NOT NULL,
    usuario  VARCHAR(50)  NOT NULL UNIQUE,
    senha    VARCHAR(32)  NOT NULL
);

ALTER TABLE usuario
MODIFY senha VARCHAR(100);

Drop table usuario ; 

Select * FRom usuario;

Describe usuario;

 insert into usuario (nome, login, senha)
 values ('RAfael','rafa',123456);