CREATE TABLE IF NOT EXISTS `turma` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ano_letivo` varchar(4) NOT NULL,
  `nome` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;