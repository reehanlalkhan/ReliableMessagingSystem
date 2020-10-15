
-- Disable foreign key check before dropping table
SET foreign_key_checks = 0;

-- drop related tables, if exists
DROP TABLE IF EXISTS message_part;

-- Enable foreign key check
SET foreign_key_checks = 1;

-- DDL for message part table
CREATE TABLE `message_part` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `start_offset` int(11) UNSIGNED NOT NULL,
  `end_offset` int(11) UNSIGNED NOT NULL,
  `message_part` varchar(150) NOT NULL,
  `is_last` TINYINT(1) NOT NULL DEFAULT '0',
  `is_delivered` TINYINT(1) NOT NULL DEFAULT '0',
  `message_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_part_in_message` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
