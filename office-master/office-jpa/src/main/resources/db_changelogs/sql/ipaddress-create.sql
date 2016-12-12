--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `CIPAddress` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `addressType` varchar(255) DEFAULT NULL,
  `ipAddress` varchar(40) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IP_ADDR_TYP` (`addressType`),
  KEY `IP_ADDR` (`ipAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CIPAddress_AUD` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `addressType` varchar(255) DEFAULT NULL,
  `ipAddress` varchar(40) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK9942A4BB5B7A65D0` (`REV`),
  CONSTRAINT `FK9942A4BB5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `AuditRevisionEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CUserIPAddress` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `ipAddress` varchar(40) NOT NULL,
  `userId` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USR_IP_ADDR` (`ipAddress`),
  KEY `USR_IP_ADDR_USRID` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CUserIPAddress_AUD` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `ipAddress` varchar(40) DEFAULT NULL,
  `userId` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK13A724305B7A65D0` (`REV`),
  CONSTRAINT `FK13A724305B7A65D0` FOREIGN KEY (`REV`) REFERENCES `AuditRevisionEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
