--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `educationrecord` (
  `id` bigint(20) NOT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) NOT NULL,
  `targetEntityName` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `degreeOfStudy` varchar(255) NOT NULL,
  `fieldOfStudy` varchar(255) DEFAULT NULL,
  `graduationYear` varchar(255) DEFAULT NULL,
  `nameOfSchool` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `EducationRecordTGT_ENTY_ID` (`targetEntityId`),
  KEY `EducationRecordSRC_ENTY_NM` (`sourceEntityName`),
  KEY `EducationRecordSRC_ENTY_ID` (`sourceEntityId`),
  KEY `EducationRecordTGT_ENTY_NM` (`targetEntityName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `educationrecord_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `sourceEntityId` bigint(20) DEFAULT NULL,
  `sourceEntityName` varchar(255) DEFAULT NULL,
  `targetEntityId` bigint(20) DEFAULT NULL,
  `targetEntityName` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `degreeOfStudy` varchar(255) DEFAULT NULL,
  `fieldOfStudy` varchar(255) DEFAULT NULL,
  `graduationYear` varchar(255) DEFAULT NULL,
  `nameOfSchool` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKFD09F4DE5B7A65D07c43a34a` (`REV`),
  CONSTRAINT `FKFD09F4DE5B7A65D07c43a34a` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
