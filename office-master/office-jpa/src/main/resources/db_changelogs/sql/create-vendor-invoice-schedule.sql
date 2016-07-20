--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `vendor_invoiceschedule` (
  `Vendor_id` bigint(20) NOT NULL,
  `invoiceSchedules_id` bigint(20) NOT NULL,
  KEY `FKBA238BED71D7D5A` (`Vendor_id`),
  KEY `FKBA238BED89DC0F6F` (`invoiceSchedules_id`),
  CONSTRAINT `FKBA238BED71D7D5A` FOREIGN KEY (`Vendor_id`) REFERENCES `vendor` (`id`),
  CONSTRAINT `FKBA238BED89DC0F6F` FOREIGN KEY (`invoiceSchedules_id`) REFERENCES `invoiceschedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vendor_invoiceschedule_aud` (
  `REV` bigint(20) NOT NULL,
  `Vendor_id` bigint(20) NOT NULL,
  `invoiceSchedules_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`Vendor_id`,`invoiceSchedules_id`),
  KEY `FKA49DFB3E5B7A65D0` (`REV`),
  CONSTRAINT `FKA49DFB3E5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
