CREATE TABLE IF NOT EXISTS `aluno` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `turma_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcrrvmtky7d9tfarahi4jahewg` (`cpf`),
  UNIQUE KEY `UK3wpes15e0anbfaa4do0pey97k` (`email`),
  UNIQUE KEY `UKfl8l37q9orcs8oepxsk2d3fk5` (`telefone`),
  KEY `FKehtgr8rih20h4gomh4dd4sbxu` (`turma_id`),
  CONSTRAINT `FKehtgr8rih20h4gomh4dd4sbxu` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`)
)