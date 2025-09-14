CREATE TABLE `nacimientostauro` (
  `Nombre` varchar(12) NOT NULL,
  `Apellido1` varchar(12) NOT NULL,
  `Apellido2` varchar(12) NOT NULL,
  `FechaNac` date DEFAULT NULL,
  `Provincia` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Nombre`,`Apellido1`,`Apellido2`)
);

INSERT INTO nacimientos VALUES ("Ana", "Saénz", "López", "2008-01-05", "SE"), ("Conecpción", "Flores", "Cruz", "2009-02-27", "SA"), ("Inmaculada", "Alba", "Ruiz", "2007-12-15", "B"), ("Felipe", "Fernández", "Gómez", "2007-11-13", "S"), ("Sandra", "Barata", "Reyes", "2008-05-21", "M"), ("Daniel", "López", "Rojas", "2008-07-25", "TO"), ("Miguel", "Bendita", "Gil", "2009-03-17", "MA"), ("Raquel", "Robles", "Santos", "2009-03-17", "TO"), ("Arantxa", "Antón", "Barrios", "2009-04-04", "M"), ("Elisa", "Alonso", "López", "2009-08-20", "V"), ("Rémulo", "Fernández", "Alto", "2009-08-19", "CA");

INSERT INTO nacimientos09 SELECT * FROM nacimientos Where year(FechaNac) = 2009;

INSERT INTO nacimientostauro SELECT * FROM nacimientos Where month(FechaNac) >= 04 and month(FechaNac) <= 05 and day(FechaNac) >= 21; 

UPDATE nacimientos set Provincia = "M" Where Apellido1 like "%z" or Apellido2 like "%z";

UPDATE nacimientos set Provincia = "AL" Where Provincia = "MA";

UPDATE nacimientos set FechaNac = date_add(FechaNac, interval 2 year) and Provincia = "M" Where year(FechaNac) < 2008;

UPDATE nacimientos set Nombre = Nombre + "Maria" and Apellido1 = "De" + Apellido1 Where left (Apellido1, 1) = left (Provincia, 1);