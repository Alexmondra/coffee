--liquibase formatted sql

-- changeset alex:20230516-0108-2

-- -----------------------------------------------------
-- modifica
-- -----------------------------------------------------

  drop table `register_clientes`;
  drop table `products_user`;
  
  
alter table `registeraction` modify `customer_id` int unsigned;
  truncate `registeraction`;
  ALTER TABLE `registeraction`
  ADD constraint fk_registros
  FOREIGN KEY(customer_id)
  REFERENCES customers(id)
  ON UPDATE CASCADE
  ON DELETE CASCADE;

alter table  `products` add `user_id` int not null;
alter table  `products` add `created` timestamp null;
alter table `products` add `updated` timestamp null;
alter table  `products` add `deleted` timestamp null;
