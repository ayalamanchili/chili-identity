--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `ImmigrationCheckRequisition` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `accountDeptReceivedDate` date DEFAULT NULL,
  `accountedBy` varchar(255) DEFAULT NULL,
  `amount` decimal(19,2) NOT NULL,
  `approvedBy` varchar(255) DEFAULT NULL,
  `approvedDate` date DEFAULT NULL,
  `attorneyName` varchar(255) NOT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `caseType` varchar(255) NOT NULL,
  `checkIssuedDate` date DEFAULT NULL,
  `mailingAddress` varchar(255) NOT NULL,
  `neededByDate` date NOT NULL,
  `purpose` longtext,
  `requestedDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `submittedBy` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IMG_CHK_REQ_RQST_DT` (`requestedDate`),
  KEY `FK_Emp_ImgCheckReqs` (`employee_id`),
  CONSTRAINT `FK_Emp_ImgCheckReqs` FOREIGN KEY (`employee_id`) REFERENCES `Contact` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ImmigrationCheckRequisition_AUD` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `accountDeptReceivedDate` date DEFAULT NULL,
  `accountedBy` varchar(255) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `approvedBy` varchar(255) DEFAULT NULL,
  `approvedDate` date DEFAULT NULL,
  `attorneyName` varchar(255) DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `caseType` varchar(255) DEFAULT NULL,
  `checkIssuedDate` date DEFAULT NULL,
  `mailingAddress` varchar(255) DEFAULT NULL,
  `neededByDate` date DEFAULT NULL,
  `purpose` longtext,
  `requestedDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `submittedBy` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFDAA946F5B7A65D0` (`REV`),
  CONSTRAINT `FKFDAA946F5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `AuditRevisionEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CheckRequisitionItem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `amount` decimal(19,2) NOT NULL,
  `itemDesc` varchar(255) NOT NULL,
  `itemName` varchar(255) NOT NULL,
  `immigrationCheckRequisition_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_IMMG_CHK_REQ_ITMS` (`immigrationCheckRequisition_id`),
  CONSTRAINT `FK_IMMG_CHK_REQ_ITMS` FOREIGN KEY (`immigrationCheckRequisition_id`) REFERENCES `ImmigrationCheckRequisition` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `CheckRequisitionItem_AUD` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `itemDesc` varchar(255) DEFAULT NULL,
  `itemName` varchar(255) DEFAULT NULL,
  `immigrationCheckRequisition_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK9ADBDA185B7A65D0` (`REV`),
  CONSTRAINT `FK9ADBDA185B7A65D0` FOREIGN KEY (`REV`) REFERENCES `AuditRevisionEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;