--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
DROP TABLE IF EXISTS `expensereport`;

CREATE TABLE `expensereport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `approvedByAccountsDept` varchar(255) DEFAULT NULL,
  `approvedByAccountsDeptDate` date DEFAULT NULL,
  `approvedByCEO` varchar(255) DEFAULT NULL,
  `approvedByCEODate` date DEFAULT NULL,
  `approvedByManager` varchar(255) DEFAULT NULL,
  `approvedByManagerDate` date DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `endDate` date NOT NULL,
  `expenseFormType` varchar(255) NOT NULL,
  `expenseReimbursePaymentMode` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `projectNumber` varchar(255) DEFAULT NULL,
  `startDate` date NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `submittedDate` date DEFAULT NULL,
  `totalExpenses` decimal(19,2) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `EXP_SUB_DTE` (`submittedDate`),
  KEY `FK_EMP_EXP_RPTS` (`employee_id`),
  CONSTRAINT `FK_EMP_EXP_RPTS` FOREIGN KEY (`employee_id`) REFERENCES `contact` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `expensereport_aud`;

CREATE TABLE `expensereport_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `approvedByAccountsDept` varchar(255) DEFAULT NULL,
  `approvedByAccountsDeptDate` date DEFAULT NULL,
  `approvedByCEO` varchar(255) DEFAULT NULL,
  `approvedByCEODate` date DEFAULT NULL,
  `approvedByManager` varchar(255) DEFAULT NULL,
  `approvedByManagerDate` date DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `expenseFormType` varchar(255) DEFAULT NULL,
  `expenseReimbursePaymentMode` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `projectNumber` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `submittedDate` date DEFAULT NULL,
  `totalExpenses` decimal(19,2) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK7FF11F5D5B7A65D0` (`REV`),
  CONSTRAINT `FK7FF11F5D5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `expenseitem`;

CREATE TABLE `expenseitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `amount` decimal(19,2) NOT NULL,
  `description` longtext,
  `expenseDate` date NOT NULL,
  `expenseMiles` decimal(19,2) DEFAULT NULL,
  `expensePaymentMode` varchar(255) NOT NULL,
  `purpose` longtext NOT NULL,
  `remark` longtext,
  `category_id` bigint(20) NOT NULL,
  `expenseReport_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Expenses_Category` (`category_id`),
  KEY `FK_EXP_RPT_ITMS` (`expenseReport_id`),
  CONSTRAINT `FK_EXP_RPT_ITMS` FOREIGN KEY (`expenseReport_id`) REFERENCES `expensereport` (`id`),
  CONSTRAINT `FK_Expenses_Category` FOREIGN KEY (`category_id`) REFERENCES `expensecategory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `expenseitem_aud`;

CREATE TABLE `expenseitem_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `description` longtext,
  `expenseDate` date DEFAULT NULL,
  `expenseMiles` decimal(19,2) DEFAULT NULL,
  `expensePaymentMode` varchar(255) DEFAULT NULL,
  `purpose` longtext,
  `remark` longtext,
  `category_id` bigint(20) DEFAULT NULL,
  `expenseReport_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFAD3F3BC5B7A65D0` (`REV`),
  CONSTRAINT `FKFAD3F3BC5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `expensereceipt`;

CREATE TABLE `expensereceipt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `fileURL` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `expenseReport_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_EXP_RPT_RCPTS` (`expenseReport_id`),
  CONSTRAINT `FK_EXP_RPT_RCPTS` FOREIGN KEY (`expenseReport_id`) REFERENCES `expensereport` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `expensereceipt_aud`;

CREATE TABLE `expensereceipt_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `fileURL` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `expenseReport_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK63738B15B7A65D0` (`REV`),
  CONSTRAINT `FK63738B15B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;