--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `clientinformation_vendor_apcontact` (
  `ClientInformation_id` bigint(20) NOT NULL,
  `vendorAPContact_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ClientInformation_id`,`vendorAPContact_id`),
  KEY `FK_VendorAPContact_ClientInformations` (`ClientInformation_id`),
  KEY `FK27C18AD8ED941EC9` (`vendorAPContact_id`),
  CONSTRAINT `FK27C18AD8ED941EC9` FOREIGN KEY (`vendorAPContact_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FK_VendorAPContact_ClientInformations` FOREIGN KEY (`ClientInformation_id`) REFERENCES `clientinformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `clientinformation_vendor_apcontact_aud` (
  `REV` bigint(20) NOT NULL,
  `ClientInformation_id` bigint(20) NOT NULL,
  `vendorAPContact_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`ClientInformation_id`,`vendorAPContact_id`),
  KEY `FK3FC8CA95B7A65D0` (`REV`),
  CONSTRAINT `FK3FC8CA95B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
