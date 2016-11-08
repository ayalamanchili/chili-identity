--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

DROP TABLE IF EXISTS `benefitenrollment` ;

CREATE TABLE `benefitenrollment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `affectiveDate` date DEFAULT NULL,
  `benefitType` varchar(255) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `enrolled` bit(1) DEFAULT NULL,
  `year` varchar(255) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `healthInsuranceWaiver_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_HLTH_INS_WVR` (`healthInsuranceWaiver_id`),
  KEY `FK_EMP_BNF_ENRO` (`employee_id`),
  CONSTRAINT `FK_EMP_BNF_ENRO` FOREIGN KEY (`employee_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FK_HLTH_INS_WVR` FOREIGN KEY (`healthInsuranceWaiver_id`) REFERENCES `healthinsurancewaiver` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `benefitenrollment_aud` ;

CREATE TABLE `benefitenrollment_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `affectiveDate` date DEFAULT NULL,
  `benefitType` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `enrolled` bit(1) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `healthInsuranceWaiver_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKC028EB2C5B7A65D0` (`REV`),
  CONSTRAINT `FKC028EB2C5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
