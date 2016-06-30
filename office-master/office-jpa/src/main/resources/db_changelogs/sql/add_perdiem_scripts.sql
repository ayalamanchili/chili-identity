--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `perdiem` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `live50MilesAway` bit(1) NOT NULL,
  `perDiemEndDate` date NOT NULL,
  `perDiemStartDate` date NOT NULL,
  `percentage` decimal(19,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `submittedDate` date DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `perdiem_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `live50MilesAway` bit(1) DEFAULT NULL,
  `perDiemEndDate` date DEFAULT NULL,
  `perDiemStartDate` date DEFAULT NULL,
  `percentage` decimal(19,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `submittedDate` date DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
