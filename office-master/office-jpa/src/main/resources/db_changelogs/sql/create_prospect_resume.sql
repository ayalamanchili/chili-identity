--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--


CREATE TABLE `resume` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `fileURL` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updatedTS` datetime DEFAULT NULL,
  `prospect_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PROSPECT_RESUMES` (`prospect_id`),
  CONSTRAINT `FK_PROSPECT_RESUMES` FOREIGN KEY (`prospect_id`) REFERENCES `prospect` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `resume_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `fileURL` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updatedTS` datetime DEFAULT NULL,
  `prospect_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK55A1F39E5B7A65D0` (`REV`),
  CONSTRAINT `FK55A1F39E5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
