-- MySQL dump 10.13  Distrib 5.5.17, for Linux (x86_64)
--
-- Host: localhost    Database: pyonhae
-- ------------------------------------------------------
-- Server version	5.5.17-log

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
-- Table structure for table `JMBOARD`
--

DROP TABLE IF EXISTS `JMBOARD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JMBOARD` (
  `IDX` int(11) NOT NULL AUTO_INCREMENT,
  `WRITER` varchar(50) NOT NULL,
  `SUBJECT` varchar(150) NOT NULL,
  `CONTENT` blob NOT NULL,
  `HITCOUNT` int(11) NOT NULL,
  `RECOMMENDCOUNT` int(11) NOT NULL,
  `WRITEDATE` date NOT NULL,
  `WRITERID` varchar(50) NOT NULL,
  `FILENAME` varchar(100) NOT NULL,
  PRIMARY KEY (`IDX`),
  UNIQUE KEY `JMBOARD_PK` (`IDX`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JMBOARD`
--

LOCK TABLES `JMBOARD` WRITE;
/*!40000 ALTER TABLE `JMBOARD` DISABLE KEYS */;
INSERT INTO `JMBOARD` VALUES (3,'2','토요일','���������',13,1,'2014-07-06','2','1404605256077'),(2,'2','이제 써지겠지?','써저라',4,0,'2014-07-06','2','1404576461128');
/*!40000 ALTER TABLE `JMBOARD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JMBOARD_COMMENT`
--

DROP TABLE IF EXISTS `JMBOARD_COMMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JMBOARD_COMMENT` (
  `IDX` int(11) NOT NULL AUTO_INCREMENT,
  `WRITER` varchar(50) NOT NULL,
  `CONTENT` blob NOT NULL,
  `WRITEDATE` date NOT NULL,
  `LINKEDARTICLENUM` int(11) NOT NULL,
  `WRITERID` varchar(50) NOT NULL,
  PRIMARY KEY (`IDX`),
  UNIQUE KEY `JMBOARD_COMMENT_PK` (`IDX`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JMBOARD_COMMENT`
--

LOCK TABLES `JMBOARD_COMMENT` WRITE;
/*!40000 ALTER TABLE `JMBOARD_COMMENT` DISABLE KEYS */;
INSERT INTO `JMBOARD_COMMENT` VALUES (1,'2','아침','2014-07-06',3,'2'),(3,'333','아아','2014-07-06',3,'333');
/*!40000 ALTER TABLE `JMBOARD_COMMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JMBOARD_MEMBER`
--

DROP TABLE IF EXISTS `JMBOARD_MEMBER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JMBOARD_MEMBER` (
  `IDX` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` varchar(70) NOT NULL,
  `USERPW` varchar(50) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `JOINDATE` date DEFAULT NULL,
  PRIMARY KEY (`IDX`),
  UNIQUE KEY `JMBOARD_MEMBER_PK` (`IDX`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JMBOARD_MEMBER`
--

LOCK TABLES `JMBOARD_MEMBER` WRITE;
/*!40000 ALTER TABLE `JMBOARD_MEMBER` DISABLE KEYS */;
INSERT INTO `JMBOARD_MEMBER` VALUES (1,'1','1','1','2014-06-19'),(2,'2','2','2','2014-07-04'),(3,'333','333','333','2014-07-04');
/*!40000 ALTER TABLE `JMBOARD_MEMBER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servers`
--

DROP TABLE IF EXISTS `servers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servers` (
  `Server_name` char(64) NOT NULL,
  `Host` char(64) NOT NULL,
  `Db` char(64) NOT NULL,
  `Username` char(64) NOT NULL,
  `Password` char(64) NOT NULL,
  `Port` int(4) DEFAULT NULL,
  `Socket` char(64) DEFAULT NULL,
  `Wrapper` char(64) NOT NULL,
  `Owner` char(64) NOT NULL,
  PRIMARY KEY (`Server_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='MySQL Foreign Servers table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servers`
--

LOCK TABLES `servers` WRITE;
/*!40000 ALTER TABLE `servers` DISABLE KEYS */;
/*!40000 ALTER TABLE `servers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp1`
--

DROP TABLE IF EXISTS `temp1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temp1` (
  `aa` varchar(8) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp1`
--

LOCK TABLES `temp1` WRITE;
/*!40000 ALTER TABLE `temp1` DISABLE KEYS */;
/*!40000 ALTER TABLE `temp1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-07  0:33:19
