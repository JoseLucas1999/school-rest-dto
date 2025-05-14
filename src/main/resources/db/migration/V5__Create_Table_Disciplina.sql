CREATE TABLE IF NOT EXISTS `disciplina` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `carga_horaria` int(11) NOT NULL,
  `descricao` varchar(500) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK5e7mrxyfs14yqtibi2frwwxcc` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;