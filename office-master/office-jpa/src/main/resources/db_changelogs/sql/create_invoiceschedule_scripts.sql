
--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `invoiceschedule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `endDate` date NOT NULL,
  `notes` longtext,
  `reminderDays` int(11) NOT NULL,
  `startDate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `invoiceschedule_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `notes` longtext,
  `reminderDays` int(11) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKB55AA0955B7A65D0` (`REV`),
  CONSTRAINT `FKB55AA0955B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;