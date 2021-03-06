-- DROP TABLE IF EXISTS `authorities`;
-- CREATE TABLE `authorities` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `username` varchar(255) DEFAULT NULL,
--   `authority` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for groups
-- ----------------------------
-- DROP TABLE IF EXISTS `groups`;
-- CREATE TABLE `groups` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `group_name` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for group_authorities
-- ----------------------------
-- DROP TABLE IF EXISTS `group_authorities`;
-- CREATE TABLE `group_authorities` (
--   `group_id` int(11) NOT NULL AUTO_INCREMENT,
--   `authority` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`group_id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for group_members
-- ----------------------------
-- DROP TABLE IF EXISTS `group_members`;
-- CREATE TABLE `group_members` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `username` varchar(255) DEFAULT NULL,
--   `group_id` int(11) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
-- DROP TABLE IF EXISTS `users`;
-- CREATE TABLE `users` (
--   `id` int(8) NOT NULL AUTO_INCREMENT,
--   `username` varchar(255) DEFAULT NULL,
--   `password` varchar(255) DEFAULT NULL,
--   `enabled` tinyint(4) DEFAULT NULL,
--   `email` varchar(50) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO oauth_client_details(client_id, resource_ids, client_secret, `scope`, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES('client', 'ui', '$2a$10$Tme77eHtXzcB8ghQUepYguJr7P7ESg0Y7XHMnk60s.kf2A.BWBD9m', 'all', 'client_credentials,password,refresh_token', NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO users(id, username, password, enabled, email)
VALUES(1, 'admin', '$2a$10$Tme77eHtXzcB8ghQUepYguJr7P7ESg0Y7XHMnk60s.kf2A.BWBD9m', 1, NULL);

INSERT INTO authorities(id, username, authority)
VALUES(1, 'admin', 'ADMIN');