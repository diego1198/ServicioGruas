-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-10-2019 a las 16:39:14
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gruas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE `client` (
  `cliId` varchar(10) NOT NULL,
  `cliname` varchar(100) DEFAULT NULL,
  `cliphone` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`cliId`, `cliname`, `cliphone`) VALUES
('0532233186', 'Jaime', 987823786),
('0532253186', 'Jose', 969098908),
('0534435632', 'Marcelo', 998709786),
('1726354635', 'Jefferson', 993035046),
('1732846343', 'Maria', 987843628),
('1736928364', 'Gonzalo', 987570391),
('2536648232', 'Lorena', 983179531);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `companyvehicle`
--

CREATE TABLE `companyvehicle` (
  `cvid` int(11) NOT NULL,
  `cvmodel` char(15) CHARACTER SET utf8 DEFAULT NULL,
  `cvbrand` char(20) CHARACTER SET utf8 DEFAULT NULL,
  `cvcolor` char(10) CHARACTER SET utf8 DEFAULT NULL,
  `cvplate` char(7) CHARACTER SET utf8 DEFAULT NULL,
  `cvtype` char(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `companyvehicle`
--

INSERT INTO `companyvehicle` (`cvid`, `cvmodel`, `cvbrand`, `cvcolor`, `cvplate`, `cvtype`) VALUES
(1, 'DSR', 'UM', 'ROJO', 'IG994D', 'MOTO'),
(2, 'I10', 'HYUNDAI', 'BLANCO', 'PBJ6748', 'AUTOMOVIL'),
(3, 'I10', 'HYUNDAI', 'BLANCO', 'PBK8320', 'AUTOMOVIL'),
(4, 'H65', 'HYUNDAI', 'BLANCO', 'PBS2151', 'GRUA'),
(5, 'H65', 'HYUNDAI', 'BLANCO', 'PCJ6978', 'GRUA'),
(6, 'D-MAX', 'CHEVROLET', 'VINO', 'PCO7566', 'CAMIONETA'),
(7, 'H65', 'HYUNDAI', 'BLANCO', 'PCS8252', 'GRUA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cranemanager`
--

CREATE TABLE `cranemanager` (
  `cmid` int(11) NOT NULL,
  `cmuser` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `cmpass` varchar(15) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cranemanager`
--

INSERT INTO `cranemanager` (`cmid`, `cmuser`, `cmpass`) VALUES
(1719568378, 'Henry Aguaiza', 'henry123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operator`
--

CREATE TABLE `operator` (
  `opid` char(10) CHARACTER SET utf8 NOT NULL,
  `cmid` int(11) NOT NULL,
  `opname` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `oplastname` char(50) CHARACTER SET utf8 DEFAULT NULL,
  `oplicense` char(2) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `operator`
--

INSERT INTO `operator` (`opid`, `cmid`, `opname`, `oplastname`, `oplicense`) VALUES
('1717922080', 1719568378, 'EDUARDO', 'NUÑEZ', 'C'),
('1718079625', 1719568378, 'JAVIER', 'NUÑEZ', 'B'),
('1718079922', 1719568378, 'JUAN', 'NUÑEZ', 'C'),
('1721210001', 1719568378, 'CRISTIAN', 'CERON', 'C'),
('1723350334', 1719568378, 'GUSTAVO', 'MOYON', 'C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `report`
--

CREATE TABLE `report` (
  `repid` int(11) NOT NULL,
  `cliId` varchar(10) DEFAULT NULL,
  `servid` varchar(5) DEFAULT NULL,
  `opid` char(10) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `report`
--

INSERT INTO `report` (`repid`, `cliId`, `servid`, `opid`) VALUES
(1, '0532233186', '19245', '1717922080'),
(2, '0532233186', '19456', '1723350334'),
(3, '0534435632', '19345', '1717922080'),
(4, '1736928364', '19565', '1721210001');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service`
--

CREATE TABLE `service` (
  `servid` varchar(5) NOT NULL,
  `service date` date NOT NULL,
  `servbrand` varchar(50) DEFAULT NULL,
  `servmodel` varchar(200) DEFAULT NULL,
  `servcolor` char(100) DEFAULT NULL,
  `servplate` char(10) DEFAULT NULL,
  `servorig` char(200) DEFAULT NULL,
  `servdest` char(200) DEFAULT NULL,
  `servcost` decimal(10,0) DEFAULT NULL,
  `servunity` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `service`
--

INSERT INTO `service` (`servid`, `service date`, `servbrand`, `servmodel`, `servcolor`, `servplate`, `servorig`, `servdest`, `servcost`, `servunity`) VALUES
('19245', '2018-07-20', 'Abarth', 'Spider124', 'NEGRO', 'PHT0694', 'OCCIDENTAL Y FLORIDA', 'CONDADO', '10', '0'),
('19254', '2018-07-13', 'Alfa Romeo', '4C', 'NEGRO', 'PHT0694', 'GUAMANI', 'ORELLANA', '7', '0'),
('19345', '2018-07-21', 'Alpine', 'A110', 'NEGRO', 'PJG2431', 'SANGOLQUI', 'null', '7', '0'),
('19423', '2018-07-26', 'Audi', 'Q7', 'NEGRO', 'GTE3244', 'GUAMANI', 'null', '7', '0'),
('19455', '2018-07-24', 'Bentley', 'Bentayga', 'NEGRO', 'JDA3243', 'RIO COCA', 'NACIONES UNIDAS', '7', '0'),
('19456', '2018-07-01', 'BMW', 'X6', 'NEGRO', 'XBA8674', 'GUAJALO', 'CARAPUNGO', '10', '0'),
('19532', '2018-07-21', 'Bugatti', 'Chiron', 'NEGRO', 'JTA3952', 'CONOCOTO', 'GUAJALO', '10', '0'),
('19565', '2018-07-12', 'Cadillac', 'SRX', 'NEGRO', 'PDF4354', 'NAPO', 'ORELLANA', '10', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehicle_operator`
--

CREATE TABLE `vehicle_operator` (
  `opid` char(10) CHARACTER SET utf8 NOT NULL,
  `cvid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehicle_operator`
--

INSERT INTO `vehicle_operator` (`opid`, `cvid`) VALUES
('1717922080', 1),
('1718079625', 2),
('1718079922', 3),
('1721210001', 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`cliId`);

--
-- Indices de la tabla `companyvehicle`
--
ALTER TABLE `companyvehicle`
  ADD PRIMARY KEY (`cvid`);

--
-- Indices de la tabla `cranemanager`
--
ALTER TABLE `cranemanager`
  ADD PRIMARY KEY (`cmid`);

--
-- Indices de la tabla `operator`
--
ALTER TABLE `operator`
  ADD PRIMARY KEY (`opid`),
  ADD KEY `FK_RELATIONSHIP_7` (`cmid`);

--
-- Indices de la tabla `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`repid`),
  ADD KEY `FK_RELATIONSHIP_4` (`cliId`),
  ADD KEY `FK_RELATIONSHIP_5` (`servid`),
  ADD KEY `FK_RELATIONSHIP_6` (`opid`);

--
-- Indices de la tabla `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`servid`);

--
-- Indices de la tabla `vehicle_operator`
--
ALTER TABLE `vehicle_operator`
  ADD PRIMARY KEY (`opid`,`cvid`),
  ADD KEY `FK_VEHICLE_OPERATOR` (`cvid`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `operator`
--
ALTER TABLE `operator`
  ADD CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`cmid`) REFERENCES `cranemanager` (`cmid`);

--
-- Filtros para la tabla `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`cliId`) REFERENCES `client` (`cliId`),
  ADD CONSTRAINT `FK_RELATIONSHIP_5` FOREIGN KEY (`servid`) REFERENCES `service` (`servid`),
  ADD CONSTRAINT `FK_RELATIONSHIP_6` FOREIGN KEY (`opid`) REFERENCES `operator` (`opid`);

--
-- Filtros para la tabla `vehicle_operator`
--
ALTER TABLE `vehicle_operator`
  ADD CONSTRAINT `FK_VEHICLE_OPERATOR` FOREIGN KEY (`cvid`) REFERENCES `companyvehicle` (`cvid`),
  ADD CONSTRAINT `FK_VEHICLE_OPERATOR1` FOREIGN KEY (`opid`) REFERENCES `operator` (`opid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
