
-- Disable foreign key check before dropping table
SET foreign_key_checks = 0;

-- drop related tables, if exists
DROP TABLE IF EXISTS message_ack;

-- Enable foreign key check
SET foreign_key_checks = 1;

-- DDL for message acknowledgement table
CREATE TABLE `message_ack` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_ack` TINYINT(1) NOT NULL DEFAULT '0',
  `ack_message` varchar(500) DEFAULT NULL,
  `ack_time` timestamp NOT NULL,
  `message_part_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_msgack_in_msgpart` FOREIGN KEY (`message_part_id`) REFERENCES `message_part` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
