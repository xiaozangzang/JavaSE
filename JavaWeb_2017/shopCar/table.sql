create table t_product(
	 id bigint primary key auto_increment,
	 model varchar(50),
	 picName varchar(20),
	 prodDesc varchar(100),
	 price double(10,2)
);

insert into t_product(model,picName,prodDesc,price)values('ս��','x200','��Ϸ��',8000.00);
insert into t_product(model,picName,prodDesc,price)values('ս��','x500','��Ϸ��',7000.00);
insert into t_product(model,picName,prodDesc,price)values('ս��','x600','��Ϸ��',6000.00);
select * from t_product;
delete from t_product ;