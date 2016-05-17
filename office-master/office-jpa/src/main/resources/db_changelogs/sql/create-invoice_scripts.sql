--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `billingRate` decimal(19,2) DEFAULT NULL,
  `employee` varchar(255) DEFAULT NULL,
  `endDate` datetime NOT NULL,
  `hours` decimal(19,2) NOT NULL,
  `invoiceDate` datetime NOT NULL,
  `invoiceFrequency` int(11) NOT NULL,
  `invoiceNumber` int(11) NOT NULL,
  `itemNumber` varchar(255) NOT NULL,
  `notes` longtext NOT NULL,
  `overTimeBillingRate` decimal(19,2) DEFAULT NULL,
  `startDate` datetime NOT NULL,
  `status` varchar(255) NOT NULL,
  `timeSheetStatus` varchar(255) NOT NULL,
  `clientInformation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `invoiceNumber` (`invoiceNumber`),
  KEY `FK_ClinetInfo_Invoice` (`clientInformation_id`),
  CONSTRAINT `FK_ClinetInfo_Invoice` FOREIGN KEY (`clientInformation_id`) REFERENCES `clientinformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `invoice_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `billingRate` decimal(19,2) DEFAULT NULL,
  `employee` varchar(255) DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `hours` decimal(19,2) DEFAULT NULL,
  `invoiceDate` datetime DEFAULT NULL,
  `invoiceFrequency` int(11) DEFAULT NULL,
  `invoiceNumber` int(11) DEFAULT NULL,
  `itemNumber` varchar(255) DEFAULT NULL,
  `notes` longtext,
  `overTimeBillingRate` decimal(19,2) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `timeSheetStatus` varchar(255) DEFAULT NULL,
  `clientInformation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK300CBA5E5B7A65D0` (`REV`),
  CONSTRAINT `FK300CBA5E5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

