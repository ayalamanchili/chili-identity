--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--
CREATE TABLE `expensereport_contact` (
  `ExpenseReport_id` bigint(20) NOT NULL,
  `otherEmployees_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ExpenseReport_id`,`otherEmployees_id`),
  KEY `FK7218AE4D5FE2667B` (`otherEmployees_id`),
  KEY `FK_Other_Emps_Exp_Rprt` (`ExpenseReport_id`),
  CONSTRAINT `FK7218AE4D5FE2667B` FOREIGN KEY (`otherEmployees_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FK_Other_Emps_Exp_Rprt` FOREIGN KEY (`ExpenseReport_id`) REFERENCES `expensereport` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `expensereport_contact_aud` (
  `REV` bigint(20) NOT NULL,
  `ExpenseReport_id` bigint(20) NOT NULL,
  `otherEmployees_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`ExpenseReport_id`,`otherEmployees_id`),
  KEY `FK3E7AED9E5B7A65D0` (`REV`),
  CONSTRAINT `FK3E7AED9E5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
