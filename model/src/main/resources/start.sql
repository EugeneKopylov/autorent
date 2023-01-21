INSERT INTO `auto_rent`.`t_role` (`role_id`, `role_desc`, `role_name`) VALUES ('1', 'for admin', 'ADMIN');
INSERT INTO `auto_rent`.`t_role` (`role_id`, `role_desc`, `role_name`) VALUES ('2', 'for user', 'USER');

INSERT INTO `auto_rent`.`t_user` (`user_id`) VALUES ('1');
INSERT INTO `auto_rent`.`t_user` (`user_id`) VALUES ('2');

INSERT INTO `auto_rent`.`t_permission` (`id`, `desc_perm`, `role_id`) VALUES ('1', 'no used ', '1');
INSERT INTO `auto_rent`.`t_permission` (`id`, `desc_perm`, `role_id`) VALUES ('2', 'no used', '2');

INSERT INTO `auto_rent`.`t_app_user` (`f_app_user_id`, `nickname`, `password`, `role_id`) VALUES ('1', 'admin', '{noop}root', '1');
INSERT INTO `auto_rent`.`t_app_user` (`f_app_user_id`, `nickname`, `password`, `role_id`) VALUES ('2', 'user', '{noop}root', '2');

INSERT INTO `auto_rent`.`car_brand` (`f_brand_id`, `brand_name`) VALUES ('1', 'BMW');
INSERT INTO `auto_rent`.`car_brand` (`f_brand_id`, `brand_name`) VALUES ('2', 'FIAT');
INSERT INTO `auto_rent`.`car_brand` (`f_brand_id`, `brand_name`) VALUES ('3', 'AUDI');
INSERT INTO `auto_rent`.`car_brand` (`f_brand_id`, `brand_name`) VALUES ('4', 'MERCEDES');
INSERT INTO `auto_rent`.`car_brand` (`f_brand_id`, `brand_name`) VALUES ('5', 'TOYOTA');

INSERT INTO `auto_rent`.`car_model` (`f_model_id`, `car_model_name`, `f_brand_id`) VALUES ('1', 'X5', '1');
INSERT INTO `auto_rent`.`car_model` (`f_model_id`, `car_model_name`, `f_brand_id`) VALUES ('2', 'M3', '1');
INSERT INTO `auto_rent`.`car_model` (`f_model_id`, `car_model_name`, `f_brand_id`) VALUES ('3', 'BRAVO', '2');
INSERT INTO `auto_rent`.`car_model` (`f_model_id`, `car_model_name`, `f_brand_id`) VALUES ('4', 'TIPO', '2');
INSERT INTO `auto_rent`.`car_model` (`f_model_id`, `car_model_name`, `f_brand_id`) VALUES ('5', 'A4', '3');
INSERT INTO `auto_rent`.`car_model` (`f_model_id`, `car_model_name`, `f_brand_id`) VALUES ('6', 'A7', '3');
INSERT INTO `auto_rent`.`car_model` (`f_model_id`, `car_model_name`, `f_brand_id`) VALUES ('7', 'SL500', '4');
INSERT INTO `auto_rent`.`car_model` (`f_model_id`, `car_model_name`, `f_brand_id`) VALUES ('8', 'COROLLA', '5');
INSERT INTO `auto_rent`.`car_model` (`f_model_id`, `car_model_name`, `f_brand_id`) VALUES ('9', 'CAMRY', '5');
INSERT INTO `auto_rent`.`car_model` (`f_model_id`, `car_model_name`, `f_brand_id`) VALUES ('10', 'TUNDRA', '5');