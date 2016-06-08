--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
CREATE TABLE `passport` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `passportCountryOfIssuance` varchar(255) DEFAULT NULL,
  `passportExpiryDate` date DEFAULT NULL,
  `passportIssuedDate` date DEFAULT NULL,
  `passportNumber` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PassportTGT_ENTY_ID` (`targetEntityId`),
  KEY `PassportSRC_ENTY_NM` (`sourceEntityName`),
  KEY `PassportSRC_ENTY_ID` (`sourceEntityId`),
  KEY `PassportTGT_ENTY_NM` (`targetEntityName`),
  KEY `PASSPORT_NBR` (`passportNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `passport_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `passportCountryOfIssuance` varchar(255) DEFAULT NULL,
  `passportExpiryDate` date DEFAULT NULL,
  `passportIssuedDate` date DEFAULT NULL,
  `passportNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D05555b503` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D05555b503` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

