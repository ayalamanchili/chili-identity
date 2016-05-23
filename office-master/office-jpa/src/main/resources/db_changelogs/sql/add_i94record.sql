--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `i94record` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `admitUntilDate` date DEFAULT NULL,
  `classOfAdmission` varchar(255) DEFAULT NULL,
  `dateofEntry` date DEFAULT NULL,
  `i94RecordNumber` varchar(255) DEFAULT NULL,
  `imageURL` varchar(255) DEFAULT NULL,
  `portOfEntry` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `i94RecordTGT_ENTY_ID` (`targetEntityId`),
  KEY `i94RecordSRC_ENTY_NM` (`sourceEntityName`),
  KEY `i94RecordSRC_ENTY_ID` (`sourceEntityId`),
  KEY `i94RecordTGT_ENTY_NM` (`targetEntityName`),
  KEY `i94_RECORD_NBR` (`i94RecordNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `i94record_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `admitUntilDate` date DEFAULT NULL,
  `classOfAdmission` varchar(255) DEFAULT NULL,
  `dateofEntry` date DEFAULT NULL,
  `i94RecordNumber` varchar(255) DEFAULT NULL,
  `imageURL` varchar(255) DEFAULT NULL,
  `portOfEntry` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D06b63b206` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D06b63b206` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

