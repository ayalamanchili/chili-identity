--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `expensereport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `approvedBy` varchar(255) DEFAULT NULL,
  `approvedDate` date DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `description` longtext,
  `endDate` date NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `paidDate` date DEFAULT NULL,
  `startDate` date NOT NULL,
  `submittedBy` varchar(255) DEFAULT NULL,
  `submittedDate` date DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `EXP_RPT_STRT_DT` (`startDate`),
  KEY `EXP_RPT_END_DT` (`endDate`),
  KEY `FK_EMP_EXP_RPTS` (`employee_id`),
  CONSTRAINT `FK_EMP_EXP_RPTS` FOREIGN KEY (`employee_id`) REFERENCES `contact` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `expensereport_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `approvedBy` varchar(255) DEFAULT NULL,
  `approvedDate` date DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `description` longtext,
  `endDate` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `paidDate` date DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `submittedBy` varchar(255) DEFAULT NULL,
  `submittedDate` date DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK7FF11F5D5B7A65D0` (`REV`),
  CONSTRAINT `FK7FF11F5D5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB;


CREATE TABLE `expenseitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `amount` decimal(19,2) NOT NULL,
  `description` longtext NOT NULL,
  `itemEndDate` date NOT NULL,
  `itemStartDate` date NOT NULL,
  `purpose` longtext,
  `remarks` longtext,
  `category_id` bigint(20) DEFAULT NULL,
  `expenseReport_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `EXP_CATG` (`category_id`),
  KEY `FK_EXP_RPT_EXP_ITEMS` (`expenseReport_id`),
  KEY `FK_EXP_CAT_EXP_ITMS` (`category_id`),
  CONSTRAINT `FK_EXP_CAT_EXP_ITMS` FOREIGN KEY (`category_id`) REFERENCES `expensecategory` (`id`),
  CONSTRAINT `FK_EXP_RPT_EXP_ITEMS` FOREIGN KEY (`expenseReport_id`) REFERENCES `expensereport` (`id`)
) ENGINE=InnoDB;


CREATE TABLE `expenseitem_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `description` longtext,
  `itemEndDate` date DEFAULT NULL,
  `itemStartDate` date DEFAULT NULL,
  `purpose` longtext,
  `remarks` longtext,
  `category_id` bigint(20) DEFAULT NULL,
  `expenseReport_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFAD3F3BC5B7A65D0` (`REV`),
  CONSTRAINT `FKFAD3F3BC5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB ;

