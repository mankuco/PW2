-- phpMyAdmin SQL Dump
-- version 2.7.0-pl2
-- http://www.phpmyadmin.net
-- 
-- Servidor: oraclepr.uco.es
-- Tiempo de generación: 06-11-2022 a las 21:30:59
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
  `tipoKart` tinyint(1) NOT NULL,
  `estado` enum('DISPONIBLE','RESERVADO','MANTENIMIENTO') NOT NULL,
  `nombrePista` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  FULLTEXT KEY `nombrePista` (`nombrePista`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Kart`
-- 

INSERT INTO `Kart` VALUES (90, 1, 'DISPONIBLE', 'Manzanares');
INSERT INTO `Kart` VALUES (2, 0, 'DISPONIBLE', 'Manzanares');
INSERT INTO `Kart` VALUES (3, 0, 'MANTENIMIENTO', 'GrandPrix');
INSERT INTO `Kart` VALUES (9, 0, 'DISPONIBLE', NULL);
INSERT INTO `Kart` VALUES (5, 1, 'DISPONIBLE', NULL);
INSERT INTO `Kart` VALUES (6, 0, 'DISPONIBLE', 'Guadalcazar');
INSERT INTO `Kart` VALUES (100, 1, 'RESERVADO', NULL);
INSERT INTO `Kart` VALUES (10, 1, 'DISPONIBLE', 'Galicia');

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

INSERT INTO `Pista` VALUES ('Manzanares', 0, 'FAMILIAR', 10, 2);
INSERT INTO `Pista` VALUES ('Linares', 1, 'FAMILIAR', 12, 0);
INSERT INTO `Pista` VALUES ('Galicia', 1, 'ADULTOS', 6, 1);
INSERT INTO `Pista` VALUES ('Jerez', 1, 'ADULTOS', 20, 0);
INSERT INTO `Pista` VALUES ('Aranjuez', 1, 'ADULTOS', 12, 0);
INSERT INTO `Pista` VALUES ('Guadalcazar', 1, 'INFANTIL', 30, 1);
INSERT INTO `Pista` VALUES ('GrandPrix', 1, 'FAMILIAR', 9, 1);

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

INSERT INTO `Reservas` VALUES ('9e09d950-5eaa-4e43-b99b-22975ee43c69', 'manuel@gmail.com', 20, 20, 0, 'Individual', '1', 12, 1, '2022-11-06', 'FAMILIAR');
INSERT INTO `Reservas` VALUES ('1689111f-215e-4f59-8ba5-5f25dd2318fd', 'carlos@gmail.com', 30, 20, 0, 'Individual', '2', NULL, 12, '2022-11-06', 'ADULTOS');
INSERT INTO `Reservas` VALUES ('946ac310-70b9-4bf2-ba07-ca113fafd278', 'carlos@gmail.com', 70, 0, 0, 'Bono', '3', 34, NULL, '2023-11-11', 'INFANTIL');
INSERT INTO `Reservas` VALUES ('5efe2881-6a85-4fd5-a8c8-1ff2601f057f', 'miguel@gmail.com', 55, 20, 0, 'Individual', '1', 1, 2, '2022-11-06', 'FAMILIAR');
INSERT INTO `Reservas` VALUES ('915ac951-c1d0-4edd-8acd-c1db21613312', 'carlos@gmail.com', 120, 40, 0, 'Individual', '2', NULL, 12, '2022-11-06', 'ADULTOS');
INSERT INTO `Reservas` VALUES ('d25c1282-08e1-4b14-9868-127c985360ac', 'antonio@gmail.com', 111, 28.5, 0, 'Bono', '2', NULL, 2, '2022-12-12', 'ADULTOS');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Usuario`
-- 

CREATE TABLE `Usuario` (
  `nombre` varchar(200) NOT NULL,
  `apellidos` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `fechaInscripcion` date NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Tabla de usuarios';

-- 
-- Volcar la base de datos para la tabla `Usuario`
-- 

INSERT INTO `Usuario` VALUES ('Miguel', 'Jiménez', 'miguel@gmail.com', '1964-12-20', '2022-11-06');
INSERT INTO `Usuario` VALUES ('Carlos', 'Córdoba', 'carlos@gmail.com', '1945-12-20', '2022-11-06');
INSERT INTO `Usuario` VALUES ('Antonio', 'Gonzalez', 'antonio@gmail.com', '2001-12-12', '2022-11-06');
INSERT INTO `Usuario` VALUES ('Manuel', 'De la Cueva', 'manuel@gmail.com', '2000-11-04', '2022-11-06');
