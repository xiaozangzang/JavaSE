create table t_user(
	id int primary key auto_increment,
	userName varchar(20),
	name varchar(20),
	password varchar(10),
	sex char(2)
);
insert into t_user(userName,name,password,sex) values('1001','����','1001','��');
insert into t_user(userName,name,password,sex) values('1002','����','1001','Ů');
insert into t_user(userName,name,password,sex) values('1003','����','1001','��');
select * from t_user;