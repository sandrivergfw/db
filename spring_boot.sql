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

/*Table structure for table `ads` */

DROP TABLE IF EXISTS `ads`;

CREATE TABLE `ads` (
  `adId` int NOT NULL AUTO_INCREMENT,
  `adText` varchar(10000) NOT NULL,
  `adTime` time NOT NULL,
  `adTitle` varchar(1000) NOT NULL,
  `adPic` varchar(100) NOT NULL,
  PRIMARY KEY (`adId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `ads` */

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

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `commentId` int NOT NULL AUTO_INCREMENT,
  `commentText` varchar(1000) NOT NULL,
  `commentScore` int NOT NULL DEFAULT '5',
  `commentTime` datetime NOT NULL,
  `commentLike` int NOT NULL DEFAULT '0',
  `commentDislike` int NOT NULL DEFAULT '0',
  `commentReplys` int NOT NULL DEFAULT '0',
  `customerId` int NOT NULL,
  `productId` int NOT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `comments` */

insert  into `comments`(`commentId`,`commentText`,`commentScore`,`commentTime`,`commentLike`,`commentDislike`,`commentReplys`,`customerId`,`productId`) values (1,'这是一个评价',5,'2022-10-23 12:58:00',2,0,3,1,1);

/*Table structure for table `customerdislikecomment` */

DROP TABLE IF EXISTS `customerdislikecomment`;

CREATE TABLE `customerdislikecomment` (
  `customerId` int NOT NULL,
  `commentId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customerdislikecomment` */

insert  into `customerdislikecomment`(`customerId`,`commentId`) values (1,1);

/*Table structure for table `customerdislikereply` */

DROP TABLE IF EXISTS `customerdislikereply`;

CREATE TABLE `customerdislikereply` (
  `customerId` int NOT NULL,
  `replyId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customerdislikereply` */

/*Table structure for table `customerlikecomment` */

DROP TABLE IF EXISTS `customerlikecomment`;

CREATE TABLE `customerlikecomment` (
  `customerId` int NOT NULL,
  `commentId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customerlikecomment` */

insert  into `customerlikecomment`(`customerId`,`commentId`) values (1,1);

/*Table structure for table `customerlikereply` */

DROP TABLE IF EXISTS `customerlikereply`;

CREATE TABLE `customerlikereply` (
  `customerId` int NOT NULL,
  `replyId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customerlikereply` */

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
  `picWay` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT 'E:\\db_images\\default.jpg',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

/*Data for the table `customers` */

insert  into `customers`(`customerId`,`customerName`,`loginPwd`,`phone`,`address`,`birthday`,`email`,`picWay`) values (1,'zjh','1212','123456789','thu','1970-01-01','zjh@163.com','2e643da2e37b4b89b9b694db4f776236_hw22.jpg'),(2,'ab','12','1245','buaa','2022-10-10','buaa.edu.cn','E:\\db_images\\default.jpg');

/*Table structure for table `deliveries` */

DROP TABLE IF EXISTS `deliveries`;

CREATE TABLE `deliveries` (
  `deliveryId` int NOT NULL AUTO_INCREMENT,
  `deliveryName` varchar(100) NOT NULL,
  PRIMARY KEY (`deliveryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `deliveries` */

/*Table structure for table `order-delivery` */

DROP TABLE IF EXISTS `order-delivery`;

CREATE TABLE `order-delivery` (
  `orderId` int NOT NULL,
  `deliveryId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `order-delivery` */

/*Table structure for table `order-product` */

DROP TABLE IF EXISTS `order-product`;

CREATE TABLE `order-product` (
  `orderId` int NOT NULL,
  `productId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `order-product` */

insert  into `order-product`(`orderId`,`productId`) values (1,1);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orderId` int unsigned NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `orderAddress` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `orderTime` datetime NOT NULL,
  `pay` double NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

/*Data for the table `orders` */

insert  into `orders`(`orderId`,`customerId`,`orderAddress`,`orderTime`,`pay`) values (1,1,'大运村','2022-01-10 00:00:00',120),(3,1,'thu','2022-10-14 00:00:00',1000);

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

/*Table structure for table `replys` */

DROP TABLE IF EXISTS `replys`;

CREATE TABLE `replys` (
  `replyId` int NOT NULL AUTO_INCREMENT,
  `replyText` varchar(1000) NOT NULL,
  `replyTime` datetime NOT NULL,
  `replyLike` int NOT NULL DEFAULT '0',
  `replyDislike` int NOT NULL DEFAULT '0',
  `customerId` int NOT NULL,
  `commentId` int NOT NULL,
  PRIMARY KEY (`replyId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `replys` */

insert  into `replys`(`replyId`,`replyText`,`replyTime`,`replyLike`,`replyDislike`,`customerId`,`commentId`) values (1,'这是一个回复','2022-10-23 08:00:00',0,0,1,1),(2,'这是一个回复','2022-10-23 08:00:00',0,0,1,1),(3,'这是一个回复','2022-10-23 15:46:35',0,0,1,1);

/*Table structure for table `store-ads` */

DROP TABLE IF EXISTS `store-ads`;

CREATE TABLE `store-ads` (
  `storeId` int NOT NULL,
  `adId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `store-ads` */

/*Table structure for table `store-followers` */

DROP TABLE IF EXISTS `store-followers`;

CREATE TABLE `store-followers` (
  `storeId` int NOT NULL,
  `customerId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `store-followers` */

/*Table structure for table `store-order` */

DROP TABLE IF EXISTS `store-order`;

CREATE TABLE `store-order` (
  `storeId` int NOT NULL,
  `orderId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `store-order` */

/*Table structure for table `store-product` */

DROP TABLE IF EXISTS `store-product`;

CREATE TABLE `store-product` (
  `storeId` int NOT NULL,
  `productId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `store-product` */

/*Table structure for table `stores` */

DROP TABLE IF EXISTS `stores`;

CREATE TABLE `stores` (
  `storeId` int NOT NULL AUTO_INCREMENT,
  `storeName` varchar(100) NOT NULL,
  `storeScore` double DEFAULT NULL,
  `storeFollowers` int NOT NULL DEFAULT '0',
  `storePwd` varchar(100) NOT NULL,
  PRIMARY KEY (`storeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `stores` */

insert  into `stores`(`storeId`,`storeName`,`storeScore`,`storeFollowers`,`storePwd`) values (1,'联想旗舰店',NULL,0,'123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
