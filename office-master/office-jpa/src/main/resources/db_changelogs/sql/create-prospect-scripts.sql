--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
CREATE TABLE `prospect` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `processDocSentDate` date DEFAULT NULL,
  `referredBy` varchar(255) NOT NULL,
  `resumeURL` varchar(255) NOT NULL,
  `screenedBy` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `contact_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Contact_Prospect` (`contact_id`),
  CONSTRAINT `FK_Contact_Prospect` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 
CREATE TABLE `prospect_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `processDocSentDate` date DEFAULT NULL,
  `referredBy` varchar(255) DEFAULT NULL,
  `resumeURL` varchar(255) DEFAULT NULL,
  `screenedBy` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `contact_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK3CC8CD7D5B7A65D0` (`REV`),
  CONSTRAINT `FK3CC8CD7D5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;