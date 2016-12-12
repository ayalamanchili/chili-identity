DROP TABLE IF EXISTS `lca_contact`;

CREATE TABLE `lca_contact` (
  `LCA_id` bigint(20) NOT NULL,
  `workedByEmployees_id` bigint(20) NOT NULL,
  PRIMARY KEY (`LCA_id`,`workedByEmployees_id`),
  KEY `FK_LCA_WorkedBy` (`LCA_id`),
  KEY `FKF0FD3E6BC04ED0B2` (`workedByEmployees_id`),
  CONSTRAINT `FKF0FD3E6BC04ED0B2` FOREIGN KEY (`workedByEmployees_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FK_LCA_WorkedBy` FOREIGN KEY (`LCA_id`) REFERENCES `lca` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `lca_contact_aud` ;

CREATE TABLE `lca_contact_aud` (
  `REV` bigint(20) NOT NULL,
  `LCA_id` bigint(20) NOT NULL,
  `workedByEmployees_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`LCA_id`,`workedByEmployees_id`),
  KEY `FK9A3E3EBC5B7A65D0` (`REV`),
  CONSTRAINT `FK9A3E3EBC5B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

