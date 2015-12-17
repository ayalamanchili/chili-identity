--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
CREATE TABLE `employeeonboarding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `startedBy` varchar(255) DEFAULT NULL,
  `startedDate` date NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_EMP_ON_BRD` (`employee_id`),
  CONSTRAINT `FK_EMP_ON_BRD` FOREIGN KEY (`employee_id`) REFERENCES `contact` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE `employeeonboarding_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `bpmProcessId` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `startedBy` varchar(255) DEFAULT NULL,
  `startedDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FKE07548FA5B7A65D0` (`REV`),
  CONSTRAINT `FKE07548FA5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;