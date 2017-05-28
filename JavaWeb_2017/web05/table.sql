create table t_user(
	id int primary key auto_increment,
	userName varchar(20),
	name varchar(20),
	password varchar(10),
	sex char(2)
);
insert into t_user(userName,name,password,sex) values('1001','张三','1001','男');
insert into t_user(userName,name,password,sex) values('1002','李四','1001','女');
insert into t_user(userName,name,password,sex) values('1003','王五','1001','男');
select * from t_user;