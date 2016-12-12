
--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `perdiem_address` (
  `PerDiem_id` bigint(20) NOT NULL,
  `addresses_id` bigint(20) NOT NULL,
  KEY `FKB1E4A31F2DFA391D` (`PerDiem_id`),
  KEY `FKB1E4A31FCFAC2124` (`addresses_id`),
  CONSTRAINT `FKB1E4A31F2DFA391D` FOREIGN KEY (`PerDiem_id`) REFERENCES `perdiem` (`id`),
  CONSTRAINT `FKB1E4A31FCFAC2124` FOREIGN KEY (`addresses_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `perdiem_address_aud` (
  `REV` bigint(20) NOT NULL,
  `PerDiem_id` bigint(20) NOT NULL,
  `addresses_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`PerDiem_id`,`addresses_id`),
  KEY `FK1ABC29705B7A65D0` (`REV`),
  CONSTRAINT `FK1ABC29705B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
