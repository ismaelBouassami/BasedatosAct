-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Temps de generació: 07-05-2023 a les 20:02:47
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
-- Base de dades: `exercici03`
--
CREATE DATABASE IF NOT EXISTS `exercici03` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `exercici03`;

-- --------------------------------------------------------

--
-- Estructura de la taula `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `cognoms` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `poblacio` varchar(100) NOT NULL,
  `any` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Bolcament de dades per a la taula `persona`
--

INSERT INTO `persona` (`id`, `nom`, `cognoms`, `email`, `poblacio`, `any`) VALUES
(1, 'David', 'Sala Llopis', 'davidsala@simarro.org', 'Xàtiva', 2000),
(2, 'Marta', 'Palop Ortí', 'martapalop@simarro.org', 'Xàtiva', 2005),
(3, 'Joan', 'Oltra Alberola', 'joanoltra@simarro.org', 'Barxeta', 2003),
(4, 'Anna', 'Seguí Orts', 'annasegui@simarro.org', 'Barxeta', 1998),
(5, 'Susanna', 'Salom Gisbert', 'susannasalom@simarro.org', 'Barxeta', 2010),
(6, 'Sergi', 'Alabort Abarca', 'sergialabort@simarro.org', 'Carcaixent', 2001),
(7, 'Sònia', 'Cubells Caroig', 'soniacubells@simarro.org', 'Carcaixent', 1995),
(8, 'Filomena', 'Faus Grau', 'filomenafaus@simarro.org', 'Carcaixent', 2005),
(9, 'Xavi', 'Ribera Sellent', 'xaviribera@simarro.org', 'Llutxent', 2002),
(10, 'Enric', 'Benavent Llopart', 'enricbenavent@simarro.org', 'Benicolet', 2005),
(11, 'Teresa', 'Amat Peris', 'teresaamat@simarro.org', 'Rafelcofer', 2005),
(12, 'Rubén', 'Gisbert Sella', 'rubengisbert@simarro.org', 'Algemesí', 2007),
(13, 'Amadeu', 'Mahiques Margarit', 'amadeumahiques@simarro.org', 'Algemesí', 2000),
(14, 'Dària', 'Gomis Sala', 'dariagomis@simarro.org', 'Manuel', 1991),
(15, 'Maria', 'Blanc Vallés', 'mariablanc@simarro.org', 'Manuel', 2009),
(16, 'Imma', 'Canet Albert', 'immacanet@simarro.org', 'Llutxent', 1993);

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
