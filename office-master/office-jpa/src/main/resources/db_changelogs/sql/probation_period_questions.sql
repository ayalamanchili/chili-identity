--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--


CREATE TABLE `probationperiodevaluation_question` (
  `ProbationPeriodEvaluation_id` bigint(20) NOT NULL,
  `questions_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ProbationPeriodEvaluation_id`,`questions_id`),
  KEY `FK6B334D682EDBDE3` (`questions_id`),
  KEY `FK6B334D683F23509D` (`ProbationPeriodEvaluation_id`),
  CONSTRAINT `FK6B334D682EDBDE3` FOREIGN KEY (`questions_id`) REFERENCES `question` (`id`),
  CONSTRAINT `FK6B334D683F23509D` FOREIGN KEY (`ProbationPeriodEvaluation_id`) REFERENCES `probationperiodevaluation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `probationperiodevaluation_question_aud` (
  `REV` bigint(20) NOT NULL,
  `ProbationPeriodEvaluation_id` bigint(20) NOT NULL,
  `questions_id` bigint(20) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`ProbationPeriodEvaluation_id`,`questions_id`),
  KEY `FKDCAA87395B7A65D0` (`REV`),
  CONSTRAINT `FKDCAA87395B7A65D0` FOREIGN KEY (`REV`) REFERENCES `auditrevisionentity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;