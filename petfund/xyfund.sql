/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.13-log : Database - xyfund
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xyfund` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xyfund`;

/*Table structure for table `t_abount` */

DROP TABLE IF EXISTS `t_abount`;

CREATE TABLE `t_abount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` mediumtext COMMENT '正文内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_abount` */

insert  into `t_abount`(`id`,`content`) values (1,'<p><span style=\"font-size: 48px;\"><strong><em><span style=\"text-decoration:underline;\"><span style=\"color: rgb(255, 0, 0);\">这个是仁爱基金</span></span></em></strong></span><br/></p>');

/*Table structure for table `t_access` */

DROP TABLE IF EXISTS `t_access`;

CREATE TABLE `t_access` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` longblob COMMENT '访问量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_access` */

/*Table structure for table `t_admin_login_log` */

DROP TABLE IF EXISTS `t_admin_login_log`;

CREATE TABLE `t_admin_login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '登录人id',
  `login_date` datetime(6) DEFAULT NULL COMMENT '登陆时间',
  `username` varchar(50) DEFAULT NULL COMMENT '登陆人账户',
  `realname` varchar(50) DEFAULT NULL COMMENT '登陆人真实姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin_login_log` */

insert  into `t_admin_login_log`(`id`,`user_id`,`login_date`,`username`,`realname`) values (1,NULL,'2016-08-09 09:38:01.897000',NULL,NULL),(2,NULL,'2016-08-09 09:47:21.897000',NULL,NULL),(3,NULL,'2016-08-09 09:47:31.795000',NULL,NULL),(4,NULL,'2016-08-09 10:06:58.272000',NULL,NULL),(5,NULL,'2016-08-09 10:20:32.258000',NULL,NULL),(6,9,'2016-08-09 10:23:13.199000',NULL,NULL),(7,9,'2016-08-09 10:40:03.930000','555',NULL),(8,9,'2016-08-09 10:59:39.768000','555','456'),(9,9,'2016-08-09 11:06:09.098000','555','456'),(10,9,'2016-08-09 11:07:02.234000','555','456'),(11,9,'2016-08-09 11:07:13.384000','555','456'),(12,1,'2016-04-05 00:00:00.000000','1','1'),(13,1,'2016-08-09 11:07:13.384000',NULL,NULL),(14,NULL,'2016-08-09 11:07:13.384000',NULL,NULL),(15,NULL,'2016-08-09 11:07:13.384000',NULL,NULL),(16,NULL,'2016-08-09 11:07:13.384000',NULL,NULL),(17,NULL,'2016-08-09 11:07:13.384000',NULL,NULL),(18,NULL,'2016-08-09 11:07:13.384000',NULL,NULL),(19,NULL,'2016-08-09 11:07:13.384000',NULL,NULL),(20,NULL,'2016-08-09 11:07:13.384000',NULL,NULL),(21,NULL,'2016-08-09 11:07:13.384000',NULL,NULL),(22,NULL,'2016-08-09 11:07:13.384000',NULL,NULL),(23,9,'2016-08-09 13:53:21.856000','555','456'),(24,9,'2016-08-09 15:37:10.648000','555','456'),(25,9,'2016-08-09 17:11:40.178000','555','456'),(26,9,'2016-08-10 09:56:40.658000','555','456'),(27,9,'2016-08-10 10:10:18.909000','555','456'),(28,9,'2016-08-10 10:10:36.149000','555','456'),(29,9,'2016-08-10 11:23:06.181000','555','456'),(30,9,'2016-08-10 11:35:42.034000','555','456'),(31,9,'2016-08-10 13:48:06.261000','555','456'),(32,9,'2016-08-10 14:53:57.624000','555','456'),(33,9,'2016-08-10 15:52:06.391000','555','456'),(34,9,'2016-08-10 16:26:54.015000','555','456'),(35,9,'2016-08-10 16:42:00.642000','555','456'),(36,9,'2016-08-10 16:46:16.650000','555','456'),(37,9,'2016-08-10 17:58:29.602000','555','456'),(38,9,'2016-08-11 09:18:06.458000','555','456'),(39,9,'2016-08-11 09:32:43.107000','555','456'),(40,9,'2016-08-11 10:30:20.917000','555','456'),(41,9,'2016-08-11 11:25:06.116000','555','456'),(42,9,'2016-08-11 13:18:20.711000','555','456'),(43,9,'2016-08-11 15:06:19.386000','555','456'),(44,9,'2016-08-11 15:41:35.261000','555','456'),(45,9,'2016-09-09 09:37:54.293000','555','456'),(46,9,'2016-11-01 09:27:41.922000','555','456'),(47,9,'2016-11-01 09:46:56.412000','555','456'),(48,9,'2016-11-01 09:50:04.176000','555','456'),(49,9,'2016-11-01 09:54:42.188000','555','456'),(50,9,'2016-11-01 10:15:58.160000','555','456'),(51,9,'2016-11-01 10:16:05.953000','555','456'),(52,9,'2016-12-07 11:17:06.173000','555','456'),(53,9,'2016-12-07 11:28:14.735000','555','456'),(54,9,'2016-12-07 14:24:19.310000','555','456'),(55,9,'2016-12-12 10:56:44.398000','555','456'),(56,9,'2016-12-22 15:10:53.940000','555','456'),(57,9,'2016-12-28 09:14:11.246000','555','小王'),(58,9,'2016-12-30 20:51:03.387000','555','小王'),(59,9,'2016-12-30 21:38:48.561000','555','小王'),(60,9,'2016-12-31 14:38:14.445000','555','小王'),(61,9,'2016-12-31 16:32:55.729000','555','小王'),(62,9,'2016-12-31 16:37:50.600000','555','小王'),(63,9,'2016-12-31 16:49:21.363000','555','小王'),(64,9,'2016-12-31 16:54:33.258000','555','小王'),(65,9,'2017-01-02 12:32:55.086000','555','小王'),(66,9,'2017-01-02 16:18:45.365000','555','小王'),(67,9,'2017-01-03 07:06:36.207000','555','小王'),(68,9,'2017-01-03 07:13:05.852000','555','小王'),(69,9,'2017-01-03 07:16:35.749000','555','小王'),(70,9,'2017-01-20 22:43:45.423000','555','小王'),(71,9,'2017-02-17 09:35:42.691000','555','小王');

/*Table structure for table `t_contribution` */

DROP TABLE IF EXISTS `t_contribution`;

CREATE TABLE `t_contribution` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) NOT NULL COMMENT '被捐信息id 可是患儿或志愿者',
  `money` decimal(16,2) DEFAULT NULL COMMENT '捐款金额',
  `name` varchar(20) DEFAULT NULL COMMENT '捐款人姓名',
  `tel` varchar(15) DEFAULT NULL COMMENT '捐款人手机号',
  `pay_type` int(1) DEFAULT NULL COMMENT '支付方式 1:支付宝 2:微信',
  `status` int(1) DEFAULT NULL,
  `contribution_type` int(1) DEFAULT NULL COMMENT '被捐人类型 1:患儿 2:志愿者',
  `info_name` varchar(20) DEFAULT NULL COMMENT '被捐人姓名',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` date DEFAULT NULL COMMENT '捐助时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `t_contribution` */

insert  into `t_contribution`(`id`,`info_id`,`money`,`name`,`tel`,`pay_type`,`status`,`contribution_type`,`info_name`,`user_id`,`create_time`) values (2,1,'1.00','11','1',1,1,1,'1',1,'1995-05-11'),(8,98,'20.00','456','111222',1,1,1,'筹款',9,'2016-08-11'),(9,98,'20.00','456','111222',1,1,1,'筹款',9,'2016-08-11'),(10,98,'20.00','456','111222',1,1,1,'筹款',9,'2016-08-11'),(11,98,'20.00','456','111222',1,1,1,'筹款',9,'2016-08-11'),(15,93,'20.00','456','2147483647',1,1,1,'1',9,'2016-08-11'),(16,105,'2010000.00','456','15620942728',1,1,1,'轧死的付i',9,'2016-08-11'),(17,101,'20.00','456','15620942728',1,1,1,'iusahdioua',9,'2016-08-11');

/*Table structure for table `t_dictionary` */

DROP TABLE IF EXISTS `t_dictionary`;

CREATE TABLE `t_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `code` varchar(30) DEFAULT NULL COMMENT '编码',
  `type` varchar(10) DEFAULT NULL COMMENT '类型',
  `pcode` varchar(30) DEFAULT NULL COMMENT '上级编码',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `is_other` tinyint(1) DEFAULT NULL COMMENT '是否是其他信息类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_dictionary` */

insert  into `t_dictionary`(`id`,`name`,`code`,`type`,`pcode`,`status`,`is_other`) values (1,'牵头救助',NULL,'service',NULL,1,NULL),(2,'筹资',NULL,'service',NULL,1,NULL),(3,'其他公益服务',NULL,'service',NULL,1,1),(4,'医学和护理',NULL,'skill',NULL,1,NULL),(5,'美工设计',NULL,'skill',NULL,1,NULL),(6,'其他',NULL,'skill',NULL,1,1);

/*Table structure for table `t_fangwen` */

DROP TABLE IF EXISTS `t_fangwen`;

CREATE TABLE `t_fangwen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(50) DEFAULT NULL COMMENT '访问人数',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_fangwen` */

insert  into `t_fangwen`(`id`,`time`) values (1,'759');

/*Table structure for table `t_fengmian` */

DROP TABLE IF EXISTS `t_fengmian`;

CREATE TABLE `t_fengmian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(1) DEFAULT NULL COMMENT '封面类型',
  `url` varchar(100) DEFAULT NULL COMMENT '封面上传url地址',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_fengmian` */

insert  into `t_fengmian`(`id`,`type`,`url`) values (9,1,'../file/fengmianFile/cf48e33cd45d417e8ac536ccd4c561b7.png'),(10,2,'../file/fengmianFile/3019a861605c4b5fa4e5d6b4b6b82b62.png'),(11,3,'../file/fengmianFile/3631e51c9455473cb1603c3044e9b189.png'),(12,4,'../file/fengmianFile/241bdb34ade24fc5b7ba3cf773d0f20e.png');

/*Table structure for table `t_file` */

DROP TABLE IF EXISTS `t_file`;

CREATE TABLE `t_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '附件名称',
  `fileurl` varchar(255) DEFAULT NULL COMMENT '文件存储位置',
  `filetype` varchar(100) DEFAULT NULL COMMENT '文件类型',
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `bucket` varchar(100) DEFAULT NULL COMMENT '位置',
  `access_type` varchar(100) DEFAULT NULL COMMENT '作者、上传人',
  `file_status` tinyint(1) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '上传人id',
  `type` int(2) DEFAULT NULL COMMENT '文件类型 供申请就叫中的不同类型文件使用',
  `stuus` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=367 DEFAULT CHARSET=utf8;

/*Data for the table `t_file` */

insert  into `t_file`(`id`,`name`,`fileurl`,`filetype`,`size`,`bucket`,`access_type`,`file_status`,`user_id`,`type`,`stuus`) values (1,'123132.png','/payfile/f7094b6a4afa47fca9a5223af0c3ab63.png','image/png',76557,'','',0,13,0,NULL),(2,'123132.png','/payfile/af3a82b21f394c319599a8dd9e798a0f.png','image/png',76557,'','',0,13,0,NULL),(3,'123132.png','/payfile/5ae7d9f191764e24920b5448cd652204.png','image/png',76557,'','',0,13,0,NULL),(5,'123132.png','/payfile/dc080f20566e43abba74feae645a419a.png','image/png',76557,'','',0,13,0,NULL),(6,'123132.png','/payfile/3fa9189850dc4d918737f34f0c157066.png','image/png',76557,'','',0,13,0,NULL),(7,'123132.png','/payfile/cad8ff69b0b54b0db98e795abe1848e6.png','image/png',76557,'','',0,13,0,NULL),(8,'123132.png','/payfile/2cfb7214eb4746218b976a9099c7e12c.png','image/png',76557,'','',0,13,0,NULL),(9,'123132.png','/payfile/37fa6f8d46914a56923123d1377a5ad7.png','image/png',76557,'','',0,13,0,NULL),(10,'123132.png','/payfile/383613e6a4df4b5eb6ccb05dfbc9e496.png','image/png',76557,'','',0,13,0,NULL),(11,'123132.png','/payfile/b3fc14e3b3854ab2b24c53d670d16aa0.png','image/png',76557,'','',0,13,0,NULL),(12,'123132.png','/payfile/2ecd9f6ce18044e6a5050d7b3b698235.png','image/png',76557,'','',0,13,0,NULL),(13,'123132.png','/payfile/8cf373515d6542acb46a0f8376f7fd55.png','image/png',76557,'','',0,13,0,NULL),(14,'123132.png','/payfile/2b1df68d776a4ab1ba14785808b05f08.png','image/png',76557,'','',0,2,0,NULL),(15,'123132.png','/payfile/0a8f76e6a6ae4ce0b9680e4f46037eab.png','image/png',76557,'','',0,13,0,NULL),(16,'123132.png','/helpFile/a6eb29a6463148f8993b5cba487496b0.png','image/png',76557,'','',0,NULL,0,NULL),(17,'123132.png','/helpFile/d9ad5db1f387473081b133eb0858ea64.png','image/png',76557,'','',0,NULL,0,NULL),(19,'123132.png','/helpFile/f653e44f4b0342609ce0e9ac1cfa1d14.png','image/png',76557,'','',0,NULL,0,NULL),(20,'123132.png','/file/helpFile/9100d501624a426d80cb839eb13206a8.png','image/png',76557,'','',0,NULL,0,NULL),(21,'123132.png','/helpFile/e9f464b702444c7ba9993bc1c769170e.png','image/png',76557,'','',0,NULL,0,NULL),(22,'123132.png','/helpFile/0f01d4e225bd4b378891ad7e80005db1.png','image/png',76557,'','',0,NULL,0,NULL),(23,'网络营销.jpg','/file/postulantFile/df6e5e00bb1e427f856dc27b4aa69062.jpg','image/jpeg',119568,'','',0,14,0,NULL),(24,'网络营销.jpg','/file/postulantFile/b45f849d061c4645b63632f89b34ebaa.jpg','image/jpeg',119568,'','',0,14,0,NULL),(29,'网络营销.jpg','/file/postulantFile/bfec77e42de14b0f8f0b3649fd7dec39.jpg','image/jpeg',119568,'','',0,14,0,NULL),(30,'网络营销.jpg','/file/postulantFile/700739a28bb64081aa334267ecd064ae.jpg','image/jpeg',119568,'','',0,14,0,NULL),(31,'网络营销.jpg','/file/postulantFile/c9b7c35f4cb14f949b1f454b81966375.jpg','image/jpeg',119568,'','',1,14,0,NULL),(32,'123132.png','/file/helpFile/e3041132ecb442f682915ce094c3e136.png','image/png',76557,'','',0,NULL,0,NULL),(34,'123132.png','/file/helpFile/4779052636264d16b29dd8b1c5335918.png','image/png',76557,'','',0,NULL,0,NULL),(35,'123132.png','/file/helpFile/db14162e39a4424dbbf7fb5622c32b36.png','image/png',76557,'','',0,NULL,0,NULL),(36,'123132.png','/file/helpFile/c25bb47318384418a93e65ad4b926601.png','image/png',76557,'','',0,NULL,0,NULL),(37,'123132.png','/file/helpFile/700f863a6e0b4d24a0f6ccf07f6c9bf3.png','image/png',76557,'','',0,NULL,0,NULL),(38,'123132.png','/file/helpFile/082b6a0ef90d41dbb869b87b6a5131bd.png','image/png',76557,'','',0,NULL,0,NULL),(39,'123132.png','/file/linkFile/e56de282a8fc451884f5cf109fb07172.png','image/png',76557,'','',0,NULL,0,NULL),(40,'123132.png','/file//helpFile/f0b37a14999f404ab18c0e2960be51a2.png','image/png',76557,'','',0,NULL,0,NULL),(41,'123132.png','/file//helpFile/85c3dd7dd97d43fd84f80c9acef83240.png','image/png',76557,'','',0,NULL,0,NULL),(42,'123132.png','/file//helpFile/40de035d390541d390bfe3c1278e1f47.png','image/png',76557,'','',0,NULL,0,NULL),(43,'123132.png','/file/file/helpFile/fd290591c27e48a28b44664e8d1f6715.png','image/png',76557,'','',0,NULL,0,NULL),(44,'123132.png','/file//helpFile/4b19f214687c4c3295e98960356b0154.png','image/png',76557,'','',0,NULL,0,NULL),(45,'123132.png','/file/helpFile/b28e1dc9664e4a05a23685d6bb6b4801.png','image/png',76557,'','',0,NULL,0,NULL),(46,'123132.png','/file/helpFile/f6ab38fc70144fc0b9d251c89ee4bebb.png','image/png',76557,'','',0,NULL,0,NULL),(48,'123132.png','/file/helpFile/ccfd8fa67ab84ee2b95420f30ec9249f.png','image/png',76557,'','',0,NULL,0,NULL),(50,'123132.png','/file/helpFile/03e959476e1d4674b64af6efb7863a80.png','image/png',76557,'','',0,NULL,0,NULL),(52,'123132.png','/file/helpFile/528747338c49485cbc37cdbc2f414e10.png','image/png',76557,'','',0,NULL,0,NULL),(54,'123132.png','/file/helpFile/39bccd526b12416e94d04ebe7cfe8ef0.png','image/png',76557,'','',0,NULL,0,NULL),(55,'123132.png','/file/helpFile/f6a4aae946314f6caf499c8d49d38207.png','image/png',76557,'','',0,NULL,0,NULL),(56,'123132.png','/file/helpFile/0c28869b0aea4e07951ca944fe507af4.png','image/png',76557,'','',0,NULL,0,NULL),(58,'123132.png','/file/helpFile/87a18f9610dc4ea082e683b160f882a4.png','image/png',76557,'','',0,NULL,0,NULL),(59,'123132.png','/file/helpFile/87a18f9610dc4ea082e683b160f882a4.png','image/png',76557,'','',0,NULL,0,NULL),(60,'123132.png','/file/helpFile/87a18f9610dc4ea082e683b160f882a4.png','image/png',76557,'','',0,NULL,0,NULL),(61,'123132.png','/file/helpFile/f27656a2589b432581449ad56a9ed1ce.png','image/png',76557,'','',0,NULL,0,NULL),(62,'123132.png','../file/helpFile/66671fb47b35432db9dc361703caa994.png','image/png',76557,'','',0,NULL,0,NULL),(63,'123132.png','/file/helpFile/525768f609c945e1b177545472166b03.png','image/png',76557,'','',0,NULL,0,NULL),(64,'123132.png','/file/helpFile/37b6b567dc4541b182af83d144bbbbaa.png','image/png',76557,'','',0,NULL,0,NULL),(65,'123132.png','/file/helpFile/af800090a3fc43e9a58716cd6cf224ee.png','image/png',76557,'','',0,NULL,0,NULL),(66,'123132.png','/file/helpFile/ec11b15eef72424bb2c9eb37418ac9a4.png','image/png',76557,'','',0,NULL,0,NULL),(67,'123132.png','/file/helpFile/1839615d99914746aab605a192c698be.png','image/png',76557,'','',0,NULL,0,NULL),(68,'123132.png','/file/helpFile/00607748a0444240aee50fddf895ea3c.png','image/png',76557,'','',0,NULL,0,NULL),(69,'123132.png','/file/helpFile/32899761f0ae46939e09f5e89ebd8f51.png','image/png',76557,'','',0,NULL,0,NULL),(70,'123132.png','/file/helpFile/295b428bda274d308545e3bf077724c2.png','image/png',76557,'','',0,NULL,0,NULL),(71,'123132.png','/file/helpFile/34ccddd0e9d440dbab720d39f745459a.png','image/png',76557,'','',0,NULL,0,NULL),(72,'123132.png','/file/helpFile/951a9b055a2940788fd09c6b2a5857e7.png','image/png',76557,'','',0,NULL,0,NULL),(73,'123132.png','/file/helpFile/3607bce0553742428721d6c29ff9c038.png','image/png',76557,'','',0,NULL,0,NULL),(74,'123132.png','/file/helpFile/a3339e0cab13490bbd3c6e7d8fd8b90f.png','image/png',76557,'','',0,NULL,0,NULL),(75,'123132.png','/file/helpFile/09863f9f41694801a6c79a08f2e5095e.png','image/png',76557,'','',0,NULL,0,NULL),(76,'123132.png','/file/helpFile/fc9b5696f36c461dbd573c580d2800f3.png','image/png',76557,'','',0,NULL,0,NULL),(77,'123132.png','/file/helpFile/53321b5ea79f49b0afc207f99ec062e5.png','image/png',76557,'','',0,NULL,0,NULL),(78,'123132.png','/file/helpFile/bd2e2da743d34171bce1b2a4c126865c.png','image/png',76557,'','',0,NULL,0,NULL),(79,'123132.png','/file/helpFile/e098f05e1dff41a7895215420c95e33f.png','image/png',76557,'','',0,NULL,0,NULL),(80,'123132.png','/file/helpFile/ce260ef3f5f04722979efdf246d431d3.png','image/png',76557,'','',0,NULL,0,NULL),(81,'123132.png','/file/helpFile/94186f4f99e0451a814f9989032c8e23.png','image/png',76557,'','',0,NULL,0,NULL),(82,'123132.png','/file/helpFile/316917e7bbb848f08a1b07ac89a22c33.png','image/png',76557,'','',0,NULL,0,NULL),(83,'123132.png','../file/fengmianFile/711dacc1cae444a296027e56fbf50b6a.png','image/png',76557,'','',0,NULL,1,NULL),(124,'123132.png','/file/helpFile/c3988209ed84410391d802b8dcdbfced.png','image/png',76557,'','',0,NULL,0,NULL),(125,'123132.png','/file/helpFile/afe095ff717743dcad7414b4c46241ae.png','image/png',76557,'','',0,NULL,0,NULL),(126,'123132.png','/file/helpFile/df4273bcf64e42e8b97dc25dd24d9eac.png','image/png',76557,'','',0,NULL,0,NULL),(127,'123132.png','../file/helpFile/b5c2c5c7f4254145910739a207a58f12.png','image/png',76557,'','',0,NULL,0,NULL),(128,'123132.png','../file/helpFile/45733debc0e34def8ae7c4c60d6b13b8.png','image/png',76557,'','',0,NULL,0,NULL),(129,'123132.png','../file/helpFile/578b74d25c194a9081daa9b935e66c93.png','image/png',76557,'','',0,NULL,0,NULL),(130,'123132.png','../file/helpFile/846ae7408e74400db978f5248661668f.png','image/png',76557,'','',0,NULL,0,NULL),(131,'123132.png','../file/helpFile/3d5282fc751342e19d7d7c2605570788.png','image/png',76557,'','',0,NULL,0,NULL),(132,'123132.png','../file/helpFile/28a67e4ef91a4680957feb2e5f2800fb.png','image/png',76557,'','',0,NULL,0,NULL),(133,'123132.png','../file/helpFile/8e8563f2b8894809a298ada1fb1df6a1.png','image/png',76557,'','',0,NULL,0,NULL),(134,'123132.png','../file/helpFile/b6faf9ba2b054029ad826b398faf55e1.png','image/png',76557,'','',0,NULL,0,NULL),(135,'123132.png','../file/helpFile/e10e77f93a6c44388f3dd2b176a43830.png','image/png',76557,'','',0,NULL,0,NULL),(136,'123132.png','../file/helpFile/c3b94df8a5204b6b8dde1074f1aa33b5.png','image/png',76557,'','',0,NULL,0,NULL),(137,'123132.png','../file/helpFile/a4e219f715d44eee97b14a95a4718e46.png','image/png',76557,'','',0,NULL,0,NULL),(138,'123132.png','../file/helpFile/f505d7c23efb4ee3a0c3b0ceb8f91ed8.png','image/png',76557,'','',0,NULL,0,NULL),(139,'123132.png','../file/helpFile/f98979598d144c658fabee46eefcfb4c.png','image/png',76557,'','',0,NULL,0,NULL),(140,'123132.png','../file/helpFile/d64e0e8ad2614a7794d2f92433368dc0.png','image/png',76557,'','',0,NULL,0,NULL),(141,'123132.png','../file/helpFile/e46d9274449842ae82efa172e9e2d9a9.png','image/png',76557,'','',0,NULL,0,NULL),(142,'123132.png','../file/helpFile/efbc8b2f6daa4d43aaaaff478b567d2e.png','image/png',76557,'','',0,NULL,0,NULL),(143,'123132.png','../file/helpFile/d9e9f04e8f7a4f8c851b43302a048200.png','image/png',76557,'','',0,NULL,0,NULL),(144,'123132.png','../file/helpFile/790f513169174c5fb43ee5ab86ed2be3.png','image/png',76557,'','',0,NULL,0,NULL),(148,'123132.png','../file/helpFile/1a03f4a0addc4d75b1545a4f4ec79f3a.png','image/png',76557,'','',0,NULL,0,NULL),(149,'123132.png','../file/helpFile/82489dfbeb3b4ba7a2f2346009f66aab.png','image/png',76557,'','',0,NULL,0,NULL),(150,'123132.png','../file/helpFile/087f022ee43a44838842ab1f75e7985b.png','image/png',76557,'','',0,NULL,0,NULL),(151,'123132.png','../file/helpFile/fc4ae169fb9e424a84fc37e0de37b013.png','image/png',76557,'','',0,NULL,0,NULL),(152,'123132.png','../file/helpFile/371b18a4f3074b41a3fb8a7bc1785817.png','image/png',76557,'','',0,NULL,0,NULL),(153,'QQ截图20160804161634.png','../file/helpFile/7c1188dccf314f859706c9248af2f8e4.png','image/png',282853,'','',0,NULL,0,NULL),(154,'123132.png','../file/helpFile/37896b93a64b4e8cb7982173a85f616a.png','image/png',76557,'','',0,NULL,0,NULL),(155,'123132.png','../file/helpFile/18181147fc9042e488f434e913b8ba50.png','image/png',76557,'','',0,NULL,0,NULL),(156,'123132.png','../file/helpFile/95c4b296875d4f7fb6e8f34724c0a116.png','image/png',76557,'','',0,NULL,0,NULL),(158,'123132.png','../file/helpFile/dcb4d92467b240cea381fbedb980d40d.png','image/png',76557,'','',0,NULL,0,NULL),(159,'QQ截图20160804161634.png','../file/helpFile/dff32bb2263645bd80bd1272be627070.png','image/png',282853,'','',0,NULL,0,NULL),(160,'123132.png','../file/helpFile/014f7933653a4e71910d87927f801161.png','image/png',76557,'','',0,NULL,0,NULL),(161,'QQ截图20160804161634.png','../file/helpFile/e040eb3c81214df283e6304617a49922.png','image/png',282853,'','',0,NULL,0,NULL),(162,'123132.png','../file/helpFile/fa5632bd44d44d99ad039cd3c18f3ec6.png','image/png',76557,'','',0,NULL,0,NULL),(163,'123132.png','../file/helpFile/a2e66b1b08ff428ab5bafbdb083cd207.png','image/png',76557,'','',0,NULL,0,NULL),(164,'123132.png','../file/helpFile/7e2f80a0d7f14af68b3da8a92a55e989.png','image/png',76557,'','',0,NULL,0,NULL),(165,'123132.png','../file/helpFile/0a06a1dc4df1439e86d4c512341d690f.png','image/png',76557,'','',0,NULL,0,NULL),(166,'123132.png','../file/helpFile/41c9962735b64c998a02b11f5fb2a8ca.png','image/png',76557,'','',0,NULL,0,NULL),(167,'123132.png','../file/helpFile/3098cdb09d5c40efbfff772735d3a442.png','image/png',76557,'','',0,NULL,0,NULL),(168,'QQ截图20160804161634.png','../file/helpFile/29d4b3e3a9204ebfb461aa6b4457f393.png','image/png',282853,'','',0,NULL,0,NULL),(190,'123132.png','../file/helpFile/88b97631a4a84ca3a781e9c5e9d05547.png','image/png',76557,'','',0,NULL,0,NULL),(191,'QQ截图20160804161634.png','../file/helpFile/6b08e8c929dd4024891202a4f1cf7027.png','image/png',282853,'','',0,NULL,0,NULL),(199,'123132.png','../file/helpFile/3c3d32b1e098423fb27245f1ffa26282.png','image/png',76557,'','',0,NULL,0,NULL),(200,'123132.png','/file/linkFile/c6347ff29c2847a09a61b281c08568bd.png','image/png',76557,'','',0,NULL,0,NULL),(201,'123132.png','/file/linkFile/18183d217d9f40f2a119966ba5836185.png','image/png',76557,'','',0,NULL,0,NULL),(202,'QQ截图20160804161634.png','/file/linkFile/a2969c78ad5f40089d00e3591e07d17a.png','image/png',282853,'','',0,NULL,0,NULL),(203,'123132.png','/file/linkFile/81c9c1f00ee24777b354cffc1ec716bd.png','image/png',76557,'','',0,NULL,0,NULL),(204,'QQ截图20160804161634.png','/file/linkFile/e4346fbb135e405aa3918dee848ff8ea.png','image/png',282853,'','',0,NULL,0,NULL),(205,'123132.png','/file/linkFile/fb32e2f43e1d4b48ae95c6d968ff53c4.png','image/png',76557,'','',0,NULL,0,NULL),(206,'QQ截图20160804161634.png','/file/linkFile/f242d47270b140698bc78d0dda3ea383.png','image/png',282853,'','',0,NULL,0,NULL),(207,'123132.png','../file/helpFile/64edc1bd832e4d248fd050515ada5205.png','image/png',76557,'','',0,NULL,0,NULL),(208,'QQ截图20160804161634.png','../file/helpFile/8b8ad071a5074f1fac297648d1d64682.png','image/png',282853,'','',0,NULL,0,NULL),(209,'123132.png','../file/helpFile/ddac88063dcb4b5ea9098207b650f7b8.png','image/png',76557,'','',0,NULL,0,NULL),(210,'123132.png','../file/helpFile/9341417719744628a457246218c8e7fa.png','image/png',76557,'','',0,NULL,0,NULL),(211,'123132.png','../file/helpFile/56509e258b5448f48b30fead6ca0c08b.png','image/png',76557,'','',0,NULL,0,NULL),(212,'123132.png','../file/helpFile/1b63adda0a66464698d43106ba1d7edf.png','image/png',76557,'','',0,NULL,0,NULL),(213,'123132.png','../file/helpFile/c02094dc449047cfb4d334bf255f2879.png','image/png',76557,'','',0,NULL,0,NULL),(214,'QQ截图20160804161634.png','../file/helpFile/d7442a42e99049728b1b50c7f1d11a6c.png','image/png',282853,'','',0,NULL,0,NULL),(215,'QQ截图20160804161634.png','../file/helpFile/c6eefbcbfc984d46b1d905860b5ea269.png','image/png',282853,'','',0,NULL,0,NULL),(216,'QQ截图20160804161634.png','../file/helpFile/9b3fc23c3c9147d0a846f4360d784daf.png','image/png',282853,'','',0,NULL,0,NULL),(229,'123132.png','../file/helpFile/c7284acaf79a4612b4a2f26af2fc1746.png','image/png',76557,'','',0,NULL,0,NULL),(230,'123132.png','../file/helpFile/ee974ae2b4404175969498e7b5ae99c1.png','image/png',76557,'','',0,NULL,0,NULL),(231,'123132.png','../file/helpFile/563ddb4c71ee485989019e2e56fbb82e.png','image/png',76557,'','',0,NULL,0,NULL),(232,'123132.png','../file/helpFile/d98db8f195dd4facbcef6fa43ae3ecf7.png','image/png',76557,'','',0,NULL,0,NULL),(233,'123132.png','../file/helpFile/e74e6a5895244d62becbbff637a43193.png','image/png',76557,'','',0,NULL,0,NULL),(234,'123132.png','../file/helpFile/bc40ed45a60d4fd39c12954792578a61.png','image/png',76557,'','',0,NULL,0,NULL),(235,'123132.png','../file/helpFile/13eda3b6bc714df2a8c2ddc8c49661a5.png','image/png',76557,'','',0,NULL,0,NULL),(236,'123132.png','../file/helpFile/e50ad15edb2a443c9503c4b4011fc666.png','image/png',76557,'','',0,NULL,0,NULL),(237,'123132.png','../file/helpFile/cdc50472d10d4bf692313b5e31fb1400.png','image/png',76557,'','',0,NULL,0,NULL),(238,'123132.png','/file/linkFile/a3e944bbec5d44e8848dc47aef14e0f1.png','image/png',76557,'','',0,NULL,0,NULL),(239,'123132.png','/file/linkFile/bb5340d121e549ca931e7229c12bc0d4.png','image/png',76557,'','',0,NULL,0,NULL),(240,'123132.png','/file/linkFile/8bb47019c63f4fd783b30458d63d0fd4.png','image/png',76557,'','',0,NULL,0,NULL),(241,'123132.png','/file/linkFile/5755bd7108a0404b8b65fef4e5a44233.png','image/png',76557,'','',0,NULL,0,NULL),(242,'123132.png','/file/linkFile/996d474339fc4291b9978b3c7860e3e4.png','image/png',76557,'','',0,NULL,0,NULL),(243,'123132.png','/file/linkFile/9561ffa77b49444daff07870992d23a5.png','image/png',76557,'','',0,NULL,0,NULL),(245,'123132.png','/file/linkFile/13bd45705554416c87c6b2a6648774b1.png','image/png',76557,'','',0,NULL,0,NULL),(246,'123132.png','/file/linkFile/9e5b8d6e043343c6905c51c9f288e17f.png','image/png',76557,'','',0,NULL,0,NULL),(248,'123132.png','../file/helpFile/3eb8cae3c7f74d3b8f29fc0e4a28233c.png','image/png',76557,'','',0,NULL,0,NULL),(249,'QQ截图20160804161634.png','../file/helpFile/0ac5f381c8bd47af837f2d2cb376f091.png','image/png',282853,'','',0,NULL,0,NULL),(250,'123132.png','../file/helpFile/d1bd2ebf0a5c4deaa2e78e0a98f44ba2.png','image/png',76557,'','',0,NULL,0,NULL),(251,'123132.png','../file/helpFile/51b9ac5b3ed0427fb05089cec1ca06c8.png','image/png',76557,'','',0,NULL,0,NULL),(253,'123132.png','../file/helpFile/85d80be427e54ffdbe99ac8773f4581e.png','image/png',76557,'','',0,NULL,0,NULL),(286,'123132.png','../file/helpFile/adfd065d0cb7453a9d4365ec551da075.png','image/png',76557,'','',0,NULL,0,NULL),(287,'QQ截图20160804161634.png','../file/helpFile/f1ccb02c03af46afb14dd6d67808f057.png','image/png',282853,'','',0,NULL,0,NULL),(288,'123132.png','../file/helpFile/b371e0f190df405081a381de785436a9.png','image/png',76557,'','',0,NULL,0,NULL),(289,'QQ截图20160804161634.png','../file/helpFile/c4adaaf91e6c4cd0a3d9344bc11d76b0.png','image/png',282853,'','',0,NULL,0,NULL),(290,'123132.png','../file/helpFile/8a5667d9bf6e4d52b90e1afd5b43d4b0.png','image/png',76557,'','',0,NULL,0,NULL),(291,'QQ截图20160804161634.png','../file/helpFile/62d5aed6f72b4bc1a3f0e3bf886d098e.png','image/png',282853,'','',0,NULL,0,NULL),(292,'QQ截图20160804161634.png','../file/helpFile/8c381e3ca35446319b35803df5a0a023.png','image/png',282853,'','',0,NULL,0,NULL),(293,'QQ截图20160804161634.png','../file/helpFile/c594590bc9f744f3b18a8baa1a5a54d5.png','image/png',282853,'','',0,NULL,0,NULL),(294,'QQ截图20160804161634.png','../file/helpFile/543caed47e504eb59d690b51b1545239.png','image/png',282853,'','',0,NULL,0,NULL),(295,'QQ截图20160804161634.png','../file/helpFile/24c89653978b43cc9e4d8d1ed96fe54d.png','image/png',282853,'','',0,NULL,0,NULL),(296,'QQ截图20160804161634.png','../file/helpFile/44e474ca210f43ecb4a2bba1f850dd51.png','image/png',282853,'','',0,NULL,0,NULL),(297,'123132.png','../file/helpFile/61097b8a7c754c7eb93a41911bbf41ae.png','image/png',76557,'','',0,NULL,0,NULL),(298,'QQ截图20160804161634.png','../file/helpFile/d13af62206c6402d982dedf902c29d4a.png','image/png',282853,'','',0,NULL,0,NULL),(299,'QQ截图20160804161634.png','../file/helpFile/c5c54a92af1b4012ac798f39a61f9849.png','image/png',282853,'','',0,NULL,0,NULL),(300,'QQ截图20160804161634.png','../file/helpFile/8e95ec43aeab4b17a10e5c7cc6ed38fa.png','image/png',282853,'','',0,NULL,0,NULL),(301,'123132.png','../file/helpFile/f2ed303e0b6745cc9c8862d89cff9dd6.png','image/png',76557,'','',0,NULL,0,NULL),(302,'QQ截图20160804161634.png','../file/helpFile/26e21f22ce414e42b224120ec52ebe23.png','image/png',282853,'','',0,NULL,0,NULL),(303,'QQ截图20161101092845.png','../file/helpFile/6275f6b9591e447c9651654891f01eb3.png','image/png',45475,'','',0,NULL,0,NULL),(304,'QQ截图20161101092845.png','../file/fengmianFile/930ea88f42ab43da909d00fc1aa332ad.png','image/png',45475,'','',0,9,1,NULL),(305,'QQ截图20161101092845.png','../file/fengmianFile/a205e13d8034417883e63379a6b35c9b.png','image/png',45475,'','',0,9,2,NULL),(306,'QQ截图20161101092845.png','../file/fengmianFile/20d163e625874a20ae436085188cc55e.png','image/png',45475,'','',0,9,3,NULL),(307,'QQ截图20161101092845.png','../file/fengmianFile/e2c2891f70a4483b9f90311b1320f86c.png','image/png',45475,'','',0,9,4,NULL),(308,'QQ截图20161101092845.png','../file/fengmianFile/cb4645f8ba9d4bee96f1933a08041df9.png','image/png',45475,'','',0,9,5,NULL),(309,'QQ截图20161101092845.png','../file/fengmianFile/c451bfad8bf9448d9acaa648674aca9a.png','image/png',45475,'','',0,9,6,NULL),(310,'QQ截图20161101092845.png','../file/helpFile/87b572842443464098597e6fb7714302.png','image/png',45475,'','',0,NULL,0,NULL),(311,'QQ截图20161222151112.png','../file/helpFile/1b644febbd984d418d7a121c05eac577.png','image/png',202454,'','',0,NULL,0,NULL),(312,'QQ截图20161222151112.png','../file/helpFile/81b164f028ba43a69851d5c02dfdd09c.png','image/png',202454,'','',0,NULL,0,NULL),(313,'QQ截图20161222151112.png','../file/helpFile/191e40a85be94e318332a396a0de4380.png','image/png',202454,'','',0,NULL,0,NULL),(314,'QQ截图20161222151112.png','../file/helpFile/6fdbe595af094b26bea27339fabb0ad6.png','image/png',202454,'','',0,NULL,0,NULL),(315,'QQ截图20161222151112.png','../file/helpFile/6e8c8bc469734f27a4898d54dc915b78.png','image/png',202454,'','',0,NULL,0,NULL),(316,'QQ截图20161222151112.png','../file/helpFile/5bfd4838c09a461ab5e67384596c46aa.png','image/png',202454,'','',0,NULL,0,NULL),(317,'QQ截图20161222160859.png','../file/helpFile/3dd5f03d8b2347079da8d99893bc8766.png','image/png',110680,'','',0,NULL,0,NULL),(318,'QQ截图20161222160859.png','../file/helpFile/19669611385945998449670746e0949b.png','image/png',110680,'','',0,NULL,0,NULL),(319,'QQ截图20161222161021.png','../file/helpFile/3ec27189f5fc43b28539f263732d32e3.png','image/png',46226,'','',0,NULL,0,NULL),(320,'QQ截图20161222161021.png','../file/helpFile/5906994351e64ae780706adcfd94806e.png','image/png',46226,'','',0,NULL,0,NULL),(321,'QQ截图20161222161021.png','../file/helpFile/553125bcd76d4fdf81aac5c401c89675.png','image/png',46226,'','',0,NULL,0,NULL),(322,'QQ截图20161222161021.png','../file/helpFile/9b181509c7dd4ad681dd3dfe106d968f.png','image/png',46226,'','',0,NULL,0,NULL),(323,'QQ截图20161222161150.png','../file/helpFile/bed0a61dea75439f9e30f2e75faa0cbb.png','image/png',147916,'','',0,NULL,0,NULL),(324,'QQ截图20161222160859.png','../file/helpFile/147a0a7aeb744557a69930dd521aac67.png','image/png',110680,'','',0,NULL,0,NULL),(325,'QQ截图20161222161021.png','../file/fengmianFile/8ae4cf1060ba4069b1cad400a98e4a85.png','image/png',46226,'','',0,9,1,NULL),(326,'QQ截图20161222161021.png','../file/fengmianFile/63e52c6db2654874b7411208c25e6681.png','image/png',46226,'','',0,9,2,NULL),(327,'QQ截图20161222161021.png','../file/fengmianFile/359947baf25c4cc8ab30fca006fe2b72.png','image/png',46226,'','',0,9,3,NULL),(328,'QQ截图20161222161021.png','../file/fengmianFile/b2b6608fa0a649daab9e507445b59252.png','image/png',46226,'','',0,9,4,NULL),(329,'QQ截图20161222161021.png','../file/fengmianFile/881fdef291d547e6985f95f02b482258.png','image/png',46226,'','',0,9,5,NULL),(330,'QQ截图20161222161021.png','../file/fengmianFile/401a6dae159f402ea6d0c777e06aa51f.png','image/png',46226,'','',0,9,6,NULL),(331,'QQ截图20161222161021.png','../file/fengmianFile/be2aa043879a40b79dc432544fd42a26.png','image/png',46226,'','',0,9,1,NULL),(332,'QQ截图20161222161021.png','../file/fengmianFile/9690870a61ac45069c6a59db7a1b798a.png','image/png',46226,'','',0,9,2,NULL),(333,'QQ截图20161222161021.png','../file/fengmianFile/45e042e360464c9fa0787f65011e8023.png','image/png',46226,'','',0,9,3,NULL),(334,'QQ截图20161222161021.png','../file/fengmianFile/1f7fca550c924f168239a9aaaad93bb4.png','image/png',46226,'','',0,9,4,NULL),(335,'QQ截图20161222161021.png','../file/fengmianFile/9c15e82fcd3643a991d4eac1d6b7763a.png','image/png',46226,'','',0,9,5,NULL),(336,'QQ截图20161222161021.png','../file/fengmianFile/cdca0ece842c4c3ba2aca6847003c72d.png','image/png',46226,'','',0,9,6,NULL),(337,'QQ截图20161230205257.png','../file/helpFile/14d051cbf55243a28ff3e4efd8ca2d3d.png','image/png',250981,'','',0,NULL,0,NULL),(338,'QQ截图20161230205241.png','../file/helpFile/1fd1691d9d6b4368beebe31080957b44.png','image/png',436690,'','',0,NULL,0,NULL),(339,'QQ截图20161230205257.png','../file/helpFile/799f7fd7e8444791acfe59fee1c34a72.png','image/png',250981,'','',0,NULL,0,NULL),(340,'QQ截图20161222160859.png','../file/helpFile/a35f2aa5bffc464cadadeebbf57fa8af.png','image/png',110680,'','',0,NULL,0,NULL),(341,'QQ截图20161230205257.png','../file/helpFile/16128de3fb4c4bc0896df226b3ab42a0.png','image/png',250981,'','',0,NULL,0,NULL),(342,'QQ截图20161222161150.png','../file/helpFile/4b596321ce534bd3ad0429e781fb8b20.png','image/png',147916,'','',0,NULL,0,NULL),(343,'QQ截图20161222161150.png','../file/helpFile/263d1b25051e4c97aac2d01db6295fb4.png','image/png',147916,'','',0,NULL,0,NULL),(344,'QQ截图20161222160859.png','../file/helpFile/820573c5070c4ca2a84259af07e81a38.png','image/png',110680,'','',0,NULL,0,NULL),(345,'QQ截图20161230205241.png','../file/helpFile/945df351a6954e3fb309c5332fddab8e.png','image/png',436690,'','',0,NULL,0,NULL),(346,'QQ截图20161222160859.png','../file/helpFile/cbde44ae63db4d7290351d686974fcf5.png','image/png',110680,'','',0,NULL,0,NULL),(347,'QQ截图20161222161150.png','../file/helpFile/29e0526b90db4f969c368b7f5b8b511d.png','image/png',147916,'','',0,NULL,0,NULL),(348,'QQ截图20161230205241.png','../file/helpFile/15366215f21d4791ac1ef750ab74aa90.png','image/png',436690,'','',0,NULL,0,NULL),(349,'QQ截图20161222160859.png','../file/helpFile/c3f309d51be74b58895469e516b19e84.png','image/png',110680,'','',0,NULL,0,NULL),(350,'QQ截图20161231164604.png','../file/helpFile/12e9270631cb4622be8832990be26aef.png','image/png',98982,'','',0,NULL,0,NULL),(351,'QQ截图20161231164618.png','../file/helpFile/72498a1e378a4e88beec50516a827e1c.png','image/png',41360,'','',0,NULL,0,NULL),(352,'QQ截图20161231164626.png','../file/helpFile/e817114d87474f97806ed877a9b7d5c2.png','image/png',72311,'','',0,NULL,0,NULL),(353,'QQ截图20161231164604.png','../file/helpFile/b06eb290eba944efbbc1ebb0a8a9d8d3.png','image/png',98982,'','',0,NULL,0,NULL),(354,'QQ截图20161231164604.png','../file/helpFile/ce82fc4578164dceac0597d5776935a3.png','image/png',98982,'','',0,NULL,0,NULL),(355,'QQ截图20161231164618.png','../file/helpFile/a91049e06f5f4c02a3f1600b8296b729.png','image/png',41360,'','',0,NULL,0,NULL),(356,'QQ截图20161231164626.png','../file/helpFile/6a0b3eb6a1b246d08da14060b9389bbe.png','image/png',72311,'','',0,NULL,0,NULL),(357,'QQ截图20161231164618.png','../file/helpFile/2bcf83969a884d26bdfb34978438a3fb.png','image/png',41360,'','',0,NULL,0,NULL),(358,'QQ截图20161231164626.png','../file/helpFile/de6b955996154603b310f062f0a4fb00.png','image/png',72311,'','',0,NULL,0,NULL),(359,'QQ截图20161231164604.png','../file/helpFile/a0ec6fe1820449bea1e29dedfc661423.png','image/png',98982,'','',0,NULL,0,NULL),(360,'QQ截图20161231164618.png','../file/helpFile/a30c14626f2a4afcb35fc4240e2d9cc5.png','image/png',41360,'','',0,NULL,0,NULL),(361,'QQ截图20161231164626.png','../file/helpFile/4cba2b374cbe42979a98f666da2212d5.png','image/png',72311,'','',0,NULL,0,NULL),(362,'QQ截图20161231164626.png','../file/helpFile/96cdfa2edec6409eb778cd973c29ca37.png','image/png',72311,'','',0,NULL,0,NULL),(363,'QQ截图20161231164604.png','../file/helpFile/c5ac3af344814d1fa3277bf214ef7890.png','image/png',98982,'','',0,NULL,0,NULL),(364,'QQ截图20161231164626.png','../file/helpFile/875a97499368451ea9fcd7ad083998b7.png','image/png',72311,'','',0,NULL,0,NULL),(365,'QQ截图20161231164618.png','../file/helpFile/8ebc8365f44e475399b7173a792abf53.png','image/png',41360,'','',0,NULL,0,NULL),(366,'QQ截图20161231164604.png','../file/helpFile/55167a0858e8444ea3e7639bb3fa8ce5.png','image/png',98982,'','',0,NULL,0,NULL);

/*Table structure for table `t_help` */

DROP TABLE IF EXISTS `t_help`;

CREATE TABLE `t_help` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '求助标题',
  `child_name` varchar(100) DEFAULT NULL COMMENT '被救助的孩子姓名,标题，病名',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `city_num` varchar(20) DEFAULT NULL COMMENT '城市',
  `money` decimal(16,2) DEFAULT NULL COMMENT '目标金额',
  `person_name` varchar(30) DEFAULT NULL COMMENT '发起人名称',
  `content` mediumtext COMMENT '详细介绍',
  `case_info` mediumtext COMMENT '病例',
  `thanks` mediumtext COMMENT '父母感言',
  `status` int(1) DEFAULT '1' COMMENT '1:正常 0:删除 2:已完成捐助',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `type` int(1) DEFAULT NULL COMMENT '求助类型 1:紧急筹款 2:将爱汇聚 3:让爱传递',
  `money_off` decimal(16,2) DEFAULT NULL COMMENT '已完成捐助的金额',
  `is_top` tinyint(1) DEFAULT NULL COMMENT '是否置顶',
  `total` int(11) DEFAULT NULL COMMENT '总计捐款人数',
  `person_id` int(11) DEFAULT NULL COMMENT '发起人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

/*Data for the table `t_help` */

insert  into `t_help`(`id`,`title`,`child_name`,`sex`,`age`,`city_num`,`money`,`person_name`,`content`,`case_info`,`thanks`,`status`,`create_time`,`type`,`money_off`,`is_top`,`total`,`person_id`) values (1,'125','1',1,1,'1','1.00','1','1','1','1',1,'2016-05-06 00:00:00.000000',NULL,'0.00',NULL,NULL,NULL),(2,'11','1',1,1,'1','1.00','11','1','1','1',NULL,NULL,NULL,'0.00',NULL,NULL,NULL),(3,'2','2',2,2,'2','22.00','2','2','2','2',1,'2016-07-28 00:00:00.000000',NULL,'0.00',NULL,87,NULL),(54,'1',NULL,NULL,NULL,NULL,'5.00','111','',NULL,NULL,0,'2016-08-04 00:00:00.000000',2,'0.00',0,87,14),(55,'1',NULL,NULL,NULL,NULL,'5.00','111','',NULL,NULL,0,'2016-08-04 00:00:00.000000',2,'0.00',0,87,14),(56,'2',NULL,NULL,NULL,NULL,'5.00','111','',NULL,NULL,0,'2016-08-04 00:00:00.000000',2,'0.00',0,78,14),(62,'11','1',NULL,NULL,NULL,'1.00','111','<p>1<br/></p>',NULL,NULL,1,'2016-08-05 00:00:00.000000',3,'0.00',0,87,14),(63,'123','132',NULL,NULL,NULL,'13.00','111','321<p><br/></p>',NULL,NULL,1,'2016-08-05 00:00:00.000000',3,'0.00',1,78,14),(64,'5','55',1,5,'5','5.00','pb','<p>5<br/></p>','<p>5<br/></p>','<p>5<br/></p>',0,'2016-08-05 00:00:00.000000',1,'0.00',0,78,2),(65,'4','4',2,4,'4','4.00','111','44<p><br/></p>','44<p><br/></p>','44<p><br/></p>',0,'2016-08-05 00:00:00.000000',1,'0.00',0,78,14),(66,'3','3',2,3,'3','3.00','111','3<p><br/></p>','3<p><br/></p>','3<p><br/></p>',0,'2016-08-05 00:00:00.000000',1,'0.00',0,78,14),(67,'2','2',2,2,'2','2.00','111','<p>2<br/></p>','<p>2<br/></p>','<p>2<br/></p>',0,'2016-08-05 00:00:00.000000',1,'0.00',0,78,14),(68,'1','1',1,1,'1','1.00','111','1<p><br/></p>','1<p><br/></p>','1<p><br/></p>',0,'2016-08-05 00:00:00.000000',1,'0.00',0,78,14),(69,'9','9',NULL,NULL,NULL,'9.00','111','9<p><br/></p>',NULL,NULL,3,'2016-08-05 00:00:00.000000',2,'0.00',0,78,14),(70,'8','8',NULL,NULL,NULL,'8.00','111','8<p><br/></p>',NULL,NULL,0,'2016-08-05 00:00:00.000000',2,'0.00',0,78,14),(71,'3','3',NULL,NULL,NULL,'3.00','111','3<p><br/></p>',NULL,NULL,1,'2016-08-05 00:00:00.000000',3,'0.00',0,78,14),(72,'2','2',NULL,NULL,NULL,'2.00','111','<p>2<br/></p>',NULL,NULL,3,'2016-08-05 00:00:00.000000',3,'0.00',0,78,14),(73,'1','1',NULL,NULL,NULL,'1.00','111','1<p><br/></p>',NULL,NULL,1,'2016-08-05 00:00:00.000000',3,'0.00',0,78,14),(74,'1','1',1,1,'1','1.00','pb','<p>1<br/></p>','<p>1<br/></p>','<p>1<br/></p>',0,'2016-08-09 00:00:00.000000',1,'0.00',0,87,2),(75,'1','1',1,1,'1','1.00','pb','<p>1<br/></p>','<p>1<br/></p>','<p>1<br/></p>',0,'2016-08-09 00:00:00.000000',1,'0.00',0,7878,2),(76,'1','1',1,1,'1','1.00','pb','<p>1<br/></p>','<p>1<br/></p>','<p>1<br/></p>',0,'2016-08-09 00:00:00.000000',1,'0.00',0,78,2),(77,'1','1',1,1,'1','1.00','pb','<p>1<br/></p>','<p>1<br/></p>','<p>1<br/></p>',0,'2016-08-09 00:00:00.000000',1,'0.00',0,87,2),(78,'1','1',1,1,'1','1.00','pb','','','',0,'2016-08-09 00:00:00.000000',1,'0.00',0,87,2),(79,'1','1',1,1,'1','1.00','pb','<p>1<br/></p>','<p>1<br/></p>','<p>1<br/></p>',0,'2016-08-09 00:00:00.000000',1,'0.00',0,878,2),(80,'1','1',1,1,'1','1.00','pb','','','',0,'2016-08-09 00:00:00.000000',1,'0.00',0,8,2),(81,'1','1',1,1,'1','1.00','pb','','','',0,'2016-08-09 00:00:00.000000',1,'0.00',0,77,2),(82,'1','1',NULL,NULL,NULL,'1.00','pb','',NULL,NULL,0,'2016-08-09 00:00:00.000000',2,'0.00',0,87,2),(83,'1','1',NULL,NULL,NULL,'1.00','pb','',NULL,NULL,0,'2016-08-09 00:00:00.000000',2,'0.00',0,78,2),(84,'1','1',NULL,NULL,NULL,'1.00','pb','',NULL,NULL,0,'2016-08-09 00:00:00.000000',2,'100.00',0,78,2),(85,'1','1',NULL,NULL,NULL,'1.00','pb','',NULL,NULL,0,'2016-08-09 00:00:00.000000',2,'3.00',0,87,2),(86,'1','1',1,120,NULL,'1.00','pb','',NULL,NULL,2,'2016-08-09 00:00:00.000000',1,'0.00',0,5,2),(87,'1','1',NULL,NULL,NULL,'1.00','pb','',NULL,NULL,0,'2016-08-09 00:00:00.000000',2,'2.00',0,5,2),(88,'1','1',NULL,NULL,NULL,'1.00','pb','',NULL,NULL,1,'2016-08-09 00:00:00.000000',3,'0.00',0,1,2),(89,'1','1',NULL,NULL,NULL,'1.00','pb','',NULL,NULL,1,'2016-08-09 00:00:00.000000',3,'0.00',0,1,2),(90,'123','132',1,132,'32','132.00','111','<p>132<br/></p>','<p>132<br/></p>','<p>132<br/></p>',0,'2016-08-09 00:00:00.000000',1,'0.00',0,1,14),(91,'123','132',1,132,'32','132.00','111','<p>132<br/></p>','<p>132<br/></p>','<p>132<br/></p>',0,'2016-08-09 00:00:00.000000',1,'0.00',0,1,14),(92,'123','132',1,132,'32','132.00','111','<p>132<br/></p>','<p>132<br/></p>','<p>132<br/></p>',2,'2016-08-09 00:00:00.000000',1,'0.00',0,1,14),(93,'1','1',2,1,'1','1.00','pb','<p>1<br/></p>','<p>1<br/></p>','<p>1<br/></p>',2,'2016-08-09 00:00:00.000000',1,'0.00',0,1,2),(95,'1','1',1,1,'1','1.00','111','11<p><br/></p>','11<p><br/></p>','11<p><br/></p>',0,'2016-08-09 00:00:00.000000',1,'0.00',0,1,14),(96,'1','1',NULL,NULL,NULL,'1.00','pb','<p>1</p><p><br/></p>',NULL,NULL,0,'2016-08-09 00:00:00.000000',2,'22.00',0,1,2),(97,'筹款','pb',1,1,'1','1.00','pb','<p>1<br/></p>','<p>1<br/></p>','<p>1<br/></p>',0,'2016-08-11 00:00:00.000000',1,'0.00',0,0,2),(98,'筹款测试','筹款',1,111,'22','2.00','pb','<p>123<br/></p>','<p>123<br/></p>','<p>123<br/></p>',2,'2016-08-11 00:00:00.000000',1,'80.00',0,4,2),(99,'筹款1','扫i的话',1,11,'21撒旦','3223165.00','pb','<div align=\"center\"><span style=\"text-decoration:underline;\">撒旦机貌似平静吗</span></div><p><br/></p>','<div align=\"center\"><span style=\"text-decoration:underline;\">撒旦机貌似平静吗</span></div><p><br/></p>','<div align=\"center\"><span style=\"text-decoration:underline;\">撒旦机貌似平静吗</span></div><p><br/></p>',0,'2016-08-11 00:00:00.000000',1,'0.00',0,0,2),(100,'筹款2','速度来看',1,1221,'天津','12212121.00','pb','<p>撒都i姐啊好似都i</p><p><br/></p>','<p>撒都i姐啊好似都i</p><p><br/></p>','<p>撒都i姐啊好似都i</p><p><br/></p>',0,'2016-08-11 00:00:00.000000',1,'0.00',0,0,2),(101,'0.7% 病痛缠身急需肝移植','李子墨',1,5,'北京','250000.00','pb','<p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;大家好，我叫李小雷，家住安徽省临泉县瓦店镇王庙行政村，2016年1月26日对我来说是一个不平凡的日子，我的儿子李子墨出生了，他的到来让我们整个家庭完全沉醉于喜悦当中，看着宝妈和宝宝从产房出来的那一刻，就像拥有了整个世界一样，那时就感觉我是世界上最幸福的人。</span></p>','<p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;大家好，我叫李小雷，家住安徽省临泉县瓦店镇王庙行政村，2016年1月26日对我来说是一个不平凡的日子，我的儿子李子墨出生了，他的到来让我们整个家庭完全沉醉于喜悦当中，看着宝妈和宝宝从产房出来的那一刻，就像拥有了整个世界一样，那时就感觉我是世界上最幸福的人。</span></p>','<p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;大家好，我叫李小雷，家住安徽省临泉县瓦店镇王庙行政村，2016年1月26日对我来说是一个不平凡的日子，我的儿子李子墨出生了，他的到来让我们整个家庭完全沉醉于喜悦当中，看着宝妈和宝宝从产房出来的那一刻，就像拥有了整个世界一样，那时就感觉我是世界上最幸福的人。</span></p>',1,'2016-08-11 00:00:00.000000',1,'250000.00',0,1,2),(102,'农民夫妻捐肝救子','罗浩航',2,9,'13216516651sad打扫打扫','11111.00','pb','<p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">我叫王小娟，是一位来自陕西省富平县淡村镇的农民，有两个儿子，大儿子是和前夫生的，孩子一岁多的时候丈夫因一场车祸离开了我们，如今孩子已经9岁了，很乖很听话。去年经人介绍和现在丈夫结婚，次年生下小儿子，取名罗浩航，本以为这次的婚姻可以让我幸福快乐的生活，但没有想到孩子突如其来的患病，让我们成天往返在医院和去医院路上！</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; &nbsp; \n出生40天后的罗浩航因黄疸不退去医院进行检查，医生怀疑是母乳性黄疸，经医生介绍后便停止3-4天的母乳喂养，但没有任何效果，医生建议我们带着孩子到大医院进一步检查，看着孩子一天天变黄我们格外着急，便再次带着向亲戚朋友借来的钱款直奔咸阳第二附属医院检查了肝功，结果却让我们不敢相信，在医生的讲解下我们得知孩子的病情在日益增重，便要求我们立即转院进行治疗，我们再次转到了西安儿童医院，经过各项细致的检查后，最终确诊为胆道闭锁，胆汁淤积性肝硬化Ⅱ期，需尽快进行葛西手术，听到这里我的脑子一片空白，向我们这样的农村人从来就没听说过这种病，顿时不知道该怎么办了。</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; \n&nbsp;看着乖巧听话的小浩航，我们当父母的不忍心让孩子就这样离开，他还没有感受到这个世界美好，就这样我们为了给孩子治病，贷款进行了葛西手术，切除了胆囊，但术后效果不是很理想，胆汁不能正常排出，每天打针吃激素药，整天哭闹不止，看着孩子肚子上缝合几十针的伤口，我的心都碎了，这么小就要遭受这么大的痛苦。</p><p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;孩子在住院时，奶奶因腰椎盘颈椎病也住进了医院，大儿子在家无人看管，顿时整个人都快崩溃了。就这样连夜赶回家一天一夜没有吃饭，夜里只睡了3个小时，第二天就没奶了，不够孩子吃，无奈下把家里买的一辆二手面包车也卖了。</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">自上次住了一个多月出院后，第四天凌晨，孩子突然高烧不退，又因宝宝对头孢，青霉素过敏，家里的医院又没有药，只能再次住院治疗，在各项检查后孩子被确诊为反流性胆管炎。经过一段时间的治疗于近日进行B超弹性变和肝功的各项复查，几项指标显示让我们再次崩溃，孩子的病情出现了恶化，B超显示有少量腹水，肝脾有所增大，胆红素红素高达222.8，直胆值175.2，经了解孩子状况后得知不能再耽误了，医生建议尽快进行肝移植手术来挽救孩子的生命。</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; &nbsp; \n就在我们不知所措时，心羽基金陕西志愿者得知孩子情况后，第一时间赶到家里表示再难也会同我们一起想办法救孩子。而且在志愿者的帮助下我们和天津市第一中心医院高伟医生通了电话，医生建议我们带着孩子尽快来医院做肝移植手术，只有这样，才能保住孩子的性命。可现在我们实在无力承担医疗费用了，现特向心羽基金求助，恳求大家帮帮我可怜的宝宝吧，我一定教育孩子做一个对社会有用之人！ <br/></span></p><p><br/></p>','<p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">我叫王小娟，是一位来自陕西省富平县淡村镇的农民，有两个儿子，大儿子是和前夫生的，孩子一岁多的时候丈夫因一场车祸离开了我们，如今孩子已经9岁了，很乖很听话。去年经人介绍和现在丈夫结婚，次年生下小儿子，取名罗浩航，本以为这次的婚姻可以让我幸福快乐的生活，但没有想到孩子突如其来的患病，让我们成天往返在医院和去医院路上！</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; &nbsp; \n出生40天后的罗浩航因黄疸不退去医院进行检查，医生怀疑是母乳性黄疸，经医生介绍后便停止3-4天的母乳喂养，但没有任何效果，医生建议我们带着孩子到大医院进一步检查，看着孩子一天天变黄我们格外着急，便再次带着向亲戚朋友借来的钱款直奔咸阳第二附属医院检查了肝功，结果却让我们不敢相信，在医生的讲解下我们得知孩子的病情在日益增重，便要求我们立即转院进行治疗，我们再次转到了西安儿童医院，经过各项细致的检查后，最终确诊为胆道闭锁，胆汁淤积性肝硬化Ⅱ期，需尽快进行葛西手术，听到这里我的脑子一片空白，向我们这样的农村人从来就没听说过这种病，顿时不知道该怎么办了。</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; \n&nbsp;看着乖巧听话的小浩航，我们当父母的不忍心让孩子就这样离开，他还没有感受到这个世界美好，就这样我们为了给孩子治病，贷款进行了葛西手术，切除了胆囊，但术后效果不是很理想，胆汁不能正常排出，每天打针吃激素药，整天哭闹不止，看着孩子肚子上缝合几十针的伤口，我的心都碎了，这么小就要遭受这么大的痛苦。</p><p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;孩子在住院时，奶奶因腰椎盘颈椎病也住进了医院，大儿子在家无人看管，顿时整个人都快崩溃了。就这样连夜赶回家一天一夜没有吃饭，夜里只睡了3个小时，第二天就没奶了，不够孩子吃，无奈下把家里买的一辆二手面包车也卖了。</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">自上次住了一个多月出院后，第四天凌晨，孩子突然高烧不退，又因宝宝对头孢，青霉素过敏，家里的医院又没有药，只能再次住院治疗，在各项检查后孩子被确诊为反流性胆管炎。经过一段时间的治疗于近日进行B超弹性变和肝功的各项复查，几项指标显示让我们再次崩溃，孩子的病情出现了恶化，B超显示有少量腹水，肝脾有所增大，胆红素红素高达222.8，直胆值175.2，经了解孩子状况后得知不能再耽误了，医生建议尽快进行肝移植手术来挽救孩子的生命。</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; &nbsp; \n就在我们不知所措时，心羽基金陕西志愿者得知孩子情况后，第一时间赶到家里表示再难也会同我们一起想办法救孩子。而且在志愿者的帮助下我们和天津市第一中心医院高伟医生通了电话，医生建议我们带着孩子尽快来医院做肝移植手术，只有这样，才能保住孩子的性命。可现在我们实在无力承担医疗费用了，现特向心羽基金求助，恳求大家帮帮我可怜的宝宝吧，我一定教育孩子做一个对社会有用之人！ <br/></span></p><p><br/></p>','<p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">我叫王小娟，是一位来自陕西省富平县淡村镇的农民，有两个儿子，大儿子是和前夫生的，孩子一岁多的时候丈夫因一场车祸离开了我们，如今孩子已经9岁了，很乖很听话。去年经人介绍和现在丈夫结婚，次年生下小儿子，取名罗浩航，本以为这次的婚姻可以让我幸福快乐的生活，但没有想到孩子突如其来的患病，让我们成天往返在医院和去医院路上！</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; &nbsp; \n出生40天后的罗浩航因黄疸不退去医院进行检查，医生怀疑是母乳性黄疸，经医生介绍后便停止3-4天的母乳喂养，但没有任何效果，医生建议我们带着孩子到大医院进一步检查，看着孩子一天天变黄我们格外着急，便再次带着向亲戚朋友借来的钱款直奔咸阳第二附属医院检查了肝功，结果却让我们不敢相信，在医生的讲解下我们得知孩子的病情在日益增重，便要求我们立即转院进行治疗，我们再次转到了西安儿童医院，经过各项细致的检查后，最终确诊为胆道闭锁，胆汁淤积性肝硬化Ⅱ期，需尽快进行葛西手术，听到这里我的脑子一片空白，向我们这样的农村人从来就没听说过这种病，顿时不知道该怎么办了。</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; \n&nbsp;看着乖巧听话的小浩航，我们当父母的不忍心让孩子就这样离开，他还没有感受到这个世界美好，就这样我们为了给孩子治病，贷款进行了葛西手术，切除了胆囊，但术后效果不是很理想，胆汁不能正常排出，每天打针吃激素药，整天哭闹不止，看着孩子肚子上缝合几十针的伤口，我的心都碎了，这么小就要遭受这么大的痛苦。</p><p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;孩子在住院时，奶奶因腰椎盘颈椎病也住进了医院，大儿子在家无人看管，顿时整个人都快崩溃了。就这样连夜赶回家一天一夜没有吃饭，夜里只睡了3个小时，第二天就没奶了，不够孩子吃，无奈下把家里买的一辆二手面包车也卖了。</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">自上次住了一个多月出院后，第四天凌晨，孩子突然高烧不退，又因宝宝对头孢，青霉素过敏，家里的医院又没有药，只能再次住院治疗，在各项检查后孩子被确诊为反流性胆管炎。经过一段时间的治疗于近日进行B超弹性变和肝功的各项复查，几项指标显示让我们再次崩溃，孩子的病情出现了恶化，B超显示有少量腹水，肝脾有所增大，胆红素红素高达222.8，直胆值175.2，经了解孩子状况后得知不能再耽误了，医生建议尽快进行肝移植手术来挽救孩子的生命。</span><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><br style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"/><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; &nbsp; \n就在我们不知所措时，心羽基金陕西志愿者得知孩子情况后，第一时间赶到家里表示再难也会同我们一起想办法救孩子。而且在志愿者的帮助下我们和天津市第一中心医院高伟医生通了电话，医生建议我们带着孩子尽快来医院做肝移植手术，只有这样，才能保住孩子的性命。可现在我们实在无力承担医疗费用了，现特向心羽基金求助，恳求大家帮帮我可怜的宝宝吧，我一定教育孩子做一个对社会有用之人！ <br/></span></p><p><br/></p>',1,'2016-08-11 00:00:00.000000',1,'11111.00',0,0,2),(103,'肝炎父母的救子心愿','小明',2,11,'32132153撒打算的','11111.00','pb','<p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; line-height: 22px; white-space: normal;\"><span style=\"font-family: SimSun;\">我叫李儒春，丈夫叫张丁，我们是来自于湖北省黄冈市红安县觅儿寺镇，儿子张钊峥出生于2016年2月6日，孩子的到来让我们全家无比的喜悦，就在全家人沉醉于欢喜当中时，孩子却因黄疸迟迟不退，从此走上了求医的道路。</span></span><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"> <br/></span></p>','<p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; line-height: 22px; white-space: normal;\"><span style=\"font-family: SimSun;\">我叫李儒春，丈夫叫张丁，我们是来自于湖北省黄冈市红安县觅儿寺镇，儿子张钊峥出生于2016年2月6日，孩子的到来让我们全家无比的喜悦，就在全家人沉醉于欢喜当中时，孩子却因黄疸迟迟不退，从此走上了求医的道路。</span></span><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"> <br/></span></p><p><br/></p>','<p><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; line-height: 22px; white-space: normal;\"><span style=\"font-family: SimSun;\">我叫李儒春，丈夫叫张丁，我们是来自于湖北省黄冈市红安县觅儿寺镇，儿子张钊峥出生于2016年2月6日，孩子的到来让我们全家无比的喜悦，就在全家人沉醉于欢喜当中时，孩子却因黄疸迟迟不退，从此走上了求医的道路。</span></span><span style=\"color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"> <br/></span></p><p><br/></p>',1,'2016-08-11 00:00:00.000000',1,'11111.00',0,0,2),(104,'士大夫撒旦法','6843',2,1651,'13213165撒旦发射的','6516516516516.00','pb','<p>啊上帝防守打法多少分<br/></p>','<p>啊上帝防守打法多少分<br/></p>','<p>啊上帝防守打法多少分<br/></p>',0,'2016-08-11 00:00:00.000000',1,'0.00',0,0,2),(105,'这是一个筹款吗测试','轧死的付i',2,22,'湿答答撒打算','156131656.00','pb','<p>萨达公司的佛i多少分ihsdifuah上帝会丢好似毒害 iuhsa滴<br/></p><p><br/></p>','<p>萨达公司的佛i多少分ihsdifuah上帝会丢好似毒害 iuhsa滴<br/></p><p><br/></p>','<p>萨达公司的佛i多少分ihsdifuah上帝会丢好似毒害 iuhsa滴<br/></p><p><br/></p>',0,'2016-08-11 00:00:00.000000',1,'2010000.00',0,1,2),(106,'156','1',1,65,'165','1.00','pb','<p>11<br/></p>','<p>11<br/></p>','<p>11<br/></p>',0,'2016-11-01 00:00:00.000000',1,'0.00',0,0,2),(107,'测试','测试',NULL,NULL,NULL,'1000.00','pb','<p>测试<br/></p>',NULL,NULL,0,'2016-12-28 00:00:00.000000',2,'11.00',0,0,2),(108,'流感','H1N1',NULL,NULL,NULL,'111.00','pb','<p>1<br/></p>',NULL,NULL,1,'2016-12-30 00:00:00.000000',2,'1111.00',0,0,2),(109,'病毒','大流感',NULL,NULL,NULL,'2222.00','pb','<p>22<br/></p>',NULL,NULL,1,'2016-12-30 00:00:00.000000',2,'1111111.00',0,0,2),(110,'爸爸与你同肝共处','小王',1,12,'1','11111.00','pb','<p>1<span style=\"font-family: 楷体; font-size: 14pt;\"><span style=\"font-family: 楷体;\">尊敬的各位好心人，大家好！我们来自湖南省邵阳县岩口铺子镇渣滩村的阳涛涛和肖碧，去年五月份经人介绍，我和老婆肖碧喜结良缘，并于</span>2016年1月9日顺利生下一名男婴，取名叫阳齐，孩子的到来让全家人沉静于喜悦之中，然而天有不测风云，人有祸福旦夕，万万没想到还没来得及享受天伦之乐的我们，一场大灾正在悄悄的向我们袭击而来。</span></p>','<p>1<span style=\"font-family: 楷体; font-size: 14pt;\"><span style=\"font-family: 楷体;\">尊敬的各位好心人，大家好！我们来自湖南省邵阳县岩口铺子镇渣滩村的阳涛涛和肖碧，去年五月份经人介绍，我和老婆肖碧喜结良缘，并于</span>2016年1月9日顺利生下一名男婴，取名叫阳齐，孩子的到来让全家人沉静于喜悦之中，然而天有不测风云，人有祸福旦夕，万万没想到还没来得及享受天伦之乐的我们，一场大灾正在悄悄的向我们袭击而来。</span></p>','<p>1<span style=\"font-family: 楷体; font-size: 14pt;\"><span style=\"font-family: 楷体;\">尊敬的各位好心人，大家好！我们来自湖南省邵阳县岩口铺子镇渣滩村的阳涛涛和肖碧，去年五月份经人介绍，我和老婆肖碧喜结良缘，并于</span>2016年1月9日顺利生下一名男婴，取名叫阳齐，孩子的到来让全家人沉静于喜悦之中，然而天有不测风云，人有祸福旦夕，万万没想到还没来得及享受天伦之乐的我们，一场大灾正在悄悄的向我们袭击而来。</span></p>',1,'2016-12-30 00:00:00.000000',1,'11111.00',1,0,2),(111,'测试','测试',NULL,NULL,NULL,'10000.00','pb','<p>测试<br/></p>',NULL,NULL,0,'2016-12-31 00:00:00.000000',2,'0.00',0,0,2),(112,'这是个很严重的病','流感',NULL,NULL,NULL,'10000.00','pb','<p>这个病是一个非常严重的流感病毒<br/></p>',NULL,NULL,1,'2016-12-31 00:00:00.000000',2,'10000.00',1,0,2),(113,'仁爱基金紧急救助','仁爱',NULL,NULL,NULL,'444444.00','pb','<p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">仁爱救助团队在过去的3年里救助的贫困大病儿童中，有很多孩子因为家里手术费用不够导致孩子手术延迟，影响手术效果。而做为民间发起的公益基金，没有太多的储备金为这些孩子进行紧急救助，单纯依靠筹款存在很多不稳定性和无法预见性，从而耽误孩子救助时间，为了让更多的孩子能够得到及时有效的救治，我们特设立紧急救助项目。</p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;紧急救助原则：</p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;（一） 救助量以量入为出为原则：预计每年救助人数为30名贫困患儿，根据社会募捐情况调整救助名额；</p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;（二）按需直接拨款：原则上一个孩子拨款2万，如遇特殊情况，核实后可以进行特殊处理，根据贫困患儿实际情况确定紧急救助款金额。</p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; &nbsp;（三） 出现下列情形之一者，终止救助。1、 违规使用救助金，用于其他不属于本救助专项所支付的款项。2、 \n经审查，故意虚报病情或隐瞒家庭成员及经济收入者。紧急救助申请程序： \n申请人（包括其他贫困患儿救助基金）需在认真阅读并认同心羽基金申请须知后完整填写《心羽基金申请表》备注紧急救助款申请，并连同以下材料，一起提交给基金办公室。</p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\"><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;审批程序：</p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;（一）紧急救助项目管理人员负责所有申报资料的审核和审批工作；</p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;（二）项目管理人员会在1至10个工作日内对报送材料的完整性、真实性等有关情况进行审核；</p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;（三）根据贫困患儿治疗方案，由医院、项目管理人员最终确认救助金额，以银行转账方式拨付给救助患者的医疗机构。</p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</p><p style=\"margin-top: 0px; margin-bottom: 0px; border: none; -webkit-margin-before: 0px; -webkit-margin-after: 0px; color: rgb(68, 68, 68); font-family: 微软雅黑; font-size: 13px; line-height: 22px; white-space: normal;\">&nbsp;\n &nbsp; &nbsp; &nbsp;费用使用说明： \n紧急救助善款使用唯一的原则就是在完全公开透明情况下运行，按需救助，善款善用，尊重每一笔善款使用，因为我们知道每一分善款都来之不易，每一分钱都是大家最无私的爱和信任，我们会及时更新每一笔善款使用情况以及每一个孩子救助后续情况，希望更多的爱心朋友一起关注和监督。腾讯视频对心羽基金的报道：</p><p><br/></p>',NULL,NULL,1,'2016-12-31 00:00:00.000000',2,'444444.00',0,0,2);

/*Table structure for table `t_help_apply` */

DROP TABLE IF EXISTS `t_help_apply`;

CREATE TABLE `t_help_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `child` varchar(20) DEFAULT NULL COMMENT '申请人姓名',
  `sex` int(1) DEFAULT NULL COMMENT '性别 1:男 0:女',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `nation` varchar(20) DEFAULT NULL COMMENT '民族',
  `native_place` varchar(40) DEFAULT NULL COMMENT '籍贯',
  `guardian` varchar(20) DEFAULT NULL COMMENT '监护人姓名',
  `guardian_age` int(4) DEFAULT NULL COMMENT '监护人年龄',
  `rela_apply` varchar(40) DEFAULT NULL COMMENT '与申请人关系',
  `guardian_id_num` varchar(30) DEFAULT NULL COMMENT '身份证号',
  `occupation` varchar(40) DEFAULT NULL COMMENT '职业',
  `tel` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `is_agr` int(1) DEFAULT NULL COMMENT '是否是农业户口',
  `familys` int(2) DEFAULT NULL COMMENT '家庭人口数量',
  `income_stream` varchar(20) DEFAULT NULL COMMENT '主要收入来源',
  `year_income` decimal(16,2) DEFAULT NULL COMMENT '年收入',
  `people_year_income` decimal(16,2) DEFAULT NULL COMMENT '人均年收入',
  `money` decimal(16,2) DEFAULT NULL COMMENT '申请金额',
  `cause` longtext COMMENT '申请理由',
  `diagnosis` varchar(60) DEFAULT NULL COMMENT '病情诊断',
  `hospital` varchar(60) DEFAULT NULL COMMENT '就诊医院',
  `doctor` varchar(20) DEFAULT NULL COMMENT '主治医师',
  `doctor_tel` varchar(30) DEFAULT NULL COMMENT '医生联系电话',
  `ho_budget` decimal(16,2) DEFAULT NULL COMMENT '医疗费用预算',
  `pe_budget` decimal(16,2) DEFAULT NULL COMMENT '自筹费用预算',
  `apply_budget` decimal(16,2) DEFAULT NULL COMMENT '申请资助预算',
  `in_date` date DEFAULT NULL COMMENT '住院日期',
  `number` varchar(10) DEFAULT NULL COMMENT '住院号',
  `reimbursement_ratio` double(6,2) DEFAULT NULL COMMENT '医保或新农合报销比例',
  `status` int(1) DEFAULT NULL COMMENT '1:申请中 0:申请驳回2：申请通过',
  `user_id` int(11) DEFAULT NULL COMMENT 'user表id',
  `apply_username` varchar(50) DEFAULT NULL COMMENT '申请求助的账号',
  `apply_date` date DEFAULT NULL COMMENT '申请求助日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `t_help_apply` */

insert  into `t_help_apply`(`id`,`child`,`sex`,`birthday`,`nation`,`native_place`,`guardian`,`guardian_age`,`rela_apply`,`guardian_id_num`,`occupation`,`tel`,`is_agr`,`familys`,`income_stream`,`year_income`,`people_year_income`,`money`,`cause`,`diagnosis`,`hospital`,`doctor`,`doctor_tel`,`ho_budget`,`pe_budget`,`apply_budget`,`in_date`,`number`,`reimbursement_ratio`,`status`,`user_id`,`apply_username`,`apply_date`) values (1,'1',1,'2012-11-11','1','1','1',1,'1','1','1','11',1,1,'1','1.00','1.00','1.00','123\r\n','1','1','1','1','1.00','1.00','11.00','2012-02-02','1',11.00,2,1,'1','1995-05-16'),(4,'11',NULL,'2016-08-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','321','321','32','132.00','1.00','321.00','1970-01-01','1',3213.00,0,9,'555','2016-08-04'),(17,NULL,NULL,'2016-08-04',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,9,'555','2016-08-04'),(18,'1',1,'2016-08-04','1','1',NULL,1,'1','1','1','1',NULL,1,'1','1.00','1.00','1.00',NULL,'1','1','1','1','11.00','1.00','1.00','1970-01-01','1',1.00,0,9,'555','2016-08-04'),(19,'test',1,'2016-08-05','1','1','1',11,'1','11','1','1',1,1,'1','1.00','1.00','1.00',NULL,'1','1','1','1','1.00','1.00','1.00','1970-01-01','1',1.00,0,9,'555','2016-08-05'),(20,NULL,NULL,'2016-08-05',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,9,'555','2016-08-05'),(21,'111',1,'2016-08-01','1','231','32',1,'321','321','3','13',1,31,'3','13.00','21.00','321.00',NULL,'132','13','1','31','232.00','13.00','1.00','2016-01-05','123',132.00,2,9,'555','2016-08-05'),(22,'11',1,'2006-08-05','1','11','1',1,'11','1','1','11',1,1,'11','1.00','1.00','11.00',NULL,'1','11','1','1','1.00','1.00','11.00','2006-08-05','1',1.00,0,9,'555','2016-08-05'),(23,'11',1,'2006-08-05','1','11','1',1,'11','1','1','11',1,1,'11','1.00','1.00','11.00','555','1','11','1','1','1.00','1.00','11.00','2006-08-05','1',1.00,2,9,'555','2016-08-05'),(24,'123',1,'2016-08-08','是是是','132','132',132,'132','132','1','321',1,32,'132','1.00','31.00','31.00','飒飒飒飒飒飒飒飒岁','21','321','321','3','132.00','13.00','21.00','2016-08-08','132',1.00,2,9,'555','2016-08-08'),(25,'123',1,'2016-08-08','1','1','1',11,'1','1','1','1',1,1,'1','1.00','1.00','1.00','11','1','1','1','1','1.00','1.00','1.00','2016-08-08','1',1.00,2,9,'555','2016-08-08'),(26,'1221',1,'2016-08-10','2132','是','1',1,'1','1','11','1',1,1,'1','1.00','1.00','1.00','1','11','1','1','1','1.00','11.00','1.00','2016-08-10','1',2222.22,1,9,'555','2016-08-10'),(27,'1655165',1,'2016-11-01','65165','156','11',6,'165','1','651','651',1,1,'651','56.00','222.00','651.00','65','1','65','1','651','56.00','1.00','65.00','2016-11-01','222',11.11,1,9,'555','2016-11-01'),(28,'1',1,'2016-12-28','1','1','1',1,'1','1','1','1',1,11,'1','1.00','1.00','1.00','11','1','11','1','1','1.00','11.00','1.00','2016-12-28','1',11.11,1,9,'555','2016-12-28');

/*Table structure for table `t_help_apply_files` */

DROP TABLE IF EXISTS `t_help_apply_files`;

CREATE TABLE `t_help_apply_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `help_apply_id` int(11) DEFAULT NULL COMMENT '申请id',
  `file_id` int(11) DEFAULT NULL COMMENT '文件id',
  `type` int(1) DEFAULT NULL COMMENT '1：父母及受助孩子户口本 2：父母双方身份证正反面 3：受助患儿出生证或身份证正反复印件 4：受助家庭的贫困贫困证明原件 5：受助患儿的诊断证明原件 6：手写求助信',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Data for the table `t_help_apply_files` */

insert  into `t_help_apply_files`(`id`,`help_apply_id`,`file_id`,`type`) values (1,15,147,2),(2,16,169,2),(3,17,170,2),(4,17,171,3),(5,17,172,4),(6,18,178,2),(7,18,179,3),(8,18,180,4),(9,18,181,5),(10,18,182,6),(11,18,183,7),(12,19,184,1),(13,19,185,2),(14,19,186,3),(15,19,187,4),(16,19,188,5),(17,19,189,6),(18,22,192,1),(19,22,193,2),(20,22,194,3),(21,22,195,4),(22,22,196,5),(23,22,197,6),(24,23,192,1),(25,23,193,2),(26,23,194,3),(27,23,195,4),(28,23,196,5),(29,23,197,6),(30,24,217,1),(31,24,218,2),(32,24,219,3),(33,24,220,4),(34,24,221,5),(35,24,222,6),(36,25,223,1),(37,25,224,2),(38,25,225,3),(39,25,226,4),(40,25,227,5),(41,25,228,6),(42,26,280,1),(43,26,281,2),(44,26,282,3),(45,26,283,4),(46,26,284,5),(47,26,285,6),(48,27,304,1),(49,27,305,2),(50,27,306,3),(51,27,307,4),(52,27,308,5),(53,27,309,6),(54,28,331,1),(55,28,332,2),(56,28,333,3),(57,28,334,4),(58,28,335,5),(59,28,336,6);

/*Table structure for table `t_help_files` */

DROP TABLE IF EXISTS `t_help_files`;

CREATE TABLE `t_help_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `help_id` int(11) NOT NULL COMMENT '求助信息id',
  `file_id` int(11) NOT NULL COMMENT '文件id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8;

/*Data for the table `t_help_files` */

insert  into `t_help_files`(`id`,`help_id`,`file_id`) values (1,11,18),(2,5,19),(3,5,19),(5,15,21),(6,18,22),(7,19,32),(8,20,33),(9,20,33),(10,20,33),(11,20,40),(12,18,47),(13,25,49),(14,26,51),(15,27,53),(16,27,53),(19,29,56),(20,6,55),(22,14,58),(24,33,62),(31,37,72),(36,35,79),(38,39,124),(39,40,125),(40,41,126),(42,42,127),(43,43,128),(47,44,132),(48,28,133),(50,46,137),(51,46,138),(56,48,141),(57,45,142),(58,49,142),(59,50,143),(60,51,144),(61,28,148),(62,52,150),(63,53,152),(64,53,152),(65,53,153),(66,53,152),(67,53,153),(69,54,158),(70,56,159),(74,58,162),(75,58,163),(76,59,163),(77,59,164),(79,60,165),(80,60,166),(82,61,168),(83,62,190),(84,63,191),(86,65,208),(87,66,209),(88,67,210),(89,68,211),(90,69,212),(91,70,213),(92,71,214),(93,72,215),(94,73,216),(95,64,229),(96,74,230),(97,75,231),(98,76,232),(99,77,233),(100,80,234),(101,82,235),(102,88,236),(103,89,237),(105,81,249),(106,90,250),(107,91,250),(108,92,250),(112,97,286),(113,98,287),(114,93,288),(127,100,301),(130,106,313),(131,105,314),(132,104,315),(140,84,323),(145,99,340),(147,96,342),(148,96,343),(149,87,344),(150,85,345),(154,111,349),(161,107,356),(164,110,359),(165,103,360),(166,102,361),(167,101,362),(168,113,363),(169,112,364),(170,109,365),(171,108,366);

/*Table structure for table `t_link` */

DROP TABLE IF EXISTS `t_link`;

CREATE TABLE `t_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL COMMENT '连接或企业名称',
  `url` varchar(200) DEFAULT NULL COMMENT '连接地址',
  `date` date DEFAULT NULL COMMENT '发布时间',
  `status` int(1) DEFAULT NULL,
  `type` int(1) DEFAULT NULL COMMENT '类型 1:感恩有你 2:友情连接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `t_link` */

insert  into `t_link`(`id`,`name`,`url`,`date`,`status`,`type`) values (1,'2233','22222','2016-08-01',0,2),(2,'111','1111','2016-08-01',0,2),(13,'1',NULL,'2016-08-05',0,1),(14,'11','12313','2016-08-05',0,2),(15,'1',NULL,'2016-08-09',0,1),(16,'1',NULL,'2016-08-09',0,1),(17,'1',NULL,'2016-08-09',0,1),(18,'1',NULL,'2016-08-09',0,1),(19,'1',NULL,'2016-08-09',0,1),(20,'1',NULL,'2016-08-09',0,1),(22,'1',NULL,'2016-08-09',0,1),(23,'1',NULL,'2016-08-09',0,1),(25,'1','1','2016-08-09',0,2),(26,'1','1','2016-08-09',0,2),(27,'1','1','2016-08-09',0,2),(28,'1','1','2016-08-09',0,2),(29,'1','1','2016-08-09',0,2),(30,'1','1','2016-08-09',0,2),(31,'1','1','2016-08-09',0,2);

/*Table structure for table `t_link_files` */

DROP TABLE IF EXISTS `t_link_files`;

CREATE TABLE `t_link_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link_id` int(11) DEFAULT NULL,
  `file_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `t_link_files` */

insert  into `t_link_files`(`id`,`link_id`,`file_id`) values (1,4,34),(2,5,35),(3,6,36),(4,7,37),(5,8,38),(6,9,39),(7,10,200),(8,11,201),(9,11,202),(10,12,203),(12,13,206),(13,15,238),(14,16,239),(15,17,240),(16,18,241),(17,19,242),(18,20,243),(19,21,244),(20,22,245),(21,23,246),(22,24,247);

/*Table structure for table `t_news` */

DROP TABLE IF EXISTS `t_news`;

CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) DEFAULT NULL COMMENT '摘要',
  `content` mediumtext COMMENT '正文',
  `type` int(1) DEFAULT NULL COMMENT '文章类型 1:新闻资讯 2:媒体报道 3:典型案例 4:志愿风采 5.客服文章',
  `status` int(1) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `t_news` */

insert  into `t_news`(`id`,`title`,`content`,`type`,`status`,`create_time`) values (2,'这时第二个新闻','<p><span style=\"text-decoration:underline;\"><em>222222222222</em></span></p>',1,1,'2016-07-29 00:00:00.000000'),(3,'媒体报道 test type2','<p><span style=\"text-decoration:underline;\"><em>22222222222222222</em></span></p>',2,1,'2016-07-29 00:00:00.000000'),(4,'典型案例 type3 test','<p><span style=\"text-decoration:underline;\"><strong><em>2222222222222222</em></strong></span></p>',3,1,'2016-07-29 00:00:00.000000'),(6,'只愿风采 test4 type','11111111111111111111',4,1,'2016-07-29 00:00:00.000000'),(8,'客服客服test','1111111111111',5,1,'2016-07-29 00:00:00.000000'),(10,'2222','22',1,1,'2016-07-29 00:00:00.000000'),(11,'123','<p align=\"center\"><span style=\"font-size:32px\">玩玩</span></p>',4,1,'2016-07-29 00:00:00.000000'),(12,'1','1<p><br/></p>',1,1,'2016-08-02 00:00:00.000000'),(13,'1','<p>1<br/></p>',2,1,'2016-08-02 00:00:00.000000'),(14,'diyi','132<p><br/></p>',1,1,'2016-08-05 00:00:00.000000'),(15,'3','<p>3<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(16,'2','<p>2<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(17,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(18,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(19,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(20,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(21,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(22,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(23,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(24,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(25,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(26,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(27,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(28,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(29,'1','<p>1<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(30,'2','<p>2<br/></p>',1,1,'2016-08-05 00:00:00.000000'),(31,'1','<p>1<br/></p>',5,1,'2016-08-09 00:00:00.000000'),(32,'1','<p>1<br/></p>',5,1,'2016-08-09 00:00:00.000000'),(33,'2','1<p><br/></p>',5,1,'2016-08-09 00:00:00.000000'),(34,'1','1<p><br/></p>',5,1,'2016-08-09 00:00:00.000000'),(35,'1','<p>1<br/></p>',5,1,'2016-08-09 00:00:00.000000'),(36,'1','1<p><br/></p>',5,1,'2016-08-09 00:00:00.000000'),(37,'1','1<p><br/></p>',5,1,'2016-08-09 00:00:00.000000'),(38,'1','1<p><br/></p>',5,1,'2016-08-09 00:00:00.000000'),(39,'1','1<p><br/></p>',5,1,'2016-08-09 00:00:00.000000'),(40,'1','1<p><br/></p>',5,1,'2016-08-09 00:00:00.000000'),(41,'中国222条河流发生超警洪水','<p align=\"left\"><strong><em><span style=\"font-size:16px\">在国务院新闻办29日举行的发布会上，水利部副部长、国家防汛抗旱总指挥部秘书长刘宁指出，今年全国有222条河流发生超警洪水，为近5年同期最多，有26条河流发生超保洪水，6条河流发生超历史洪水，主要江河共出现23次洪水过程，洪水总量较常年偏多34%。今年南方地区先后出现20多次强降雨过程，为近5年同期最多，全国降水量比多年同期多23%，列建国以来第2位，最大点日雨量达493毫米。截至6月28日统计，今年以来全国已有23省（区、市）不同程度遭受洪涝灾害。水利基础设施、防洪工程体系和非工程体系的有效运用，以及各部门及时有效的防汛抗洪工作，使得目前整体受灾情况较轻。截至6月28日统计，受灾人口、死亡人口、受灾面积和倒塌房屋分别比2000年以来同期均值偏少43%、45%、23%和77%。受灾区域主要集中在南方地区。但今年的防汛形势仍然十分严峻。刘宁表示，受超强厄尔尼诺事件影响，气候水文形势复杂多变，江淮、松辽、太湖等流域有发生较大洪水的可能，中小河流洪水、山洪灾害、城市内涝可能多发，登陆台风强度偏强，可能深入内陆，防汛形势严峻。在国务院新闻办29日举行的发布会上，水利部副部长、国家防汛抗旱总指挥部秘书长刘宁指出，今年全国有222条河流发生超警洪水，为近5年同期最多，有26条河流发生超保洪水，6条河流发生超历史洪水，主要江河共出现23次洪水过程，洪水总量较常年偏多34%。今年南方地区先后出现20多次强降雨过程，为近5年同期最多，全国降水量比多年同期多23%，列建国以来第2位，最大点日雨量达493毫米。截至6月28日统计，今年以来全国已有23省（区、市）不同程度遭受洪涝灾害。水利基础设施、防洪工程体系和非工程体系的有效运用，以及各部门及时有效的防汛抗洪工作，使得目前整体受灾情况较轻。截至6月28日统计，受灾人口、死亡人口、受灾面积和倒塌房屋分别比2000年以来同期均值偏少43%、45%、23%和77%。受灾区域主要集中在南方地区。但今年的防汛形势仍然十分严峻。刘宁表示，受超强厄尔尼诺事件影响，气候水文形势复杂多变，江淮、松辽、太湖等流域有发生较大洪水的可能，中小河流洪水、山洪灾害、城市内涝可能多发，登陆台风强度偏强，可能深入内陆，防汛形势严峻。在国务院新闻办29日举行的发布会上，水利部副部长、国家防汛抗旱总指挥部秘书长刘宁指出，今年全国有222条河流发生超警洪水，为近5年同期最多，有26条河流发生超保洪水，6条河流发生超历史洪水，主要江河共出现23次洪水过程，洪水总量较常年偏多34%。今年南方地区先后出现20多次强降雨过程，为近5年同期最多，全国降水量比多年同期多23%，列建国以来第2位，最大点日雨量达493毫米。截至6月28日统计，今年以来全国已有23省（区、市）不同程度遭受洪涝灾害。水利基础设施、防洪工程体系和非工程体系的有效运用，以及各部门及时有效的防汛抗洪工作，使得目前整体受灾情况较轻。截至6月28日统计，受灾人口、死亡人口、受灾面积和倒塌房屋分别比2000年以来同期均值偏少43%、45%、23%和77%。受灾区域主要集中在南方地区。但今年的防汛形势仍然十分严峻。刘宁表示，受超强厄尔尼诺事件影响，气候水文形势复杂多变，江淮、松辽、太湖等流域有发生较大洪水的可能，中小河流洪水、山洪灾害、城市内涝可能多发，登陆台风强度偏强，可能深入内陆，防汛形势严峻。今年以来全国已有23省（区、市）不同程度遭受洪涝灾害。水利基础设施、防洪工程体系和非工程体系的有效运用，以及各部门及时有效的防汛抗洪工作，使得目前整体受灾情况较轻。截至6月28日统计，受灾人口、死亡人口、受灾面积和倒塌房屋分别比2000年以来同期均值偏少43%、45%、23%和77%。受灾区域主要集中在南方地区。但今年的防汛形势仍然十分严峻。刘宁表示，受超强厄尔尼诺事件影响，气候水文形势复杂多变，江淮、松辽、太湖等流域有发生较大洪水的可能，中小河流洪水、山洪灾害、城市内涝可能多发，登陆台风强度偏强，可能深入内陆，防汛形势严峻。在国务院新闻办29日举行的发布会上，水利部副部长、国家防汛抗旱总指挥部秘书长刘宁指出，今年全国有222条河流发生超警洪水，为近5年同期最多，有26条河流发生超保洪水，6条河流发生超历史洪水，主要江河共出现23次洪水过程，洪水总量较常年偏多34%。今年南方地区先后出现20多次强降雨过程，为近5年同期最多，全国降水量比多年同期多23%，列建国以来第2位，最大点日雨量达493毫米。截至6月28日统计，今年以来全国已有23省（区、市）不同程度遭受洪涝灾害。水利基础设施、防洪工程体系和非工程体系的有效运用，以及各部门及时有效的防汛抗洪工作，使得目前整体受灾情况较轻。截至6月28日统计，受灾人口、死亡人口、受灾面积和倒塌房屋分别比2000年以来同期均值偏少43%、45%、23%和77%。受灾区域主要集中在南方地区。但今年的防汛形势仍然十分严峻。刘宁表示，受超强厄尔尼诺事件影响，气候水文形势复杂多变，江淮、松辽、太湖等流域有发生较大洪水的可能，中小河流洪水、山洪灾害、城市内涝可能多发，登陆台风强度偏强，可能深入内陆，防汛形势严峻。</span></em></strong></p>',5,1,'2016-08-09 00:00:00.000000'),(42,'今天来面试','<div align=\"center\"><strong>很开心</strong></div><p><br/></p>',3,1,'2017-02-17 00:00:00.000000');

/*Table structure for table `t_postulant` */

DROP TABLE IF EXISTS `t_postulant`;

CREATE TABLE `t_postulant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `id_number` varchar(30) NOT NULL COMMENT '证件号码',
  `id_type` int(1) NOT NULL COMMENT '证件类型',
  `tel` varchar(13) NOT NULL COMMENT '移动电话',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `country` varchar(80) DEFAULT NULL COMMENT '国籍',
  `nation` varchar(20) DEFAULT NULL COMMENT '民族',
  `zzmm` varchar(20) DEFAULT NULL COMMENT '政治面貌',
  `school` varchar(80) DEFAULT NULL COMMENT '毕业院校',
  `level` varchar(20) DEFAULT NULL COMMENT '学历',
  `profession_type` varchar(20) DEFAULT NULL COMMENT '专业类别',
  `profession` varchar(80) DEFAULT NULL COMMENT '专业',
  `c_language` varchar(40) DEFAULT NULL COMMENT '中国语种',
  `e_language` varchar(40) DEFAULT NULL COMMENT '外国语种',
  `e_language_level` varchar(20) DEFAULT NULL COMMENT '外语熟练度',
  `blood_group` int(1) DEFAULT NULL COMMENT '血型',
  `native_place` varchar(40) DEFAULT NULL COMMENT '籍贯',
  `zone` varchar(6) DEFAULT NULL COMMENT '居住区域(身份证后六位)',
  `address` varchar(60) DEFAULT NULL COMMENT '联系地址',
  `zip_code` varchar(10) DEFAULT NULL COMMENT '邮政编码',
  `telephone` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `other_tel` varchar(80) DEFAULT NULL COMMENT '其他联系方式',
  `title` varchar(40) DEFAULT NULL COMMENT '职称',
  `unit` varchar(80) DEFAULT NULL COMMENT '工作单位',
  `unit_trade_type` varchar(40) DEFAULT NULL COMMENT '单位行业性质',
  `unit_type` varchar(40) DEFAULT NULL COMMENT '工作单位性质',
  `service_area` varchar(60) DEFAULT NULL COMMENT '服务区域',
  `service_object` varchar(60) DEFAULT NULL COMMENT '服务对象',
  `is_service_date` date DEFAULT NULL COMMENT '可提供服务的时间',
  `service_date` date DEFAULT NULL COMMENT '志愿服务时间',
  `training_date` date DEFAULT NULL COMMENT '参加培训时间',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `user_id` int(11) DEFAULT NULL COMMENT 'uer_id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_postulant` */

insert  into `t_postulant`(`id`,`name`,`id_number`,`id_type`,`tel`,`birthday`,`country`,`nation`,`zzmm`,`school`,`level`,`profession_type`,`profession`,`c_language`,`e_language`,`e_language_level`,`blood_group`,`native_place`,`zone`,`address`,`zip_code`,`telephone`,`other_tel`,`title`,`unit`,`unit_trade_type`,`unit_type`,`service_area`,`service_object`,`is_service_date`,`service_date`,`training_date`,`status`,`sex`,`user_id`) values (15,'张三','1',1,'1','1995-05-16','1','1','1','1','1','1','1','1','1','1',1,'1','1','1','1','1','1','1','1','1','1','1','1','1970-01-01','1970-01-01','1970-01-01',1,1,14);

/*Table structure for table `t_postulant_files` */

DROP TABLE IF EXISTS `t_postulant_files`;

CREATE TABLE `t_postulant_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postulant_id` int(11) NOT NULL COMMENT '志愿申请id',
  `file_id` int(11) NOT NULL COMMENT '文件id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `t_postulant_files` */

insert  into `t_postulant_files`(`id`,`postulant_id`,`file_id`) values (2,10,14),(4,15,31),(5,23,255),(6,24,256),(7,25,257),(8,26,258),(9,27,261),(10,28,262),(11,29,268),(12,30,269),(13,30,270),(14,31,271),(15,32,272),(16,33,273),(17,34,274),(18,34,275),(19,34,276),(20,34,277),(21,34,278),(22,35,279),(23,36,290);

/*Table structure for table `t_postulant_service_skill` */

DROP TABLE IF EXISTS `t_postulant_service_skill`;

CREATE TABLE `t_postulant_service_skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dictionary_id` int(11) NOT NULL COMMENT '字典表id',
  `postulant_id` int(11) NOT NULL COMMENT '申请信息id',
  `other` varchar(100) DEFAULT NULL COMMENT '其他内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_postulant_service_skill` */

insert  into `t_postulant_service_skill`(`id`,`dictionary_id`,`postulant_id`,`other`) values (1,1,14,NULL),(2,3,14,'11'),(3,4,14,NULL),(4,6,14,'22'),(5,2,14,NULL),(6,1,23,NULL),(7,5,23,NULL),(8,1,24,NULL),(9,5,24,NULL),(10,6,24,'1'),(11,2,25,NULL),(12,6,25,'1'),(13,2,26,NULL),(14,5,26,NULL),(15,2,27,NULL),(16,5,27,NULL),(17,6,27,'22'),(18,2,28,NULL),(19,6,28,'2222'),(20,1,29,NULL),(21,5,29,NULL),(22,1,30,NULL),(23,4,30,NULL),(24,1,31,NULL),(25,5,31,NULL);

/*Table structure for table `t_publictiy` */

DROP TABLE IF EXISTS `t_publictiy`;

CREATE TABLE `t_publictiy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '受助人名称',
  `time` date DEFAULT NULL COMMENT '受助时间',
  `info` longtext COMMENT '项目',
  `receiving_party` varchar(20) DEFAULT NULL COMMENT '收款方',
  `account` varchar(30) DEFAULT NULL COMMENT '账户',
  `money` decimal(16,2) DEFAULT NULL COMMENT '捐款额',
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `t_publictiy` */

insert  into `t_publictiy`(`id`,`name`,`time`,`info`,`receiving_party`,`account`,`money`,`status`) values (2,'123','2008-08-01','1111','132132','1321','321.00',0),(3,'132132','2016-08-01','123','1321','32','132.00',0),(7,'123','2016-08-01','1111','132132','1321','321.00',0),(12,'12','2016-08-02','1','1','1','1.00',0),(13,'123','2008-08-02','11','1','1','1.00',0),(14,'111','2016-08-02','1','1','1','1.00',0),(17,'123','2016-08-02','2','2','2','2.00',0),(18,'3223','2013-08-02','23','32','23','32.00',0),(21,'132','2014-08-02','1','1','1','1.00',0),(22,'23','2016-05-02','1','123','132','13.00',0),(23,'12312','2006-08-02','1','1','132','132.00',0),(24,'1','2016-08-08',NULL,'1','1','1.00',0);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(128) NOT NULL,
  `username` varchar(30) DEFAULT NULL COMMENT '账号',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱(帐号)',
  `is_superuser` tinyint(1) DEFAULT '0' COMMENT '是否是管理员',
  `tel` varchar(13) DEFAULT NULL COMMENT '手机号',
  `is_postulant` tinyint(1) DEFAULT '0' COMMENT '是否是志愿者',
  `status` int(1) DEFAULT NULL COMMENT '状态 1:启用 0:停用',
  `register_date` datetime(6) DEFAULT NULL COMMENT '注册日期',
  `card_number` varchar(30) DEFAULT NULL COMMENT '银行卡号',
  `count` int(10) DEFAULT NULL COMMENT '行善次数',
  `type` int(1) DEFAULT NULL COMMENT '用户类型 1:普通用户 2:申请志愿者 ',
  `realname` varchar(60) DEFAULT NULL COMMENT '真实姓名',
  `icon_url` varchar(300) DEFAULT NULL COMMENT '头像url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`password`,`username`,`email`,`is_superuser`,`tel`,`is_postulant`,`status`,`register_date`,`card_number`,`count`,`type`,`realname`,`icon_url`) values (2,'pb19950516','419995258@qq.com','419995258@qq.com',1,'15620942728',1,NULL,'2016-07-21 00:00:00.000000',NULL,0,2,'pb',NULL),(3,'123123','123123','123123',0,'123123123',0,NULL,'2016-07-21 00:00:00.000000',NULL,NULL,2,NULL,NULL),(4,'123','123123123','123123123',0,'123',0,0,'2016-07-21 00:00:00.000000',NULL,NULL,2,NULL,''),(5,'123123','123','123',0,'12313',0,0,'2016-07-21 00:00:00.000000',NULL,NULL,2,NULL,''),(6,'pb19950516','365719444@qq.com','365719444@qq.com',0,'15620942752',0,1,'2016-07-21 00:00:00.000000',NULL,NULL,2,NULL,''),(8,'123','123','123',0,'123',0,0,'2016-07-21 00:00:00.000000',NULL,NULL,2,NULL,''),(9,'123','555','555',1,'15620830149',0,1,'2016-07-21 00:00:00.000000','622848002812551452',6,1,'小王',''),(10,'123','41@qq.com','41@qq.com',0,'15620942728',0,0,'2016-07-22 00:00:00.000000',NULL,NULL,1,NULL,''),(11,'123','412@qq.com','412@qq.com',0,'15620942728',0,2,'2016-07-22 00:00:00.000000',NULL,NULL,2,NULL,''),(12,'pb19950516','411@qq.com','411@qq.com',0,'15620942728',0,0,'2016-07-22 00:00:00.000000',NULL,NULL,2,NULL,''),(13,'123','123@qq.com','123@qq.com',0,'15620942728',1,0,'2016-07-22 00:00:00.000000',NULL,NULL,2,'333',''),(14,'111','11@qq.com','11@qq.com',0,'13688888888',1,0,'2016-07-30 00:00:00.000000',NULL,0,2,'111','........../file/userHead/14/98f7fe957c18405997c43d198ca045c2.jpg'),(15,'123','zxczxc@qq.com','zxczxc@qq.com',0,'123',0,0,'2016-08-08 00:00:00.000000',NULL,NULL,1,NULL,''),(16,'111','36511','36511',0,'15622222222',0,0,'2016-08-09 00:00:00.000000',NULL,NULL,1,NULL,'');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
