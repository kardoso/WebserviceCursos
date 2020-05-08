create database db_cursos;

alter schema `db_cursos` default character set utf8  default collate utf8_general_ci;

use db_cursos;

create table curso
(
	id int not null auto_increment,
	nome varchar(45) not null,
	descricao varchar(120) not null default "",
	preco float not null,
	codigo varchar(10) not null,
	duracao int not null,
	avaliacao int not null default 0,
	key(id)
)
engine = innodb
default charset = utf8;

insert into curso
	(nome, descricao, preco, codigo, duracao)
values
	("Backend com Java", "Crie uma aplicação real utilizando JAVA e aprenda na prática.", 59.99, "C-JAV1", 120),
	("Google APIS", "Aprenda a utilizar APIs", 29.99, "C-GOA1", 40),
	("Introdução ao Angular 9", "Aprenda Angular 9", 39.99, "C-ANG1", 132)