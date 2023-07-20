-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: db_gestion_productos
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `IDE_CAT` int NOT NULL AUTO_INCREMENT,
  `DES_CAT` varchar(35) NOT NULL,
  PRIMARY KEY (`IDE_CAT`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'JUGOS'),(2,'SANDWICHS'),(3,'POSTRES'),(4,'BEBIDAS CALIENTES'),(5,'BEBIDAS FRIAS');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `IDE_PRO` int NOT NULL AUTO_INCREMENT,
  `DES_PRO` varchar(40) NOT NULL,
  `IDE_CAT` int NOT NULL,
  `PRE_PRO` double NOT NULL,
  `STO_PRO` int NOT NULL,
  PRIMARY KEY (`IDE_PRO`),
  KEY `fk_pro01` (`IDE_CAT`),
  CONSTRAINT `fk_pro01` FOREIGN KEY (`IDE_CAT`) REFERENCES `categoria` (`IDE_CAT`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'PYE DE MANZANA',3,5,50),(2,'TORTA DE CHOCOLATE',3,5,100),(3,'TORTA TRES LECHES',3,8,40),(4,'MOUSE DE MANZANA',3,7,70),(5,'ARROZ CON LECHE - ENVASE ESPECIAL',3,10,40),(6,'MAZAMORRA MORADA',3,4.5,70),(7,'YOGURT ARABE',3,9,100),(8,'PAN CON POLLO',2,4.5,500),(9,'BROWNIE',3,7,300),(10,'BESO DE MOZA',3,1,400),(11,'PYE DE LIMON',3,3.5,100),(12,'TORTA DE NARANJA',3,5,10),(13,'TORTA DE FRESA',3,4,100),(14,'ALFAJORES',3,1,400),(15,'CHOCOTEJAS',3,1.5,100),(16,'SUSPIRO A LA LIMEÑA',3,8.5,100),(17,'PAPAYA',1,5,100),(18,'SURTIDO',1,7.5,100),(19,'PIÑA',1,3.5,100),(20,'PLATANO CON LECHE',1,9.5,40),(21,'CAFE PASADO',4,2.5,30),(22,'CAFE CON LECHE',4,5.5,30),(23,'GASEOSA',5,3,100),(24,'REHIDRATANTE',5,7,100);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_boleta`
--

DROP TABLE IF EXISTS `tb_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta` (
  `num_bol` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int DEFAULT NULL,
  `cod_cli` int DEFAULT NULL,
  `fec_emi_bol` date DEFAULT NULL,
  `monto_bol` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`num_bol`),
  KEY `fk4` (`id_usuario`),
  KEY `fk5` (`cod_cli`),
  CONSTRAINT `fk4` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`),
  CONSTRAINT `fk5` FOREIGN KEY (`cod_cli`) REFERENCES `tb_cliente` (`cod_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta`
--

LOCK TABLES `tb_boleta` WRITE;
/*!40000 ALTER TABLE `tb_boleta` DISABLE KEYS */;
INSERT INTO `tb_boleta` VALUES (8,1,1,'2020-05-14',555),(15,1,1,'2023-07-13',1500),(16,1,1,'2023-07-13',1500),(17,1,22,'2023-07-14',1500);
/*!40000 ALTER TABLE `tb_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `cod_cli` int NOT NULL AUTO_INCREMENT,
  `nom_cli` varchar(30) DEFAULT NULL,
  `pat_cli` varchar(30) DEFAULT NULL,
  `mat_cli` varchar(30) DEFAULT NULL,
  `sex_cli` varchar(15) DEFAULT NULL,
  `dni_cli` int DEFAULT NULL,
  `fec_nac_cli` date DEFAULT NULL,
  `cel_cli` int DEFAULT NULL,
  `dir_cli` varchar(50) DEFAULT NULL,
  `correo_electronico` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (1,'Paolo','Martin','Quispe','Masculino',40770863,'2010-12-24',9916018,'Carabayllo','paolo@gmail.com'),(19,'Ana Sofia','Bernechea','Quispe','Femenino',968375385,'2005-06-22',968375385,'Peru-lima-carabayllo','ana@gmail.com'),(21,'sf','asd','sdf','sdf',124,'2023-07-14',124,'ad','sdf@gmail.com'),(22,'paolo','martin','quispe','masculino',987654321,'2023-07-04',987654321,'Peru-lima-carabayllo','marti@gmail.com');
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_empleado`
--

DROP TABLE IF EXISTS `tb_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_empleado` (
  `id_emp` int NOT NULL AUTO_INCREMENT,
  `ape_emp` varchar(25) DEFAULT NULL,
  `dni` char(8) DEFAULT NULL,
  `fech_registro` date DEFAULT NULL,
  `nom_emp` varchar(25) DEFAULT NULL,
  `telf_emp` varchar(15) DEFAULT NULL,
  `idrol` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_emp`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `telf_emp` (`telf_emp`),
  KEY `fk_emp01` (`idrol`),
  KEY `fk_emp02` (`id_usuario`),
  CONSTRAINT `fk_emp01` FOREIGN KEY (`idrol`) REFERENCES `tb_rol` (`idrol`),
  CONSTRAINT `fk_emp02` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empleado`
--

LOCK TABLES `tb_empleado` WRITE;
/*!40000 ALTER TABLE `tb_empleado` DISABLE KEYS */;
INSERT INTO `tb_empleado` VALUES (1,'MARTIN QUISPE','75672188','2023-07-13','Paolo Kennedy','974885335',3,NULL);
/*!40000 ALTER TABLE `tb_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_enlace`
--

DROP TABLE IF EXISTS `tb_enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_enlace` (
  `idenlace` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `ruta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idenlace`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_enlace`
--

LOCK TABLES `tb_enlace` WRITE;
/*!40000 ALTER TABLE `tb_enlace` DISABLE KEYS */;
INSERT INTO `tb_enlace` VALUES (2,'Producto','/producto/lista'),(3,'Empleado','/empleado/lista'),(4,'Cliente','/cliente/lista'),(5,'Boleta','/boleta/lista'),(6,'Usuario','/usuario/lista'),(7,'Reporte','/reporte/lista');
/*!40000 ALTER TABLE `tb_enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_producto_has_boleta`
--

DROP TABLE IF EXISTS `tb_producto_has_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_producto_has_boleta` (
  `num_bol` int NOT NULL,
  `IDE_PRO` int NOT NULL,
  `pre` double DEFAULT NULL,
  KEY `fk6` (`num_bol`),
  KEY `fk7` (`IDE_PRO`),
  CONSTRAINT `fk6` FOREIGN KEY (`num_bol`) REFERENCES `tb_boleta` (`num_bol`),
  CONSTRAINT `fkpb7` FOREIGN KEY (`IDE_PRO`) REFERENCES `producto` (`IDE_PRO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_producto_has_boleta`
--

LOCK TABLES `tb_producto_has_boleta` WRITE;
/*!40000 ALTER TABLE `tb_producto_has_boleta` DISABLE KEYS */;
INSERT INTO `tb_producto_has_boleta` VALUES (8,1,555),(15,5,10),(16,5,10),(17,6,4.5);
/*!40000 ALTER TABLE `tb_producto_has_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rol`
--

DROP TABLE IF EXISTS `tb_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rol` (
  `idrol` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rol`
--

LOCK TABLES `tb_rol` WRITE;
/*!40000 ALTER TABLE `tb_rol` DISABLE KEYS */;
INSERT INTO `tb_rol` VALUES (1,'administrador'),(2,'cajero'),(3,'solicitante'),(4,'profesor');
/*!40000 ALTER TABLE `tb_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rol_enlace`
--

DROP TABLE IF EXISTS `tb_rol_enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rol_enlace` (
  `idrol` int NOT NULL,
  `idenlace` int NOT NULL,
  PRIMARY KEY (`idrol`,`idenlace`),
  KEY `fk25` (`idenlace`),
  CONSTRAINT `fk24` FOREIGN KEY (`idrol`) REFERENCES `tb_rol` (`idrol`),
  CONSTRAINT `fk25` FOREIGN KEY (`idenlace`) REFERENCES `tb_enlace` (`idenlace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rol_enlace`
--

LOCK TABLES `tb_rol_enlace` WRITE;
/*!40000 ALTER TABLE `tb_rol_enlace` DISABLE KEYS */;
INSERT INTO `tb_rol_enlace` VALUES (1,2),(1,3),(1,4),(1,5),(2,5),(1,6),(1,7);
/*!40000 ALTER TABLE `tb_rol_enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `correo_electronico` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `idrol` int DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `dni` varchar(8) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `fk_usuario_rol_idx` (`idrol`),
  KEY `llave_idx` (`idrol`),
  CONSTRAINT `ghgh` FOREIGN KEY (`idrol`) REFERENCES `tb_rol` (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'paolo','martin','martin@gmail.com','$2a$10$cKE.Y1BJHk.6Skw53xTbDO8MGdE2woJgQkZJ9GUuDlcynFTIcmh8G',1,'martin','47586985'),(14,'frank','mendoza','i201821212@cibertec.edu.pe','wqwwqwqwq',3,'frank20','12345678'),(15,'Armando','Scripts','sarmando@cibertec.pe',NULL,4,'armando','85203698'),(16,'benedicto','XIV','papita@hotmail.com','$2a$10$hQUVDh6uWf/ioBfKagMbu.mCNfCdgLsYFPm3SOEZUx7bOSvrYnG/C',3,'papaxiv','58963247');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-20 11:51:53
