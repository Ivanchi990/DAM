DROP DATABASE IF EXISTS ropaDam;

CREATE DATABASE ropaDam;

USE ropaDam;

CREATE TABLE categoria (
    id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    sexo VARCHAR(10) NOT NULL,
    nombre VARCHAR(255) NOT NULL
);
CREATE TABLE prenda (
    id_prenda INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    id_categoria INT NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE compra (
    id_compra INT PRIMARY KEY AUTO_INCREMENT,
    fecha_compra DATE NOT NULL,
    precio_total DECIMAL(10, 2) NOT NULL,
    usuario VARCHAR(255) NOT NULL
);

CREATE TABLE detalle_compra (
    id_compra INT NOT NULL,
    id_prenda INT NOT NULL,
    PRIMARY KEY (id_compra, id_prenda),
    FOREIGN KEY (id_compra) REFERENCES compra(id_compra),
    FOREIGN KEY (id_prenda) REFERENCES prenda(id_prenda)
);