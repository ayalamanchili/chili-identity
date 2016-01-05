--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--


CREATE TABLE `cidocument` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `fileURL` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `clientInformation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CI_RPT_RCPTS` (`clientInformation_id`),
  CONSTRAINT `FK_CI_RPT_RCPTS` FOREIGN KEY (`clientInformation_id`) REFERENCES `clientinformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `cidocument_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `fileURL` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `clientInformation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKD268ECF25B7A65D0` (`REV`),
  CONSTRAINT `FKD268ECF25B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
