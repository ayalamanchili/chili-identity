--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `ClientInformation_Contact` (
  `ClientInformation_id` bigint(20) NOT NULL,
  `recruiters_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ClientInformation_id`,`recruiters_id`),
  KEY `FK_Recruiters_ClientInformations` (`ClientInformation_id`),
  KEY `FKBE7D3E02697BAEA8` (`recruiters_id`),
  CONSTRAINT `FKBE7D3E02697BAEA8` FOREIGN KEY (`recruiters_id`) REFERENCES `Contact` (`id`),
  CONSTRAINT `FK_Recruiters_ClientInformations` FOREIGN KEY (`ClientInformation_id`) REFERENCES `ClientInformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ClientInformation_Contact_AUD` (
  `REV` bigint(20) NOT NULL,
  `ClientInformation_id` bigint(20) NOT NULL,
  `recruiters_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`ClientInformation_id`,`recruiters_id`),
  KEY `FKA1F69AD35B7A65D0` (`REV`),
  CONSTRAINT `FKA1F69AD35B7A65D0` FOREIGN KEY (`REV`) REFERENCES `AuditRevisionEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;