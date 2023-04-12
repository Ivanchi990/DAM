
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (1, 'Hombre', 'Camisas');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (2, 'Hombre', 'Pantalones');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (3, 'Hombre', 'Camisetas');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (4, 'Hombre', 'Cazadoras');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (5, 'Hombre', 'Zapatos');

INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (6, 'Mujer', 'Vestidos');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (7, 'Mujer', 'Faldas');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (8, 'Mujer', 'Blusas');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (9, 'Mujer', 'Camisas');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (10, 'Mujer', 'Pantalones');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (11, 'Mujer', 'Camisetas');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (12, 'Mujer', 'Cazadoras');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (13, 'Mujer', 'Zapatos');
INSERT INTO categoria (id_categoria, sexo, nombre) VALUES (14, 'hombre', 'para Borrar');



INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (1, 'Camisa Azul', 'Camisa formal de manga larga para hombres', 50.99, 1);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (2, 'Camisa Blanca', 'Camisa informal de manga corta para hombres', 29.99, 1);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (3, 'Pantalón Negro', 'Pantalón de vestir para hombres', 69.99, 2);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (4, 'Jeans Azul', 'Pantalón casual para hombres', 39.99, 2);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (5, 'Camiseta Negra', 'Camiseta básica de algodón para hombres', 14.99, 3);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (6, 'Cazadora Marrón', 'Cazadora de piel sintética para hombres', 99.99, 4);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (7, 'Zapatos Negros', 'Zapatos de vestir para hombres', 79.99, 5);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (9, 'Vestido Rojo', 'Vestido de fiesta para mujeres', 129.99, 6);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (10, 'Falda Floral', 'Falda midi con estampado floral para mujeres', 59.99, 7);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (11, 'Blusa Blanca', 'Blusa de manga corta con detalles de encaje para mujeres', 39.99, 8);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (12, 'Camisa de Rayas', 'Camisa casual de manga larga con rayas para mujeres', 49.99, 9);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (13, 'Pantalón Beige', 'Pantalón de vestir de tela ligera para mujeres', 79.99, 10);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (14, 'Camiseta Blanca', 'Camiseta básica de algodón para mujeres', 12.99, 11);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (15, 'Cazadora de Cuero', 'Cazadora de cuero sintético con cierre de cremallera para mujeres', 89.99, 12);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (16, 'Zapatos de Tacón', 'Zapatos de tacón alto con acabado brillante para mujeres', 99.99, 13);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (17, 'Traje Azul Marino', 'Traje de tres piezas para hombres', 299.99, 1);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (18, 'Sudadera Gris', 'Sudadera con capucha y bolsillo canguro para hombres', 49.99, 3);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (19, 'Chaleco Negro', 'Chaleco de vestir para hombres', 89.99, 2);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (20, 'Zapatillas Deportivas', 'Zapatillas de running para hombres', 69.99, 5);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (21, 'Vestido Verde', 'Vestido casual de verano para mujeres', 79.99, 6);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (22, 'Blusa Estampada', 'Blusa con estampado de flores para mujeres', 59.99, 8);
INSERT INTO prenda (id_prenda, nombre, descripcion, precio, id_categoria) VALUES (23, 'Pantalón Corto Vaquero', 'Shorts de mezclilla para mujeres', 29.99, 7);

-- Inserts para tabla "compra"
INSERT INTO compra (fecha_compra, precio_total, usuario) VALUES ('2023-03-07', 225.94, 'Juan Perez');
INSERT INTO compra (fecha_compra, precio_total, usuario) VALUES ('2023-03-08', 439.93, 'Maria Garcia');
INSERT INTO compra (fecha_compra, precio_total, usuario) VALUES ('2023-03-08', 189.97, 'Pedro Gomez');

-- Inserts para tabla "detalle_compra"
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (1, 1);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (1, 2);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (1, 5);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (2, 3);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (2, 6);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (2, 7);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (2, 9);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (2, 12);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (3, 10);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (3, 11);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (3, 14);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (3, 16);
INSERT INTO detalle_compra (id_compra, id_prenda) VALUES (3, 19);