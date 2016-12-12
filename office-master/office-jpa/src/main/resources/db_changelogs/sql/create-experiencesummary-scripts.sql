--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `experiencesummary` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `summary` longtext,
  PRIMARY KEY (`id`),
  KEY `ExperienceSummaryTGT_ENTY_ID` (`targetEntityId`),
  KEY `ExperienceSummarySRC_ENTY_NM` (`sourceEntityName`),
  KEY `ExperienceSummarySRC_ENTY_ID` (`sourceEntityId`),
  KEY `ExperienceSummaryTGT_ENTY_NM` (`targetEntityName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `experiencesummary_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `summary` longtext,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D0d49c0a8d` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D0d49c0a8d` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;