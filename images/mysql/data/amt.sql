CREATE DATABASE amt;
USE amt;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL UNIQUE,
  `password` varchar(100) DEFAULT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `users` (`userName`, `password`, `firstName`, `lastName`) VALUES ('admin', 'adminpass', 'Admin', 'God');

