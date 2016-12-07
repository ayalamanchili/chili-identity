--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `miscellaneousinfo` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `eadNumber` varchar(255) DEFAULT NULL,
  `sevisNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `MiscellaneousInfoTGT_ENTY_ID` (`targetEntityId`),
  KEY `MiscellaneousInfoSRC_ENTY_NM` (`sourceEntityName`),
  KEY `MiscellaneousInfoSRC_ENTY_ID` (`sourceEntityId`),
  KEY `MiscellaneousInfoTGT_ENTY_NM` (`targetEntityName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `miscellaneousinfo_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `eadNumber` varchar(255) DEFAULT NULL,
  `sevisNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D010d4956d` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D010d4956d` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;