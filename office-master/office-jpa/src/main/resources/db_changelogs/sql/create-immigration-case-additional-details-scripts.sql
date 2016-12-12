--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
CREATE TABLE `immigrationcaseadditionaldetails` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `countryOfCitizenship` varchar(255) DEFAULT NULL,
  `currentOccupation` varchar(255) DEFAULT NULL,
  `nameOfEmployer` varchar(255) DEFAULT NULL,
  `noOfDependents` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ImmigrationCaseAdditionalDetailsTGT_ENTY_ID` (`targetEntityId`),
  KEY `ImmigrationCaseAdditionalDetailsSRC_ENTY_NM` (`sourceEntityName`),
  KEY `ImmigrationCaseAdditionalDetailsSRC_ENTY_ID` (`sourceEntityId`),
  KEY `ImmigrationCaseAdditionalDetailsTGT_ENTY_NM` (`targetEntityName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `immigrationcaseadditionaldetails_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `countryOfCitizenship` varchar(255) DEFAULT NULL,
  `currentOccupation` varchar(255) DEFAULT NULL,
  `nameOfEmployer` varchar(255) DEFAULT NULL,
  `noOfDependents` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D0d31deb32` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D0d31deb32` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;