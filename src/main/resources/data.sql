DROP table IF EXISTS salas cascade;
DROP table IF EXISTS peliculas cascade;

create table peliculas(
    id int auto_increment,
    nombre varchar(100),
    calificacionEdad int,
	PRIMARY KEY (id)
);

create table salas(
    id int auto_increment,
    nombre varchar(100),
    pelicula int,
	PRIMARY KEY (id),
	CONSTRAINT pelicula_fk FOREIGN KEY (pelicula) REFERENCES peliculas (id)
);

insert into peliculas (nombre,calificacionEdad)values('Avatar',13);
insert into peliculas (nombre,calificacionEdad)values('Titanic',7);
insert into peliculas (nombre,calificacionEdad)values('Spiderman',18);
insert into salas (nombre,pelicula)values('A1',1);
insert into salas (nombre,pelicula)values('B1',2);
insert into salas (nombre,pelicula)values('B2',3);