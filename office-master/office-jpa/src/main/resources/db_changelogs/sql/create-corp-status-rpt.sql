--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `corporatestatusreport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `approvedBy` varchar(255) DEFAULT NULL,
  `approvedDate` date DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `report` longtext,
  `reportEndDate` date NOT NULL,
  `reportStartDate` date NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `submittedDate` date DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `corporatestatusreport_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `approvedBy` varchar(255) DEFAULT NULL,
  `approvedDate` date DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `report` longtext,
  `reportEndDate` date DEFAULT NULL,
  `reportStartDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `submittedDate` date DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;