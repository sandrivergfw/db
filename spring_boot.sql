/*
SQLyog Ultimate v8.32 
MySQL - 8.0.30 : Database - sale_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sale_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `sale_system`;

/*Table structure for table `cartinfor` */

DROP TABLE IF EXISTS `cartinfor`;

CREATE TABLE `cartinfor` (
  `customerId` int DEFAULT NULL,
  `productId` int DEFAULT NULL,
  `isSelect` tinyint(1) DEFAULT '0',
  `num` int DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `cartinfor` */

insert  into `cartinfor`(`customerId`,`productId`,`isSelect`,`num`) values (1,2,0,1),(1,3,0,1);

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `customerId` int unsigned NOT NULL AUTO_INCREMENT,
  `customerName` varchar(100) NOT NULL,
  `loginPwd` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `picUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*Data for the table `customers` */

insert  into `customers`(`customerId`,`customerName`,`loginPwd`,`phone`,`address`,`birthday`,`email`,`picUrl`) values (1,'zjh','1212','123456789','thu','1970-01-01','zjh@163.com',NULL);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orderId` int unsigned NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `orderAddress` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `orderTime` date NOT NULL,
  `pay` double NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

/*Data for the table `orders` */

insert  into `orders`(`orderId`,`customerId`,`orderAddress`,`orderTime`,`pay`) values (1,1,'大运村','2022-01-10',120),(3,1,'thu','2022-10-14',1000);

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `productId` int unsigned NOT NULL AUTO_INCREMENT,
  `productName` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `size` double NOT NULL,
  `picture` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `SSD` int NOT NULL,
  `memory` int NOT NULL,
  `sales` int NOT NULL,
  `brand` varchar(100) NOT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

/*Data for the table `products` */

insert  into `products`(`productId`,`productName`,`price`,`size`,`picture`,`SSD`,`memory`,`sales`,`brand`) values (1,'电脑1',1000,15.6,'url',256,8,10,'联想'),(2,'电脑2',1200,14,'url',256,8,10,'mac');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
