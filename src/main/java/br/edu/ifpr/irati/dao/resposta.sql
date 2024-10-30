CREATE TABLE `resposta` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `texto` varchar(70) COLLATE utf8mb3_unicode_ci NOT NULL,
                            `fkIdContato` int NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fkIdContato_idx` (`fkIdContato`),
                            CONSTRAINT `fkIdContato` FOREIGN KEY (`fkIdContato`) REFERENCES `contato` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
