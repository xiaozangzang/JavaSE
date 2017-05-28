create database open default character set utf8;
use open;
create table user(
	id int primary key auto_increment,
	name varchar(20),
	salary varchar(20),
	age varchar(2),
	sex char(1),
	tel varchar(11)
);
insert into user(name,salary,age,sex,tel) values('张三','20000','25','F','12345678901');
insert into user(name,salary,age,sex,tel) values('李四','24000','35','F','34567890123');
insert into user(name,salary,age,sex,tel) values('王五','12000','29','M','56789011234');

update user set sex='男' where id=1;
update user set sex='男' where id=2;
update user set sex='女' where id=3;

alter table user modify column sex char(2);
