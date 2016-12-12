--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `stayperiodinfo` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `fromDate` date DEFAULT NULL,
  `immigrantStatus` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `otherCitizenship` bit(1) DEFAULT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `toDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `StayPeriodInfoTGT_ENTY_ID` (`targetEntityId`),
  KEY `StayPeriodInfoSRC_ENTY_NM` (`sourceEntityName`),
  KEY `StayPeriodInfoSRC_ENTY_ID` (`sourceEntityId`),
  KEY `StayPeriodInfoTGT_ENTY_NM` (`targetEntityName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `stayperiodinfo_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `fromDate` date DEFAULT NULL,
  `immigrantStatus` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `otherCitizenship` bit(1) DEFAULT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `toDate` date DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D04c361339` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D04c361339` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;