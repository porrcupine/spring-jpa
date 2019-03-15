--
-- Table structure for table `role`
--
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255)  DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `private_data`
--
DROP TABLE IF EXISTS `private_data`;
CREATE TABLE `private_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `additional_info` text ,
  `additional_phone` varchar(255)  DEFAULT NULL,
  `email` varchar(255)  DEFAULT NULL,
  `first_name` varchar(255)  DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `last_name` varchar(255)  DEFAULT NULL,
  `middle_name` varchar(255)  DEFAULT NULL,
  `phone` varchar(255)  DEFAULT NULL,
  `skype` varchar(255)  DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `employee`
--
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `create_date` datetime DEFAULT NULL,
  `last_access_date` datetime DEFAULT NULL,
  `login` varchar(255)  DEFAULT NULL,
  `may_db_auth` tinyint(1) DEFAULT NULL,
  `password` varchar(255)  DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `old_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3046kvjyysq288vy3lsbtc9nw` (`role_id`)
);

--
-- Table structure for table `employee_archive`
--
DROP TABLE IF EXISTS `employee_archive`;
CREATE TABLE `employee_archive` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhhnvtqk1g13sfb6b14ovbudpa` (`employee_id`)
);

--
-- Table structure for table `employee_sale_request`
--
DROP TABLE IF EXISTS `employee_sale_request`;
CREATE TABLE `employee_sale_request` (
  `employee_id` bigint(20) NOT NULL,
  `sale_request_id` bigint(20) NOT NULL,
  KEY `FK4itoh5dg6xc0ov32dqq4u0989` (`sale_request_id`),
  KEY `FKi90qil9qev350y10alf41mkak` (`employee_id`)
);

--
-- Table structure for table `sale_request`
--
DROP TABLE IF EXISTS `sale_request`;
CREATE TABLE `sale_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `name` varchar(255)  DEFAULT NULL,
  `start_at` datetime DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `responsible_for_request_id` bigint(20) DEFAULT NULL,
  `responsible_rm_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsi2ottr3y2yfefomhkyh9xx7` (`author_id`),
  KEY `FK3xhgcg0yf8h7ubc8t4cbpguhj` (`company_id`),
  KEY `FKn0qxkmq388b8uwlaxk1oriypr` (`responsible_for_request_id`),
  KEY `FKrievd1b3i73em6v7bl9i5ui9` (`responsible_rm_id`)
);

--
-- Table structure for table `company`
--
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text ,
  `is_active` tinyint(1) NOT NULL,
  `name` varchar(255)  DEFAULT NULL,
  `phone` varchar(255)  DEFAULT NULL,
  `url` varchar(255)  DEFAULT NULL,
  `old_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_OLD_ID_COMPANY` (`old_id`)
);

--
-- Table structure for table `resume`
--
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `candidate_info` varchar(255)  DEFAULT NULL,
  `status` varchar(255)  NOT NULL,
  `id` bigint(20) NOT NULL,
  `responsible_hr_id` bigint(20) DEFAULT NULL,
  `resume_request_id` bigint(20) DEFAULT NULL,
  `fio` varchar(255)  NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeawpjgme034bcdiva66p1jhvj` (`responsible_hr_id`),
  KEY `FKmi7hyhfqu4y2p43ge0f5st2tp` (`resume_request_id`)
);

--
-- Table structure for table `sale_object`
--
DROP TABLE IF EXISTS `sale_object`;
CREATE TABLE `sale_object` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sale_object_employee_idx` (`author_id`)
);

--
-- Table structure for table `resume_request`
--
DROP TABLE IF EXISTS `resume_request`;
CREATE TABLE `resume_request` (
  `done_date` datetime DEFAULT NULL,
  `priority` varchar(255)  NOT NULL,
  `status` varchar(255)  NOT NULL,
  `id` bigint(20) NOT NULL,
  `company_sale_id` bigint(20) DEFAULT NULL,
  `old_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `old_id_UNIQUE` (`old_id`),
  KEY `FK3enc55txjmjb7r4i7c1p4v5t8` (`company_sale_id`)
);

--
-- Table structure for table `company_sale`
--
DROP TABLE IF EXISTS `company_sale`;
CREATE TABLE `company_sale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `description` text ,
  `next_activity_date` datetime DEFAULT NULL,
  `status` varchar(255)  DEFAULT NULL,
  `status_changed_date` datetime DEFAULT NULL,
  `weight` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `last_activity_id` bigint(20) DEFAULT NULL,
  `main_contact_id` bigint(20) DEFAULT NULL,
  `responsible_id` bigint(20) DEFAULT NULL,
  `old_id` bigint(20) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_OLD_ID_COMPANY_SALE` (`old_id`),
  KEY `FKtpbc877x9966vvo6fkg9n9gja` (`company_id`),
  KEY `FKs2gb1on76786h2b3twtg0qnn3` (`last_activity_id`),
  KEY `FKa88khufpnax8bmtmx66gum7ls` (`main_contact_id`),
  KEY `FK2v2d2is1pklforiu1raxmsoe3` (`responsible_id`)
);

DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `create_date` datetime DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `personal_email` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `social_network` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  `social_network_user_id` bigint(20) DEFAULT NULL,
  `source_id` bigint(20) DEFAULT NULL,
  `old_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_OLD_ID_CONTACT` (`old_id`),
  KEY `FKpgbqt6dnai52x55o1qvsx1dfn` (`company_id`),
  KEY `FKb0f44s4mhm2n8y18miwfic974` (`country_id`),
  KEY `FKr7jjgw77d071br840qwafrp56` (`social_network_user_id`),
  KEY `FKjilgqaqw6ttl7kd4js7jgwis1` (`source_id`)
);

--
-- Table structure for table `countries`
--
DROP TABLE IF EXISTS `countries`;
CREATE TABLE `countries` (
  `id` bigint(20) NOT NULL,
  `alpha_2` char(2) NOT NULL DEFAULT '',
  `alpha_3` char(3) NOT NULL DEFAULT '',
  `name` varchar(75) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `source`
--
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK4a1uurs8rtj4xnah2j9uguec0` (`name`)
);

--
-- Table structure for table `social_network_user`
--
DROP TABLE IF EXISTS `social_network_user`;
CREATE TABLE `social_network_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKfdgw8wt87fbs5dhkicdmde35n` (`name`)
);

--
-- Table structure for table `activity`
--
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_activity` datetime DEFAULT NULL,
  `description` text NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `types` varchar(255) DEFAULT NULL,
  `company_sale_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkts88o0p0sgq71tctimq9jcfl` (`company_sale_id`),
  KEY `FKm67enjapuo2hd7irnv1k2fx7t` (`employee_id`),
  CONSTRAINT `FKkts88o0p0sgq71tctimq9jcfl` FOREIGN KEY (`company_sale_id`) REFERENCES `company_sale` (`id`),
  CONSTRAINT `FKm67enjapuo2hd7irnv1k2fx7t` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
);

--
-- Table structure for table `activity`
--
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_activity` datetime DEFAULT NULL,
  `description` text NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `types` varchar(255) DEFAULT NULL,
  `company_sale_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkts88o0p0sgq71tctimq9jcfl` (`company_sale_id`),
  KEY `FKm67enjapuo2hd7irnv1k2fx7t` (`employee_id`)
) ;
