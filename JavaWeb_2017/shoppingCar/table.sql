create table computer(
	 id bigint primary key auto_increment,
	 model varchar(20),
	 picName varchar(20),
	 prodDesc varchar(20),
	 price double(10,2)
);
select * from computer;
insert into computer(model,picName,prodDesc,price)values('联想','战神','游戏本',8000.00);
insert into computer(model,picName,prodDesc,price)values('x200','战神','游戏本',8000.00);
insert into computer(model,picName,prodDesc,price)values('x500','战神','游戏本',8000.00);
insert into computer(model,picName,prodDesc,price)values('x600','战神','游戏本',8000.00);