-- phpMyAdmin SQL Dump
-- version 2.7.0-pl2
-- http://www.phpmyadmin.net
-- 
-- Servidor: oraclepr.uco.es
-- Tiempo de generación: 05-11-2022 a las 09:28:28
-- Versión del servidor: 5.1.73
-- Versión de PHP: 5.3.3
-- 
-- Base de datos: `i92curam`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Kart`
-- 

CREATE TABLE `Kart` (
  `idKart` int(11) NOT NULL,
  `tipoKart` int(1) NOT NULL,
  `estado` enum('DISPONIBLE','RESERVADO','MANTENIMIENTO') NOT NULL,
  `nombrePista` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  FULLTEXT KEY `nombrePista` (`nombrePista`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Kart`
-- 

INSERT INTO `Kart` VALUES (1, 0, 'DISPONIBLE', NULL);
INSERT INTO `Kart` VALUES (2, 0, 'DISPONIBLE', 'Manzanares');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Pista`
-- 

CREATE TABLE `Pista` (
  `nombrePista` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tipoEstado` int(1) NOT NULL,
  `dificultad` enum('INFANTIL','FAMILIAR','ADULTOS') CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `maxKarts` int(11) NOT NULL,
  `nkartsasociados` int(11) NOT NULL DEFAULT '0',
  FULLTEXT KEY `nombrePista` (`nombrePista`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Pista`
-- 

INSERT INTO `Pista` VALUES ('Manzanares', 0, 'FAMILIAR', 10, 0);
INSERT INTO `Pista` VALUES ('Linares', 1, 'FAMILIAR', 12, 0);
INSERT INTO `Pista` VALUES ('Almodovar', 1, 'FAMILIAR', 6, 0);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Reservas`
-- 

CREATE TABLE `Reservas` (
  `id` varchar(200) NOT NULL,
  `idUsuario` varchar(200) NOT NULL,
  `minutos` int(8) NOT NULL,
  `precio` float NOT NULL,
  `descuento` int(8) NOT NULL,
  `modalidad` varchar(40) NOT NULL,
  `idPista` varchar(200) NOT NULL,
  `numeroNinos` int(8) DEFAULT NULL,
  `numeroAdultos` int(8) DEFAULT NULL,
  `fecha` date NOT NULL,
  `tipo` enum('INFANTIL','FAMILIAR','ADULTOS') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Tabla de reservas';

-- 
-- Volcar la base de datos para la tabla `Reservas`
-- 

