--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `travelhistoryrecord` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `arrivalDate` date DEFAULT NULL,
  `departureDate` date DEFAULT NULL,
  `typeOfVisa` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `TravelHistoryRecordTGT_ENTY_ID` (`targetEntityId`),
  KEY `TravelHistoryRecordSRC_ENTY_NM` (`sourceEntityName`),
  KEY `TravelHistoryRecordSRC_ENTY_ID` (`sourceEntityId`),
  KEY `TravelHistoryRecordTGT_ENTY_NM` (`targetEntityName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `travelhistoryrecord_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `arrivalDate` date DEFAULT NULL,
  `departureDate` date DEFAULT NULL,
  `typeOfVisa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D0a177913c` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D0a177913c` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

