--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `probationperiodevaluation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `acceptDate` date DEFAULT NULL,
  `additionalComments` longtext,
  `approvedBy` varchar(255) DEFAULT NULL,
  `approvedDate` date DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `evaluationDate` datetime DEFAULT NULL,
  `hrApprovalBy` varchar(255) DEFAULT NULL,
  `hrApprovalDate` date DEFAULT NULL,
  `hrNotes` longtext,
  `stage` varchar(255) DEFAULT NULL,
  `trainingRequirments` longtext,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `probationperiodevaluation_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `acceptDate` date DEFAULT NULL,
  `additionalComments` longtext,
  `approvedBy` varchar(255) DEFAULT NULL,
  `approvedDate` date DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `evaluationDate` datetime DEFAULT NULL,
  `hrApprovalBy` varchar(255) DEFAULT NULL,
  `hrApprovalDate` date DEFAULT NULL,
  `hrNotes` longtext,
  `stage` varchar(255) DEFAULT NULL,
  `trainingRequirments` longtext,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK1D67FBEE5B7A65D0` (`REV`),
  CONSTRAINT `FK1D67FBEE5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;