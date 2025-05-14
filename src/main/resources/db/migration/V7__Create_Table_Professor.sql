CREATE TABLE IF NOT EXISTS `professor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `disciplina_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKpk1omryj5cud6uslkepgyfrca` (`cpf`),
  UNIQUE KEY `UKqjm28ojevoom770jyieljec3e` (`email`),
  UNIQUE KEY `UKo38itxyf0p308vdivy4alyn8e` (`telefone`),
  KEY `FKjd5tffs6nybojju4abe15tq78` (`disciplina_id`),
  CONSTRAINT `FKjd5tffs6nybojju4abe15tq78` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplina` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;