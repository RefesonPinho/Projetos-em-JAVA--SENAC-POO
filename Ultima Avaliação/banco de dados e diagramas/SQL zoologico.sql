Create database Zoologico;
use Zoologico;
CREATE TABLE `leao` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`alimentacao` INT NOT NULL,
	`visitantes` INT NOT NULL,
	`jaula_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `jaula` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`descricao` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `golfinho` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`treinamento` INT NOT NULL,
	`jaula_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `alimentacao` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`leao_id` INT NOT NULL,
	`data` DATE NOT NULL,
	`detalhes` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `treinamento` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`golfinho_id` INT NOT NULL,
	`data` DATE NOT NULL,
	`detalhes` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `leao` ADD CONSTRAINT `leao_fk0` FOREIGN KEY (`jaula_id`) REFERENCES `jaula`(`id`);

ALTER TABLE `golfinho` ADD CONSTRAINT `golfinho_fk0` FOREIGN KEY (`jaula_id`) REFERENCES `jaula`(`id`);

ALTER TABLE `alimentacao` ADD CONSTRAINT `alimentacao_fk0` FOREIGN KEY (`leao_id`) REFERENCES `leao`(`id`);

ALTER TABLE `treinamento` ADD CONSTRAINT `treinamento_fk0` FOREIGN KEY (`golfinho_id`) REFERENCES `golfinho`(`id`);






