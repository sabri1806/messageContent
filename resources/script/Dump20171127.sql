-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: messagecontent
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (3301,'alto coment',3253),(3302,'alto coment',3253),(3303,'alto coment',3253),(3304,'alto coment',3253),(4101,'comments here',4051),(4251,'another comment',3953),(4353,'comments here',4306);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (5001,'nzrft75y73',359619,'image/png'),(5002,'sh3dox70ic',359619,'image/png'),(5003,'sa55zkd7m2',359619,'image/png'),(5501,'371ifw7e0r',7173,'image/jpeg'),(5502,'606hpzoajl',7173,'image/jpeg'),(5601,'o68s7ontgq',7173,'image/jpeg'),(5703,'d1mwy0tkmq',7173,'image/jpeg'),(5705,'9hx1ydatdg',8756,'image/jpeg'),(5706,'sobn7wq445',70809,'image/jpeg'),(5851,'jnj1y26qrk',7173,'image/jpeg');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `openjpa_sequence_table`
--

LOCK TABLES `openjpa_sequence_table` WRITE;
/*!40000 ALTER TABLE `openjpa_sequence_table` DISABLE KEYS */;
INSERT INTO `openjpa_sequence_table` VALUES (0,5951);
/*!40000 ALTER TABLE `openjpa_sequence_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (4304,'2017-11-13 20:15:56','this is my first post wow',2001,NULL),(4306,'2017-11-13 20:17:36','another post in this site',2001,NULL),(4307,'2017-11-13 20:19:03','try to create a post whitout content',3501,NULL),(5754,'2017-11-27 18:04:02','okff',4401,5703),(5756,'2017-11-27 18:04:54','grhgx',4401,5705),(5901,'2017-11-27 19:36:57','holaa',5801,5851);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4401,'pepito@gmail.com','pepito','pepito',NULL),(4402,'sabrina@mail.com','sabrina','sabrina',NULL),(4403,'juanito@mail.com','juanito','juanito',NULL),(4404,'fulanito@correo.com','fulanito','fulanito',NULL),(4501,'panchito@mail.com','panchito','panchito',NULL),(4751,'juanito@m.c','juanito','juanito',NULL),(5351,'raulito@mail.com','raulito','raulito',NULL),(5352,'raulito@mail.com','raulito','raulito',NULL),(5353,'raulito@mail.com','raulito','raulito',NULL),(5401,'pedrito@m.c','pedrito','pedrito',NULL),(5451,'filo@m.c','filome','filome',NULL),(5651,'a@a.com','aaaaa','123456',5601),(5801,'homer@simpson.com','homer','homer123',5706);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-27 19:54:24
