-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.24 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for kookschool
CREATE DATABASE IF NOT EXISTS `kookschool` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kookschool`;

-- Dumping structure for table kookschool.deelnemers
CREATE TABLE IF NOT EXISTS `deelnemers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `naam` varchar(50) NOT NULL,
  `voornaam` varchar(50) NOT NULL,
  `geboorte_datum` varchar(50) DEFAULT NULL,
  `geslacht` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `betaald_bedrag` double NOT NULL,
  `verwijderd` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table kookschool.deelnemers: ~4 rows (approximately)
/*!40000 ALTER TABLE `deelnemers` DISABLE KEYS */;
INSERT INTO `deelnemers` (`id`, `naam`, `voornaam`, `geboorte_datum`, `geslacht`, `betaald_bedrag`, `verwijderd`) VALUES
	(20, 'Veldkamp', 'Pricilla', '1993/04/16', 'V', 2500, 0),
	(22, 'Bandhoe', 'Prevish', '1994/12/12', 'M', 2500, 0),
	(24, 'Sebede', 'Tatshana', '1993/11/23', 'V', 2500, 0),
	(25, 'Pique', 'Anoeska', '2000/06/07', 'V', 2500, 0),
	(26, 'Sabajo', 'Merugia', '1996/05/02', 'V', 2500, 0),
	(27, 'Sidokromo', 'Randall', '1992/02/01', 'M', 2500, 0),
	(28, 'Wagiman', 'Sukimin', '1967/04/06', 'M', 2500, 0);
/*!40000 ALTER TABLE `deelnemers` ENABLE KEYS */;

-- Dumping structure for table kookschool.kookcursus
CREATE TABLE IF NOT EXISTS `kookcursus` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cursus_naam` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cursus_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `looptijd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `startdatum` date NOT NULL,
  `verlopen` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `bedrag` double NOT NULL,
  `verwijderd` char(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cursus_code` (`cursus_code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table kookschool.kookcursus: ~5 rows (approximately)
/*!40000 ALTER TABLE `kookcursus` DISABLE KEYS */;
INSERT INTO `kookcursus` (`id`, `cursus_naam`, `cursus_code`, `looptijd`, `startdatum`, `verlopen`, `bedrag`, `verwijderd`) VALUES
	(1, 'Rijst Pom Kip', 'RPOM', '1 week', '2021-05-30', '0', 2500, '0'),
	(2, 'chinise Tjop Suey', 'ctjop', '1 week', '2021-06-01', '0', 2500, '0'),
	(4, 'Tjauwmin kip', 'TJA_KIP', '1 dag', '2021-07-02', '0', 2500, '1'),
	(5, 'Carbonade', 'CARBO', '2 dagen', '2021-06-28', '0', 2500, '0'),
	(6, 'Saoto', 'SAO', '1 dag', '2021-07-01', '0', 2500, '0'),
	(7, 'Gevulde Sopropo', 'GVE', '1 dag', '2021-06-25', '0', 2500, '0');
/*!40000 ALTER TABLE `kookcursus` ENABLE KEYS */;

-- Dumping structure for table kookschool.kookcursus_deelnemer
CREATE TABLE IF NOT EXISTS `kookcursus_deelnemer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `kookcursus_id` bigint NOT NULL,
  `deelnemer_id` bigint NOT NULL,
  `rest_bedrag` double NOT NULL DEFAULT '0',
  `inschrijfdatum` date NOT NULL,
  `resultaat` char(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_constraint_cursus_deelnemer` (`kookcursus_id`,`deelnemer_id`) USING BTREE,
  KEY `FK_kookcursus_deelnemer_deelnemers` (`deelnemer_id`),
  CONSTRAINT `FK_kookcursus_deelnemer_deelnemers` FOREIGN KEY (`deelnemer_id`) REFERENCES `deelnemers` (`id`),
  CONSTRAINT `FK_kookcursus_deelnemer_kookcursus` FOREIGN KEY (`kookcursus_id`) REFERENCES `kookcursus` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table kookschool.kookcursus_deelnemer: ~4 rows (approximately)
/*!40000 ALTER TABLE `kookcursus_deelnemer` DISABLE KEYS */;
INSERT INTO `kookcursus_deelnemer` (`id`, `kookcursus_id`, `deelnemer_id`, `rest_bedrag`, `inschrijfdatum`, `resultaat`) VALUES
	(8, 5, 26, 0, '2021-06-24', '0'),
	(9, 2, 22, 0, '2021-06-24', '0'),
	(10, 7, 25, 0, '2021-06-24', '0'),
	(11, 6, 28, 0, '2021-06-24', '0'),
	(12, 4, 20, 0, '2021-06-24', '0'),
	(13, 1, 22, 0, '2021-06-24', '0'),
	(14, 4, 24, 0, '2021-06-24', '0'),
	(15, 5, 25, 0, '2021-06-24', '0');
/*!40000 ALTER TABLE `kookcursus_deelnemer` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
