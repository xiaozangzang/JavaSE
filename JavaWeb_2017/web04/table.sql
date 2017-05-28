create database demo default character set utf8;
create table person(
	id int primary key auto_increment,
	name varchar(20),
	salary varchar(20),
	age varchar(2)
);
insert into person (name,salary,age) values ('zs',12000,23);
insert into person (name,salary,age) values ('ls',24000,43);
insert into person (name,salary,age) values ('ww',34000,32);