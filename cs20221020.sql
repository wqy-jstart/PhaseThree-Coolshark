-- MariaDB dump 10.19  Distrib 10.5.17-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: cs
-- ------------------------------------------------------
-- Server version	10.5.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
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
INSERT INTO `product` VALUES (2,'雪中飞墨绿色短袖t恤女夏2022新款纯棉半袖打底体恤夏季上衣潮ins','/4c5d4484-21e7-476c-9596-7097484bce17.jpg',233.00,598.00,2333,10000,139,'2022-10-19 06:40:20',3),(4,'森马牛仔裤女宽松慢跑裤运动风2022春季新款显瘦束脚长裤复古','/4c367aa2-39fd-4504-aa06-cedb0c4ae082.jpg',333.00,598.00,4333,10000,172,'2022-10-19 06:40:38',2),(5,'茵曼马甲连衣裙两件套春季新款娃娃领色织格长袖背心裙套装','/fd18f4f3-77ac-4320-bf4c-3b09a3b70810.jpg',233.00,589.00,3333,10000,2,'2022-10-19 03:53:27',2),(6,'【佟丽娅同款】鸭鸭明星同款羽绒服2021年冬季新款时尚连帽外套冬','/2054c647-fe08-4971-90ea-7e8c0b630cf5.jpg',233.00,598.00,1333,10000,5,'2022-10-19 06:41:06',2),(7,'BEASTER小恶魔鬼脸明星同款夹克毛绒保暖加厚字母印花宽松外套ins','/7866bb08-66be-45c2-8dc9-9f84f6a2515b.jpg',233.00,598.00,2333,10000,17,'2022-10-19 06:30:33',3),(8,'香影毛呢外套女中长款2021年冬季新款气质韩版娃娃领紫色呢子大衣','/146eb4cf-16eb-4d23-b60e-5e0a51d127fe.jpg',233.00,598.00,2333,10000,2,'2022-10-19 02:41:29',2),(9,'SEMIR森马商场同款打底针织毛衣纯色高领新品显瘦','/cd4d9572-dc73-4c2d-8207-b41c5da98164.jpg',233.00,598.00,2333,10000,6,'2022-10-19 06:30:19',1),(10,'美特斯邦威女MTEE 贺岁系列中长款风衣736598','/313048df-7446-4206-bb62-43419283a1cb.jpg',233.00,598.00,2333,10000,1,'2022-10-19 04:58:11',3),(11,'imone2021秋款黑色小西装外套女韩版学生宽松学院风外套jk外套','/4ab75201-371d-49d1-868a-f63b6f8925a4.jpg',233.00,598.00,2333,10000,1,'2022-10-19 03:53:28',3),(12,'BEASTER 小恶魔明星同款保暖长袖街头潮流连帽卫衣情侣上衣','/3243e5c8-e64d-428b-8f9f-a73f08428e35.jpg',233.00,598.00,2333,10000,0,'2022-10-18 08:43:36',3),(13,'憨厚皇后100%绵羊皮2021秋海宁真皮皮衣女长款修身绵羊皮风衣外','/4a747e10-8bbd-43b9-bf4e-f7efab84474e.jpg',233.00,598.00,2333,10000,0,'2022-10-19 01:18:49',2),(14,'美特斯邦威高腰牛仔裤女宽松小脚新款春秋彩色潮流女士牛仔','/99a7ed0d-7ee4-45a0-a7d5-9ece3e2a6b85.jpg',233.00,589.00,2333,10000,0,'2022-10-18 08:45:18',2),(15,'美食甜点','/49d59b10-2512-4313-9d1e-32808a40d368.jpg',59.00,89.00,5000,10000,5,'2022-10-19 06:30:38',4),(16,'鲨鱼电脑','/d68bf56b-e799-4b0f-ba50-9d1f1093bd73.png',12900.00,30000.00,500,1000,4,'2022-10-19 07:13:48',9),(17,'无污染挎包','/c288476f-ba38-4333-b3f1-76349e573ea8.jpg',299.00,599.00,3000,10000,3,'2022-10-19 07:23:52',5);
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

-- Dump completed on 2022-10-20 20:50:06
