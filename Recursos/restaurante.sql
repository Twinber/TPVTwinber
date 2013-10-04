-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurante
-- ------------------------------------------------------
-- Server version	5.6.10

CREATE SCHEMA IF NOT EXISTS `restaurante` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `restaurante` ;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulos` (
  `idArticulo` int(11) NOT NULL AUTO_INCREMENT,
  `categoriaArticulo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombreArticulo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `precioArticulo` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`idArticulo`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` VALUES (1,'BEBIDAS','Cerveza Rubia',2.30),(2,'BEBIDAS','Pepsi',3.00),(3,'BEBIDAS','CocaCola',3.10),(4,'BEBIDAS','Fanta Naranja',1.74),(5,'BEBIDAS','Fanta Limón',1.71),(6,'BEBIDAS','Kas Naranja',1.56),(7,'BEBIDAS','Agua Mineral',0.79),(8,'BEBIDAS','Kas Limón',3.10),(9,'BEBIDAS','Cerveza Negra',2.15),(10,'BEBIDAS','Seven Up',2.15),(11,'BEBIDAS','Ginger Ale',2.31),(12,'BEBIDAS','Cool',1.98),(13,'BEBIDAS','Heineken',1.70),(14,'BEBIDAS','Tonica',2.34),(15,'ENSALADAS','Ensalada Marisco',5.50),(16,'ENSALADAS','Ensalada Exotica',6.00),(17,'ENSALADAS','Ensalada Especial',5.50),(18,'ENSALADAS','Ensalada Fantasia',6.50),(19,'ENSALADAS','Ensalada Mixta',5.50),(20,'ENSALADAS','Ensalada Normal',4.00),(21,'ENSALADAS','Ensalada Pasta',6.00),(22,'ENSALADAS','Ensalada Tono',5.50),(23,'ENTRANTES','1/2 Tabla Pates',3.00),(24,'ENTRANTES','1/2 Tabla Quesos',3.00),(25,'ENTRANTES','1/2 Tabla Salumit',3.75),(26,'ENTRANTES','Abundante',3.00),(27,'ENTRANTES','Carpaccio de Bresaola',8.00),(28,'ENTRANTES','Carpaccio Verdura',8.00),(29,'ENTRANTES','Doble Todo',3.00),(30,'ENTRANTES','Esparragos',3.00),(31,'ENTRANTES','Mejillones Mare Nostrum',6.00),(32,'ENTRANTES','Plato Olivas',3.00),(33,'ENTRANTES','Porquetta',3.00),(34,'ENTRANTES','Tabla de Paté',7.50),(35,'ENTRANTES','Tabla de Quesos',8.00),(36,'ENTRANTES','Tabla de Salumi',8.50),(37,'ENTRANTES','Papas',2.00),(38,'VINOS','Marques Caceres Tinto',10.00),(39,'VINOS','Marques Caceres Blanco',9.00),(40,'VINOS','Lambrusco Rosado',9.00),(41,'VINOS','Ribeiro',9.00),(42,'VINOS','Protos ribera Duero Crianza',15.00),(43,'VINOS','Rioja Reserva Tinto',16.00),(44,'VINOS','Tinto de la casa',7.00),(45,'VINOS','Blanco Monistrol',10.00),(46,'VINOS','El Coto cosecha',9.00),(47,'VINOS','El Coto Crianza',14.00),(48,'VINOS','Parnas Blanco',11.00),(49,'VINOS','Penedés Blanco',9.00),(50,'VINOS','Marques Caceres Tinto',10.00),(51,'VINOS','Marques Caceres Blanco',9.00),(52,'VINOS','Lambrusco Rosado',9.00),(53,'VINOS','Ribeiro',9.00),(54,'VINOS','Protos ribera Duero Crianza',15.00),(55,'VINOS','Rioja Reserva Tinto',16.00),(56,'VINOS','Tinto de la casa',7.00),(57,'VINOS','Blanco Monistrol',10.00),(58,'VINOS','El Coto cosecha',9.00),(59,'VINOS','El Coto Crianza',14.00),(60,'VINOS','Parnas Blanco',11.00),(61,'VINOS','Penedés Blanco',9.00),(62,'CARNES','Ternasco',9.00),(63,'CARNES','Confit de Pato',10.00),(64,'CARNES','Entrecot salsa pimienta',9.00),(65,'CARNES','Chuletas Cordero',8.00),(66,'CARNES','Cabritillo al horno',15.00),(67,'CARNES','Cochinillo asado',15.00),(68,'CARNES','Embutido asado',8.00),(69,'CARNES','Solomillo Salsa',8.00),(70,'CARNES','Lomo relleno',9.00),(71,'CARNES','Pollo al yogur',7.00),(72,'PESCADOS','Lubina al Espalda',12.00),(73,'PESCADOS','Lubina al horno',10.00),(74,'PESCADOS','Dorada asada',12.00),(75,'PESCADOS','Rape',9.00),(76,'PESCADOS','Langosta',25.00),(77,'PESCADOS','Fritura pescado',10.00),(78,'PESCADOS','Emperador',9.00),(79,'PESCADOS','Cazon',9.00),(80,'PESCADOS','Salmonetes',12.00),(81,'PESCADOS','Bogavante',19.00),(82,'PESCADOS','Rodaballo',13.00),(83,'PESCADOS','Datiles',20.00),(84,'PESCADOS','Caixetes',11.00),(85,'PESCADOS','Ostras',13.00),(86,'PESCADOS','Caldereta Langosta',17.00),(87,'POSTRES','Músico',3.50),(88,'POSTRES','Crema Catalana',3.00),(89,'POSTRES','Naranjas',3.00),(90,'POSTRES','Peras',3.00),(91,'POSTRES','Manzanas',3.00),(92,'POSTRES','Kiwis',3.00),(93,'POSTRES','Fruta del Tiempo',3.00),(94,'POSTRES','Flan',3.00),(95,'POSTRES','Natillas',3.00),(96,'POSTRES','Fresas con Nata',3.00),(97,'POSTRES','Tarta de Manzana',3.21),(98,'HELADOS','Cucurucho',2.00),(99,'HELADOS','Polo Hielo',1.20),(100,'HELADOS','Crocanti',2.10),(101,'HELADOS','Tarrina',2.00),(102,'HELADOS','Tarta al Wisky',3.00),(103,'HELADOS','Helado de Coco',3.10),(104,'HELADOS','Helado de Limón',3.20),(105,'HELADOS','Contesa',2.70),(106,'HELADOS','Solero',2.80),(107,'HELADOS','Frigo Dedo',1.50),(108,'HELADOS','Magnum Blanco',2.00),(109,'HELADOS','Magnum Noir',2.00),(110,'HELADOS','Magnum Clasic',2.00),(111,'HELADOS','Granizado de Horchata',3.00),(112,'HELADOS','Granizado de Limón',3.00),(113,'HELADOS','Granizado de Café',3.00),(114,'CAFES','Café Solo',1.00),(115,'CAFES','Café Cortado',1.00),(116,'CAFES','Bombon',1.20),(117,'CAFES','Capuchino',2.00),(118,'CAFES','Carajillo',1.20),(119,'CAFES','Poleo',1.00),(120,'CAFES','Manzanilla',1.00),(121,'CAFES','Té',1.00),(122,'CAFES','Chocolate',1.50),(123,'MENU','Menú del día',9.00),(124,'MENU','Menú 1',11.00),(125,'MENU','Menú 2',11.00),(126,'MENU','Menú 3',12.00),(127,'MENU','Menú 4',12.00),(128,'MENU','Menú 5',15.00);
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `idMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `idTicketCobradoFK` int(11) DEFAULT NULL,
  `importeIngreso` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`idMovimiento`),
  KEY `idTicketFK_idx` (`idTicketCobradoFK`),
  CONSTRAINT `idTicketCobradoFK` FOREIGN KEY (`idTicketCobradoFK`) REFERENCES `tickets` (`idTicket`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleticket`
--

DROP TABLE IF EXISTS `detalleticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleticket` (
  `idTicketFK` int(11) NOT NULL,
  `idArticuloFK` int(11) NOT NULL,
  `cantidadArticulo` int(11) DEFAULT NULL,
  `precioArticulo` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`idTicketFK`,`idArticuloFK`),
  KEY `idArticuloFK_idx` (`idArticuloFK`),
  CONSTRAINT `idTicketFK` FOREIGN KEY (`idTicketFK`) REFERENCES `tickets` (`idTicket`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idArticuloFK` FOREIGN KEY (`idArticuloFK`) REFERENCES `articulos` (`idArticulo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleticket`
--

LOCK TABLES `detalleticket` WRITE;
/*!40000 ALTER TABLE `detalleticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesas`
--

DROP TABLE IF EXISTS `mesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesas` (
  `idMesa` int(11) NOT NULL AUTO_INCREMENT,
  `nombreMesa` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idMesa`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesas`
--

LOCK TABLES `mesas` WRITE;
/*!40000 ALTER TABLE `mesas` DISABLE KEYS */;
INSERT INTO `mesas` VALUES (1,'Mesa 1'),(2,'Mesa 2'),(3,'Mesa 3'),(4,'Mesa 4'),(5,'Mesa 5'),(6,'Mesa 6'),(7,'Mesa 7'),(8,'Mesa 8'),(9,'Mesa 9'),(10,'Mesa 10'),(11,'Barra'),(12,'Llevar');
/*!40000 ALTER TABLE `mesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tickets` (
  `idTicket` int(11) NOT NULL AUTO_INCREMENT,
  `idMesaFK` int(11) DEFAULT NULL,
  `cobrado` tinyint(1) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `idMesaFk_idx` (`idMesaFK`),
  CONSTRAINT `idMesaFk` FOREIGN KEY (`idMesaFK`) REFERENCES `mesas` (`idMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `nombreUsuario` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `passwordUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`nombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('CAMARERO',1234),('ENCARGADO',1357),('GERENTE',1928);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-28  1:51:35
