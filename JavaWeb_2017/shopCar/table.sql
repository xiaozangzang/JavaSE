create table t_product(
	 id bigint primary key auto_increment,
	 model varchar(50),
	 picName varchar(20),
	 prodDesc varchar(100),
	 price double(10,2)
);

insert into t_product(model,picName,prodDesc,price)values('战神','x200','游戏本',8000.00);
insert into t_product(model,picName,prodDesc,price)values('战神','x500','游戏本',7000.00);
insert into t_product(model,picName,prodDesc,price)values('战神','x600','游戏本',6000.00);
select * from t_product;
delete from t_product ;