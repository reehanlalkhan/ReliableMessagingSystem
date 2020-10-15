
-- Disable foreign key check before dropping table
SET foreign_key_checks = 0;

-- drop related tables, if exists
DROP TABLE IF EXISTS message;

-- Enable foreign key check
SET foreign_key_checks = 1;

-- DDL for Message table
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(100) NOT NULL,
  `sender` varchar(20) UNSIGNED NOT NULL,
  `recipient` varchar(20) UNSIGNED NOT NULL,
  `status` int(3) NOT NULL DEFAULT '10',
  `send_time` timestamp,
  `delivery_time` timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
