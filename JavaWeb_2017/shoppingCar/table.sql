create table computer(
	 id bigint primary key auto_increment,
	 model varchar(20),
	 picName varchar(20),
	 prodDesc varchar(20),
	 price double(10,2)
);
select * from computer;
insert into computer(model,picName,prodDesc,price)values('����','ս��','��Ϸ��',8000.00);
insert into computer(model,picName,prodDesc,price)values('x200','ս��','��Ϸ��',8000.00);
insert into computer(model,picName,prodDesc,price)values('x500','ս��','��Ϸ��',8000.00);
insert into computer(model,picName,prodDesc,price)values('x600','ս��','��Ϸ��',8000.00);