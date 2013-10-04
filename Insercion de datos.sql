-- TABLA MESAS --
INSERT INTO `restaurante`.`Mesas` (`nombreMesa`)
VALUES 	('Mesa 1'),('Mesa 2'),('Mesa 3'),('Mesa 4'),('Mesa 5'),
		('Mesa 6'),('Mesa 7'),('Mesa 8'),('Mesa 9'),('Mesa 10'),
		('Barra'),('Llevar');

-- ARTICULOS --
-- CATEGORIA BEBIDAS --

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('BEBIDAS','Cerveza Rubia',2.30),
			('BEBIDAS','Pepsi',3.00),
			('BEBIDAS','CocaCola',3.10),
			('BEBIDAS','Fanta Naranja',1.74),
			('BEBIDAS','Fanta Limón',1.71),
			('BEBIDAS','Kas Naranja',1.56),
			('BEBIDAS','Agua Mineral',0.79),
			('BEBIDAS','Kas Limón',3.10),
			('BEBIDAS','Cerveza Negra',2.15),
			('BEBIDAS','Seven Up',2.15),
			('BEBIDAS','Ginger Ale',2.31),
			('BEBIDAS','Cool',1.98),
			('BEBIDAS','Heineken',1.70),
			('BEBIDAS','Tonica',2.34);

-- ARTICULOS --
-- CATEGORIA ENSALADAS --

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('ENSALADAS','Ensalada Marisco',5.50),
			('ENSALADAS','Ensalada Exotica',6.00),
			('ENSALADAS','Ensalada Especial',5.50),
			('ENSALADAS','Ensalada Fantasia',6.50),
			('ENSALADAS','Ensalada Mixta',5.50),
			('ENSALADAS','Ensalada Normal',4.00),
			('ENSALADAS','Ensalada Pasta',6.00),
			('ENSALADAS','Ensalada Tono',5.50);

-- ARTICULOS --
-- CATEGORIA ENSALADAS --

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('ENTRANTES','1/2 Tabla Pates',3.00),
			('ENTRANTES','1/2 Tabla Quesos',3.00),
			('ENTRANTES','1/2 Tabla Salumit',3.75),
			('ENTRANTES','Abundante',3.00),
			('ENTRANTES','Carpaccio de Bresaola',8.00),
			('ENTRANTES','Carpaccio Verdura',8.00),
			('ENTRANTES','Doble Todo',3.00),
			('ENTRANTES','Esparragos',3.00),
			('ENTRANTES','Mejillones Mare Nostrum',6.00),
			('ENTRANTES','Plato Olivas',3.00),
			('ENTRANTES','Porquetta',3.00),
			('ENTRANTES','Tabla de Paté',7.50),
			('ENTRANTES','Tabla de Quesos',8.00),
			('ENTRANTES','Tabla de Salumi',8.50),
			('ENTRANTES','Papas',2.00);
			
-- ARTICULOS --
-- CATEGORIA VINOS -- 

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('VINOS','Marques Caceres Tinto',10.00),
			('VINOS','Marques Caceres Blanco',9.00),
			('VINOS','Lambrusco Rosado',9.00),
			('VINOS','Ribeiro',9.00),
			('VINOS','Protos ribera Duero Crianza',15.00),
			('VINOS','Rioja Reserva Tinto',16.00),
			('VINOS','Tinto de la casa',7.00),
			('VINOS','Blanco Monistrol',10.00),
			('VINOS','El Coto cosecha',9.00),
			('VINOS','El Coto Crianza',14.00),
			('VINOS','Parnas Blanco',11.00),
			('VINOS','Penedés Blanco',9.00);
			
-- ARTICULOS --
-- CATEGORIA VINOS -- 

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('VINOS','Marques Caceres Tinto',10.00),
			('VINOS','Marques Caceres Blanco',9.00),
			('VINOS','Lambrusco Rosado',9.00),
			('VINOS','Ribeiro',9.00),
			('VINOS','Protos ribera Duero Crianza',15.00),
			('VINOS','Rioja Reserva Tinto',16.00),
			('VINOS','Tinto de la casa',7.00),
			('VINOS','Blanco Monistrol',10.00),
			('VINOS','El Coto cosecha',9.00),
			('VINOS','El Coto Crianza',14.00),
			('VINOS','Parnas Blanco',11.00),
			('VINOS','Penedés Blanco',9.00);

-- ARTICULOS --
-- CATEGORIA CARNES -- 

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('CARNES','Ternasco',9.00),
			('CARNES','Confit de Pato',10.00),
			('CARNES','Entrecot salsa pimienta',9.00),
			('CARNES','Chuletas Cordero',8.00),
			('CARNES','Cabritillo al horno',15.00),
			('CARNES','Cochinillo asado',15.00),
			('CARNES','Embutido asado',8.00),
			('CARNES','Solomillo Salsa',8.00),
			('CARNES','Lomo relleno',9.00),
			('CARNES','Pollo al yogur',7.00);

-- ARTICULOS --
-- CATEGORIA PESCADOS -- 

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('PESCADOS','Lubina al Espalda',12.00),
			('PESCADOS','Lubina al horno',10.00),
			('PESCADOS','Dorada asada',12.00),
			('PESCADOS','Rape',9.00),
			('PESCADOS','Langosta',25.00),
			('PESCADOS','Fritura pescado',10.00),
			('PESCADOS','Emperador',9.00),
			('PESCADOS','Cazon',9.00),
			('PESCADOS','Salmonetes',12.00),
			('PESCADOS','Bogavante',19.00),
			('PESCADOS','Rodaballo',13.00),
			('PESCADOS','Datiles',20.00),
			('PESCADOS','Caixetes',11.00),
			('PESCADOS','Ostras',13.00),
			('PESCADOS','Caldereta Langosta',17.00);

-- ARTICULOS --
-- CATEGORIA POSTRES -- 

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('POSTRES','Músico',3.50),
			('POSTRES','Crema Catalana',3.00),
			('POSTRES','Naranjas',3.00),
			('POSTRES','Peras',3.00),
			('POSTRES','Manzanas',3.00),
			('POSTRES','Kiwis',3.00),
			('POSTRES','Fruta del Tiempo',3.00),
			('POSTRES','Flan',3.00),
			('POSTRES','Natillas',3.00),
			('POSTRES','Fresas con Nata',3.00),
			('POSTRES','Tarta de Manzana',3.21);
			
-- ARTICULOS --
-- CATEGORIA HELADOS -- 

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('HELADOS','Cucurucho',2.00),
			('HELADOS','Polo Hielo',1.20),
			('HELADOS','Crocanti',2.10),
			('HELADOS','Tarrina',2.00),
			('HELADOS','Tarta al Wisky',3.00),
			('HELADOS','Helado de Coco',3.10),
			('HELADOS','Helado de Limón',3.20),
			('HELADOS','Contesa',2.70),
			('HELADOS','Solero',2.80),
			('HELADOS','Frigo Dedo',1.50),
			('HELADOS','Magnum Blanco',2.00),
			('HELADOS','Magnum Noir',2.00),
			('HELADOS','Magnum Clasic',2.00),
			('HELADOS','Granizado de Horchata',3.00),
			('HELADOS','Granizado de Limón',3.00),
			('HELADOS','Granizado de Café',3.00);

-- ARTICULOS --
-- CATEGORIA CAFES -- 

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('CAFES','Café Solo',1.00),
			('CAFES','Café Cortado',1.00),
			('CAFES','Bombon',1.20),
			('CAFES','Capuchino',2.00),
			('CAFES','Carajillo',1.20),
			('CAFES','Poleo',1.00),
			('CAFES','Manzanilla',1.00),
			('CAFES','Té',1.00),
			('CAFES','Chocolate',1.50);

-- ARTICULOS --
-- CATEGORIA MENU -- 

INSERT INTO `restaurante`.`Articulos`
	(`categoriaArticulo`,`nombreArticulo`,`precioArticulo`)
	VALUES 	('MENU','Menú del día',9.00),
			('MENU','Menú 1',11.00),
			('MENU','Menú 2',11.00),
			('MENU','Menú 3',12.00),
			('MENU','Menú 4',12.00),
			('MENU','Menú 5',15.00);

-- USUARIOS --

INSERT INTO `restaurante`.`Usuarios`
(`nombreUsuario`,`passwordUsuario`)
VALUES 	('CAMARERO',1234),
		('ENCARGADO',1357),
		('GERENTE',1928);


