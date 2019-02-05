CREATE TABLE `funcionario` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `sexo` char(1) NOT NULL,
  `rg` varchar(20) NOT NULL,
  `orgao_emissor` varchar(10) NOT NULL,
  `data_nascimento` date NOT NULL,
  `cargo` varchar(200) DEFAULT NULL,
  `setor` varchar(200) DEFAULT NULL,
  `data_admissao` date NOT NULL,
  `data_demissao` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `tipo_exame` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `descricao` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `exame` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_tipo_exame` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `data_exame` date NOT NULL,
  `parecer_medico` varchar(200) DEFAULT NULL,
  `data_emissao_aso` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_tipo_exame`) REFERENCES `tipo_exame`(`id`),
  FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario`(`id`)
);

INSERT INTO `funcionario` (`id`, `nome`, `sexo`, `rg`, `orgao_emissor`, `data_nascimento`, `cargo`, `setor`, `data_admissao`, `data_demissao`) VALUES
(1, 'DIEGO MENDOZA FERREIRA', 'M', '460769698', 'SSP/SP', '1989-08-10', 'ANALISTA DE SISTEMAS', 'DESENVOLVIMENTO', '2016-01-04', NULL);

INSERT INTO `tipo_exame` (`id`, `descricao`) VALUES
(1, 'Admissional'),
(2, 'Periódico'),
(3, 'Demissional'),
(4, 'Mudança de Função'),
(5, 'Retorno ao Trabalho');

INSERT INTO `exame` (`id`, `id_tipo_exame`, `id_funcionario`, `data_exame`, `parecer_medico`, `data_emissao_aso`) VALUES
(1, 2, 1, '2019-02-05', NULL, NULL);