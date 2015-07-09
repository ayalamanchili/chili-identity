--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
CREATE TABLE `bpmtaskdelegaterule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `attributeData` longtext,
  `bpmProcessId` varchar(255) NOT NULL,
  `bpmTaskId` varchar(255) NOT NULL,
  `ruleExpression` varchar(255) DEFAULT NULL,
  `ruleName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `BPM_TSK_RUL_NM` (`ruleName`),
  KEY `BPM_TSK_RUL_PRC_ID` (`bpmProcessId`),
  KEY `BPM_TSK_RUL_TSK_ID` (`bpmTaskId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bpmtaskdelegaterule_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `attributeData` longtext,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `bpmTaskId` varchar(255) DEFAULT NULL,
  `ruleExpression` varchar(255) DEFAULT NULL,
  `ruleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK8E2283765B7A65D0` (`REV`),
  CONSTRAINT `FK8E2283765B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;