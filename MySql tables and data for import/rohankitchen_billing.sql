-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: rohankitchen
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `billing`
--

DROP TABLE IF EXISTS `billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing` (
  `bId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Unique id for each entry for the bill',
  `bNumber` varchar(45) DEFAULT NULL COMMENT 'Bill number',
  `bDate` date DEFAULT NULL COMMENT 'Biiling date',
  `bCustName` varchar(45) DEFAULT NULL,
  `item_iId` int(11) NOT NULL,
  `iName` varchar(45) DEFAULT NULL,
  `iDescription` varchar(45) DEFAULT NULL COMMENT 'Description fo the item. This is a foreighn key form the item table',
  `bQty` int(11) DEFAULT NULL COMMENT 'Qty of the item sold',
  `iSp` int(11) DEFAULT NULL COMMENT 'Selling price of the item taken from the item table',
  `iCp` int(11) DEFAULT NULL COMMENT 'Cost price of the item taken from the item table',
  `bOk` varchar(5) DEFAULT 'Yes' COMMENT 'Table to know if row is active or has been deleted\nYes means row is active.\nNo means row has been deleted.',
  `bAmount` int(11) GENERATED ALWAYS AS ((`bQty` * `iSp`)) STORED COMMENT 'Amount of that particular item',
  `bProfit` int(11) GENERATED ALWAYS AS (((`bQty` * `iSp`) - (`bQty` * `iCp`))) STORED,
  PRIMARY KEY (`bId`),
  KEY `billing_item_fk1_idx` (`item_iId`),
  CONSTRAINT `billing_item_fk1` FOREIGN KEY (`item_iId`) REFERENCES `item` (`iId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing`
--

LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
INSERT INTO `billing` (`bId`, `bNumber`, `bDate`, `bCustName`, `item_iId`, `iName`, `iDescription`, `bQty`, `iSp`, `iCp`, `bOk`) VALUES (1,'RB/1/17-18','2017-10-01','Ashif Ali',1,'Black forest cake','Black forest cake small piece cake',10,15,10,'No'),(2,'RB/2/17-18','2017-10-02','Sk Wasim',2,'Dark chocolate cake','Dark chocolate small piece cake',5,22,11,'Yes'),(3,'RB/2/17-18','2017-10-02','Sk Wasim',5,'dfsdfdsf','dfghdfg',2,10,5,'Yes'),(4,'RB/2/17-18','2017-10-02','Sk Wasim',3,'Apple cake','Apple cake',5,20,12,'Yes'),(5,'RB/3/17-18','2017-10-20','Sk Shayeed',3,'Apple cake','Apple cake',5,20,12,'Yes'),(6,'RB/3/17-18','2017-10-20','Sk Shayeed',9,'Kaju Barfi','Bardis made from Kajus',2,25,5,'Yes'),(7,'RB/3/17-18','2017-10-20','Sk Shayeed',5,'Choco cup','Chocolate filled delight in a cup',6,10,5,'Yes'),(8,'RB/3/17-18','2017-10-20','Sk Shayeed',1,'Black forest cake','Black forest cake small piece cake',7,30,18,'Yes');
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-20 17:26:59
