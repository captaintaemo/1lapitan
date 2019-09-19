-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.26-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for dbmslapitan21
CREATE DATABASE IF NOT EXISTS `dbmslapitan21` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dbmslapitan21`;

-- Dumping structure for table dbmslapitan21.add_product
CREATE TABLE IF NOT EXISTS `add_product` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` text,
  `p_quantity` int(11) DEFAULT NULL,
  `p_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Dumping data for table dbmslapitan21.add_product: ~14 rows (approximately)
/*!40000 ALTER TABLE `add_product` DISABLE KEYS */;
INSERT INTO `add_product` (`p_id`, `p_name`, `p_quantity`, `p_price`) VALUES
	(1, 'name', 10, 1000),
	(2, 'names', 10, 100),
	(3, 'names', 10, 120),
	(4, 'nnn', 90, 90),
	(5, 'nnnnnnnnn', 890, 9998),
	(6, 'nnnnnnnnnnnn', 80, 9099),
	(7, 'nmkjhgtyui', 880, 887),
	(8, 'hjklkjhgbn', 80, 777),
	(9, 'dgfhjkl;ljhgffhjklh', 10, 888),
	(10, 'fgghjkkhgjk', 10, 888),
	(11, 'asdasda', 10, 1231),
	(12, 'qweqwqw', 220, 12312),
	(13, 'asdsdasdasda', 10, 67890),
	(14, 'cxbvnbn,m.l,/kjhkgf', 8980, 789098);
/*!40000 ALTER TABLE `add_product` ENABLE KEYS */;

-- Dumping structure for table dbmslapitan21.createacc
CREATE TABLE IF NOT EXISTS `createacc` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fname` text,
  `lname` text,
  `username` text,
  `password` text,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table dbmslapitan21.createacc: ~2 rows (approximately)
/*!40000 ALTER TABLE `createacc` DISABLE KEYS */;
INSERT INTO `createacc` (`id`, `fname`, `lname`, `username`, `password`) VALUES
	(1, 'gogo', 'gogogo', 'ggness', 'ggnes'),
	(2, 'admin', 'admin', 'admin', 'admin');
/*!40000 ALTER TABLE `createacc` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
