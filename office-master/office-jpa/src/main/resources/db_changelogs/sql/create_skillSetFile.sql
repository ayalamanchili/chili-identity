CREATE TABLE `skillsetfile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `fileURL` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `skillSetFileType` varchar(255) DEFAULT NULL,
  `skillSet_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SkillSet_ResumeUrl` (`skillSet_id`),
  CONSTRAINT `FK_SkillSet_ResumeUrl` FOREIGN KEY (`skillSet_id`) REFERENCES `skillset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `skillsetfile_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `fileURL` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `skillSetFileType` varchar(255) DEFAULT NULL,
  `skillSet_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKE159D8DE5B7A65D0` (`REV`),
  CONSTRAINT `FKE159D8DE5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

