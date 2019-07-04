use docket;

create database docket;
use docket;

create table cartorios(
 id integer not null AUTO_INCREMENT,
 nome varchar(255) not null,
 PRIMARY KEY (id)
);

SELECT * FROM cartorios;
describe cartorios;

INSERT INTO cartorios (nome) VALUES ("Nome1");

