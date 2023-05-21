-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Temps de generació: 07-05-2023 a les 20:03:29
-- Versió del servidor: 10.4.24-MariaDB
-- Versió de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `exercici04`
--
DROP DATABASE IF EXISTS `exercici04`;
CREATE DATABASE IF NOT EXISTS `exercici04` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `exercici04`;

-- --------------------------------------------------------

--
-- Estructura de la taula `ciutat`
--

DROP TABLE IF EXISTS `ciutat`;
CREATE TABLE `ciutat` (
  `idciutat` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `comarca` varchar(100) NOT NULL,
  `habitants` int(11) NOT NULL,
  `altitud` int(11) NOT NULL,
  `codipostal` int(11) NOT NULL,
  `festes` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `ciutat`
--
ALTER TABLE `ciutat`
  ADD PRIMARY KEY (`idciutat`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `ciutat`
--
ALTER TABLE `ciutat`
  MODIFY `idciutat` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
