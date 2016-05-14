/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.11-log : Database - mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mobile` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mobile`;

/*Data for the table `items` */

insert  into `items`(`id`,`name`,`price`,`detail`,`pic`,`createtime`) values (1,'电脑',12.0,'幽幽',NULL,'2016-05-07 19:39:38'),(2,'手机',899.0,NULL,NULL,'2016-05-07 19:40:26'),(3,'篮球',100.0,NULL,NULL,NULL),(4,'水果',12.0,NULL,NULL,NULL),(5,'方便面',8.0,'fb',NULL,'2016-05-05 19:41:11');

/*Data for the table `orderdetail` */

insert  into `orderdetail`(`id`,`orders_id`,`items_id`,`items_num`) values (1,2,1,5),(2,2,3,2),(3,3,3,3),(4,3,4,12);

/*Data for the table `orders` */

insert  into `orders`(`id`,`user_id`,`number`,`createtime`,`note`) values (1,1,1001,'2016-05-07 18:07:52','xx'),(2,3,1002,'2016-05-07 18:08:22',NULL),(3,3,1003,'2016-05-18 18:08:33',NULL);

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`birthday`,`sex`,`address`) values (1,'李明','2016-05-04','1','广州'),(2,'王五',NULL,'1','北京'),(3,'小明','2016-05-03','0','海南'),(4,'伍小明',NULL,'1','天津'),(5,'李小明','2016-05-12','1','河南'),(8,'老毛','2016-05-07','0','老北京2'),(10,'老毛','2016-05-06','1','老北京'),(12,'hello1','2016-05-07','0','老北京2'),(16,'老毛','2016-05-07','1','老北京');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
