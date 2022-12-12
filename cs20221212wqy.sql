-- MySQL dump 10.16  Distrib 10.3.7-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: cs
-- ------------------------------------------------------
-- Server version	10.3.7-MariaDB

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
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(202) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` VALUES (2,'/imgs/b2.jpg'),(3,'/imgs/b3.jpg'),(5,'/imgs/b1.jpg');
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'精彩活动'),(2,'当季女装'),(3,'品牌男装'),(4,'环球美食'),(5,'医药健康'),(9,'电脑'),(11,'恐龙');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `old_price` double(10,2) DEFAULT NULL,
  `sale_count` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT current_timestamp(),
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'雪中飞墨绿色短袖t恤女夏2022新款纯棉半袖打底体恤夏季上衣潮ins','/imgs/a.jpg',233.00,598.00,2333,10000,140,'2022-10-19 06:40:20',3),(4,'森马牛仔裤女宽松慢跑裤运动风2022春季新款显瘦束脚长裤复古','/imgs/b.jpg',333.00,598.00,4333,10000,172,'2022-10-19 06:40:38',2),(5,'茵曼马甲连衣裙两件套春季新款娃娃领色织格长袖背心裙套装','/imgs/b1.jpg',233.00,589.00,3333,10000,2,'2022-10-19 03:53:27',2),(6,'【佟丽娅同款】鸭鸭明星同款羽绒服2021年冬季新款时尚连帽外套冬','/imgs/b2.jpg',233.00,598.00,1333,10000,5,'2022-10-19 06:41:06',2),(7,'BEASTER小恶魔鬼脸明星同款夹克毛绒保暖加厚字母印花宽松外套ins','/imgs/b3.jpg',233.00,598.00,2333,10000,17,'2022-10-19 06:30:33',3),(8,'香影毛呢外套女中长款2021年冬季新款气质韩版娃娃领紫色呢子大衣','/imgs/b4.jpg',233.00,598.00,2333,10000,2,'2022-10-19 02:41:29',2),(9,'SEMIR森马商场同款打底针织毛衣纯色高领新品显瘦','/imgs/c.jpg',233.00,598.00,2333,10000,8,'2022-10-19 06:30:19',1),(10,'美特斯邦威女MTEE 贺岁系列中长款风衣736598','/imgs/d.jpg',233.00,598.00,2333,10000,1,'2022-10-19 04:58:11',3),(11,'imone2021秋款黑色小西装外套女韩版学生宽松学院风外套jk外套','/imgs/e.jpg',233.00,598.00,2333,10000,1,'2022-10-19 03:53:28',3),(12,'BEASTER 小恶魔明星同款保暖长袖街头潮流连帽卫衣情侣上衣','/imgs/f.jpg',233.00,598.00,2333,10000,0,'2022-10-18 08:43:36',3),(13,'憨厚皇后100%绵羊皮2021秋海宁真皮皮衣女长款修身绵羊皮风衣外','/imgs/g.jpg',233.00,598.00,2333,10000,0,'2022-10-19 01:18:49',2),(14,'美特斯邦威高腰牛仔裤女宽松小脚新款春秋彩色潮流女士牛仔','/imgs/h.jpg',233.00,589.00,2333,10000,0,'2022-10-18 08:45:18',2),(15,'美食甜点','/imgs/i.jpg',59.00,89.00,5000,10000,5,'2022-10-19 06:30:38',4),(16,'鲨鱼电脑','/imgs/shark.png',12900.00,30000.00,500,1000,4,'2022-10-19 07:13:48',9),(17,'无污染挎包','/imgs/j.jpg',299.00,599.00,3000,10000,3,'2022-10-19 07:23:52',5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','123456','管理员');
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

-- Dump completed on 2022-12-12 14:22:09
