--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `clientinformation_vendor_recruiter` (
  `ClientInformation_id` bigint(20) NOT NULL,
  `vendorRecruiter_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ClientInformation_id`,`vendorRecruiter_id`),
  KEY `FK_VendorRecruiter_ClientInformations` (`ClientInformation_id`),
  KEY `FK8F1C72327924C12F` (`vendorRecruiter_id`),
  CONSTRAINT `FK8F1C72327924C12F` FOREIGN KEY (`vendorRecruiter_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FK_VendorRecruiter_ClientInformations` FOREIGN KEY (`ClientInformation_id`) REFERENCES `clientinformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `clientinformation_vendor_recruiter_aud` (
  `REV` bigint(20) NOT NULL,
  `ClientInformation_id` bigint(20) NOT NULL,
  `vendorRecruiter_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`ClientInformation_id`,`vendorRecruiter_id`),
  KEY `FKEA8037035B7A65D0` (`REV`),
  CONSTRAINT `FKEA8037035B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
