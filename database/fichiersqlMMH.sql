-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: make_me_happy
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

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
-- Table structure for table `avatar`
--

DROP TABLE IF EXISTS `avatar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avatar` (
  `id_avatar` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id_avatar`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avatar`
--

LOCK TABLES `avatar` WRITE;
/*!40000 ALTER TABLE `avatar` DISABLE KEYS */;
INSERT INTO `avatar` VALUES (1,'/image/boy.svg'),(2,'/image/boy-1.svg'),(3,'/image/girl.svg'),(4,'/image/girl-1.svg'),(5,'/image/man.svg'),(6,'/image/man-1.svg'),(7,'/image/man-2.svg'),(8,'/image/man-3.svg'),(9,'/image/man-4.svg');
/*!40000 ALTER TABLE `avatar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gift`
--

DROP TABLE IF EXISTS `gift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gift` (
  `id_gift` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) NOT NULL,
  `description` text NOT NULL,
  `preference` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `url_dealer` varchar(150) NOT NULL,
  `price` float NOT NULL,
  `id_gift_list` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_gift`),
  KEY `gift_gift_list_FK` (`id_gift_list`),
  CONSTRAINT `gift_gift_list_FK` FOREIGN KEY (`id_gift_list`) REFERENCES `gift_list` (`id_gift_list`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gift`
--

LOCK TABLES `gift` WRITE;
/*!40000 ALTER TABLE `gift` DISABLE KEYS */;
INSERT INTO `gift` VALUES (1,'fauteuil de gamer','Il ferait beaucoup de bien à mon dos!BB',2,'https://images-na.ssl-images-amazon.com/images/I/61ohQy8UPqL._AC_SY741_.jpg','https://www.amazon.fr/GTPLAYER-Fauteuil-Haut-Parleur-Bluetooth-Ergonomique/dp/B07KRS5N64',210,NULL),(2,'fauteuil de gamer','Il ferait beaucoup de bien à mon dos!BB',2,'https://images-na.ssl-images-amazon.com/images/I/61ohQy8UPqL._AC_SY741_.jpg','https://www.amazon.fr/GTPLAYER-Fauteuil-Haut-Parleur-Bluetooth-Ergonomique/dp/B07KRS5N64',199.9,NULL),(3,'chapeau','',1,'','',100,NULL),(4,'montre','',1,'','',500,NULL),(5,'bonnet','',1,'','',20,NULL),(6,'pipe','',1,'','',30,NULL),(7,'montre','',1,'','',50,NULL),(8,'mangue','',5,'','',5,NULL),(9,'casque','j\'en rêve la nuit!, il me le faut absolment!',1,'https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Headphones_1.jpg/1200px-Headphones_1.jpg','https://www.backmarket.fr/casque-reducteur-de-bruit-bluetooth-avec-micro-beats-studio3-wireless-noir-pas-cher/89869.html#?l=0',200,NULL),(10,'ballon','',3,'','',20,NULL),(11,'tabouret','',2,'','',5,NULL),(12,'pipe','',3,'','',20,NULL),(15,'tacos','',1,'https://cdn.shopify.com/s/files/1/1450/7662/products/PLAY_International_Classic_Toy_-_Taco_1_-_Web_Res_grande_a2183acd-f5a5-4c15-8acd-7b19ba8b22e6_grande.jpg?v=1513686768','',100,1),(18,'ballon','',5,'https://www.bonhommedebois.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/B/A/BALLON_DE_FOOT_DINOSAURE_TAILLE_2.jpg','',5,1),(19,'pipe','',5,'https://cdn1.smkg.fr/images/cat_desc/329-pipe-art-et-volutes.png','',29,1),(20,'chat Rose','',5,'https://images-na.ssl-images-amazon.com/images/I/61bkoEwlCdL._AC_SY355_.jpg','',20,1);
/*!40000 ALTER TABLE `gift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gift_list`
--

DROP TABLE IF EXISTS `gift_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gift_list` (
  `id_gift_list` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT NULL,
  `dead_line` date DEFAULT NULL,
  `share_link` varchar(255) DEFAULT NULL,
  `description` text,
  `notify_gift` tinyint(1) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_theme` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_gift_list`),
  KEY `gift_list_theme0_FK` (`id_theme`),
  KEY `gift_list_user_FK` (`id_user`),
  CONSTRAINT `gift_list_theme0_FK` FOREIGN KEY (`id_theme`) REFERENCES `theme` (`id_theme`),
  CONSTRAINT `gift_list_user_FK` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gift_list`
--

LOCK TABLES `gift_list` WRITE;
/*!40000 ALTER TABLE `gift_list` DISABLE KEYS */;
INSERT INTO `gift_list` VALUES (1,'papaye','2020-05-22',NULL,'',NULL,4,4);
/*!40000 ALTER TABLE `gift_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme` (
  `id_theme` int(11) NOT NULL AUTO_INCREMENT,
  `background` varchar(255) NOT NULL,
  PRIMARY KEY (`id_theme`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` VALUES (1,'anniversaire5.jpg'),(2,'naissance.jpeg'),(3,'mariage1.jpg'),(4,'papanoel.png'),(5,'cremaillere.jpg'),(6,'bapteme.jpg'),(7,'cadeau20.jpg');
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `avatar` varchar(250) DEFAULT NULL,
  `id_avatar` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `user_avatar_FK` (`id_avatar`),
  CONSTRAINT `user_avatar_FK` FOREIGN KEY (`id_avatar`) REFERENCES `avatar` (`id_avatar`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','password',NULL,NULL,NULL),(2,'abc','ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad',NULL,NULL,NULL),(3,'diablotin','abc',NULL,NULL,NULL),(4,'kali','fc5669b52ce4e283ad1d5d182de88ff9faec6672bace84ac2ce4c083f54fe2bc',NULL,'/image/girl-1.svg',4),(5,'NanaROUge','1630418519dd43ea99e390a4769091e1920215526f75843c3d48825d528a89cf',NULL,'/image/girl.svg',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_gift`
--

DROP TABLE IF EXISTS `user_gift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_gift` (
  `id_gift` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `message` text NOT NULL,
  PRIMARY KEY (`id_gift`,`id_user`),
  KEY `user_gift_user0_FK` (`id_user`),
  CONSTRAINT `user_gift_gift_FK` FOREIGN KEY (`id_gift`) REFERENCES `gift` (`id_gift`),
  CONSTRAINT `user_gift_user0_FK` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_gift`
--

LOCK TABLES `user_gift` WRITE;
/*!40000 ALTER TABLE `user_gift` DISABLE KEYS */;
INSERT INTO `user_gift` VALUES (1,1,'Je te souhaite beaucoup d\'amour et de tacos, ton petit diablotin'),(1,3,'Je te souhaite beaucoup d\'amour et de tacos, ton petit diablotin');
/*!40000 ALTER TABLE `user_gift` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-02  9:51:57