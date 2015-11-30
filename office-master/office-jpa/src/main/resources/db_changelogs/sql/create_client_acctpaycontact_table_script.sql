--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
CREATE TABLE `client_acctpaycontacts` (
  `Client_id` bigint(20) NOT NULL,
  `clientAcctPayContacts_id` bigint(20) NOT NULL,
  KEY `FK543B5A94521DC335` (`clientAcctPayContacts_id`),
  KEY `FK543B5A94B64E4A7A` (`Client_id`),
  CONSTRAINT `FK543B5A94521DC335` FOREIGN KEY (`clientAcctPayContacts_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FK543B5A94B64E4A7A` FOREIGN KEY (`Client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `client_acctpaycontacts_aud` (
  `REV` bigint(20) NOT NULL,
  `Client_id` bigint(20) NOT NULL,
  `clientAcctPayContacts_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`Client_id`,`clientAcctPayContacts_id`),
  KEY `FKBB501E655B7A65D0` (`REV`),
  CONSTRAINT `FKBB501E655B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
