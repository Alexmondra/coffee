--liquibase formatted sql

-- changeset alex:20230426-162500-1

-- -----------------------------------------------------
-- Table `comerciante`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `base_user` (
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  dni char(8) NULL,
  name VARCHAR(150) NOT NULL,
  last_name VARCHAR(150) NULL,
  email VARCHAR(100) NOT NULL,
  phone VARCHAR(100),
  register_status INT NOT NULL,
  password VARCHAR(100) NOT NULL,
  recover_pw VARCHAR(100) ,
  img BLOB,
	updated TIMESTAMP NULL,
	created TIMESTAMP NULL,
	deleted TIMESTAMP NULL,

	PRIMARY KEY (`id`),
	UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
 ENGINE = InnoDB
;
-- -----------------------------------------------------
-- Table base_role
-- -----------------------------------------------------
DROP TABLE IF EXISTS `base_role` ;

CREATE TABLE IF NOT EXISTS `base_role`  (
   `id` INT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(45) NOT NULL
  )
  
ENGINE = InnoDB;
INSERT INTO base_role (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_CLIENT');
-- -----------------------------------------------------
-- Table `user_roles`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `base_user_roles` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `user_id` INT  NOT NULL ,
  `role_id` INT  NOT NULL

   )
ENGINE = InnoDB ;



CREATE TABLE IF NOT EXISTS customers (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT primary key,
    dni char(8) NULL,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(150) NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(100) NULL,
	base_user_id INT(10) UNSIGNED NOT NULL,
    register_status INT NOT NULL,
    img BLOB NULL,

	updated TIMESTAMP NULL,
	created TIMESTAMP NULL,
	deleted TIMESTAMP NULL,

    CONSTRAINT customers_fk
    FOREIGN KEY (base_user_id)
    REFERENCES base_user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
   ENGINE = InnoDB
;

CREATE TABLE IF NOT EXISTS products (
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  description VARCHAR (255) NULL
)
ENGINE = InnoDB ;

CREATE TABLE IF NOT EXISTS `products_user` ( -- 1,1,8
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `products_id` INT  NOT NULL ,
  `user_id` INT  NOT NULL
)
   
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS registerAction ( 
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(1) NOT NULL,
  cant decimal (8,3) NOT NULL,
  price decimal(8,3) NOT NULL,
  discount INT NULL,
  product_id INT(10) UNSIGNED NOT NULL,
   updated TIMESTAMP NULL,
   created TIMESTAMP NULL,
   deleted TIMESTAMP NULL

   )
ENGINE = InnoDB
;


CREATE TABLE IF NOT EXISTS `register_clientes` ( -- 1,1,8
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `register_id` INT  NOT NULL ,
  `customer_id` INT  NOT NULL

   )
ENGINE = InnoDB ;










