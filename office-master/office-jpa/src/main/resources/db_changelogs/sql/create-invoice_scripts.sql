--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `billingRate` decimal(19,2) DEFAULT NULL,
  `endDate` date NOT NULL,
  `hours` decimal(19,2) NOT NULL,
  `invoiceDate` date NOT NULL,
  `invoiceFrequency` varchar(255) NOT NULL,
  `invoiceNumber` varchar(255) NOT NULL,
  `invoiceStatus` varchar(255) NOT NULL,
  `itemNumber` varchar(255) NOT NULL,
  `notes` longtext,
  `overTimeBillingRate` decimal(19,2) DEFAULT NULL,
  `startDate` date NOT NULL,
  `timeSheetStatus` varchar(255) NOT NULL,
  `clientInformation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `invoiceNumber` (`invoiceNumber`),
  KEY `FK_ClinetInfo_Invoice` (`clientInformation_id`),
  CONSTRAINT `FK_ClinetInfo_Invoice` FOREIGN KEY (`clientInformation_id`) REFERENCES `clientinformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `invoice_aud`
--

DROP TABLE IF EXISTS `invoice_aud`;

CREATE TABLE `invoice_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `billingRate` decimal(19,2) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `hours` decimal(19,2) DEFAULT NULL,
  `invoiceDate` date DEFAULT NULL,
  `invoiceFrequency` varchar(255) NOT NULL,
  `invoiceNumber` varchar(255) DEFAULT NULL,
  `invoiceStatus` varchar(255) DEFAULT NULL,
  `itemNumber` varchar(255) DEFAULT NULL,
  `notes` longtext,
  `overTimeBillingRate` decimal(19,2) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `timeSheetStatus` varchar(255) DEFAULT NULL,
  `clientInformation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK300CBA5E5B7A65D0` (`REV`),
  CONSTRAINT `FK300CBA5E5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;