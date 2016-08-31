--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
CREATE TABLE `healthinsurance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `dateRequested` date DEFAULT NULL,
  `enrolled` bit(1) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `healthInsuranceWaiver_id` bigint(20) DEFAULT NULL,
  `insuranceEnrollment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_INS_ENR` (`insuranceEnrollment_id`),
  KEY `FK_HLTH_INS_WVR` (`healthInsuranceWaiver_id`),
  KEY `FK_EMP_INSU_ENRO` (`employee_id`),
  CONSTRAINT `FK_EMP_INSU_ENRO` FOREIGN KEY (`employee_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FK_HLTH_INS_WVR` FOREIGN KEY (`healthInsuranceWaiver_id`) REFERENCES `healthinsurancewaiver` (`id`),
  CONSTRAINT `FK_INS_ENR` FOREIGN KEY (`insuranceEnrollment_id`) REFERENCES `insuranceenrollment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `healthinsurance_aud` (
  `id` bigint(20) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `dateRequested` date DEFAULT NULL,
  `enrolled` bit(1) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `healthInsuranceWaiver_id` bigint(20) DEFAULT NULL,
  `insuranceEnrollment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK3F49828F5B7A65D0` (`REV`),
  CONSTRAINT `FK3F49828F5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
