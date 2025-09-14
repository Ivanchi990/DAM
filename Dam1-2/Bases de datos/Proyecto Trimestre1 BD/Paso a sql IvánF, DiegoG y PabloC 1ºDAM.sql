CREATE TABLE disciplina
( 
id_nombre varchar(20) NOT NULL,
PRIMARY KEY (id_nombre),
num_jugadores int default 0
);

CREATE TABLE torneo(
nombre varchar(20),
PRIMARY KEY(nombre), 
FOREIGN KEY (nombre) REFERENCES disciplina(id_nombre),
fecha_inicio date default "2021-01-01" not null,
duracion int,
FOREIGN KEY (nombre) REFERENCES estadio(nombre),
FOREIGN KEY (nombre) REFERENCES equipo(nombre)
);

create table juega(
juega_partido int,
PRIMARY KEY (juega_partido),
FOREIGN KEY (juega_partido) REFERENCES equipo(nombre),
FOREIGN KEY (juega_partido) REFERENCES torneo(nombre),
FOREIGN KEY (juega_partido) REFERENCES estadio(nombre),
faltas int zerofill,
goles int default 0,
fueras_de_juego int default 0,
penaltis int default 0
);

CREATE TABLE estadio(
nombre varchar(20) not null,
PRIMARY KEY(nombre),
FOREIGN KEY (nombre) REFERENCES torneo(nombre),
FOREIGN KEY (nombre) REFERENCES equipo(nombre),
fecha_construccion date,
aforo int NOT NULL
);

CREATE TABLE equipo(
nombre varchar(20) unique,
fecha_creacion date NOT NULL unique,
PRIMARY KEY (nombre, fecha_creacion),
FOREIGN KEY (nombre) REFERENCES estadio(nombre),
FOREIGN KEY (nombre) REFERENCES torneo(nombre)
);

CREATE TABLE equipo_rival(
nombre varchar(20),
fecha_creacion date NOT NULL,
PRIMARY KEY (nombre, fecha_creacion),
FOREIGN KEY (nombre) REFERENCES equipo(nombre),
FOREIGN KEY (fecha_creacion) REFERENCES equipo(fecha_creacion)
);

CREATE TABLE aficionado(
dni varchar(9),
PRIMARY KEY (dni),
FOREIGN KEY (dni) REFERENCES equipo(nombre) ON DELETE CASCADE,
edad int,
numero_aficionado int
);

CREATE TABLE jugador(
nombre varchar(20),
edad int,
dni varchar(20),
PRIMARY KEY (dni),
FOREIGN KEY (dni) REFERENCES entrenador(dni),
FOREIGN KEY (dni) REFERENCES equipo(nombre)
);

CREATE TABLE entrenador(
dni varchar(9),
PRIMARY KEY (dni),
edad int,
nombre varchar(20),
numero_entrenador int
);