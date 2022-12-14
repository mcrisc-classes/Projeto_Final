Create database if not exists ComparsasBanco;

use ComparsasBanco;

DROP TABLE IF EXISTS `carros`;

CREATE TABLE `carros` (
  `placa` varchar(20) NOT NULL,
  `descricao` varchar(40) NOT NULL,
  `duracao` int NOT NULL,
  `quantidade_blocos` int DEFAULT NULL,
  `hora_entrada` datetime NOT NULL,
  `hora_saida` datetime DEFAULT NULL,
  PRIMARY KEY (`placa`)
);

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `cpf` varchar(20) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `n_cliente` int DEFAULT NULL,
  `observacoes` varchar(20) DEFAULT NULL,
  `placa` varchar(20) NOT NULL,
  PRIMARY KEY (`cpf`),
  KEY `n_placa` (`placa`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`placa`) REFERENCES `carros` (`placa`)
);

DROP TABLE IF EXISTS `estacionamento`;

CREATE TABLE `estacionamento` (
  `id` int NOT NULL,
  `vagas_totais` int Not Null,
  `vagas_ocupadas` int NOT NULL,
  `vagas_livre` int DEFAULT NULL,
  `tipo_bloco` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
 
);

DROP TABLE IF EXISTS `vaga`;

create table `vaga`(

	`numero` int NOT NULL,
	`id` int NOT NULL,
	`placa` VARCHAR(20) NOT NULL,
	primary key (`numero`),
	key `id_Es` (`id`),
	constraint `vaga_ibfk_1` foreign key (`id`) references `estacionamento`(`id`),
	key `n_placa` (`placa`),
	constraint `vaga_ibfk_2` foreign key (`placa`) references `carros`(`placa`)
);

DROP TABLE IF EXISTS `tarifa`;

CREATE TABLE `tarifa` (
  `placa` varchar(20) NOT NULL,
  `preco_bloco` float NOT NULL,
  `dt_pagamento` datetime DEFAULT NULL,
  `valor_pago` float DEFAULT NULL,
  PRIMARY KEY (`placa`),
  CONSTRAINT `tarifa_ibfk_1` FOREIGN KEY (`placa`) REFERENCES `carros` (`placa`)
);