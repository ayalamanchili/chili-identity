--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `clientinformation_vendor_recruiters` (
  `ClientInformation_id` bigint(20) NOT NULL,
  `vendorRecruiters_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ClientInformation_id`,`vendorRecruiters_id`),
  KEY `FK_VendorRecruiter_ClientInformations` (`ClientInformation_id`),
  KEY `FK5471D4818E0C6582` (`vendorRecruiters_id`),
  CONSTRAINT `FK5471D4818E0C6582` FOREIGN KEY (`vendorRecruiters_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FK_VendorRecruiters_ClientInformations` FOREIGN KEY (`ClientInformation_id`) REFERENCES `clientinformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `clientinformation_vendor_recruiters_aud` (
  `REV` bigint(20) NOT NULL,
  `ClientInformation_id` bigint(20) NOT NULL,
  `vendorRecruiters_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`ClientInformation_id`,`vendorRecruiters_id`),
  KEY `FK66ADD9D25B7A65D0` (`REV`),
  CONSTRAINT `FK66ADD9D25B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
