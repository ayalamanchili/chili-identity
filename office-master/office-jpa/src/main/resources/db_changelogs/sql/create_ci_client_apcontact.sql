--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `clientinformation_client_apcontacts` (
  `ClientInformation_id` bigint(20) NOT NULL,
  `clientAPContacts_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ClientInformation_id`,`clientAPContacts_id`),
  KEY `FK_ClientAPContacts_ClientInformations` (`ClientInformation_id`),
  KEY `FK404662387C015985` (`clientAPContacts_id`),
  CONSTRAINT `FK404662387C015985` FOREIGN KEY (`clientAPContacts_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FK_ClientAPContacts_ClientInformations` FOREIGN KEY (`ClientInformation_id`) REFERENCES `clientinformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `clientinformation_client_apcontacts_aud` (
  `REV` bigint(20) NOT NULL,
  `ClientInformation_id` bigint(20) NOT NULL,
  `clientAPContacts_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`ClientInformation_id`,`clientAPContacts_id`),
  KEY `FK1586B4095B7A65D0` (`REV`),
  CONSTRAINT `FK1586B4095B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
