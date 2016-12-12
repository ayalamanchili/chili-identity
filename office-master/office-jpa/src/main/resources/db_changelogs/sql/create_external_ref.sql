--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `externalref` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `externalId` varchar(255) NOT NULL,
  `source` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ExternalRefTGT_ENTY_ID` (`targetEntityId`),
  KEY `ExternalRefSRC_ENTY_NM` (`sourceEntityName`),
  KEY `ExternalRefSRC_ENTY_ID` (`sourceEntityId`),
  KEY `ExternalRefTGT_ENTY_NM` (`targetEntityName`),
  KEY `EXT_REF_SRC` (`source`),
  KEY `EXT_REF_ID` (`externalId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `externalref_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `externalId` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D01ec48679` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D01ec48679` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;