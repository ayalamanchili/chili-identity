--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `outofofficerequest` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `endDate` date NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `outOfOfficeType` varchar(255) NOT NULL,
  `reason` longtext NOT NULL,
  `recurring` bit(1) DEFAULT NULL,
  `startDate` date NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `outofofficerequest_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `outOfOfficeType` varchar(255) DEFAULT NULL,
  `reason` longtext,
  `recurring` bit(1) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
