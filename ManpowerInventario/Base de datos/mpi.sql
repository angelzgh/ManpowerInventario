-- MySQL dump 10.13  Distrib 5.7.21, for Win32 (AMD64)
--
-- Host: localhost    Database: mpi
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `asignacion`
--

DROP TABLE IF EXISTS `asignacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignacion` (
  `idAsignacion` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Noempleado` varchar(45) DEFAULT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  `Jefe` varchar(45) DEFAULT NULL,
  `fechaasig` date DEFAULT NULL,
  `Hostname` varchar(45) DEFAULT NULL,
  `Bitlocker` varchar(45) DEFAULT NULL,
  `status_idstatus` varchar(45) NOT NULL,
  `UDN_idUDN` varchar(45) NOT NULL,
  `Soporte_idSoporte` varchar(45) NOT NULL,
  `CC_idCC` int(11) NOT NULL,
  `Equipo_Serie` varchar(20) NOT NULL,
  `EquipoAnterior` varchar(30) DEFAULT NULL,
  `Fechaterm` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idAsignacion`),
  KEY `fk_Asignacion_status_idx` (`status_idstatus`),
  KEY `fk_Asignacion_UDN1_idx` (`UDN_idUDN`),
  KEY `fk_Asignacion_Soporte1_idx` (`Soporte_idSoporte`),
  KEY `fk_Asignacion_CC1_idx` (`CC_idCC`),
  KEY `fk_Asignacion_Equipo1_idx` (`Equipo_Serie`),
  CONSTRAINT `fk_Asignacion_CC1` FOREIGN KEY (`CC_idCC`) REFERENCES `cc` (`idCC`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asignacion_Equipo1` FOREIGN KEY (`Equipo_Serie`) REFERENCES `equipo` (`Serie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asignacion_Soporte1` FOREIGN KEY (`Soporte_idSoporte`) REFERENCES `soporte` (`idSoporte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asignacion_UDN1` FOREIGN KEY (`UDN_idUDN`) REFERENCES `udn` (`idUDN`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asignacion_status` FOREIGN KEY (`status_idstatus`) REFERENCES `status` (`idstatus`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `cc`
--

DROP TABLE IF EXISTS `cc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cc` (
  `idCC` varchar(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cc`
--

LOCK TABLES `cc` WRITE;
/*!40000 ALTER TABLE `cc` DISABLE KEYS */;
INSERT INTO `cc` VALUES (3,'Corporativo'),(159,'San Simon-Promociones');
/*!40000 ALTER TABLE `cc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada` (
  `idEntrada` varchar(20) NOT NULL,
  `Remitente` varchar(45) DEFAULT NULL,
  `Destinatario` varchar(45) DEFAULT NULL,
  `Tipo` int(11) DEFAULT NULL,
  `Fecha` datetime DEFAULT NULL,
  `Equipo_Serie` varchar(20) NOT NULL,
  PRIMARY KEY (`idEntrada`),
  KEY `fk_Entrada_Equipo1_idx` (`Equipo_Serie`),
  CONSTRAINT `fk_Entrada_Equipo1` FOREIGN KEY (`Equipo_Serie`) REFERENCES `equipo` (`Serie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `equipo` (
  `Serie` varchar(20) NOT NULL,
  `Tipo` varchar(45) DEFAULT NULL,
  `Modelo` varchar(45) DEFAULT NULL,
  `Marca` varchar(45) DEFAULT NULL,
  `status_idstatus` varchar(45) NOT NULL,
  `Comentarios` varchar(300) DEFAULT NULL,
  `CartaR` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`Serie`),
  KEY `fk_Equipo_status1_idx` (`status_idstatus`),
  CONSTRAINT `fk_Equipo_status1` FOREIGN KEY (`status_idstatus`) REFERENCES `status` (`idstatus`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES ('PC0SUAA1','Laptop','X270','Lenovo','En bodega',NULL,NULL),('PC0SUAA2','Laptop','X270','Lenovo','En bodega',NULL,NULL),('PC0SUAA3','Laptop','X270','Lenovo','En bodega',NULL,NULL),('PC0SUBB1','Laptop','X270','Lenovo','En bodega',NULL,'Pendiente'),('PC0SUBB2','Laptop','X270','Lenovo','En bodega',NULL,NULL),('PC0SUBB3','Laptop','X270','Lenovo','En bodega',NULL,NULL),('PC0SUCC1','Laptop','X270','Lenovo','En bodega',NULL,NULL),('PC0SUCC2','Laptop','X270','Lenovo','En bodega',NULL,NULL),('PC0SUCC3','Laptop','X270','Lenovo','En bodega',NULL,NULL),('PC0SUDD1','Laptop','X270','Lenovo','En bodega',NULL,NULL),('PF0EAAA1','Laptop','L450','Lenovo','En bodega',NULL,NULL),('PF0EAAA2','Laptop','L450','Lenovo','En bodega',NULL,NULL),('PF0EAAA3','Laptop','L450','Lenovo','En bodega',NULL,NULL),('PF0EBBB1','Laptop','L450','Lenovo','En bodega',NULL,NULL),('PF0EBBB2','Laptop','L450','Lenovo','En bodega',NULL,NULL),('PF0EBBB3','Laptop','L450','Lenovo','En bodega',NULL,NULL),('PF0ECCC1','Laptop','L450','Lenovo','En bodega',NULL,NULL),('PF0ECCC2','Laptop','L450','Lenovo','En bodega',NULL,NULL),('PF0ECCC3','Laptop','L450','Lenovo','En bodega',NULL,NULL),('PF0ERRR1','Laptop','L450','Lenovo','En bodega',NULL,NULL),('PRUEBA',NULL,NULL,NULL,'En bodega',NULL,NULL);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soporte`
--

DROP TABLE IF EXISTS `soporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soporte` (
  `idSoporte` varchar(45) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSoporte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soporte`
--

LOCK TABLES `soporte` WRITE;
/*!40000 ALTER TABLE `soporte` DISABLE KEYS */;
INSERT INTO `soporte` VALUES ('agutierrezh','Angel Gutiérrez'),('jrleon','Roberto León'),('nsanjuan','Noe San Juan'),('caalvarado','Carlos Alvarado'),('degamiz','Diego Gamiz'),('ccruz','Cesar Uriel Cruz');
/*!40000 ALTER TABLE `soporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `idstatus` varchar(45) NOT NULL,
  PRIMARY KEY (`idstatus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES ('Asignado'),('En bodega'),('Dañado'),('Robado'),('En prestamo'),('Cambio');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `udn`
--

DROP TABLE IF EXISTS `udn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `udn` (
  `idUDN` varchar(45) NOT NULL,
  PRIMARY KEY (`idUDN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `udn`
--

LOCK TABLES `udn` WRITE;
/*!40000 ALTER TABLE `udn` DISABLE KEYS */;
INSERT INTO `udn` VALUES ('Corporativo'),('Tabacalera'),('San Angel'),('Polanco Experis'),('Vallejo'),('San Simón'),('Santa Fe');
/*!40000 ALTER TABLE `udn` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-23  0:42:37
