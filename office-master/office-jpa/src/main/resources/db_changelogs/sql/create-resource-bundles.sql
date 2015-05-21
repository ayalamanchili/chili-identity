--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

CREATE TABLE `ci18nresource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `_key` varchar(255) NOT NULL,
  `_value` longtext NOT NULL,
  `resourceBundle_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ci18nresource_aud` (
  `id` int(11) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `_key` varchar(255) DEFAULT NULL,
  `_value` longtext DEFAULT NULL,
  `resourceBundle_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ci18nresourcebundle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `country` varchar(2) DEFAULT NULL,
  `clanguage` varchar(2) DEFAULT NULL,
  `variant` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ci18nresourcebundle_aud` (
  `id` int(11) NOT NULL,
  `REV` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `country` varchar(2) DEFAULT NULL,
  `clanguage` varchar(2) DEFAULT NULL,
  `variant` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;