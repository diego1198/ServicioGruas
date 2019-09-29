-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 27-07-2018 a las 04:29:11
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gruas`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarServicio` (`estado` VARCHAR(50), `foraneoLocal` VARCHAR(10), `costoAdicional` FLOAT, `km` INTEGER, `expediente` INTEGER)  BEGIN

 UPDATE basegruas.servicio s
	  SET    s.ESTATUS = estado,
             s.DISTANCIA_LOCAL_FORANEO = foraneoLocal,
			 s.COSTO_ADICIONAL = costoAdicional,
			 s.KILOMETROS= km
             
	  WHERE s.EXPEDIENTE = expediente;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `recuperarServicio` (`ci_operador` VARCHAR(10))  BEGIN

    SELECT s.EXPEDIENTE ,s.TIPO_SEGURO, a.NOMBRE_ASEGURADO, a.APELLIDO_ASEGURADO,s.DESCRIPCION_SERVICIO,
	          v.MARCA_VEHICULO_ASEGURADO, v.MODELO_VEHICULO_ASEGURADO, v.COLOR_VEHICULO_ASEGURADO,
              v.PLACA_VEHICULO_ASEGURADO, s.DIRECCION_DESTINO

       FROM  basegruas.servicio s, basegruas.asegurado a , basegruas.vehiculoasegurado v 

       WHERE    s.CI_OPERADOR LIKE ci_operador 
                and s.ESTATUS LIKE 'pendiente'
                and  s.PLACA_VEHICULO_ASEGURADO  LIKE v.PLACA_VEHICULO_ASEGURADO
                and  v.ID_ASEGURADO LIKE a.ID_ASEGURADO ;


END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradorgruas`
--

CREATE TABLE `administradorgruas` (
  `ID_ADMINISTRADOR` int(11) NOT NULL,
  `USUARIO` varchar(15) DEFAULT NULL,
  `CONTRASENA` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `administradorgruas`
--

INSERT INTO `administradorgruas` (`ID_ADMINISTRADOR`, `USUARIO`, `CONTRASENA`) VALUES
(1718079922, 'Juan Nunez', 'juan123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asegurado`
--

CREATE TABLE `asegurado` (
  `ID_ASEGURADO` char(10) NOT NULL,
  `NOMBRE_ASEGURADO` char(30) DEFAULT NULL,
  `APELLIDO_ASEGURADO` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `asegurado`
--

INSERT INTO `asegurado` (`ID_ASEGURADO`, `NOMBRE_ASEGURADO`, `APELLIDO_ASEGURADO`) VALUES
('0532233186', 'Jaime', 'Pozo'),
('0532253186', 'Jose', 'Duran'),
('0534435632', 'Marcelo', 'Camacho'),
('1726354635', 'Jefferson', 'Cango'),
('1732846343', 'Maria', 'Benalcazar'),
('1736928364', 'Gonzalo', 'Pazmiño'),
('2536648232', 'Lorena', 'Lopez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operador`
--

CREATE TABLE `operador` (
  `CI_OPERADOR` char(10) NOT NULL,
  `PLACA_VEHICULO_EMPRESA` char(7) NOT NULL,
  `NOMBRE_OPERADOR` char(50) DEFAULT NULL,
  `APELLIDO_OPERADOR` char(50) DEFAULT NULL,
  `TIPO_LICENCIA` char(2) DEFAULT NULL,
  `USUARIO` varchar(15) NOT NULL,
  `PASSWORD` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `operador`
--

INSERT INTO `operador` (`CI_OPERADOR`, `PLACA_VEHICULO_EMPRESA`, `NOMBRE_OPERADOR`, `APELLIDO_OPERADOR`, `TIPO_LICENCIA`, `USUARIO`, `PASSWORD`) VALUES
('1717922080', 'PBJ6748', 'EDUARDO', 'NUÑEZ', 'C', 'edu', 'edu123'),
('1718079625', 'PBK8320', 'JAVIER', 'NUÑEZ', 'B', 'javier', 'javi123'),
('1718079922', 'PBS2151', 'JUAN', 'NUÑEZ', 'C', 'juan', 'juan123'),
('1721210001', 'PCJ6978', 'CRISTIAN', 'CERON', 'C', 'cristian', 'cristian123'),
('1723350334', 'PCS8252', 'GUSTAVO', 'MOYON', 'C', 'gustavo', 'gustavo123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `EXPEDIENTE` int(11) NOT NULL,
  `CI_OPERADOR` char(10) NOT NULL,
  `ID_ADMINISTRADOR` int(11) NOT NULL,
  `PLACA_VEHICULO_ASEGURADO` char(7) NOT NULL,
  `TIPO_SEGURO` char(30) DEFAULT NULL,
  `FECHA_SERVICIO` date DEFAULT NULL,
  `DESCRIPCION_SERVICIO` char(60) DEFAULT NULL,
  `DIRECCION_ORIGEN` char(60) DEFAULT NULL,
  `DIRECCION_DESTINO` char(60) DEFAULT NULL,
  `ESTATUS` char(30) DEFAULT NULL,
  `DISTANCIA_LOCAL_FORANEO` char(10) DEFAULT NULL,
  `COSTO_SIN_IVA` float DEFAULT NULL,
  `COSTO_ADICIONAL` float DEFAULT NULL,
  `KILOMETROS` int(11) DEFAULT NULL,
  `OBSERVACIONES` char(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`EXPEDIENTE`, `CI_OPERADOR`, `ID_ADMINISTRADOR`, `PLACA_VEHICULO_ASEGURADO`, `TIPO_SEGURO`, `FECHA_SERVICIO`, `DESCRIPCION_SERVICIO`, `DIRECCION_ORIGEN`, `DIRECCION_DESTINO`, `ESTATUS`, `DISTANCIA_LOCAL_FORANEO`, `COSTO_SIN_IVA`, `COSTO_ADICIONAL`, `KILOMETROS`, `OBSERVACIONES`) VALUES
(1924523, '1721210001', 1718079922, 'PHT0694', 'GENERALLI', '2018-07-20', 'GRUA', 'OCCIDENTAL Y FLORIDA', 'CONDADO', 'TERMINADO', 'LOCAL', 10, 0, 0, NULL),
(1925425, '1721210001', 1718079922, 'PHT0694', 'ASEGURADORA DEL SUR', '2018-07-13', 'GRUA', 'GUAMANI', 'ORELLANA', 'TERMINADO', 'FORANEO', 7, 0, 7, NULL),
(1934546, '1717922080', 1718079922, 'PJG2431', 'ASEGURADORA DEL SUR', '2018-07-21', 'PASO DE CORRIENTE', 'SANGOLQUI', 'null', 'TERMINADO', 'FORANEO', 7, 0, 24, NULL),
(1942389, '1718079625', 1718079922, 'GTE3244', 'SUCRE', '2018-07-26', 'CERRAJERÍA VIAL', 'GUAMANI', 'null', 'terminado', 'LOCAL', 7, 0, 7, 'null'),
(1945589, '1717922080', 1718079922, 'JDA3243', 'CONSTITUCION', '2018-07-24', 'CAMBIO DE LLANTA', 'NACIONES UNIDAS', '', 'TERMINADO', 'LOCAL', 7, 0, 0, 'null'),
(1945673, '1718079922', 1718079922, 'XBA8674', 'SUCRE', '2018-07-01', 'GRUA', 'GUAJALO', 'CARAPUNGO', 'TERMINADO', 'FORANEO', 10, 0, 11, NULL),
(1953243, '1718079922', 1718079922, 'JTA3952', 'PACIFICARD', '2018-07-21', 'GRUA', 'CONOCOTO', 'GUAJALO', 'TERMINADO', 'FORANEO', 10, 0, 20, NULL),
(1956533, '1723350334', 1718079922, 'PDF4354', 'ALIANZA', '2018-07-12', 'GRUA', 'NAPO', 'ORELLANA', 'TERMINADO', 'LOCAL', 10, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculoasegurado`
--

CREATE TABLE `vehiculoasegurado` (
  `PLACA_VEHICULO_ASEGURADO` char(7) NOT NULL,
  `ID_ASEGURADO` char(10) NOT NULL,
  `MODELO_VEHICULO_ASEGURADO` char(15) DEFAULT NULL,
  `MARCA_VEHICULO_ASEGURADO` char(20) DEFAULT NULL,
  `COLOR_VEHICULO_ASEGURADO` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vehiculoasegurado`
--

INSERT INTO `vehiculoasegurado` (`PLACA_VEHICULO_ASEGURADO`, `ID_ASEGURADO`, `MODELO_VEHICULO_ASEGURADO`, `MARCA_VEHICULO_ASEGURADO`, `COLOR_VEHICULO_ASEGURADO`) VALUES
('GTE3244', '0534435632', 'SONATA', 'HYUNDAI', 'NEGRO'),
('JDA3243', '0532233186', 'RIO', 'KIA', 'AZUL'),
('JTA3952', '1736928364', 'HILUX', 'TOYOTA', 'PLATEADO'),
('PDF4354', '0532253186', '3', 'MAZDA', 'ROJO'),
('PHT0694', '1732846343', 'CORSA', 'CHEVROLET', 'PLOMO'),
('PJG2431', '1726354635', 'SAIL', 'CHEVROLET', 'VINO'),
('XBA8674', '2536648232', 'SENTRA', 'NISSAN', 'AMARILLO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculoempresa`
--

CREATE TABLE `vehiculoempresa` (
  `PLACA_VEHICULO_EMPRESA` char(7) NOT NULL,
  `MODELO_VEHICULO_EMPRESA` char(15) DEFAULT NULL,
  `MARCA_VEHICULO_EMPRESA` char(20) DEFAULT NULL,
  `COLOR_VEHICULO_EMPRESA` char(10) DEFAULT NULL,
  `TIPO_VEHICULO_EMPRESA` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vehiculoempresa`
--

INSERT INTO `vehiculoempresa` (`PLACA_VEHICULO_EMPRESA`, `MODELO_VEHICULO_EMPRESA`, `MARCA_VEHICULO_EMPRESA`, `COLOR_VEHICULO_EMPRESA`, `TIPO_VEHICULO_EMPRESA`) VALUES
('IG994D', 'DSR', 'UM', 'ROJO', 'MOTO'),
('PBJ6748', 'I10', 'HYUNDAI', 'BLANCO', 'AUTOMOVIL'),
('PBK8320', 'I10', 'HYUNDAI', 'BLANCO', 'AUTOMOVIL'),
('PBS2151', 'H65', 'HYUNDAI', 'BLANCO', 'GRUA'),
('PCJ6978', 'H65', 'HYUNDAI', 'BLANCO', 'GRUA'),
('PCO7566', 'D-MAX', 'CHEVROLET', 'VINO', 'CAMIONETA'),
('PCS8252', 'H65', 'HYUNDAI', 'BLANCO', 'GRUA');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradorgruas`
--
ALTER TABLE `administradorgruas`
  ADD PRIMARY KEY (`ID_ADMINISTRADOR`);

--
-- Indices de la tabla `asegurado`
--
ALTER TABLE `asegurado`
  ADD PRIMARY KEY (`ID_ASEGURADO`);

--
-- Indices de la tabla `operador`
--
ALTER TABLE `operador`
  ADD PRIMARY KEY (`CI_OPERADOR`),
  ADD KEY `FK_ASIGNA` (`PLACA_VEHICULO_EMPRESA`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`EXPEDIENTE`),
  ADD KEY `FK_ADMINISTRA` (`ID_ADMINISTRADOR`),
  ADD KEY `FK_REALIZA` (`CI_OPERADOR`),
  ADD KEY `FK_SE_REALIZA_A` (`PLACA_VEHICULO_ASEGURADO`);

--
-- Indices de la tabla `vehiculoasegurado`
--
ALTER TABLE `vehiculoasegurado`
  ADD PRIMARY KEY (`PLACA_VEHICULO_ASEGURADO`),
  ADD KEY `FK_PERTENECE` (`ID_ASEGURADO`);

--
-- Indices de la tabla `vehiculoempresa`
--
ALTER TABLE `vehiculoempresa`
  ADD PRIMARY KEY (`PLACA_VEHICULO_EMPRESA`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `operador`
--
ALTER TABLE `operador`
  ADD CONSTRAINT `FK_ASIGNA` FOREIGN KEY (`PLACA_VEHICULO_EMPRESA`) REFERENCES `vehiculoempresa` (`PLACA_VEHICULO_EMPRESA`);

--
-- Filtros para la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD CONSTRAINT `FK_ADMINISTRA` FOREIGN KEY (`ID_ADMINISTRADOR`) REFERENCES `administradorgruas` (`ID_ADMINISTRADOR`),
  ADD CONSTRAINT `FK_REALIZA` FOREIGN KEY (`CI_OPERADOR`) REFERENCES `operador` (`CI_OPERADOR`),
  ADD CONSTRAINT `FK_SE_REALIZA_A` FOREIGN KEY (`PLACA_VEHICULO_ASEGURADO`) REFERENCES `vehiculoasegurado` (`PLACA_VEHICULO_ASEGURADO`);

--
-- Filtros para la tabla `vehiculoasegurado`
--
ALTER TABLE `vehiculoasegurado`
  ADD CONSTRAINT `FK_PERTENECE` FOREIGN KEY (`ID_ASEGURADO`) REFERENCES `asegurado` (`ID_ASEGURADO`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
