ALTER TABLE employee
ADD CONSTRAINT `FK3046kvjyysq288vy3lsbtc9nw` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
ALTER TABLE employee
ADD CONSTRAINT `FKdpnm8hqn6ngrt21w7atddvt1w` FOREIGN KEY (`id`) REFERENCES `private_data` (`id`);

ALTER TABLE employee_archive
ADD CONSTRAINT `FKhhnvtqk1g13sfb6b14ovbudpa` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

ALTER TABLE employee_sale_request
ADD CONSTRAINT `FK4itoh5dg6xc0ov32dqq4u0989` FOREIGN KEY (`sale_request_id`) REFERENCES `sale_request` (`id`);
ALTER TABLE employee_sale_request
ADD CONSTRAINT `FKi90qil9qev350y10alf41mkak` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

ALTER TABLE sale_request
ADD CONSTRAINT `FK3xhgcg0yf8h7ubc8t4cbpguhj` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);
ALTER TABLE sale_request
ADD CONSTRAINT `FKn0qxkmq388b8uwlaxk1oriypr` FOREIGN KEY (`responsible_for_request_id`) REFERENCES `employee` (`id`);
ALTER TABLE sale_request
ADD CONSTRAINT `FKrievd1b3i73em6v7bl9i5ui9` FOREIGN KEY (`responsible_rm_id`) REFERENCES `employee` (`id`);
ALTER TABLE sale_request
ADD CONSTRAINT `FKsi2ottr3y2yfefomhkyh9xx7` FOREIGN KEY (`author_id`) REFERENCES `employee` (`id`);

ALTER TABLE resume
ADD CONSTRAINT `FK2j1je6ow8pwxc7bcyc2cj9jjp` FOREIGN KEY (`id`) REFERENCES `sale_object` (`id`);
ALTER TABLE resume
ADD CONSTRAINT `FKeawpjgme034bcdiva66p1jhvj` FOREIGN KEY (`responsible_hr_id`) REFERENCES `employee` (`id`);
ALTER TABLE resume
ADD CONSTRAINT `FKmi7hyhfqu4y2p43ge0f5st2tp` FOREIGN KEY (`resume_request_id`) REFERENCES `resume_request` (`id`);

ALTER TABLE sale_object
ADD CONSTRAINT `FK_sale_object_employee` FOREIGN KEY (`author_id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE resume_request
ADD CONSTRAINT `FK3enc55txjmjb7r4i7c1p4v5t8` FOREIGN KEY (`company_sale_id`) REFERENCES `company_sale` (`id`);
ALTER TABLE resume_request
ADD CONSTRAINT `FKl6ghkw1pwb9mrbco895oi6gh5` FOREIGN KEY (`id`) REFERENCES `sale_request` (`id`);

ALTER TABLE company_sale
ADD CONSTRAINT `FK2v2d2is1pklforiu1raxmsoe3` FOREIGN KEY (`responsible_id`) REFERENCES `employee` (`id`);
ALTER TABLE company_sale
ADD CONSTRAINT `FKa88khufpnax8bmtmx66gum7ls` FOREIGN KEY (`main_contact_id`) REFERENCES `contact` (`id`);
ALTER TABLE company_sale
ADD CONSTRAINT `FKs2gb1on76786h2b3twtg0qnn3` FOREIGN KEY (`last_activity_id`) REFERENCES `activity` (`id`);
ALTER TABLE company_sale
ADD CONSTRAINT `FKtpbc877x9966vvo6fkg9n9gja` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

ALTER TABLE contact
ADD CONSTRAINT `FK6mebqorbkg0obiid1pgjt9uxa` FOREIGN KEY (`id`) REFERENCES `private_data` (`id`);
ALTER TABLE contact
ADD CONSTRAINT `FKb0f44s4mhm2n8y18miwfic974` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);
ALTER TABLE contact
ADD CONSTRAINT `FKjilgqaqw6ttl7kd4js7jgwis1` FOREIGN KEY (`source_id`) REFERENCES `source` (`id`);
ALTER TABLE contact
ADD CONSTRAINT `FKpgbqt6dnai52x55o1qvsx1dfn` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);
ALTER TABLE contact
ADD CONSTRAINT `FKr7jjgw77d071br840qwafrp56` FOREIGN KEY (`social_network_user_id`) REFERENCES `social_network_user` (`id`);

ALTER TABLE activity
ADD CONSTRAINT `FKkts88o0p0sgq71tctimq9jcfl` FOREIGN KEY (`company_sale_id`) REFERENCES `company_sale` (`id`);
ALTER TABLE activity
ADD CONSTRAINT `FKm67enjapuo2hd7irnv1k2fx7t` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);