/*
SQLyog Ultimate v8.32 
MySQL - 8.0.30 : Database - spring-boot-test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring-boot-test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `spring-boot-test`;

/*Table structure for table `cartinfor` */

DROP TABLE IF EXISTS `cartinfor`;

CREATE TABLE `cartinfor` (
  `customerId` int NOT NULL COMMENT '顾客序号',
  `productId` int NOT NULL COMMENT '产品序号',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `cartId` int NOT NULL AUTO_INCREMENT COMMENT '加购记录',
  PRIMARY KEY (`cartId`),
  KEY `producrIndex` (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

/*Data for the table `cartinfor` */

insert  into `cartinfor`(`customerId`,`productId`,`createTime`,`cartId`) values (1,3,'2022-10-01 16:20:45',2),(1,4,'2022-10-01 16:20:50',3);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customerId` int NOT NULL AUTO_INCREMENT COMMENT '顾客ID',
  `loginPwd` varchar(20) NOT NULL COMMENT '登录密码',
  `payPwd` varchar(20) DEFAULT NULL COMMENT '支付密码',
  `customerName` varchar(20) NOT NULL COMMENT '用户名(自定义不可重）',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer` */

insert  into `customer`(`customerId`,`loginPwd`,`payPwd`,`customerName`,`sex`,`phone`,`address`,`birthday`,`email`) values (1,'123456',NULL,'zjh',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `productId` int NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `productName` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '产品名',
  `brand` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '品牌名',
  `size` double NOT NULL COMMENT '尺寸',
  `price` double NOT NULL COMMENT '价格',
  `sales` int NOT NULL DEFAULT '0' COMMENT '销量',
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

/*Data for the table `products` */

insert  into `products`(`productId`,`productName`,`brand`,`size`,`price`,`sales`) values (1,'电脑1','联想',15.6,6000,1),(2,'电脑2','联想',15.6,7000,2),(3,'电脑3','戴尔',14,6500,10),(4,'电脑4','mac',14,8000,5);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varbinary(250) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`nickname`,`email`,`phone`,`address`,`create_time`) values (1,'ab','123',NULL,NULL,NULL,NULL,NULL),(3,'fsjhsfj','123',NULL,NULL,NULL,NULL,NULL),(4,'zjh','123',NULL,NULL,NULL,NULL,NULL),(5,'20377133','12345678',NULL,NULL,NULL,NULL,NULL),(6,'123123','145145145',NULL,NULL,NULL,NULL,NULL),(7,'123123123','123123123',NULL,NULL,NULL,NULL,NULL),(8,'123123123123','123123123',NULL,NULL,NULL,NULL,NULL),(9,'123456','123123123',NULL,NULL,NULL,NULL,NULL),(10,'jhdfjmhg','123123123',NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
