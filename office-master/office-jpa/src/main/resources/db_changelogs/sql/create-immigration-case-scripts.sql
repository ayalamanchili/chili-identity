--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `immigrationcase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `employeeName` varchar(255) DEFAULT NULL,
  `immigrationCaseStatus` varchar(255) DEFAULT NULL,
  `immigrationCaseType` varchar(255) NOT NULL,
  `sponsorType` varchar(255) NOT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IMM_CASE_CRT_DATE` (`createdDate`),
  KEY `FK_CMPNY_IMM_CASE` (`company_id`),
  KEY `FK_Employee_IMM_CASE` (`employee_id`),
  CONSTRAINT `FK_CMPNY_IMM_CASE` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `FK_Employee_IMM_CASE` FOREIGN KEY (`employee_id`) REFERENCES `contact` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `immigrationcase_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `employeeName` varchar(255) DEFAULT NULL,
  `immigrationCaseStatus` varchar(255) DEFAULT NULL,
  `immigrationCaseType` varchar(255) DEFAULT NULL,
  `sponsorType` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK853BA22B5B7A65D0` (`REV`),
  CONSTRAINT `FK853BA22B5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;