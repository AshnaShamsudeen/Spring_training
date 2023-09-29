-- create table customer_data (id integer not null,customer_name varchar(50) not null,email varchar(255), dob date,   type varchar(255), primary key (id));
-- alter table customer_data add constraint UK_gdcm1j83nwy0hkvuvxneu9xjp unique (email);
insert into customer_data (id,customer_name,email,dob, type ) values (101, 'Amal', 'amalin@gmail.com', '2000-01-13','GENERAL' );
insert into customer_data (id,customer_name,email,dob, type ) values (102, 'Vivek', 'vivi@gmail.com', '2000-01-29','PREMIUM' );
insert into customer_data (id,customer_name,email,dob, type ) values (103, 'Tony', 'manduzz@gmail.com', '2000-05-13','GENERAL' );
insert into customer_data (id,customer_name,email,dob, type ) values (104, 'Shyma', 'shy@gmail.com', '1998-02-24','PREMIUM' );