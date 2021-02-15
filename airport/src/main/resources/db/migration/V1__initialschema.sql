-- CREATE DATABASE `test`;
-- USE `test`;

DROP TABLE IF EXISTS `aeropuerto`;

CREATE TABLE `aeropuerto` (
  `id` bigint NOT NULL,
  `ciudad` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codiata` varchar(3) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pais` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

DROP TABLE IF EXISTS `avion`;

CREATE TABLE `avion` (
  `id` bigint NOT NULL,
  `fabricante` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `horas_vuelo` double DEFAULT NULL,
  `matricula` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `modelo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

DROP TABLE IF EXISTS `mecanico`;

CREATE TABLE `mecanico` (
  `id` bigint NOT NULL,
  `cod_empleado` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `empresa` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `año_incorporacion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `formacion_previa` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

DROP TABLE IF EXISTS `revision`;

CREATE TABLE `revision` (
  `id` bigint NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_fin` datetime(6) DEFAULT NULL,
  `fecha_inicio` datetime(6) DEFAULT NULL,
  `horas` double DEFAULT NULL,
  `tipo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `aeropuerto_id` bigint DEFAULT NULL,
  `avion_id` bigint DEFAULT NULL,
  `mecanico_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5clx7t15sygeqxsqfxl57rpme` (`aeropuerto_id`),
  KEY `FKepufjqvypljnk6si1dhtdcn3r` (`avion_id`),
  KEY `FKau67qcpfipyergrmy3unkdgfn` (`mecanico_id`),
  CONSTRAINT `FK5clx7t15sygeqxsqfxl57rpme` FOREIGN KEY (`aeropuerto_id`) REFERENCES `aeropuerto` (`id`),
  CONSTRAINT `FKau67qcpfipyergrmy3unkdgfn` FOREIGN KEY (`mecanico_id`) REFERENCES `mecanico` (`id`),
  CONSTRAINT `FKepufjqvypljnk6si1dhtdcn3r` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

DROP TABLE IF EXISTS `tripulante`;

CREATE TABLE `tripulante` (
  `id` bigint NOT NULL,
  `cod_empleado` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `empresa` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `formacion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `puesto` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

DROP TABLE IF EXISTS `vuelo`;

CREATE TABLE `vuelo` (
  `id` bigint NOT NULL,
  `cod_vuelo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `compania` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `duracion` double DEFAULT NULL,
  `fecha_hora` datetime(6) DEFAULT NULL,
  `avion_id` bigint DEFAULT NULL,
  `destino_id` bigint DEFAULT NULL,
  `origen_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8j5widj67y5mcf830eqkvth2p` (`avion_id`),
  KEY `FKnvtlv125kssq8a3dt0bdrm1lm` (`destino_id`),
  KEY `FKkbrspynyr16o6kreury553afl` (`origen_id`),
  CONSTRAINT `FK8j5widj67y5mcf830eqkvth2p` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`id`),
  CONSTRAINT `FKkbrspynyr16o6kreury553afl` FOREIGN KEY (`origen_id`) REFERENCES `aeropuerto` (`id`),
  CONSTRAINT `FKnvtlv125kssq8a3dt0bdrm1lm` FOREIGN KEY (`destino_id`) REFERENCES `aeropuerto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

DROP TABLE IF EXISTS `vuelo_tripulante`;

CREATE TABLE `vuelo_tripulante` (
  `tripulante_id` bigint NOT NULL,
  `vuelo_id` bigint NOT NULL,
  PRIMARY KEY (`tripulante_id`,`vuelo_id`),
  KEY `FK5b3ie8vvvgm7yrqf5j7r51n2g` (`vuelo_id`),
  KEY `FKkafyo5jljj8pptv8xly7vdxv`  (`tripulante_id`),
  CONSTRAINT `FK5b3ie8vvvgm7yrqf5j7r51n2g` FOREIGN KEY (`vuelo_id`) REFERENCES `vuelo` (`id`),
  CONSTRAINT `FKkafyo5jljj8pptv8xly7vdxv` FOREIGN KEY (`tripulante_id`) REFERENCES `tripulante` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--- Example data

INSERT INTO `hibernate_sequence` VALUES (11);
INSERT INTO `aeropuerto` VALUES (3,'Madrid','AAA','Adolfo Suárez','España'),(4,'Las Palmas','BBB','LPA','España'),(5,'Nueva York','CCC','JFK','USA');
INSERT INTO `avion` VALUES (1,'Airbus',1500,'00000AAA','775'),(2,'Boeing',856.5,'1111BBB','737');
INSERT INTO `mecanico` VALUES (10,'40288105779b079d01779b07abf50000','El de los palotes','Airbus','Pepito','2021','Universidad de la calle'),(11,'40288105779b079d01779b07ac2c0001','De la Vega','Airbus','Juanito','2020','FP2');
INSERT INTO `revision` VALUES (8,'Comprobación de flaps del avión','2021-01-12 10:55:07.214000','2021-01-11 10:55:07.214000',2,'Reparacion',3,1,10),(9,'Ajuste de turbina','2021-01-12 10:55:07.214000','2021-01-11 10:55:07.214000',3,'Reparacion',3,1,11),(10,'Revision de ruedas','2021-01-12 10:55:07.214000','2021-01-11 10:55:07.214000',1,'Revision',4,2,11);
INSERT INTO `tripulante` VALUES (12,'40288105779b079d01779b07ae010002','Me lavo','Airbus','Jony','Pagada por papa','Capitan del mundo'),(13,'40288105779b079d01779b07ae4b0003','Jhonensen','Iberia','Johnson','Curso de azafato','Azafato');
INSERT INTO `vuelo` VALUES (6,'IB3343','Iberia',2.5,'2021-02-13 09:31:47.214000',1,4,3),(7,'UX3345','Air Europa',9,'2021-02-13 08:41:47.214000',2,5,3);
INSERT INTO `vuelo_tripulante` VALUES (13,6),(13,7);
