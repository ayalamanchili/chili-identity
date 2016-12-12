--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `clientinformation_vendor_apcontacts` (
  `ClientInformation_id` bigint(20) NOT NULL,
  `vendorAPContacts_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ClientInformation_id`,`vendorAPContacts_id`),
  KEY `FK_VendorAPContact_ClientInformations` (`ClientInformation_id`),
  KEY `FKD06FD09BA788BB28` (`vendorAPContacts_id`),
  CONSTRAINT `FKD06FD09BA788BB28` FOREIGN KEY (`vendorAPContacts_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FK_VendorAPContacts_ClientInformations` FOREIGN KEY (`ClientInformation_id`) REFERENCES `clientinformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `clientinformation_vendor_apcontacts_aud` (
  `REV` bigint(20) NOT NULL,
  `ClientInformation_id` bigint(20) NOT NULL,
  `vendorAPContacts_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`ClientInformation_id`,`vendorAPContacts_id`),
  KEY `FK7CBC38EC5B7A65D0` (`REV`),
  CONSTRAINT `FK7CBC38EC5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
