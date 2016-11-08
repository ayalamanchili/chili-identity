DROP TABLE IF EXISTS `healthinsurancewaiver` ;

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
  `waiverYear` varchar(255) DEFAULT NULL,
  `waivingCoverageDueTo` varchar(255) NOT NULL,
  `waivingCoverageFor` varchar(255) NOT NULL,
  `benefitEnrollment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `HealthInsuranceWaiverTGT_ENTY_ID` (`targetEntityId`),
  KEY `HealthInsuranceWaiverSRC_ENTY_NM` (`sourceEntityName`),
  KEY `HealthInsuranceWaiverSRC_ENTY_ID` (`sourceEntityId`),
  KEY `HealthInsuranceWaiverTGT_ENTY_NM` (`targetEntityName`),
  KEY `FK871925C21D712FB0` (`benefitEnrollment_id`),
  CONSTRAINT `FK871925C21D712FB0` FOREIGN KEY (`benefitEnrollment_id`) REFERENCES `benefitenrollment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `healthinsurancewaiver_aud` ;

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
  `waiverYear` varchar(255) DEFAULT NULL,
  `waivingCoverageDueTo` varchar(255) DEFAULT NULL,
  `waivingCoverageFor` varchar(255) DEFAULT NULL,
  `benefitEnrollment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D066d8a293` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D066d8a293` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
