DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `login` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `users` WRITE;

INSERT INTO `users` VALUES ('admin','admin');

UNLOCK TABLES;

DROP TABLE IF EXISTS `allotment`;

CREATE TABLE `allotment` (
  `address` varchar(255) NOT NULL,
  `rent` double NOT NULL,
  `area` varchar(255) NOT NULL,
  `available` tinyint(1) DEFAULT '1',
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `allotment` WRITE;

INSERT INTO allotment(address,rent,area,available) VALUES ('A1',12345,'20x20',1),('A2',1234,'10x10',1),('A3',23234,'200x200',1);

UNLOCK TABLES;


DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `contact_id` int NOT NULL AUTO_INCREMENT,
  `responsible` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_1` varchar(255) NOT NULL,
  `phone_2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `contact` WRITE;

UNLOCK TABLES;

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fantasy_name` varchar(255) NOT NULL,
  `CNPJ` varchar(255) NOT NULL,
  `allotment_address` varchar(255) DEFAULT NULL,
  `contact_id` int DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `activity` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `salesOrServiceProvision` varchar(255) NOT NULL,
  `social_reason` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `allotment_address` (`allotment_address`),
  KEY `contact_id` (`contact_id`),
  CONSTRAINT `store_ibfk_1` FOREIGN KEY (`allotment_address`) REFERENCES `allotment` (`address`),
  CONSTRAINT `store_ibfk_2` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `store` WRITE;


UNLOCK TABLES;




