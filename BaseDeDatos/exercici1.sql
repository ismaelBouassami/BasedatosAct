-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Temps de generació: 07-05-2023 a les 20:00:09
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
-- Base de dades: `exercici1`
--
--
DROP DATABASE IF EXISTS `exercici01`;
CREATE DATABASE IF NOT EXISTS `exercici01` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `exercici01`;

-- --------------------------------------------------------

--
-- Estructura de la taula `alumne`
--

DROP TABLE IF EXISTS `alumne`;
CREATE TABLE `alumne` (
  `idalumne` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `cognoms` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `poblacio` varchar(50) NOT NULL,
  `datanaixement` varchar(100) NOT NULL,
  `cicleformatiu` enum('ASIX','DAM','DAW','SMX') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `alumne`
--
ALTER TABLE `alumne`
  ADD PRIMARY KEY (`idalumne`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `alumne`
--
ALTER TABLE `alumne`
  MODIFY `idalumne` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
