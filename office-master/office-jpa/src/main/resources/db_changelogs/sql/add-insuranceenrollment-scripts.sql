--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `insuranceenrollment` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `insuranceType` varchar(255) DEFAULT NULL,
  `year` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `InsuranceEnrollmentTGT_ENTY_ID` (`targetEntityId`),
  KEY `InsuranceEnrollmentSRC_ENTY_NM` (`sourceEntityName`),
  KEY `InsuranceEnrollmentSRC_ENTY_ID` (`sourceEntityId`),
  KEY `InsuranceEnrollmentTGT_ENTY_NM` (`targetEntityName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `insuranceenrollment_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `insuranceType` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D0b592b42f` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D0b592b42f` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `healthinsurancewaiver` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `dependentName` varchar(255) DEFAULT NULL,
  `fileUrl` varchar(255) DEFAULT NULL,
  `otherCarrierType` varchar(255) DEFAULT NULL,
  `otherNameOfCarrier` varchar(255) DEFAULT NULL,
  `spouseName` varchar(255) DEFAULT NULL,
  `spouseNameOfCarrier` varchar(255) DEFAULT NULL,
  `submittedDate` date DEFAULT NULL,
  `waivingCoverageDueTo` varchar(255) NOT NULL,
  `waivingCoverageFor` varchar(255) NOT NULL,
  `insuranceEnrollment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `HealthInsuranceWaiverTGT_ENTY_ID` (`targetEntityId`),
  KEY `HealthInsuranceWaiverSRC_ENTY_NM` (`sourceEntityName`),
  KEY `HealthInsuranceWaiverSRC_ENTY_ID` (`sourceEntityId`),
  KEY `HealthInsuranceWaiverTGT_ENTY_NM` (`targetEntityName`),
  KEY `FK871925C28F44F45E` (`insuranceEnrollment_id`),
  CONSTRAINT `FK871925C28F44F45E` FOREIGN KEY (`insuranceEnrollment_id`) REFERENCES `insuranceenrollment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `healthinsurancewaiver_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `dependentName` varchar(255) DEFAULT NULL,
  `fileUrl` varchar(255) DEFAULT NULL,
  `otherCarrierType` varchar(255) DEFAULT NULL,
  `otherNameOfCarrier` varchar(255) DEFAULT NULL,
  `spouseName` varchar(255) DEFAULT NULL,
  `spouseNameOfCarrier` varchar(255) DEFAULT NULL,
  `submittedDate` date DEFAULT NULL,
  `waivingCoverageDueTo` varchar(255) DEFAULT NULL,
  `waivingCoverageFor` varchar(255) DEFAULT NULL,
  `insuranceEnrollment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D066d8a293` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D066d8a293` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




