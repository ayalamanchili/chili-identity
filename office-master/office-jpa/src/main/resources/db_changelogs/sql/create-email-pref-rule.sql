--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
CREATE TABLE `EmailPreferenceRule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `actionName` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `eventName` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `processId` varchar(255) NOT NULL,
  `ruleId` varchar(255) NOT NULL,
  `taskId` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ruleId` (`ruleId`),
  KEY `EML_PREF_RUL_PRC_ID` (`processId`),
  KEY `EML_PREF_RUL_TSK_ID` (`taskId`),
  KEY `EML_PREF_RUL_NM` (`name`),
  KEY `EML_PREF_RUL_ID` (`ruleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `EmailPreferenceRule_AUD` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `actionName` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `eventName` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `processId` varchar(255) DEFAULT NULL,
  `ruleId` varchar(255) DEFAULT NULL,
  `taskId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK75B5AD645B7A65D0` (`REV`),
  CONSTRAINT `FK75B5AD645B7A65D0` FOREIGN KEY (`REV`) REFERENCES `AuditRevisionEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `UserEmailPreferenceRule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `userId` varchar(255) NOT NULL,
  `emailPreferenceRule_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`userId`,`emailPreferenceRule_id`),
  KEY `FK_USR_EML_PREF_RUL` (`emailPreferenceRule_id`),
  CONSTRAINT `FK_USR_EML_PREF_RUL` FOREIGN KEY (`emailPreferenceRule_id`) REFERENCES `EmailPreferenceRule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `UserEmailPreferenceRule_AUD` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  `emailPreferenceRule_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKB20095195B7A65D0` (`REV`),
  CONSTRAINT `FKB20095195B7A65D0` FOREIGN KEY (`REV`) REFERENCES `AuditRevisionEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;